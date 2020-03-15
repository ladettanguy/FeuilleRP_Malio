import Perso.SortAcqui;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.FileReader;
import java.util.ArrayList;

public class Outil {
    public static ArrayList<String> listOfPersonnage() throws Exception{
        JSONObject jsonObject =(JSONObject) new JSONParser().parse(new FileReader("Classes.json"));
        JSONArray listDesClasse =(JSONArray) jsonObject.get("classe");
        ArrayList<String> result = new ArrayList<>();
        for (int i=0 ; i< listDesClasse.size(); i++){
            JSONObject classe = (JSONObject) listDesClasse.get(i);
            result.add((String) classe.get("nom"));
        }
        return result;
    }

    public static SortAcqui getSortByNom(ArrayList<SortAcqui> list,String nom){
        SortAcqui result = null;
        for (SortAcqui sA: list) {
            if(sA.nom == nom) return sA;
        }
        return null;
    }

    public static void disabledAll(ArrayList<? extends Component> list){
        for (Component c: list)
            c.setVisible(false);
    }

    public static void enabledAll(ArrayList<? extends Component> list){
        for (Component c: list)
            c.setVisible(true);
    }
}
