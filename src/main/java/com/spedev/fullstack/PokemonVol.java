package com.spedev.fullstack;

public class PokemonVol extends Pokemon {

    public PokemonVol(String nom, int niveau, int puissance){
        super(nom, niveau, puissance);
    }

    @Override
    public String getType(){
        return "Vol";
    }

}
