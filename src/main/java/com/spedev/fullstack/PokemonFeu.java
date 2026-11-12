package com.spedev.fullstack;

public class PokemonFeu extends Pokemon {
    public PokemonFeu(String nom, int niveau, int puissance){
        super(nom, niveau, puissance);
    }

    @Override
    public String getType(){
        return "Feu";
    }

    @Override
    public String getTalent(){
        return "Brasier";
    }

    @Override
    public int getForce() {
        return (int)Math.round(super.getForce() * 1.2);
    }

    public double sensibiliteA(String typeAdversaire) {
        double facteurSensibilite;
        switch (typeAdversaire) {
            case "Plante":
                facteurSensibilite = 1.0;
                break;
            case "Eau":
                facteurSensibilite = 2.0;
                break;
            default:
                facteurSensibilite = 1.0;
                break;
        }
        return facteurSensibilite;
    }
}
