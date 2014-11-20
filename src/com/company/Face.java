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

    public void setEntree(Portion entree) {
        this.entree = entree;
    }

    public Portion getSortie() {
        return sortie;
    }

    public void setSortie(Portion sortie) {
        this.sortie = sortie;
    }

    public void connect(Face cacher){
        cacher.getSortie().addSuivant(this.getEntree());
        this.getSortie().addSuivant(cacher.getEntree());
    }
}
