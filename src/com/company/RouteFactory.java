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

    public RouteFactory getInstance() {
        return RouteFactoryHolder.INSTANCE;
    }

    public Route createRoute(int longueur) {
        Route route = new Route();

        for (int i = 0; i < longueur; i ++) {
            Portion portion = new Portion();
            route.addRoute(0, portion);
        }

        for (int i = 0; i < longueur; i ++) {
            Portion portion = new Portion();
            route.addRoute(1, portion);
        }

        return route;
    }
}
