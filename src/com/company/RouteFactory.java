package com.company;

/**
 * Created by axeleroy on 06/11/2014.
 */
public class RouteFactory {
    private static final class RouteFactoryHolder {
        private static final RouteFactory INSTANCE = new RouteFactory();
    }

    private RouteFactory() {

    }

    public static RouteFactory getInstance() {
        return RouteFactoryHolder.INSTANCE;
    }

    public Route createRoute(int longueur) {
        Route route = new Route();

        Portion firstPortion = new Portion();


        for (int i = 0; i < longueur; i ++) {
            Portion portion = new Portion();
            route.addRoute(0, firstPortion);
            if (i < longueur - 1) {
                firstPortion.addSuivant(portion);
            }
            firstPortion = portion;
        }

        firstPortion = new Portion();

        for (int i = 0; i < longueur; i ++) {
            Portion portion = new Portion();
            route.addRoute(1, firstPortion);
            if (i < longueur - 1) {
                firstPortion.addSuivant(portion);
            }
            firstPortion = portion;
        }

        return route;
    }

    public void connectRoute(Route route0, int sens0, Route route1, int sens1) {
        Face face1 = new Face(route0.getEntree(sens0), route1.getSortie(sens1));
        Face face2 = new Face(route1.getEntree(sens1), route0.getSortie(sens0));
        face1.connect(face2);
    }
}
