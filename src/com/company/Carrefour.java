package com.company;

/**
 * Created by Pony on 09/10/2014. With IntelliJ
 */
public class Carrefour {
    private CircularLinkedList sorties;

    public Carrefour() {
        sorties = new CircularLinkedList();
    }

    public void addRoute(Route route) {
        sorties.add(route);
    }

    public Route turn() {
        do {
            sorties.next();
        } while (((Route)sorties.get()).isOccupe());

        return (Route)sorties.get();
    }
}
