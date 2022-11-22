package com.sdzee.gs.beans;

public class Personne {
    private int ID_PERS;
    private String NOM;
    private String PRENOM;
    private String ADRESSE;
    private int TEL;
    private String MAIL;
    private String CIN;
public Personne(){
	
}

    public Personne(int ID_PERS, String NOM, String PRENOM, String ADRESSE, int TEL, String MAIL, String CIN) {
        this.ID_PERS = ID_PERS;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.ADRESSE = ADRESSE;
        this.TEL = TEL;
        this.MAIL = MAIL;
        this.CIN = CIN;
    }

    public void setID_PERS(int ID_PERS) {
        this.ID_PERS = ID_PERS;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public void setADRESSE(String ADRESSE) {
        this.ADRESSE = ADRESSE;
    }

    public void setTEL(int TEL) {
        this.TEL = TEL;
    }

    public void setMAIL(String MAIL) {
        this.MAIL = MAIL;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public int getID_PERS() {
        return ID_PERS;
    }

    public String getNOM() {
        return NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public String getADRESSE() {
        return ADRESSE;
    }

    public int getTEL() {
        return TEL;
    }

    public String getMAIL() {
        return MAIL;
    }

    public String getCIN() {
        return CIN;
    }


public void Display() {
	System.out.println("votre nom est : "+this.NOM);
	System.out.println("votre prenom est : "+this.PRENOM);
	System.out.println("votre email est : "+this.MAIL);
        System.out.println("votre numero de telephone est : "+this.TEL);
        System.out.println("Votre CIN est :"+ this.CIN);
	System.out.println("votre ID est : "+this.ID_PERS);
}

}