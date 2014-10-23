package com.company;

/**
 * Created by zaelyous on 23/10/2014.
 */
public abstract class AbstractRoute {
    public abstract AbstractRoute suivant();
    public abstract boolean isOccupe();
    public abstract void occuperRoute();
    public abstract void libererRoute();
    public abstract void setSuivant(AbstractRoute route);
}
