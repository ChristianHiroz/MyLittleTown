package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 * Modèle de donnée représentant une portion de route
 */
public class Route extends AbstractRoute{
    private boolean occupe;
    private AbstractRoute suivant;

    public Route(AbstractRoute route) {
        occupe = false;
        suivant = route;
    }

    @Override
    public AbstractRoute suivant() {
        return suivant;
    }

    @Override
    public void setSuivant(AbstractRoute route) {
        suivant = route;
    }

    @Override
    public boolean isOccupe() {
        return occupe;
    }

    @Override
    public void occuperRoute() {
        occupe = true;
    }

    @Override
    public void libererRoute() {
        occupe = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route that = (Route) o;

        if (occupe != that.occupe) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (occupe ? 1 : 0);
    }
}
