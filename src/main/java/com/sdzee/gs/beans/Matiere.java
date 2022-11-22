package com.sdzee.gs.beans;

public class Matiere {
    private int ID;

    private Enseignant ENS;
    private String NOM;

    public Matiere(int ID,  Enseignant ENS, String NOM) {
        this.ID = ID;
       
        this.ENS = ENS;
        this.NOM = NOM;
    }

    public Matiere() {
    }

    public int getID() {
        return ID;
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

  

    public void setENS(Enseignant ENS) {
        this.ENS = ENS;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }
    
}

