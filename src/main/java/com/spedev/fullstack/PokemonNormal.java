package com.spedev.fullstack;

public class PokemonNormal extends Pokemon {
    
    public PokemonNormal(String nom, int niveau, int puissance){
        super(nom, niveau, puissance);
    }

    @Override
    public String getType(){
        return "Normal";
    }

}
