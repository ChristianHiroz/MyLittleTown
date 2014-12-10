package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axeleroy on 10/12/2014.
 */
public class GestionnaireFeux extends Thread {
    List<Feu> feux;

    public GestionnaireFeux() {
        feux = new ArrayList<Feu>();
    }

    public void permute() {
        for(Feu feu : feux) {
            feu.permute();
        }
    }

    public void addFeu(Feu feu) {
        feux.add(feu);
    }

    @Override
    public void run() {
        for(;;) {
            permute();

            for (Feu f : feux) {
                System.out.println(f);
            }

            try {
                sleep(5000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
