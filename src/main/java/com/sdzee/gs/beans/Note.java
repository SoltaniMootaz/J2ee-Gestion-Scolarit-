package com.sdzee.gs.beans;

import java.util.ArrayList;

public class Note {
	   private Matiere MAT;
	   private Etudiant ETD;
	   private TypeNote TYPE;
	   private double note;

	    public void setMAT(Matiere MAT) {
	        this.MAT = MAT;
	    }

	    public void setETD(Etudiant ETD) {
	        this.ETD = ETD;
	    }

	    public void setTYPE(TypeNote TYPE) {
	        this.TYPE = TYPE;
	    }

	    public void setNote(double note) {
	        this.note = note;
	    }

	    public Matiere getMAT() {
	        return MAT;
	    }

	    public Etudiant getETD() {
	        return ETD;
	    }

	    public TypeNote getTYPE() {
	        return TYPE;
	    }

	    public double getNote() {
	        return note;
	    }

	    public Note(Matiere MAT, Etudiant ETD, TypeNote TYPE, double note) {
	        this.MAT = MAT;
	        this.ETD = ETD;
	        this.TYPE = TYPE;
	        this.note = note;
	    }

	    public Note() {
	    }
	    
	    public Note RetournerNoteForMoy(ArrayList<Note> notes,int ID_MAT, int ID_TYPEN,int ID_ETD) {
	    	Note n1=new Note();
	    	for(Note n : notes) {
	    		if(n.getMAT().getID()==ID_MAT && n.getTYPE().getID_TypeN()==ID_TYPEN && n.getETD().getID_ETD()==ID_ETD) {
		    		
		    		n1=n;
	    		}
	    	}
	    	
	    	return n1;
	    }
	   
	   
	}

