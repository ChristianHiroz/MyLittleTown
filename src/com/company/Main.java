package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RouteFactory rf = RouteFactory.getInstance();
        GestionnaireFeux gestionnaireFeux = new GestionnaireFeux();

        Route r0 = rf.createRoute(5, "Avenue du Lapin Doré");
        Route r1 = rf.createRoute(5, "Rue du PorteJartelle");
        Route r2 = rf.createRoute(5, "Chemin de la Fistiniere");
        Route r3 = rf.createRoute(5, "Quai des Dés");
        Route r4 = rf.createRoute(5, "Rue des Chaudières");
        Route r5 = rf.createRoute(5, "Avenue des Granolas");
        Route r6 = rf.createRoute(5, "Quai du Phalus");
        Route r7 = rf.createRoute(5, "Chemin de la Fin du Monde");

        // Création du premier carré de routes
        r0.getFace(0).connect(r1.getFace(1));
        r1.getFace(0).connect(r2.getFace(1));
        r2.getFace(0).connect(r3.getFace(1));


        // Création du second carré de routes
        r4.getFace(0).connect(r5.getFace(1));
        r5.getFace(0).connect(r6.getFace(1));
        r6.getFace(0).connect(r7.getFace(1));

        // Listing des faces qu'on va lier afin de créer une intersection
        List<Face> faces = new ArrayList<Face>();
        faces.add(r0.getFace(1));
        faces.add(r3.getFace(0));
        faces.add(r4.getFace(1));
        faces.add(r7.getFace(0));

        Intersection.createIntersection(faces, gestionnaireFeux);
        gestionnaireFeux.start();

        Voiture v0 = new Voiture(r0.getEntree(0), Comportement.CHAUFFARD, "Gerard");
        Voiture v1 = new Voiture(r0.getEntree(0).getSuivants().get(0), Comportement.TOURISTE, "Jacky");
        Voiture v3 = new Voiture(r4.getEntree(1), Comportement.LIVREUR, "Bernard");
        v0.start();
        v1.start();
        v3.start();

        Thread.sleep(120000);
        System.out.println("End of prog... Exiting");
        System.exit(0);
    }
}
