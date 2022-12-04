package com.sdzee.gs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.gs.beans.Etudiant;
import com.sdzee.gs.beans.Personne;
import com.sdzee.gs.db.Connexion;

/**
 * Servlet implementation class ModifierEtudiant
 */

public class ModifierEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_ID= "id_pers";
	public static final String CHAMP_NUM= "num";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_ADRESSE= "adresse";
	public static final String CHAMP_MAIL = "mail";
	public static final String CHAMP_TEL = "tel";
	public static final String CHAMP_CIN = "cin";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String num = request.getParameter( CHAMP_NUM );
		String nom = request.getParameter( CHAMP_NOM);
		String prenom = request.getParameter( CHAMP_PRENOM );
		String adresse = request.getParameter( CHAMP_ADRESSE );
		String mail = request.getParameter( CHAMP_MAIL );
		String tel = request.getParameter( CHAMP_TEL );
		String cin = request.getParameter( CHAMP_CIN );
		String id=request.getParameter( CHAMP_ID);
		System.out.println(num);
		Personne etd=new Personne();
		
		etd.setNOM(nom);
		etd.setPRENOM(prenom);
		etd.setADRESSE(adresse);
		etd.setMAIL(mail);
		etd.setTEL(Integer.parseInt(tel));
		etd.setCIN(cin);
		etd.setID_PERS(Integer.parseInt(id));
		Connexion conn=new Connexion();
		conn.ModifierEtudiant(Integer.parseInt(num), etd);
		response.sendRedirect("GestionEtudiants.jsp");
				
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
