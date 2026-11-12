package com.spedev.fullstack;

import java.util.ArrayList;

public class ApprentiArene extends DresseurAbstrait {
    
    public ApprentiArene(String nom, String villeDOrigine){
        super(nom, villeDOrigine);
    }

    public String presentation(){
        return "Apprenti " + this.nom + " de l'arène " + this.villeDOrigine;
    }

     @Override 
     public int tailleMaxEquipe(){
        return 3;
     };

    public Dresseur affronter(Dresseur adversaire){
        Combat affrontement = new Combat(this, adversaire);
        Dresseur vainqueur = affrontement.lancer();

        if(vainqueur != this){
            System.out.println(this.nom + " : Bien joué ! Le maître de l'arène " + this.villeDOrigine + " t'attend.");
        }
        return vainqueur;
    }   // retourne le vainqueur (écrite à l'étape 5)
}
