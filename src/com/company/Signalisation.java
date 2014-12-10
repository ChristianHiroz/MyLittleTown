package com.company;

/**
 * Created by axeleroy on 10/12/2014.
 */
public enum Signalisation {
    FEU("Feu rouge"),
    PANNEAU_VITESSE("Panneau de limitation de vitesse"),
    PANNEAU_FIN_VITESSE("Panneau de fin de limitation de vitesse"),
    PANNEAU_DEPASSEMENT("Panneau d'interdiction de dépasser"),
    PANNEAU_FIN_DEPASSEMENT("Panneau de fin d'interdiction de dépasser"),
    DOS_D_ANE("Dos d'âne");

    private String name="";

    Signalisation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
