package Perso;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class SortActif {

    public String nom,description;
    public ArrayList<String> niveau = new ArrayList<>();

    public SortActif(JSONObject j) {
        nom = (String) j.get("nom");
        description  = (String) j.get("Description");

        JSONArray level = (JSONArray) j.get("niveau");
        niveau.add("");
        for (int i = 0; i < level.size(); i++) {
            niveau.add((String) level.get(i));
        }
    }

    public String toString(){
        return "\n" + nom + ": " + description +"\n";
    }
}
