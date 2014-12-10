package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Portion{
    //region Propriétés
    private boolean occupe;
    private List<Portion> suivants;
    private ArrayList<ElementRoute> elements;
    private String name;
    private int num;
    //endregion

    //region Constructeur
    public Portion(String name, int num) {
        occupe = false;
        this.name = name;
        this.num = num;
        suivants = new ArrayList<Portion>();
        elements = new ArrayList<ElementRoute>();
    }

    public Portion(ElementRoute elementRoute, String name, int num) {
        occupe = false;
        this.name = name;
        this.num = num;
        suivants = new ArrayList<Portion>();
        elements = new ArrayList<ElementRoute>();
        addElement(elementRoute);
    }

    public Portion(ArrayList<ElementRoute> elementRoute, String name, int num) {
        occupe = false;
        this.name = name;
        this.num = num;
        suivants = new ArrayList<Portion>();
        elements = elementRoute;
    }
    //endregion

    //region Getter/Setter
    public boolean isStationService(){
        if(this.elements.contains(ElementRoute.STATIONSERVICE)){
            return true;
        }

        return false;
    }

    public boolean isLieuLivraison(){
        if(this.elements.contains(ElementRoute.LIEULIVRAISON)){
            return true;
        }

        return false;
    }

    public void addElement(ElementRoute elementRoute) {
        if(!this.elements.contains(elementRoute)){
            this.elements.add(elementRoute);
        }
    }

    public ArrayList<ElementRoute> getElements(){
        return this.elements;
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
    //endregion

    //region Méthodes
    @Override
    public String toString() {
        return this.name + " au numéro: " + this.num;
    }
    //endregion

}
