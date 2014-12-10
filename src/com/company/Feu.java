package com.company;

/**
 * Created by axeleroy on 10/12/2014.
 */
public class Feu {
    private EtatFeu etat;

    public Feu(EtatFeu etat) {
        this.etat = etat;
    }

    public EtatFeu getEtat() {
        return etat;
    }

    public void permute() {
        if (etat.equals(EtatFeu.VERT)) {
            etat = EtatFeu.ROUGE;
        } else {
            etat = EtatFeu.VERT;
        }
    }

    @Override
    public String toString() {
        return etat.toString();
    }
}
