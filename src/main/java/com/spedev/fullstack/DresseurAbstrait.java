package com.spedev.fullstack;

import java.util.ArrayList;
import java.util.List;

public abstract class DresseurAbstrait implements Dresseur{

    protected String nom;
    protected String villeDOrigine;
    protected List<Pokemon> equipe;


    protected  DresseurAbstrait(String nom, String villeDOrigine){
         if(nom.trim() != ""){
            this.nom = nom;
        } else {
            throw new IllegalArgumentException("Le dresseur doit avoir un nom.");
        }
        if(villeDOrigine.trim() != ""){
            this.villeDOrigine = villeDOrigine;
        }else {
            throw new IllegalArgumentException("Le dresseur doit avoir une ville.");
        }

        this.equipe = new ArrayList<Pokemon>();
    }


    public abstract int tailleMaxEquipe();

    public String getNom(){
        return this.nom;
    }

    public void capturer(Pokemon pokemon) throws EquipePleineException{
        if(this.equipe.size()>=tailleMaxEquipe()){
            
            throw new EquipePleineException("Equipe pleine : vous ne pouvez pas porter plus de 6 pokémons");
        }
        for (Pokemon p : equipe) {
            if(p == pokemon){
                throw new IllegalArgumentException("Vous ne pouvez pas ajouter deux fois le pokémon à l'équipe");
            }
        }
        this.equipe.add(pokemon);
    };


    public List<Pokemon> getEquipe(){
        return  new ArrayList<Pokemon>(this.equipe);
    };             // une copie


    public Pokemon pokemonActif(){
        Pokemon actif;
        actif = null;
        for (Pokemon p : equipe) {
            if(!p.estKo()){
                actif = p;
                break;
            }
        }
        return  actif;
    }                // le premier Pokémon de l'équipe qui n'est pas K.O., ou null

    public boolean peutEncoreCombattre(){
        boolean peutEncoreCombattre = false;
        for (Pokemon p : equipe) {
            if(!p.estKo()){
                peutEncoreCombattre = true;
                break;
            }
        }
        return peutEncoreCombattre;
    }


    public void soignerEquipe(){
        for (Pokemon p : equipe) {
            p.soigner();
        }
    }
    public String badgeOffert(){
        return null;
    }                 // le badge gagné en battant ce dresseur, ou null

}
