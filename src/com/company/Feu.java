package com.company;

/**
 * Created by axeleroy on 10/12/2014.
 */
public class Feu {
    private boolean etat; // true : rouge ; false : vert

    public Feu(boolean etat) {
        this.etat = etat;
    }

    public boolean estRouge() {
        return etat;
    }

    public void permute() {
        etat = !etat;
    }

    @Override
    public String toString() {
        if(etat) {
            return "Feu rouge";
        } else {
            return "Feu vert";
        }
    }
}
