package com.company;

/**
 * Created by Pony on 09/10/2014. With IntelliJ
 */
public class Carrefour extends AbstractRoute {
    private CircularLinkedList sorties;

    public Carrefour() {
        sorties = new CircularLinkedList();
    }

    public void addRoute(PortionRoute portionRoute) {
        sorties.add(portionRoute);
    }

    public PortionRoute turn() {
        do {
            sorties.next();
        } while (((PortionRoute)sorties.get()).isOccupe());

        return (PortionRoute)sorties.get();
    }
}
