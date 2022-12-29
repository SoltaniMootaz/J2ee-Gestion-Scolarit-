package com.sdzee.gs.beans;

public class TypeNote {
	private int ID_TYPEN;
	private String NOM_TYPE;
	private float COEF_N;
	public TypeNote() {
		// TODO Auto-generated constructor stub
	}
	public TypeNote(int id,String nom,float coef) {
	
		ID_TYPEN = id;
		NOM_TYPE = nom;
		COEF_N = coef;
	}
	
	public int getID_TypeN() {
		return ID_TYPEN;
	}
	public void setID_TypeN(int iD_TypeN) {
		ID_TYPEN = iD_TypeN;
	}
	public float getCOEF_N() {
		return COEF_N;
	}
	public void setCOEF_N(float cOEF_N) {
		COEF_N = cOEF_N;
	}
	public String getNOM_TYPE() {
		return NOM_TYPE;
	}
	public void setNOM_TYPE(String nOM_TYPE) {
		NOM_TYPE = nOM_TYPE;
	}

}
