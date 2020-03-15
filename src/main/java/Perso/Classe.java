package Perso;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Classe {

    public String nom;

    public Classe(JSONObject j) {
        this.nom = (String) j.get("nom");
    }

    public String toString(){
        return nom;
    }
}
