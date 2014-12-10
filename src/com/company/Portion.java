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
    private Signalisation signalisation;
    private Feu feu;
    //endregion

    //region Constructeur
    public Portion() {
        occupe = false;
        suivants = new ArrayList<Portion>();
        elements = new ArrayList<ElementRoute>();
    }

    public Portion(ElementRoute elementRoute) {
        occupe = false;
        suivants = new ArrayList<Portion>();
        elements = new ArrayList<ElementRoute>();
        addElement(elementRoute);
    }

    public Portion(ArrayList<ElementRoute> elementRoute) {
        occupe = false;
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

    public Feu getFeu() {
        return feu;
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
        if (occupe)
            return "Je suis occupé et mon suivant est " + suivants;
        else return "Je suis libre";

    }
    //endregion

}
