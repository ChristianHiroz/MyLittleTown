package com.company;

import java.util.ArrayList;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Portion{
    private boolean occupe;
    private ArrayList<Portion> suivants;

    public Portion() {
        occupe = false;
        suivants = new ArrayList<Portion>();
    }

    public ArrayList<Portion> getSuivants() {
        return suivants;
    }

    public void addSuivant(Portion route) {
        this.suivants.add(route);
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

    @Override
    public String toString() {
        if (occupe)
            return "Je suis occupé et mon suivant est " + suivants;
        else return "Je suis libre";

    }

}
