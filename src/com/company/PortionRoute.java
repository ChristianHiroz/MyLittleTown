package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class PortionRoute {
    private boolean occupe;

    public PortionRoute() {
        occupe = false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortionRoute that = (PortionRoute) o;

        if (occupe != that.occupe) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (occupe ? 1 : 0);
    }
}
