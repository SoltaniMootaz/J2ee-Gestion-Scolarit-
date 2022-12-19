package com.sdzee.gs.db;

import java.sql.*;
import java.util.ArrayList;

import com.sdzee.gs.beans.Enseignant;
import com.sdzee.gs.beans.Etudiant;
import com.sdzee.gs.beans.Personne;
import com.sdzee.gs.beans.Role;
import com.sdzee.gs.beans.User;


    public  class Connexion {
    public static Connection cnx;
    public static int ID_PERS;
    
    public Connexion()throws SQLException, ClassNotFoundException {
        try{
         Class.forName("com.mysql.jdbc.Driver");
         cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_scolarite?characterEncoding=utf8","root","");
       }catch(SQLException e){
           System.out.println(e);
       }
    }
    public  int VerifUsers(String Mat,String Pass) throws SQLException, ClassNotFoundException{
         
         String QUERY = "select ID_PERS, count(*) AS counted  from user where MATRICULE=? and PASS=?";
         int retourner = 0;
          
        try{
         PreparedStatement Statement1=cnx.prepareStatement(QUERY);
         Statement1.setString(1, Mat);
         Statement1.setString(2, Pass);
         User user = new User();
         ResultSet rs1 = Statement1.executeQuery();
         rs1.next();
         
         
         //ResultSetMetaData metadata=rs1.getMetaData();*/
         int count=rs1.getInt("counted");
         if(count>0){
         ID_PERS=rs1.getInt("ID_PERS");
         retourner =1;
         }else{
         retourner =0;
         }
                     
             }
        catch (SQLException e) {
            //If exception occurs catch it and exit the program
            e.printStackTrace();
        }
        return retourner ;
        }  
    
    public static Personne RetournerPersonneFromENS(int ID){
        String Query="Select * from personne p Inner join enseignant e on e.ID_PERS=p.ID_PERS where e.CNSS=? ";
        Personne P=new Personne();
        try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setInt(1, ID);
               ResultSet rslt=stmt.executeQuery();   
               
               while(rslt.next()){
               Personne P_tmp=new Personne();
               P_tmp.setID_PERS(rslt.getInt("ID_PERS"));
               P_tmp.setNOM(rslt.getString("NOM"));
           
               P_tmp.setPRENOM(rslt.getString("PRENOM"));
               P_tmp.setADRESSE(rslt.getString("ADRESSE"));
               P_tmp.setMAIL(rslt.getString("MAIL"));
               P_tmp.setTEL(rslt.getInt("TEL"));
               P_tmp.setCIN(rslt.getString("CIN"));
               P=P_tmp;
               } 
              
           }catch(SQLException e){
               e.printStackTrace();
           }      
           return P;
    }
    public static int RetournerIDensWithCNSS(int cnss){
        String Query="Select ID_ENS from enseignant where CNSS=?";
        int ID=0;
        try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setInt(1, cnss);
               ResultSet rslt=stmt.executeQuery();   
               
               while(rslt.next()){
               ID=rslt.getInt("ID_ENS");
               } 
              
           }catch(SQLException e){
               e.printStackTrace();
           }      
           return ID;
    }
    public static int RetournerIDetdWithNUM(int num){
        String Query="Select ID_ETD from etudiants where NUM_INSC=?";
        int ID=0;
        try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setInt(1, num);
               ResultSet rslt=stmt.executeQuery();   
               
               while(rslt.next()){
               ID=rslt.getInt("ID_ETD");
               } 
              
           }catch(SQLException e){
               e.printStackTrace();
           }      
           return ID;
    }
    public static  Personne RetournerPersonneFromETD(int num){
         String Query="Select * from personne p Inner join etudiants e on e.ID_PERS=p.ID_PERS where e.NUM_INSC=? ";
        Personne P=new Personne();
        System.out.println(num);
        try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setInt(1, num);
               ResultSet rslt=stmt.executeQuery();   
               
               while(rslt.next()){
               Personne P_tmp=new Personne();
               P_tmp.setID_PERS(rslt.getInt("ID_PERS"));
               P_tmp.setNOM(rslt.getString("NOM"));
           
               P_tmp.setPRENOM(rslt.getString("PRENOM"));
               P_tmp.setADRESSE(rslt.getString("ADRESSE"));
               P_tmp.setMAIL(rslt.getString("MAIL"));
               P_tmp.setTEL(rslt.getInt("TEL"));
               P_tmp.setCIN(rslt.getString("CIN"));
               P=P_tmp;
               } 
              
           }catch(SQLException e){
               e.printStackTrace();
           }    
        System.out.println(P.getNOM());
           return P;
    }
    public static Role RetournerNoneRole(){
        String Query="SELECT *FROM role where NOM_ROLE='none'";
           
           Role _role=new Role();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               Role role=new Role();
               role.setID(rslt.getInt("ID_ROLE"));
               role.setNOM(rslt.getString("NOM_ROLE"));
               _role=role;
               } 
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return _role;
    }
    public static int RetournerPermissions(){
        String Query="SELECT * FROM role r inner join user u on u.ID_ROLE=r.ID_ROLE where u.ID_PERS=?";
           
           Role _role=new Role();
           int permission=0;
           
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
                System.out.println("l'id est:"+ID_PERS);
               stmt.setInt(1,ID_PERS);
               ResultSet rslt=stmt.executeQuery();   

               if(rslt.next()){
               Role role=new Role();
               role.setID(rslt.getInt("ID_ROLE"));
                System.out.println("l'id est du role est:"+rslt.getInt("ID_ROLE"));
               role.setNOM(rslt.getString("NOM_ROLE"));
               _role=role;
               }
           }catch(SQLException e){
               e.printStackTrace();
           }
           
          System.out.println(_role.getNOM());
          /* if(null == _role.getNOM()){
               permission=0;
           }else { 
        	   switch (_role.getNOM()) {
            case "superadmin" : permission=3;
            case "chef" : permission=2;
            case "enseignant":permission= 1;
            default :permission= 0;
        }
           }*/
           return permission;
    }

    public static ArrayList<User> ConsulterUsers(){
           String Query="SELECT *FROM user u inner join personne p on u.ID_PERS=p.ID_PERS inner join role r on u.ID_ROLE=r.ID_ROLE";
           
           ArrayList<User> users=new ArrayList<User>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               Role role=new Role();
               User user = new User();
               user.setID_PERS(rslt.getInt("ID_PERS"));
               user.setNOM(rslt.getString("NOM"));
           
               user.setPRENOM(rslt.getString("PRENOM"));
               user.setADRESSE(rslt.getString("ADRESSE"));
               user.setMAIL(rslt.getString("MAIL"));
               user.setTEL(rslt.getInt("TEL"));
               user.setCIN(rslt.getString("CIN"));
               user.setID_USER(rslt.getInt("ID_USER"));
               user.setMATRICULE(rslt.getString("MATRICULE"));
               user.setPASS(rslt.getString("PASS"));
               role.setID(rslt.getInt("ID_ROLE"));
               role.setNOM(rslt.getString("NOM_ROLE"));
               user.setRole(role);
               users.add(user);
               } 
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return users;
       }
    public static User ConsulterUser(int num){
        String Query="SELECT *FROM user u inner join personne p on u.ID_PERS=p.ID_PERS inner join role r on u.ID_ROLE=r.ID_ROLE where u.ID_USER="+num ;
        
        User usr=new User();
 
        try{
            
            PreparedStatement stmt=cnx.prepareStatement(Query);
            ResultSet rslt=stmt.executeQuery();   

            while(rslt.next()){
            Role role=new Role();
            User user = new User();
            user.setID_PERS(rslt.getInt("ID_PERS"));
            user.setNOM(rslt.getString("NOM"));
        
            user.setPRENOM(rslt.getString("PRENOM"));
            user.setADRESSE(rslt.getString("ADRESSE"));
            user.setMAIL(rslt.getString("MAIL"));
            user.setTEL(rslt.getInt("TEL"));
            user.setCIN(rslt.getString("CIN"));
            user.setID_USER(rslt.getInt("ID_USER"));
            user.setMATRICULE(rslt.getString("MATRICULE"));
            user.setPASS(rslt.getString("PASS"));
            role.setID(rslt.getInt("ID_ROLE"));
            role.setNOM(rslt.getString("NOM_ROLE"));
            user.setRole(role);
            usr=user;
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
       
        
        return usr;
    }
    public static ArrayList<Role> ConsulterRole(){
        String Query="SELECT *FROM role";
           
           ArrayList<Role> roles=new ArrayList<Role>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               Role role=new Role();
               role.setID(rslt.getInt("ID_ROLE"));
               role.setNOM(rslt.getString("NOM_ROLE"));
               roles.add(role);
               } 
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return roles;
    }   
    public static ArrayList<Enseignant> ConsulterEnseignant(){
           String Query="SELECT *FROM enseignant e inner join personne p on p.ID_PERS=e.ID_PERS ";
           
           ArrayList<Enseignant> enseignants=new ArrayList<Enseignant>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               Enseignant ens = new Enseignant();
               
               ens.setID_PERS(rslt.getInt("ID_PERS"));
               ens.setNOM(rslt.getString("NOM"));   
               ens.setPRENOM(rslt.getString("PRENOM"));
               ens.setADRESSE(rslt.getString("ADRESSE"));
               ens.setMAIL(rslt.getString("MAIL"));
               ens.setTEL(rslt.getInt("TEL"));
               ens.setCIN(rslt.getString("CIN"));
              
               ens.setCNSS(rslt.getInt("CNSS"));
          
          
                
               enseignants.add(ens);
               } 
              
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return enseignants;
    }
    public  ArrayList<Etudiant> ConsulterEtudiant(){
           String Query="SELECT *FROM etudiants e inner join personne p on e.ID_PERS=p.ID_PERS";
           System.out.println("hi");
           ArrayList<Etudiant> etudiants=new ArrayList<Etudiant>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               Etudiant etd = new Etudiant();
               System.out.println(rslt.getInt("ID_PERS"));
               etd.setID_PERS(rslt.getInt("ID_PERS"));
               etd.setNOM(rslt.getString("NOM"));
           
               etd.setPRENOM(rslt.getString("PRENOM"));
               etd.setADRESSE(rslt.getString("ADRESSE"));
               etd.setMAIL(rslt.getString("MAIL"));
               etd.setTEL(rslt.getInt("TEL"));
               etd.setCIN(rslt.getString("CIN"));
               
               etd.setNUM_INSC(rslt.getInt("NUM_INSC"));
               
               etudiants.add(etd);
               } 
              
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return etudiants;
    }

    
    public static void ModifierUser(User user){  
    	Role r=user.getRole();
       String Query="UPDATE user SET MATRICULE="+"\"" +user.getMATRICULE()+"\"" +",PASS="+"\"" +user.getPASS()+"\""+",ID_ROLE="+"\"" +r.getID()+"\"" +" WHERE ID_USER="+"\"" +user.getID_USER()+"\"" ;
       String Query2="Update personne set NOM="+"\""+user.getNOM()+"\""+",PRENOM="+"\""+user.getPRENOM()+"\""+", ADRESSE="+"\""+user.getADRESSE()+"\""+",TEL="+user.getTEL()+",MAIL="+"\""+user.getMAIL()+"\""+",CIN="+"\""+user.getCIN()+"\""+"where ID="+user.getID_PERS();
       try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
              /* stmt.setString(1, user.getMATRICULE());
               stmt.setString(2,user.getPASS());
               stmt.setInt(3,user.getID_USER());*/
               int rslt=stmt.executeUpdate(Query);
               int rslt1=stmt.executeUpdate(Query2);
               
           }catch(SQLException e){
               e.printStackTrace();
           }
    }
    public static void ModifierRole(Role role){
       String Query="Update role set NOM_ROLE="+"\""+ role.getNOM()+"\"" ;
       try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
             //  stmt.setString(1, role.getNOM());         
               int rslt=stmt.executeUpdate(Query);  
               System.out.println(rslt);
           }catch(SQLException e){
               e.printStackTrace();
           }
    }
   public static void ModifierEtudiant(int num, Personne p){
       
	 
       
       
         String Query2="Update personne set NOM="+"\""+p.getNOM()+"\""+",PRENOM="+"\""+p.getPRENOM()+"\""+", ADRESSE="+"\""+p.getADRESSE()+"\""+",TEL="+p.getTEL()+",MAIL="+"\""+p.getMAIL()+"\""+",CIN="+"\""+p.getCIN()+"\""+"where ID_PERS="+p.getID_PERS();
         
       try{
            
               
               PreparedStatement stmt1=cnx.prepareStatement(Query2);
             //  stmt.setString(1, role.getNOM());         
        
               int rslt1=stmt1.executeUpdate(Query2);  

            
               System.out.println(rslt1);

           }catch(SQLException e){
               e.printStackTrace();
           } 
    }
    public static void ModifierEnseignant(int num,Personne p){
    	 String Query2="Update personne set NOM="+"\""+p.getNOM()+"\""+",PRENOM="+"\""+p.getPRENOM()+"\""+", ADRESSE="+"\""+p.getADRESSE()+"\""+",TEL="+p.getTEL()+",MAIL="+"\""+p.getMAIL()+"\""+",CIN="+"\""+p.getCIN()+"\""+"where ID_PERS="+p.getID_PERS();
         
       try{
            
               
              
               PreparedStatement stmt1=cnx.prepareStatement(Query2);
          
               int rslt1=stmt1.executeUpdate(Query2);  

              
           }catch(SQLException e){
               e.printStackTrace();
           } 
    }
    public static void SuprimerEtudiant(int num,int id){
        String Query1="Delete from personne where ID_PERS="+id;
        String Query2="Delete from etudiants where ID_ETD="+num;
        try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query1);
               PreparedStatement stmt1=cnx.prepareStatement(Query2);
               //stmt.setInt(1,ID);
               int rslt=stmt.executeUpdate(Query1);  
               int rslt1=stmt1.executeUpdate(Query2);  
               System.out.println(rslt);
           }catch(SQLException e){
               e.printStackTrace();
           }
    }
    public static void SuprimerEnseignant(int num,int id){
        String Query1="Delete from personne where ID_PERS="+id;
        String Query2="Delete from enseignant where CNSS="+num;
        try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query1);
               PreparedStatement stmt1=cnx.prepareStatement(Query2);
               //stmt.setInt(1,ID);
               int rslt=stmt.executeUpdate(Query1);  
                int rslt1=stmt1.executeUpdate(Query2);  
               System.out.println(rslt);
           }catch(SQLException e){
               e.printStackTrace();
           }
    }
    public static void SuprimerUser(int num,int id){
    	   String Query1="Delete from personne where ID_PERS="+id;
           String Query2="Delete from user where ID_USER="+num;
       try{
    	   PreparedStatement stmt=cnx.prepareStatement(Query1);
           PreparedStatement stmt1=cnx.prepareStatement(Query2);
           //stmt.setInt(1,ID);
           int rslt=stmt.executeUpdate(Query1);  
            int rslt1=stmt1.executeUpdate(Query2);  
    
           }catch(SQLException e){
               e.printStackTrace();
           }
    }
    public static void SuprimerRole(int ID){
       String Query="Delete from role where ID_ROLE="+"\""+ID+"\"";
       try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
              // stmt.setInt(1, role.getID());         
               int rslt=stmt.executeUpdate(Query);  
               System.out.println(rslt);
           }catch(SQLException e){
               e.printStackTrace();
           }
    }


    public static void AjouterUser(User user){
    	 String Query="Insert into personne (NOM,PRENOM,ADRESSE,TEL,MAIL,CIN) values("+"\""+user.getNOM()+"\""+","+"\""+user.getPRENOM()+"\""+","+"\""+user.getADRESSE()+"\""+","+user.getTEL()+","+"\""+user.getMAIL()+"\""+","+"\""+user.getCIN()+"\""+")";  
      
      int id = 0;
          try{
               
        	  Statement stmt= cnx.createStatement();
              stmt.execute(Query, Statement.RETURN_GENERATED_KEYS);
              ResultSet rslt=stmt.getGeneratedKeys();
              if(rslt.next()) id=rslt.getInt(1);
              String Query2="Insert into user (ID_PERS,ID_ROLE,MATRICULE,PASS) values("+id+","+user.getRole().getID()+","+"\""+user.getMATRICULE()+"\""+","+"\""+user.getPASS()+"\""+")";     
              PreparedStatement stmt1=cnx.prepareStatement(Query2);
              stmt1.execute();
          }catch(SQLException e){
              e.printStackTrace();
    }
}
    public static void AjouterEtudiant(Etudiant etd){
      String Query="Insert into personne (NOM,PRENOM,ADRESSE,TEL,MAIL,CIN) values("+"\""+etd.getNOM()+"\""+","+"\""+etd.getPRENOM()+"\""+","+"\""+etd.getADRESSE()+"\""+","+etd.getTEL()+","+"\""+etd.getMAIL()+"\""+","+"\""+etd.getCIN()+"\""+")";  
      int id = 0;
      try{
               
               //PreparedStatement stmt=cnx.prepareStatement(Query);
               Statement stmt= cnx.createStatement();
               stmt.execute(Query, Statement.RETURN_GENERATED_KEYS);
               ResultSet rslt=stmt.getGeneratedKeys();
               if(rslt.next()) id=rslt.getInt(1);
               PreparedStatement stmt1=cnx.prepareStatement("Insert into etudiants (NUM_INSC,ID_PERS) values("+etd.getNUM_INSC()+","+id+")");
               stmt1.execute();
          }catch(SQLException e){
              e.printStackTrace();
    }
    }
    public static void AjouterEnseignant(Enseignant ens){
      String Query="Insert into personne (NOM,PRENOM,ADRESSE,TEL,MAIL,CIN) values("+"\""+ens.getNOM()+"\""+","+"\""+ens.getPRENOM()+"\""+","+"\""+ens.getADRESSE()+"\""+","+ens.getTEL()+","+"\""+ens.getMAIL()+"\""+","+"\""+ens.getCIN()+"\""+")";  
      int id = 0;
      try{
               
               //PreparedStatement stmt=cnx.prepareStatement(Query);
               Statement stmt= cnx.createStatement();
               stmt.execute(Query, Statement.RETURN_GENERATED_KEYS);
               ResultSet rslt=stmt.getGeneratedKeys();
               if(rslt.next()) id=rslt.getInt(1);
               PreparedStatement stmt1=cnx.prepareStatement("Insert into enseignant (CNSS,ID_PERS) values("+ens.getCNSS() +","+id+")");
               stmt1.execute();
          }catch(SQLException e){
              e.printStackTrace();
    }
    }
    public static ArrayList<User> RechercherUser(String matricule){
           String Query="SELECT *FROM user u inner join personne p on u.ID_PERS=p.ID_PERS inner join role r on u.ID_ROLE=r.ID_ROLE where u.MATRICULE=?";
           
           ArrayList<User> users=new ArrayList<User>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setString(1, matricule);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               Role role=new Role();
               User user = new User();
               user.setID_PERS(rslt.getInt("ID_PERS"));
               user.setNOM(rslt.getString("NOM"));
           
               user.setPRENOM(rslt.getString("PRENOM"));
               user.setADRESSE(rslt.getString("ADRESSE"));
               user.setMAIL(rslt.getString("MAIL"));
               user.setTEL(rslt.getInt("TEL"));
               user.setCIN(rslt.getString("CIN"));
               user.setID_USER(rslt.getInt("ID_USER"));
               user.setMATRICULE(rslt.getString("MATRICULE"));
               user.setPASS(rslt.getString("PASS"));
               role.setID(rslt.getInt("ID_ROLE"));
               role.setNOM(rslt.getString("NOM_ROLE"));
               user.setRole(role);
               users.add(user);
               } 
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return users;
       }
    public static ArrayList<Role> RechercherRole(String Nom){
           String Query="SELECT *FROM role where NOM_ROLE=?";
           
           ArrayList<Role> roles=new ArrayList<Role>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setString(1,Nom);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               Role role=new Role();
               role.setID(rslt.getInt("ID_ROLE"));
               role.setNOM(rslt.getString("NOM_ROLE"));
               roles.add(role);
               } 
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return roles;
    }   
   /* public static ArrayList<Etudiant> RechercherEtudiant(int NUMINSC){
           String Query="SELECT *FROM etudiants e inner join personne p on e.ID_PERS=p.ID_PERS  where e.NUM_INSC=?";
           
           ArrayList<Etudiant> etds=new ArrayList<Etudiant>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setInt(1, NUMINSC);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               
               Etudiant etd = new Etudiant();
               etd.setID_PERS(rslt.getInt("ID_PERS"));
               etd.setNOM(rslt.getString("NOM"));
           
               etd.setPRENOM(rslt.getString("PRENOM"));
               etd.setADRESSE(rslt.getString("ADRESSE"));
               etd.setMAIL(rslt.getString("MAIL"));
               etd.setTEL(rslt.getInt("TEL"));
               etd.setCIN(rslt.getString("CIN"));
               etd.setNUM_INSC(rslt.getInt("NUM_INSC"));
               etd.setID_ETD(rslt.getInt("ID_ETD"));
               
               etds.add(etd);
               } 
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return etds;
       }*/
  /*  public static ArrayList<Enseignant> RechercherEnseignant(int CNSS){
         String Query="SELECT *FROM enseignant e inner join personne p on e.ID_PERS=p.ID_PERS inner join departement d on e.ID_DEP=d.ID_DEP  where e.CNSS=?";
           
           ArrayList<Enseignant> enseignants=new ArrayList<Enseignant>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setInt(1, CNSS);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
               
               Enseignant ens = new Enseignant();
              
               ens.setID_PERS(rslt.getInt("ID_PERS"));
               ens.setNOM(rslt.getString("NOM"));
           
               ens.setPRENOM(rslt.getString("PRENOM"));
               ens.setADRESSE(rslt.getString("ADRESSE"));
               ens.setMAIL(rslt.getString("MAIL"));
               ens.setTEL(rslt.getInt("TEL"));
               ens.setCIN(rslt.getString("CIN"));
               ens.setCNSS(rslt.getInt("CNSS"));
               ens.setID_ENS(rslt.getInt("ID_ENS"));
              
               ens.setCHEF(rslt.getBoolean("CHEF"));
               
               enseignants.add(ens);
               } 
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return enseignants;
     }
    */
  
    public static ArrayList<Enseignant> ConsulterGroupeByCNSS(int ID_GRP,int ID_ENS){
         String Query="SELECT *FROM enseignant_groupe eg  inner join enseignant e on eg.ID_ENS=e.ID_ENS inner join personne p on e.ID_PERS=p.ID_PERS inner join departement dep on dep.ID_DEP=e.ID_DEP where eg.ID_GRP=? and eg.ID_ENS=?";
           
           ArrayList<Enseignant> enseignants=new ArrayList<Enseignant>();
    
           try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               stmt.setInt(1, ID_GRP);
               stmt.setInt(2, ID_ENS);
               ResultSet rslt=stmt.executeQuery();   

               while(rslt.next()){
                 Enseignant ens = new Enseignant();
             
               ens.setID_PERS(rslt.getInt("ID_PERS"));
               ens.setNOM(rslt.getString("NOM"));
           
               ens.setPRENOM(rslt.getString("PRENOM"));
               ens.setADRESSE(rslt.getString("ADRESSE"));
               ens.setMAIL(rslt.getString("MAIL"));
               ens.setTEL(rslt.getInt("TEL"));
               ens.setCIN(rslt.getString("CIN"));
               ens.setID_ENS(rslt.getInt("ID_ENS"));
               ens.setCNSS(rslt.getInt("CNSS"));
               ens.setCHEF(rslt.getBoolean("CHEF"));
               
               enseignants.add(ens);
               } 
              
           }catch(SQLException e){
               e.printStackTrace();
           }
          
           
           return enseignants;
    }
    public static void GrantRole(int id_role,int id_user){
        String Query="Update user set ID_ROLE="+"\""+id_role+"\""+" where ID_USER="+"\""+id_user+"\"";
        try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               /*stmt.setInt(1,id_role);              
               stmt.setInt(2,id_user);*/

               int rslt=stmt.executeUpdate(Query);  
               System.out.println(rslt);
           }catch(SQLException e){
               e.printStackTrace();
           }
    }
    public static void RevokeRole(int id_user){
         Role role=RetournerNoneRole();
         String Query="Update user set ID_ROLE="+"\""+role.getID()+"\""+" where ID_USER="+"\""+id_user+"\"";
       
        try{
               
               PreparedStatement stmt=cnx.prepareStatement(Query);
               /*stmt.setInt(1,role.getID());              
               stmt.setInt(2,id_user);*/

               int rslt=stmt.executeUpdate(Query);  
               System.out.println(rslt);
           }catch(SQLException e){
               e.printStackTrace();
           }
    }
}