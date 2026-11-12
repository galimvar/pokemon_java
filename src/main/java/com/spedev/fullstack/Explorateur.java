package com.spedev.fullstack;

import java.util.ArrayList;
import java.util.List;


public class Explorateur extends DresseurAbstrait {

    public List<String> badges;

    public Explorateur(String nom, String villeDOrigine) {
        super(nom, villeDOrigine);
        this.badges = new ArrayList<String>();
    }

    @Override 
     public int tailleMaxEquipe(){
        return 6;
     };

    public String presentation(){
        return "Explorateur " + this.nom + ", de " + this.villeDOrigine + "(" + this.badges.size() + " bagdge(s))";
    }

    public List<String> getBadges(){
        return  List.copyOf(this.badges);
    }; 

    public Dresseur affronter(Dresseur adversaire){
        Combat affrontement = new Combat(this, adversaire);
        Dresseur vainqueur = affrontement.lancer();

        if(vainqueur == this){
            if(adversaire.badgeOffert() != null){
                this.badges.add(adversaire.badgeOffert());
            }
        }
        return vainqueur;
    }   // retourne le vainqueur (écrite à l'étape 5)
}
