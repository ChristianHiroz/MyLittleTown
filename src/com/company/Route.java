package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Route {
    public int posX; // Utilisé pour représentation graphique
    public int posY; // Utilisé pour représentation graphique
    private boolean occupe;
    public Route nextPortion; // Le ou les portions de route suivante(s).

    public Route(int xPos, int yPos) {
        this.posX = xPos;
        this.posY = yPos;
        occupe = false;
        nextPortion = null;
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

    public synchronized void setNextPortion(Route route) {
        nextPortion = route;
    }

    public synchronized Route getNextPortion() {
        return nextPortion;
    }

    /* Fonction pour connaître si une portion est égale à une autre
    * Utile si stockée dans un Set
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (occupe != route.occupe) return false;
        if (posX != route.posX) return false;
        if (posY != route.posY) return false;
        if (nextPortion != null ? !nextPortion.equals(route.nextPortion) : route.nextPortion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = posX;
        result = 31 * result + posY;
        result = 31 * result + (occupe ? 1 : 0);
        result = 31 * result + (nextPortion != null ? nextPortion.hashCode() : 0);
        return result;
    }
}
