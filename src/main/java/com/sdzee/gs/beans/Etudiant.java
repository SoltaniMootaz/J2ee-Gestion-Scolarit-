package com.sdzee.gs.beans;

public class Etudiant extends Personne {
    private int ID_ETD;
	private int NUM_INSC;

public int getID_ETD() {
    return ID_ETD;
}

public int getNUM_INSC() {
    return NUM_INSC;
}

public void setID_ETD(int ID_ETD) {
    this.ID_ETD = ID_ETD;
}

public void setNUM_INSC(int NUM_INSC) {
    this.NUM_INSC = NUM_INSC;
}

    
void affichage() {
	
	System.out.println("votre numero d'inscription : "+getNUM_INSC());
	this.Display();
}
//CONSTRUCTORS
public Etudiant(){	
}

public Etudiant(int NUM_INSC) {
    this.NUM_INSC = NUM_INSC;
}

public Etudiant(int ID_ETD, int NUM_INSC) {
    this.ID_ETD = ID_ETD;
    this.NUM_INSC = NUM_INSC;
}

public Etudiant(int ID_ETD, int NUM_INSC, int ID_PERS, String NOM, String PRENOM, String ADRESSE, int TEL, String MAIL, String CIN) {
    super(ID_PERS, NOM, PRENOM, ADRESSE, TEL, MAIL, CIN);
    this.ID_ETD = ID_ETD;
    this.NUM_INSC = NUM_INSC;
}


}
