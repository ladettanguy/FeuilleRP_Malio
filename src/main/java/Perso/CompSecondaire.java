package Perso;

import org.json.simple.JSONObject;

public class CompSecondaire {
    public String nom,description;

    public CompSecondaire(JSONObject j) {
        nom = (String) j.get("nom");
        description =(String) j.get("Description");
    }

    public String toString(){
        return "\n" + nom + "\n" + description + "\n";
    }
}