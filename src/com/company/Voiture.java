package com.company;

import java.util.ArrayList;

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
        ArrayList<Route> prochainesPortions = routeActuelle.getNextPortions();

        for (Route r : prochainesPortions) {
            if (!r.isOccupe()) {
                routeActuelle = r;
                r.occuperRoute();
            }
        }
    }
}
