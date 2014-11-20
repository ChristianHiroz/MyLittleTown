package com.company;

import java.util.ArrayList;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Portion{
    private boolean occupe;
    private ArrayList<Portion> suivant;

    public Portion() {
        occupe = false;
    }

    public ArrayList<Portion> getSuivant() {
        return suivant;
    }

    public void addSuivant(Portion route) {
        this.suivant.add(route);
    }

    public boolean isOccupe() {
        return occupe;
    }

    public void occuperRoute() {
        occupe = true;
    }

    public void libererRoute() {
        occupe = false;
    }

}
