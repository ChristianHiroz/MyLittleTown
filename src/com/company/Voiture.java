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

    }
}
