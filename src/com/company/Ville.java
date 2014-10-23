package com.company;

import java.util.ArrayList;

/**
 * Created by Pony on 09/10/2014. With IntelliJ
 */
public class Ville {

    public ArrayList<Portion> routes;

    public Ville()
     {
        routes=new ArrayList<Portion>();
      }
    public void ajouterRoute(Portion r)
    {
        this.routes.add(r);
    }
    
}
