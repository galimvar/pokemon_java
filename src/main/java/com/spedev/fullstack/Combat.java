package com.spedev.fullstack;

public class Combat {
    private Dresseur dresseur1;
    private Dresseur dresseur2;

    public Combat(Dresseur dresseur1, Dresseur dresseur2){
        this.dresseur1 = dresseur1;
        this.dresseur2 = dresseur2;
    }

    public Dresseur lancer(){
        if(!this.dresseur1.peutEncoreCombattre() || !this.dresseur2.peutEncoreCombattre()){
            throw new IllegalArgumentException("Les dresseurs doivent avoir au moins un pokémon en état de combattre.");
        }

        System.out.println("=== " + dresseur1.presentation() + " VS " + dresseur2.presentation() + " ===");
        
        while(dresseur1.peutEncoreCombattre() && dresseur2.peutEncoreCombattre()){
            dresseur1.pokemonActif().affronter(dresseur2.pokemonActif());
        }
        if(dresseur1.peutEncoreCombattre()){
            System.out.println(dresseur1.getNom() + " remporte le combat !");
            return dresseur1;
        } else {
            System.out.println(dresseur2.getNom() + " remporte le combat !");
            return dresseur2;
        }
    }
}
