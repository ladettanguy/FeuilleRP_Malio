package Perso;

import org.json.simple.JSONObject;

public class SortPassif {

    public String nom,description;

    public SortPassif(JSONObject j){
        nom =(String) j.get("nom");
        description= (String) j.get("Description");
    }

    public String toString(){
        return "\n" + nom + "\n" + description + "\n";
    }
}
