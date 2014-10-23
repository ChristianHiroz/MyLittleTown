package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pony on 09/10/2014. With IntelliJ
 */
public class Ville {

    public ArrayList<Route> routes;

    public Ville()
     {
        routes=new ArrayList<Route>();
      }
    public void ajouterRoute(Route r)
    {
        this.routes.add(r);
    }
    
}
