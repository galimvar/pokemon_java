package com.spedev.fullstack;

public class PokemonPsy extends Pokemon {
    public PokemonPsy(String nom, int niveau, int puissance){
        super(nom, niveau, puissance);
    }

    @Override
    public String getType(){
        return "Psy";
    }

}
