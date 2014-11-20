package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axeleroy on 20/11/2014.
 */
public class Intersection {
    List<Face> voies;
    Portion entree;
    Portion sortie;

    public Intersection() {
        voies = new ArrayList<Face>();
        entree = new Portion();
        sortie = new Portion();
    }

    public void ajouterFace(Face face) {
        Face f = new Face(entree, sortie);
        f.connect(face);
    }
}
