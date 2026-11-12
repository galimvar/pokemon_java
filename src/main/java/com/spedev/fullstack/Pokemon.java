package com.spedev.fullstack;

public abstract class Pokemon {
    private final String nom;
    private int niveau;
    private final int puissance;
    private boolean ko;

    protected Pokemon (String nom, int niveau, int puissance){
        if(nom.trim() != ""){
            this.nom = nom;
        } else {
            throw new IllegalArgumentException("Le pokémon doit avoir un nom.");
        }
        
        if(niveau > 1 && niveau <= 100){
            this.niveau = niveau;
        } else {
            throw new IllegalArgumentException("Le niveau du pokémon doit être compris entre 1 et 100");
        }
        if(puissance > 0){
            this.puissance = puissance;
        } else {
            throw new IllegalArgumentException("La puissance doit être supérieure à 0");
        }
        
        this.ko = false;
    }

    public abstract String getType();

    // Multiplicateur appliqué à la force d'un adversaire de ce type
    public double sensibiliteA(String typeAdversaire) {
        return 1.0;
    }

    public String getTalent() {
        return "Aucun";
    }

    public String getNom(){ return this.nom; }

    public int getNiveau(){ return this.niveau; }

    public int getPuissance(){ return this.puissance; }

    public boolean estKo(){ return this.ko; }

    public int getForce(){ return this.puissance * this.niveau; }

    public int forceContre(Pokemon adversaire){
        return (int) Math.round(getForce() * adversaire.sensibiliteA(getType()));
    }


    public void gagnerNiveau(){ 
        if(this.niveau<100){
            this.niveau++; 
        } else {
            System.out.println("Niveau max déjà atteint");
        }
    }

    public String toString(){
        return this.nom + "(" + getType() + ", niv. " + this.niveau + ",puissance " + this.puissance + ", force " + getForce() + ")" + (ko ? "[K.O.]":"");
    }

    public Pokemon affronter(Pokemon adversaire){
        if(adversaire == this){
            throw new IllegalArgumentException("Un pokémon ne peut pas s'affronter lui-même");
        }
        if (adversaire.estKo() || this.estKo()){
            throw new IllegalStateException("L'un des pokémons n'est pas en état de combattre, soignez-le et revenez");
        }
        Pokemon vainqueur;
        if((this.forceContre(adversaire) > adversaire.forceContre(this)) || (this.forceContre(adversaire) == adversaire.forceContre(this)) ){
            vainqueur = this;
            this.gagnerNiveau();
            adversaire.ko = true;
        } else {
            vainqueur = adversaire;
            adversaire.gagnerNiveau();
            this.ko = true;
        }

        return vainqueur;
        
    }

    public void soigner(){ this.ko = false; }
    
}
