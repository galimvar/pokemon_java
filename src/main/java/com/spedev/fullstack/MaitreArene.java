package com.spedev.fullstack;

import java.util.ArrayList;


public class MaitreArene extends DresseurAbstrait {
    private int defensesReussies;
    private String specialite;

    public MaitreArene(String nom, String villeDOrigine, String specialite){
        super(nom, villeDOrigine);
        this.specialite = specialite;
    }

    @Override 
    public int tailleMaxEquipe(){
        return 6;
    };

    public String presentation(){
        return "Maitre " + this.nom + " de l'arène " + this.villeDOrigine + ", spécialiste " + specialite +" (" + defensesReussies + " défense(s) réussie(s))";
    }

    @Override 
    public void capturer(Pokemon pokemon) throws EquipePleineException{
        if(!specialite.equals(pokemon.getType())){
            throw new IllegalArgumentException(nom + " n'accepte que des pokémons de type " + specialite + " dans son équipe !");
        }
        if(this.equipe.size()>=3){
            
            throw new EquipePleineException("Equipe pleine : vous ne pouvez pas porter plus de 6 pokémons");
        }
        for (Pokemon p : equipe) {
            if(p == pokemon){
                throw new IllegalArgumentException("Vous ne pouvez pas ajouter deux fois le pokémon à l'équipe");
            }
        }
        this.equipe.add(pokemon);
    };

    public String badgeOffert(){
        return "Badge " + this.villeDOrigine;
    }                 

    public int getNbDefensesReussies(){
        return this.defensesReussies;
    }

    public Dresseur affronter(Dresseur adversaire){
        soignerEquipe();
        Combat affrontement = new Combat(this, adversaire);
        Dresseur vainqueur = affrontement.lancer();

        if(vainqueur == this){
            this.defensesReussies++;
        }
        return vainqueur;
    }   // retourne le vainqueur (écrite à l'étape 5)
}
