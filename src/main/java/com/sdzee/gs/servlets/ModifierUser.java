package com.sdzee.gs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.gs.beans.Personne;
import com.sdzee.gs.beans.Role;
import com.sdzee.gs.beans.User;
import com.sdzee.gs.db.Connexion;

/**
 * Servlet implementation class ModifierUser
 */

public class ModifierUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_ID= "id_pers";
	public static final String CHAMP_NUM= "num";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_ADRESSE= "adresse";
	public static final String CHAMP_MAIL = "mail";
	public static final String CHAMP_TEL = "tel";
	public static final String CHAMP_CIN = "cin";
	public static final String CHAMP_MATRICULE = "matricule";
	public static final String CHAMP_MOTDEPASSE = "mdp";
	public static final String CHAMP_IDROLE= "role";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		String num = request.getParameter( CHAMP_NUM );
		String nom = request.getParameter( CHAMP_NOM);
		String prenom = request.getParameter( CHAMP_PRENOM );
		String adresse = request.getParameter( CHAMP_ADRESSE );
		String mail = request.getParameter( CHAMP_MAIL );
		String tel = request.getParameter( CHAMP_TEL );
		String cin = request.getParameter( CHAMP_CIN );
		String id=request.getParameter( CHAMP_ID);
		String matricule=request.getParameter( CHAMP_MATRICULE);
		String mdp=request.getParameter( CHAMP_MOTDEPASSE);
		String role=request.getParameter( CHAMP_IDROLE);
		System.out.println(role);
		Role r=new Role(Integer.parseInt(role));
		User usr=new User();
		usr.setNOM(nom);
		usr.setPRENOM(prenom);
		usr.setADRESSE(adresse);
		usr.setMAIL(mail);
		usr.setTEL(Integer.parseInt(tel));
		usr.setCIN(cin);
		usr.setID_PERS(Integer.parseInt(id));
		usr.setMATRICULE(matricule);
		usr.setPASS(mdp);
		usr.setID_USER(Integer.parseInt(num));
		usr.setRole(r);
		Connexion conn=new Connexion();
		conn.ModifierUser(usr);
		response.sendRedirect("GestionUtilisateurs.jsp");
				
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
