package com.company;

/**
 * Created by axeleroy on 06/11/2014.
 */
public class RouteFactory {
    private static final class RouteFactoryHolder {
        private static final RouteFactory INSTANCE = new RouteFactory();
    }

    private String[] lesNoms = new String[11];

    private RouteFactory() {
        this.lesNoms[0] = "Avenue du Lapin Doré";
        this.lesNoms[1] = "Rue du Lapin Brillant";
        this.lesNoms[2] = "Boulevard du Cassoulet";
        this.lesNoms[3] = "Avenue de la Cuisse";
        this.lesNoms[4] = "Rue du BonBouchon";
        this.lesNoms[5] = "Avenue des Pincettes Rondes";
        this.lesNoms[6] = "Boulard PorteJartelle";
        this.lesNoms[7] = "Rue de la Guimauve";
        this.lesNoms[8] = "Rue 404";
        this.lesNoms[9] = "Chemin de la Pinta";
        this.lesNoms[10] = "Place Domino";
    }

    public static RouteFactory getInstance() {
        return RouteFactoryHolder.INSTANCE;
    }

    public Route createRoute(int longueur) {
        Route route = new Route(this.lesNoms[(int)Math.random() * 10]);

        Portion firstPortion = new Portion();


        for (int i = 0; i < longueur; i ++) {
            Portion portion = new Portion();
            route.addRoute(0, firstPortion);
            if (i < longueur - 1) {
                firstPortion.addSuivant(portion);
            }
            firstPortion = portion;
        }

        firstPortion = new Portion();

        for (int i = 0; i < longueur; i ++) {
            Portion portion = new Portion();
            route.addRoute(1, firstPortion);
            if (i < longueur - 1) {
                firstPortion.addSuivant(portion);
            }
            firstPortion = portion;
        }

        return route;
    }

    public void connectRoute(Route route0, int sens0, Route route1, int sens1) {
        Face face1 = new Face(route0.getEntree(sens0), route1.getSortie(sens1));
        Face face2 = new Face(route1.getEntree(sens1), route0.getSortie(sens0));
        face1.connect(face2);
    }
}
