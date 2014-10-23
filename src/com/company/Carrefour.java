package com.company;

/**
 * Created by Pony on 09/10/2014. With IntelliJ
 */
public class Carrefour {
    private CircularLinkedList sorties;
    private int nbVoitures;

    public Carrefour() {
        sorties = new CircularLinkedList();
    }

    public void setSuivant(Portion route) {
        sorties.add(route);
    }

    public boolean isOccupe() {
        if (nbVoitures < sorties.length()) {
            return false;
        } else return true;
    }

    public void occuperRoute() {
        nbVoitures++;
    }

    public void libererRoute() {
        nbVoitures--;
    }

    public Portion suivant() {
        do {
            sorties.next();
        } while (((Portion)sorties.get()).isOccupe());

        return (Portion)sorties.get();
    }
}
