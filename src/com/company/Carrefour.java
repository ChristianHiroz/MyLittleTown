package com.company;

/**
 * Created by Pony on 09/10/2014. With IntelliJ
 */
public class Carrefour extends AbstractRoute {
    private CircularLinkedList sorties;
    private int nbVoitures;

    public Carrefour() {
        sorties = new CircularLinkedList();
    }

    @Override
    public void setSuivant(AbstractRoute route) {
        sorties.add(route);
    }

    @Override
    public boolean isOccupe() {
        if (nbVoitures < sorties.length()) {
            return false;
        } else return true;
    }

    @Override
    public void occuperRoute() {
        nbVoitures++;
    }

    @Override
    public void libererRoute() {
        nbVoitures--;
    }

    @Override
    public AbstractRoute suivant() {
        do {
            sorties.next();
        } while (((AbstractRoute)sorties.get()).isOccupe());

        return (AbstractRoute)sorties.get();
    }
}
