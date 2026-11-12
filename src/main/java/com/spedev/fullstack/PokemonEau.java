package com.spedev.fullstack;

public class PokemonEau extends Pokemon {
    
    public PokemonEau(String nom, int niveau, int puissance){
        super(nom, niveau, puissance);
    }

    @Override
    public String getType(){
        return "Eau";
    }

    public double sensibiliteA(String typeAdversaire) {
        double facteurSensibilite;
        switch (typeAdversaire) {
            case "Électrique":
                facteurSensibilite = 2.0;
                break;
            case "Plante":
                facteurSensibilite = 2.0;
                break;
            default:
                facteurSensibilite = 1.0;
                break;
        }
        return facteurSensibilite;
    }

    @Override
    public String getTalent(){
        return "Croissance";
    }
 
    @Override
    public void gagnerNiveau() {
        super.gagnerNiveau();
        super.gagnerNiveau();
    }
}
