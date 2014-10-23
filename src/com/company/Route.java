package com.company;

import java.util.List;

/**
 * Created by Pony on 23/10/2014. With IntelliJ
 */
public class Route extends AbstractRoute{
    private List<PortionRoute> route;

    public Route(List<PortionRoute> route) {
        this.route = route;
    }

    public List<PortionRoute> getRoute() {
        return route;
    }

    public void setRoute(List<PortionRoute> route) {
        this.route = route;
    }
}
