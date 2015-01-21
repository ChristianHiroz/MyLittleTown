package com.company;

/**
 * Created by Fluttershy on 06/11/2014.
 */
public class Face {
    private Portion entree;
    private Portion sortie;

    public Face(Portion entree, Portion sortie) {
        this.entree = entree;
        this.sortie = sortie;
    }

    public Portion getEntree() {
        return entree;
    }

    public Portion getSortie() {
        return sortie;
    }

    public void connect(Face face){
        face.getSortie().addSuivant(this.getEntree());
        this.getSortie().addSuivant(face.getEntree());
    }
}
