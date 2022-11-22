package com.sdzee.gs.beans;
import java.util.ArrayList;
import java.util.Iterator;
public class User extends Personne {
    private int ID_USER;
    private String MATRICULE;
    private String PASS;
    private Role role;

    public String getMATRICULE() {
        return MATRICULE;
    }

    public String getPASS() {
        return PASS;
    }

    public Role getRole() {
        return role;
    }

    public int getID_USER() {
        return ID_USER;
    }

    public void setMATRICULE(String MATRICULE) {
        this.MATRICULE = MATRICULE;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    public User(int ID_USER, String MATRICULE, String PASS, Role role) {
        this.ID_USER = ID_USER;
        this.MATRICULE = MATRICULE;
        this.PASS = PASS;
        this.role = role;
    }

    public User(int ID_USER, String MATRICULE, String PASS, Role role, int ID, String NOM, String PRENOM,String ADRESSE, int TEL, String MAIL, String CIN) {
        super(ID, NOM, PRENOM,ADRESSE, TEL, MAIL, CIN);
        this.ID_USER = ID_USER;
        this.MATRICULE = MATRICULE;
        this.PASS = PASS;
        this.role = role;
    }    

    public User() {
    }

    public User(int ID_USER, String MATRICULE, String PASS) {
        this.ID_USER = ID_USER;
        this.MATRICULE = MATRICULE;
        this.PASS = PASS;
    }
    
    public User(int ID_USER) {
       this.ID_USER=ID_USER;
    }
    public int ReturnIndex(ArrayList<User> users){
        int indx=-1;
        int i=0;
        Iterator<User> itr=users.iterator();
        while(itr.hasNext()){
            if(itr.next().getID_USER()==this.ID_USER) indx=i;
            i++;
        }
        return indx;
    }

}
