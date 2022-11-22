package com.sdzee.gs.beans;
public class Enseignant extends Personne {
	   private int ID_ENS;
	   private int CNSS;
	   private boolean CHEF;

	//SETTERS AND GETTERS
	public void setCNSS(int cnss) {
		this.CNSS=cnss;
	}

	    public void setID_ENS(int ID_ENS) {
	        this.ID_ENS = ID_ENS;
	    }

	    public void setCHEF(boolean CHEF) {
	        this.CHEF = CHEF;
	    }

	    

	public int getCNSS() {
		return CNSS;
	}

	    public int getID_ENS() {
	        return ID_ENS;
	    }

	    public boolean isCHEF() {
	        return CHEF;
	    }

	  

	//FUNCTIONS
	public void affichageCNSS() {
		System.out.println("cnss du professeur ==> "+getCNSS());
	        this.Display();
	}

	//CONSTRUCTORS
	public Enseignant(){
		
	} 

	 public Enseignant(int CNSS) {
	        this.CNSS = CNSS;
	    }

	    public Enseignant(int ID_ENS, int CNSS, boolean CHEF,  int ID_PERS, String NOM, String PRENOM, String ADRESSE, int TEL, String MAIL, String CIN) {
	        super(ID_PERS, NOM, PRENOM, ADRESSE, TEL, MAIL, CIN);
	        this.ID_ENS = ID_ENS;
	        this.CNSS = CNSS;
	        this.CHEF = CHEF;

	    }

	}
