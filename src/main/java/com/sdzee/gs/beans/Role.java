package com.sdzee.gs.beans;

import java.util.*;

public class Role {
    private int ID_ROLE;
    private String NOM_ROLE;


    public int getID() {
        return ID_ROLE;
    }

    public String getNOM() {
        return NOM_ROLE;
    }

   

    public void setID(int ID) {
        this.ID_ROLE = ID;
    }

    public void setNOM(String NOM) {
        this.NOM_ROLE = NOM;
    }

    public Role(int ID_ROLE, String NOM_ROLE) {
        this.ID_ROLE = ID_ROLE;
        this.NOM_ROLE = NOM_ROLE;
    }

    public Role(int ID_ROLE) {
        this.ID_ROLE = ID_ROLE;
    }

    public Role() {
    }
    public int ReturnIndex(ArrayList<Role> roles){
        int indx=-1;
        int i=0;
        Iterator<Role> itr=roles.iterator();
        while(itr.hasNext()){
            if(itr.next().getID()==this.ID_ROLE) indx=i;
            i++;
        }
        return indx;
    }
    
}
