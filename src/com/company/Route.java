package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axeleroy on 06/11/2014.
 */
public class Route {
    private List<Portion> voie0;
    private List<Portion> voie1;
    private String name;

    Route(String name) {
        voie0 = new ArrayList<Portion>();
        voie1 = new ArrayList<Portion>();
        this.name = name;
    }

    public void addRoute(int voie, Portion portion) throws IllegalArgumentException {
        if (voie == 0) {
            voie0.add(portion);
        } else if (voie == 1) {
            voie1.add(portion);
        } else {
            throw new IllegalArgumentException("Parameter voie is " + voie + " instead of 0 or 1");
        }
    }

    public Portion getEntree(int voie) throws IllegalArgumentException {
        if (voie == 0) {
            return voie1.get(0);
        }
        else if (voie == 1) {
            return voie0.get(0);
        } else {
            throw new IllegalArgumentException("Parameter voie is " + voie + " instead of 0 or 1");
        }
    }

    public Portion getSortie(int voie) throws IllegalArgumentException {
        if (voie == 0) {
            return voie1.get(voie1.size()-1);
        }
        else if (voie == 1) {
            return voie0.get(voie0.size()-1);
        } else {
            throw new IllegalArgumentException("Parameter voie is " + voie + " instead of 0 or 1");
        }
    }

    public Face getFace(int voie) throws IllegalArgumentException {
        if (voie != 0 && voie != 1) {
            throw new IllegalArgumentException("Parameter voie is " + voie + " instead of 0 or 1");
        }
        return new Face(getEntree(voie), getSortie(1 - voie));
    }

    @Override
    public String toString(){
        return this.name;
    }
}
