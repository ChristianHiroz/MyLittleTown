package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pony on 23/10/2014. With IntelliJ
 */
public class Route extends AbstractRoute {
    List<PortionRoute> route;

    public Route(List<PortionRoute> route) {
        this.route = new ArrayList<PortionRoute>();
    }

    public List<PortionRoute> getRoute() {
        return route;
    }

    public void setRoute(List<PortionRoute> route) {
        this.route = route;
    }
}
