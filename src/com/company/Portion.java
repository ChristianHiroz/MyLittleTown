package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Portion{
    private boolean occupe;
    private Portion suivant;

    public Portion() {
        occupe = false;
    }

    public Portion getSuivant() {
        return suivant;
    }

    public void setSuivant(Portion route) {
        suivant = route;
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
