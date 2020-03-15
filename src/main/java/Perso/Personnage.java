package Perso;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Personnage {
    public String nom,sexe;
    public Classe classe;
    public long kamas,xp,xpMax,armure;
    public TreeMap<String,Long> element = new TreeMap<>();
    public ArrayList<SortAcqui> sortAcquis = new ArrayList<>();
    public ArrayList<SortPassif> sortsPassifs = new ArrayList<>();
    public Qualite_Defaut qualiteDefaut;
    public ArrayList<CompSecondaire> compSecondaires = new ArrayList<>();
    public JSONObject PersoJson;
    public JSONObject allClasse;

    public Personnage(String nom){
        this.nom = nom;
        try
        {
            JSONObject jsonObject =(JSONObject) new JSONParser().parse(new FileReader("bd.json"));
            JSONObject perso = (JSONObject) jsonObject.get(nom);
            allClasse =(JSONObject) new JSONParser().parse(new FileReader("Classes.json"));

            sexe = (String) perso.get("sexe");
            kamas = (long) perso.get("kamas");
            xp = (long) perso.get("xp");
            xpMax = (long) perso.get("xpMax");
            armure = (long) perso.get("armure");


            //Attribution des Éléments
            JSONObject elements = (JSONObject) perso.get("element");
            element.put("air",(long) elements.get("air"));
            element.put("terre",(long) elements.get("terre"));
            element.put("eau",(long) elements.get("eau"));
            element.put("feu",(long) elements.get("feu"));
            element.put("lumiere",(long) elements.get("lumiere"));
            element.put("tenebre",(long) elements.get("tenebre"));

            //Sort Actif
            JSONArray sortA = (JSONArray) perso.get("sortAcqui");
            for (Object o : sortA) sortAcquis.add(new SortAcqui((JSONObject) o));

            //Sort Passif
            JSONArray sortP = (JSONArray) perso.get("sortPassif");

            for (Object o : sortP) sortsPassifs.add(new SortPassif((JSONObject) o));

            Qualite_Defaut q = new Qualite_Defaut();

            //Qualité
            JSONArray qualit = (JSONArray) perso.get("qualite");
            for (Object s: qualit) q.addQualite((JSONObject) s);

            //Defaut
            JSONArray defaut = (JSONArray) perso.get("defaut");
            for (Object s: defaut) q.addDefaut((JSONObject) s);

            this.qualiteDefaut = q;

            //Compétence Secondaire
            JSONArray comp = (JSONArray) perso.get("compSecondaire");
            for (Object o : comp) compSecondaires.add(new CompSecondaire((JSONObject) o));

            //Classe
            this.classe = new Classe((JSONObject) perso.get("classe"));

            PersoJson = perso;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void upElement(String elementChoisi,int montant){
        if(element.containsKey(elementChoisi)) {
            long i = element.get(elementChoisi);
            element.remove(elementChoisi);
            element.put(elementChoisi,i + montant);
        }
    }

    public void roll(){
        JSONArray clas = (JSONArray) allClasse.get("classe");

        int indexClasse = (int) (Math.random() * clas.size());
        JSONObject newClass =(JSONObject) clas.get(indexClasse);
        classe = new Classe(newClass);

        JSONArray newSort = (JSONArray) newClass.get("sort");
        for (Object o : newSort)
            if (((int) (Math.random() * 2)) == 1 && ((int) (Math.random() * 3) != 0))
                sortAcquis.add(new SortAcqui((JSONObject) o, (int) ((Math.random() * 6) + 1)));
        save();
    }

    public void save(){
        JSONObject obj = new JSONObject();

        //Sauvegarde des sorts
        JSONArray newSort = new JSONArray();
        for (SortAcqui s: sortAcquis) {
            JSONObject sort = new JSONObject();
            sort.put("nom",s.nom);
            sort.put("Description",s.description);
            sort.put("Bonus",s.descriptionNiveau);
            sort.put("niveau",s.niveau);
            newSort.add(sort);
        }
        PersoJson.put("sortAcqui",newSort);

        //Sauvegarde de la classe
        JSONObject classe = new JSONObject();
        classe.put("nom",this.classe.toString());
        PersoJson.put("classe",classe);


        obj.put("Malio", PersoJson);
        try (FileWriter file = new FileWriter("bd.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return nom
                + "\n" + sexe
                + "\n Niveau : " + (xpMax/100)
                + "\n Classe : " + classe
                + "\n SortActif : " + sortAcquis
                + "\n SortPassif : " + sortsPassifs
                + "\n Compétence Secondaire : " + compSecondaires;
    }
}
