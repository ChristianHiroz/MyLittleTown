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
    private Signalisation signalisation;
    private Feu feu;
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
        return elements.contains(ElementRoute.STATIONSERVICE);
    }

    public boolean isLieuLivraison(){
        return elements.contains(ElementRoute.LIEULIVRAISON);
    }

    public boolean isFeuRouge() {
        if (feu != null) {
            return feu.estRouge();
        } else {
            return false;
        }
    }

    public void setFeu(Feu feu) {
        this.feu = feu;
    }

    public void addElement(ElementRoute elementRoute) {
        if(!this.elements.contains(elementRoute)){
            this.elements.add(elementRoute);
        }
    }

    public void setSignalisation(Signalisation sign) {
        signalisation = sign;
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
