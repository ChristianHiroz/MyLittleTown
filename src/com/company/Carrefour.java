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
        sorties.insertAfterActual(route);
    }

    public Route turn() {
        do {
            sorties.goToNextElement();
        }while (!((Route)sorties.getActualElementData()).isOccupe());

        return (Route)sorties.getActualElementData();
    }
}
