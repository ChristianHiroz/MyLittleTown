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

    public Route createRoute(int longueur, String routeName) {
        int numero = 2;
        Route route = new Route(routeName);
        Portion firstPortion = new Portion(routeName, numero);

        for (int i = 0; i < longueur; i ++) {
            numero += 2;
            Portion portion = new Portion(routeName, numero);
            route.addRoute(0, firstPortion);
            if (i < longueur - 1) {
                firstPortion.addSuivant(portion);
            }
            firstPortion = portion;
        }

        numero -= 3;
        firstPortion = new Portion(routeName, numero);

        for (int i = 0; i < longueur; i ++) {
            numero -= 2;
            Portion portion = new Portion(routeName, numero);
            route.addRoute(1, firstPortion);
            if (i < longueur - 1) {
                firstPortion.addSuivant(portion);
            }
            firstPortion = portion;
        }
        return route;
    }

    public void connectRoute(Route route0, int sens0, Route route1, int sens1) {
        route0.getFace(sens0).connect(route1.getFace(sens1));
    }
}
