package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RouteFactory rf = RouteFactory.getInstance();

        Route r0 = rf.createRoute(5);
        Route r1 = rf.createRoute(5);
        Route r2 = rf.createRoute(5);
        Route r3 = rf.createRoute(5);

        r0.getFace(0).connect(r1.getFace(1));
        r1.getFace(0).connect(r2.getFace(1));
        r2.getFace(0).connect(r3.getFace(1));
        r3.getFace(0).connect(r0.getFace(1));

        Voiture v0 = new Voiture(r0.getEntree(0), Comportement.CHAUFFARD);
        Voiture v1 = new Voiture(r0.getEntree(0).getSuivants().get(0), Comportement.TOURISTE);
        v0.start();
        v1.start();
        v0.join();
        v1.join();




    }
}
