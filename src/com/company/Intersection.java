package com.company;

import java.util.List;

/**
 * Created by axeleroy on 20/11/2014.
 */
public class Intersection {
    private List<Face> faces;

    public Intersection(List<Face> f, GestionnaireFeux g) {
        faces = f;

        for (int i = 0; i < faces.size(); i++) {
            for (int j = 0; j < faces.size(); j++) {
                if (i != j) {
                    faces.get(i).connect(faces.get(j));
                }
            }

            Feu feu;
            if (i % 2 == 0) {
                feu = new Feu(false);
            } else {
                feu = new Feu(true);
            }
            faces.get(i).getSortie().setFeu(feu);
            g.addFeu(feu);
        }
    }
}
