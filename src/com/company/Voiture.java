package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 */
public class Voiture extends Thread {
    private Portion routeActuelle;

    public Voiture(Portion route) {
        routeActuelle = route;
        route.occuperRoute();
    }

    @Override
    public void run() {
        System.out.println(routeActuelle);
        boolean isDeplacer = false;
        while(!isDeplacer){
            try {
                deplacer();
                System.out.println("Avance");
                isDeplacer = true;
            } catch (PortionOccupedException pooe) {
                try {
                    System.out.println("Bouchon");
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(routeActuelle);
    }

    public synchronized void deplacer() throws PortionOccupedException {
        Portion prochaineRoute = routeActuelle.getSuivants()
            .get((int) Math.random() * 10 % routeActuelle.getSuivants().size());

        if (prochaineRoute.isOccupe() != true) {
            routeActuelle.libererRoute();
            routeActuelle = prochaineRoute;
            routeActuelle.occuperRoute();
        } else {
            throw new PortionOccupedException("La route suivante est occupée");
        }
    }
}
