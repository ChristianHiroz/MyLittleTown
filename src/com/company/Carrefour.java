package com.company;

/**
 * Created by Pony on 09/10/2014. With IntelliJ
 */
public class Carrefour extends AbstractRoute {
    private CircularLinkedList sorties;
    private int

    public Carrefour() {
        sorties = new CircularLinkedList();
    }

    public void addRoute(Route route) {
        sorties.add(route);
    }

    @Override
    public Route suivant() {
        do {
            sorties.next();
        } while (((Route)sorties.get()).isOccupe());

        return (Route)sorties.get();
    }
}
