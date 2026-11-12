package com.spedev.fullstack;

public class PokemonElectrique extends Pokemon {
    public PokemonElectrique(String nom, int niveau, int puissance){
        super(nom, niveau, puissance);
    }

    @Override
    public String getType(){
        return "Électrique";
    }

    @Override
    public String getTalent(){
        return "Super Speed";
    }

    @Override
    public int getForce() {
        return (int)Math.round(super.getForce() * 1.5);
    }

}
