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
    private boolean stationService;


    public Portion() {
        occupe = false;
        suivants = new ArrayList<Portion>();
        this.stationService = false;
    }

    public Portion(boolean stationService) {
        occupe = false;
        suivants = new ArrayList<Portion>();
        this.stationService = stationService;
    }


    public boolean isStationService() {
        return stationService;
    }

    public void setStationService(boolean stationService) {
        this.stationService = stationService;
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
