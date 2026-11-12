package com.spedev.fullstack;

public class PokemonPlante extends Pokemon {
    public PokemonPlante(String nom, int niveau, int puissance){
        super(nom, niveau, puissance);
    }

    @Override
    public String getType(){
        return "Plante";
    }

    public double sensibiliteA(String typeAdversaire) {
        double facteurSensibilite;
        switch (typeAdversaire) {
            case "Feu":
                facteurSensibilite = 2.0;
                break;
            case "Eau":
                facteurSensibilite = 0.5;
                break;
            default:
                facteurSensibilite = 1.0;
                break;
        }
        return facteurSensibilite;
    }

    @Override 
    public String getTalent(){
        return "SuperPousse";
    }

    @Override 
    public Pokemon affronter(Pokemon adversaire) {
        soigner();
        gagnerNiveau();
        return super.affronter(adversaire);
    }

}
