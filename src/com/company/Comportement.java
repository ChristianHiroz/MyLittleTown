package com.company;

/**
 * Created by Fluttershy on 20/11/2014.
 */
// Enumération des différents comportements : 
// ESSENCE = L'automobiliste vas cherche une station essence,
// pour cela, lorsqu'il aura un choix entre deux portions suivantes, il vas parcourir leur suite voir s'il y  a une station
// ESSENCE arrive lorsqu'un automobiliste n'a que 10% de son réservoir plein
// CHAUFFARD, TOURISTE, PRESSER, VIEUX modifient les propriétés suivantes : vitesse, vitesseMax et accélération.
// LIVREUR s'arrête s'il y a un lieu de livraison sur la portion
public enum Comportement {
    DEFAULT,ESSENCE,CHAUFFARD,TOURISTE,PRESSER,VIEUX,LIVREUR;
}
