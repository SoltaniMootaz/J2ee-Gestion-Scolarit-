package com.sdzee.gs.beans;
public class Matiere {
    private int ID;
    private Groupe GROUPE;
    private Enseignant ENS;
    private String NOM;
    private float COEF;

    public Matiere(int ID, Groupe GROUPE, Enseignant ENS, String NOM) {
        this.ID = ID;
        this.GROUPE = GROUPE;
        this.ENS = ENS;
        this.NOM = NOM;
    }

    public Matiere() {
    }

    public int getID() {
        return ID;
    }

    public Groupe getGROUPE() {
        return GROUPE;
    }

    public Enseignant getENS() {
        return ENS;
    }

    public String getNOM() {
        return NOM;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGROUPE(Groupe GROUPE) {
        this.GROUPE = GROUPE;
    }

    public void setENS(Enseignant ENS) {
        this.ENS = ENS;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

	public float getCOEF() {
		return COEF;
	}

	public void setCOEF(float cOEF) {
		COEF = cOEF;
	}
    
}
