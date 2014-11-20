package com.company;

import java.util.ArrayList;

/**
 * Created by axeleroy on 06/11/2014.
 */
public class Route {
    private ArrayList<Portion> voie0;
    private ArrayList<Portion> voie1;

    Route() {
        voie0 = new ArrayList<Portion>();
        voie1 = new ArrayList<Portion>();
    }

    public void addRoute(int route, Portion portion) throws IllegalArgumentException {
        if (route == 0) {
            voie0.add(portion);
        } else if (route == 1) {
            voie1.add(portion);
        } else {
            throw new IllegalArgumentException("Parameter route is " + route + " instead of 0 or 1");
        }
    }

    public Portion getEntree(int voie){
        if (voie == 0) {
            return voie1.get(0);
        }
        else if (voie == 1) {
            return voie0.get(0);
        } else {
            return null;
        }
    }

    public Portion getSortie(int voie){
        if (voie == 0) {
            return voie1.get(voie1.size()-1);
        }
        else if (voie == 1) {
            return voie0.get(voie0.size()-1);
        } else {
            return null;
        }
    }
}
