package com.company;

import java.util.ArrayList;

/**
 * Created by axeleroy on 06/11/2014.
 */
public class Route {
    private ArrayList<Portion> route0;
    private ArrayList<Portion> route1;

    Route() {
        route0 = new ArrayList<Portion>();
        route1 = new ArrayList<Portion>();
    }

    public void addRoute(int route, Portion portion) throws IllegalArgumentException {
        if (route == 0) {
            route0.add(portion);
        } else if (route == 2) {
            route1.add(portion);
        } else {
            throw new IllegalArgumentException("Parameter route is " + route + "instead of 0 or 1");
        }
    }
}
