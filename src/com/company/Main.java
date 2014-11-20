package com.company;

public class Main {

    public static void main(String[] args) {
        RouteFactory rf = RouteFactory.getInstance();

        Route r0 = rf.createRoute(5);
        Route r1 = rf.createRoute(5);
        Route r2 = rf.createRoute(5);
        Route r3 = rf.createRoute(5);

        Face f00 = new Face(r0.getEntree(0), r0.getSortie(1));
        Face f01 = new Face(r0.getEntree(1), r0.getSortie(0));
        Face f10 = new Face(r1.getEntree(0), r1.getSortie(1));
        Face f11 = new Face(r1.getEntree(1), r1.getSortie(0));
        Face f20 = new Face(r2.getEntree(0), r2.getSortie(1));
        Face f21 = new Face(r2.getEntree(1), r2.getSortie(0));
        Face f30 = new Face(r3.getEntree(0), r3.getSortie(1));
        Face f31 = new Face(r3.getEntree(1), r3.getSortie(0));

        f00.connect(f11);
        f10.connect(f21);
        f20.connect(f31);
        f30.connect(f01);

        Voiture v0 = new Voiture(r0.getEntree(0));
        v0.run();




    }
}
