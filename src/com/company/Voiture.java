package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 */
public class Voiture extends Thread {
    private PortionRoute portionRouteActuelle;

    public Voiture(PortionRoute portionRoute) {
        portionRouteActuelle = portionRoute;
    }

    @Override
    public void run() {
        deplacer();
    }

    public synchronized void deplacer() {
        PortionRoute prochainePortionRoute = portionRouteActuelle.getNextPortion();

        if (prochainePortionRoute.isOccupe() != true) {
            portionRouteActuelle = prochainePortionRoute;
        }
    }
}
