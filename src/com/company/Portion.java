package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Portion{
    private boolean occupe;
    private List<Portion> suivants;
    private boolean stationService = false;
    private boolean lieuLivraison = false;


    public Portion() {
        occupe = false;
        suivants = new ArrayList<Portion>();
    }

    public Portion(ElementRoute elementRoute) {
        occupe = false;
        suivants = new ArrayList<Portion>();
        setElementRoute(elementRoute);
    }

    public boolean isStationService() {
        return stationService;
    }

    public void setElementRoute(ElementRoute elementRoute) {
        if(elementRoute == ElementRoute.STATIONSERVICE){
            this.stationService = true;
        } else if (elementRoute == ElementRoute.LIEULIVRAISON) {
            this.lieuLivraison = true;
        }
    }

    public List<Portion> getSuivants() {
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
