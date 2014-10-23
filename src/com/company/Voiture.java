package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 */
public class Voiture extends Thread {
    private AbstractRoute routeActuelle;

    public Voiture(AbstractRoute route) {
        routeActuelle = route;
    }

    @Override
    public void run() {
        deplacer();
    }

    public synchronized void deplacer() {
        AbstractRoute prochaineRoute = routeActuelle.suivant();

        if (prochaineRoute.isOccupe() != true) {
            routeActuelle.libererRoute();
            routeActuelle = prochaineRoute;
            routeActuelle.occuperRoute();
        }
    }
}
