package Perso;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Qualite_Defaut {
    public ArrayList<Qualite> qualites;
    public ArrayList<Defaut> defauts;

    public Qualite_Defaut(){
        qualites = new ArrayList<Qualite>();
        defauts = new ArrayList<Defaut>();
    }

    public void addQualite(JSONObject j){
        qualites.add(new Qualite((String) j.get("nom"),(String) j.get("Description")));
    }

    public void addDefaut(JSONObject j){
        defauts.add(new Defaut((String) j.get("nom"),(String) j.get("Description")));
    }
}
