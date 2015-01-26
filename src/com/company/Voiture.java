package com.company;

import java.util.ArrayList;

/**
 * Created by axeleroy on 09/10/2014.
 */
public class Voiture extends Thread {
    //region Variable de classe
    private static final int MAXESSENCE = 500;
    //endregion

    //region Propriétés
    
    //portion sur laquelle se trouve la voiture
    private Portion routeActuelle;
    //nom du conducteur de la voiture
    private String nomConducteur;
    // vitesse de la voiture (défaut = 0)
    private int vitesse = 0;
    // enssence contenu dans le réservoir de la voiture
    private int essence;
    // liste des différents types de comportements que possède le conducteur
    private ArrayList<Comportement> comportements;
    // vitesse MAX de la voiture (défaut = 50)
    private int vitesseMax = 50;
    // accélération par portion de la voiture (défaut = 10)
    private int acceleration = 10;
    //endregion

    //region Constructeurs
    public Voiture(Portion route, String nomConducteur) {
        routeActuelle = route;
        this.nomConducteur = nomConducteur;
        route.occuperRoute();
        this.comportements = new ArrayList<Comportement>();
        this.addComportement(Comportement.DEFAULT);
        this.essence = MAXESSENCE;
    }

    public Voiture(Portion route, Comportement comportement, String nomConducteur) {
        routeActuelle = route;
        this.nomConducteur = nomConducteur;
        route.occuperRoute();
        this.comportements = new ArrayList<Comportement>();
        this.addComportement(comportement);
        this.essence = MAXESSENCE;
    }
    //endregion

    //region Getter/Setter
    
    // ajoute un comportement à l'automobiliste, ainsi que les particularités du comportement
    public void addComportement(Comportement comportement) {
        if(comportement == Comportement.CHAUFFARD) {
            this.vitesseMax += 20;
            this.acceleration += 5;
        } else if (comportement == Comportement.TOURISTE) {
            this.vitesseMax -= 10;
            this.acceleration -= 5;
        } else if (comportement == Comportement.VIEUX) {
            this.acceleration -= 5;
        } else if (comportement == Comportement.PRESSER) {
            this.acceleration += 5;
        }
        this.comportements.add(comportement);
    }

    public void augmenterVitesse () {
        if(this.vitesse + acceleration <= vitesseMax){
            this.vitesse+=acceleration;
        }
        else if (this.vitesse + acceleration > vitesseMax && this.vitesse < vitesseMax) {
            this.vitesse= vitesseMax;
        }
    }

    public void arretVoiture() {
        this.vitesse = 0;
    }

    public void arretVoiture(boolean fin) throws FinException {
        this.vitesse = 0;
        if(fin) {
            throw new FinException();
        }
    }

    public void diminuerEssence(){
        this.essence--;
        if(this.essence == MAXESSENCE /10 && !this.comportements.contains(Comportement.ESSENCE)) {
            this.comportements.add(Comportement.ESSENCE);
        }
        if(this.comportements.contains(Comportement.ESSENCE) && this.essence == 0) {
            try {
                sleep(25000);
                arretVoiture();
                System.out.println("Panne d'essence");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void remettreEssence() {
        this.essence = MAXESSENCE;
        for(Comportement comportement : comportements) {
            if(comportement == Comportement.ESSENCE) {
                this.comportements.remove(comportements.indexOf(comportement));
            }
        }
    }
    //endregion

    //region Méthodes
    @Override
    public void run() {
        boolean fin = false;
        while(!fin){
            try {
                deplacer();
                System.out.println(this.toString() + "... j'avance sur la route " + routeActuelle.toString());
                if(routeActuelle.isStationService()){
                    this.remettreEssence();
                    System.out.println("Refull !!");
                }
                long tempsAttente = 10000 / (long)this.vitesse; // gestion vitesse (1000 = arrêt, donc 1000/vitesse donne le temps de parcours d'une portion)
                sleep(tempsAttente);
            } catch (PortionOccupedException pooe) {
                try {
                    arretVoiture();
                    System.out.println(this.toString() + "... il y a un bouchon sur la route " + routeActuelle.toString());
                    sleep(10000);
                } catch (InterruptedException e) {
                    try {
                        arretVoiture(true);
                    } catch (FinException e1) {
                        System.out.println("Fin de la démonstration !");
                    }
                }
            } catch (FeuRougeException fre) {
                arretVoiture();
                System.out.println(this.toString() + "... le feu est rouge");

                try {
                    sleep(1000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            } catch (InterruptedException e) {
                System.out.println("Accident ?");
            }
        }
        System.out.println(routeActuelle);
    }

    private Portion choixRouteAleatoire(){
        return this.routeActuelle.getSuivants()
                .get((int) Math.random() * 10 % routeActuelle.getSuivants().size());
    }

    public synchronized void deplacer() throws PortionOccupedException, FeuRougeException {
        testFeuRouge();
        Portion prochaineRoute = choisirRoute();
        if (!prochaineRoute.isOccupe()) {
            this.alterationVoiture();
            this.changementRoute(prochaineRoute);
        } else {
            throw new PortionOccupedException("La route suivante est occupée");
        }
        testLivraison();
    }

    // test si l'automobiliste a une livraison
    private void testLivraison(){
        if (this.routeActuelle.isLieuLivraison() && this.comportements.contains(Comportement.LIVREUR)) {
            try{
                System.out.println("Livraison en cours");
                arretVoiture();
                sleep(15000);
            }
            catch(InterruptedException e) {
                System.out.println("Livraison annulée");
            }
        }
    }
    
    // test s'il y a un feu rouge sur la portion
    private void testFeuRouge() throws FeuRougeException {

    }
    
    private void alterationVoiture(){
        augmenterVitesse();
        diminuerEssence();
    }

    private void changementRoute(Portion prochaineRoute) {
        routeActuelle.libererRoute();
        routeActuelle = prochaineRoute;
        routeActuelle.occuperRoute();
    }

    private Portion choisirRoute() {
        Portion prochaineRoute = null;
        for(Comportement comportement : comportements) {
            if (comportement == Comportement.ESSENCE) {
                boolean stationVue = false;
                boolean intersection = false;
                for (Portion portion : routeActuelle.getSuivants()) {
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
                if (prochaineRoute == null) {
                    prochaineRoute = choixRouteAleatoire();
                }
            } else {
                prochaineRoute = choixRouteAleatoire();
            }
        }

        return prochaineRoute;
    }

    @Override
    public String toString(){
        String toReturn = this.nomConducteur + ": Je roule à " + this.vitesse + "km/h. Je suis ";
        for(Comportement c : comportements) {
            toReturn += c.toString() + ", ";
        }

        return  toReturn;
    }
    //endregion
}
