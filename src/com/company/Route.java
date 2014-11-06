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

    public Portion getEntree(int sens){
        if (sens == 0) {
            return route1.get(0);
        }
        else if (sens == 1) {
            return route0.get(0);
        } else {
            return null;
        }
    }

    public Portion getSortie(int sens){
        if (sens == 0) {
            return route1.get(route1.size()-1);
        }
        else if (sens == 1) {
            return route0.get(route0.size()-1);
        } else {
            return null;
        }
    }
}
