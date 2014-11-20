package com.company;

/**
 * Created by axeleroy on 09/10/2014.
 */
public class Voiture extends Thread {
    private Portion routeActuelle;
    private int vitesse = 0;
    static final int VITESSEMAX = 50;
    static final int ACCELERATION = 10;

    public Voiture(Portion route) {
        routeActuelle = route;
        route.occuperRoute();
    }
    public void augmenterVitesse () {
        if(this.vitesse + ACCELERATION <= VITESSEMAX){
            this.vitesse=+ACCELERATION;
        }
        else if (this.vitesse + ACCELERATION > VITESSEMAX && this.vitesse < VITESSEMAX) {
            this.vitesse=VITESSEMAX;
        }
    }

    public void arretVoiture() {
        this.vitesse = 0;
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
                    arretVoiture();
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
            augmenterVitesse();
            routeActuelle.libererRoute();
            routeActuelle = prochaineRoute;
            routeActuelle.occuperRoute();
        } else {
            throw new PortionOccupedException("La route suivante est occupée");

        }
    }
}
