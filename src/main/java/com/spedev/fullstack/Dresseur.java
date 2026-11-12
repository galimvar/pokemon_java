package com.spedev.fullstack;

import java.util.List;

public interface Dresseur {
    String getNom();
    String presentation();                 // une phrase qui présente le dresseur
    void capturer(Pokemon pokemon) throws EquipePleineException;
    List<Pokemon> getEquipe();             // une copie
    Pokemon pokemonActif();                // le premier Pokémon de l'équipe qui n'est pas K.O., ou null
    boolean peutEncoreCombattre();
    void soignerEquipe();
    String badgeOffert();                  // le badge gagné en battant ce dresseur, ou null
    Dresseur affronter(Dresseur adversaire);   // retourne le vainqueur (écrite à l'étape 5)
}
