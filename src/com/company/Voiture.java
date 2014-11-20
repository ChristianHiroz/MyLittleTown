package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 */
public class Voiture extends Thread {
    private Portion routeActuelle;

    public Voiture(Portion route) {
        routeActuelle = route;
    }

    @Override
    public void run() {
        deplacer();
        System.out.println(routeActuelle);
    }

    public synchronized void deplacer() {
        Portion prochaineRoute = routeActuelle.getSuivants()
            .get((int) Math.random() * 10 % routeActuelle.getSuivants().size());

        if (prochaineRoute.isOccupe() != true) {
            routeActuelle.libererRoute();
            routeActuelle = prochaineRoute;
            routeActuelle.occuperRoute();
        }
    }
}
