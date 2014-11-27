package com.company;

/**
 * Created by axeleroy on 20/11/2014.
 */
public class Intersection {
    Portion entree;

    public Intersection() {
        entree = new Portion();
    }

    public void ajouterFace(Face face) {
        Face f = new Face(entree, entree);
        f.connect(face);
    }
}
