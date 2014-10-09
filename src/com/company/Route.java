package com.company;

import java.util.ArrayList;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Route {
    public int posX; // Utilisé pour représentation graphique
    public int posY; // Utilisé pour représentation graphique
    private boolean occupe;
    public ArrayList<Route> nextPortions; // Le ou les portions de route suivante(s).

    public Route(int xPos, int yPos) {
        this.posX = posX;
        this.posY = posY;
        occupe = false;
        nextPortions = new ArrayList<Route>();
    }

    public boolean isOccupe() {
        return occupe;
    }

    public synchronized void occuperRoute() {
        occupe = true;
    }

    public synchronized void liberRoute() {
        occupe = false;
    }

    public synchronized ArrayList<Route> getNextPortions() {
        return nextPortions;
    }

    /* Fonction pour connaître si une portion est égale à une autre
    * Utile si stockée dans un Set
    */
    public boolean equalsTo(Route otherRoute) {
        if (this.posX == otherRoute.posX)
            return true;
        else if (this.posY == otherRoute.posY)
            return true;
        else return false;
    }
}
