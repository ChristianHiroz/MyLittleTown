package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 */
public class Voiture extends Thread {
    private Route routeActuelle;

    public Voiture(Route route) {
        routeActuelle = route;
    }

    @Override
    public void run() {
        deplacer();
    }

    public synchronized void deplacer() {
        Route prochaineRoute = routeActuelle.getNextPortion();

        if (prochaineRoute.isOccupe() != true) {
            routeActuelle = prochaineRoute;
        }
    }
}
