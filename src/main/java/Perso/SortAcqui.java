package Perso;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class SortAcqui {

    public String nom,description,descriptionNiveau;
    public int niveau;

    public SortAcqui(JSONObject j) {
        nom = (String) j.get("nom");
        description  = (String) j.get("Description");
        niveau = (int) ((long) j.get("niveau"));
        descriptionNiveau = (String) j.get("descriptionNiveau");
    }

    public SortAcqui(JSONObject j, int niveau) {
        nom = (String) j.get("nom");
        description  = (String) j.get("Description");
        this.niveau = niveau;
        descriptionNiveau =(String) j.get("Bonus");
    }

    public JSONObject toJSONObject(){
        JSONObject j = new JSONObject();
        j.put("nom", nom);
        j.put("Description", description);
        j.put("descriptionNiveau", descriptionNiveau);
        j.put("niveau",niveau);
        return j;
    }

    public String toString(){
        return "\n" + nom + "\n" + niveau + "\n" + description + "\n";
    }
}
