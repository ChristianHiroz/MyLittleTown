package com.company;

import java.util.ArrayList;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Route {
    public int posX; // Utilisé pour représentation graphique
    public int posY; // Utilisé pour représentation graphique
    public ArrayList<Route> nextPortions; // Le ou les portions de route suivante.

    public Route(int xPos, int yPos) {
        this.posX = posX;
        this.posY = posY;
        nextPortions = new ArrayList<Route>();
    }

    public boolean equals(Route otherRoute) {
        if (this.posX == otherRoute.posX)
            return true;
        else if (this.posY == otherRoute.posY)
            return true;
        else return false;
    }

    public boolean equals(int posX, int posY) {
        if (this.posX == posX)
            return true;
        else if (this.posY == posY)
            return true;
        else return false;
    }
}
