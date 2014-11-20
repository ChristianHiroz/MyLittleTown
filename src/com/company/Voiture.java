package com.company;

import java.util.ArrayList;

/**
 * Created by axeleroy on 09/10/2014.
 */
public class Voiture extends Thread {
    static final int VITESSEMAX = 50;
    static final int ACCELERATION = 10;
    static final int MAXESSENCE = 500;

    private Portion routeActuelle;
    private int vitesse = 0;
    private int essence;
    private Comportement comportement;

    public Voiture(Portion route) {
        routeActuelle = route;
        route.occuperRoute();
        this.comportement = Comportement.DEFAULT;
        this.essence = MAXESSENCE;
    }

    public Voiture(Portion route, Comportement comportement) {
        routeActuelle = route;
        route.occuperRoute();
        this.comportement = comportement;
        this.essence = MAXESSENCE;
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

    public void diminuerEssence(){
        this.essence--;
        if(this.essence == MAXESSENCE /10) {
            this.comportement = Comportement.ESSENCE;
        }
    }

    public void remettreEssence() {
        this.essence = MAXESSENCE;
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
                if(routeActuelle.isStationService()){
                    this.remettreEssence();
                    System.out.println("Refull !!");
                }
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

    public Portion choixRouteAleatoire(){
        return this.routeActuelle.getSuivants()
                .get((int) Math.random() * 10 % routeActuelle.getSuivants().size());
    }

    public synchronized void deplacer() throws PortionOccupedException {
        Portion prochaineRoute = null;
        if(comportement == Comportement.ESSENCE){
            boolean stationVue = false;
            boolean intersection = false;
            for(Portion portion : routeActuelle.getSuivants()) {
                while (!stationVue && !intersection) {
                    if (portion.isStationService()) {
                        stationVue = true;
                        prochaineRoute = portion;
                    }
                    if (portion.getSuivants().size() == 1) {
                        portion = portion.getSuivants().get(0);
                    } else {
                        intersection = true;
                    }
                }
            }
            if(prochaineRoute == null) {
                prochaineRoute = choixRouteAleatoire();
            }
        } else {
            prochaineRoute = choixRouteAleatoire();
        }
        if (prochaineRoute.isOccupe() != true) {
            augmenterVitesse();
            diminuerEssence();
            routeActuelle.libererRoute();
            routeActuelle = prochaineRoute;
            routeActuelle.occuperRoute();
        } else {
            throw new PortionOccupedException("La route suivante est occupée");

        }
    }
}
