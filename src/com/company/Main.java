package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RouteFactory rf = RouteFactory.getInstance();
        GestionnaireFeux gestionnaireFeux = new GestionnaireFeux();

        Route r0 = rf.createRoute(5, "Avenue du Lapin Doré");
        Route r1 = rf.createRoute(5, "Rue du Port");
        Route r2 = rf.createRoute(5, "Chemin du Finistère");
        Route r3 = rf.createRoute(5, "Quai des Dés");
        Route r4 = rf.createRoute(5, "Rue des Chaudières");
        Route r5 = rf.createRoute(5, "Avenue des Granolas");
        Route r6 = rf.createRoute(5, "Quai du Phare");
        Route r7 = rf.createRoute(5, "Chemin de la Fin du Monde");

        // Création du premier carré de routes
        rf.connectRoute(r0, 0, r1, 1);
        rf.connectRoute(r1, 0, r2, 1);
        rf.connectRoute(r2, 0, r3, 1);

        // Création du second carré de routes
        rf.connectRoute(r4, 0, r5, 1);
        rf.connectRoute(r5, 0, r6, 1);
        rf.connectRoute(r6, 0, r7, 1);

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
        Voiture v3 = new Voiture(r4.getEntree(1), "Bernard");
        v0.start();
        v1.start();
        v3.start();

        Thread.sleep(120000);
        System.out.println("End of prog... Exiting");
        System.exit(0);
    }
}
