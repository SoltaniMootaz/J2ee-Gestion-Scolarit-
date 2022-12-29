package com.sdzee.gs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.gs.beans.Matiere;
import com.sdzee.gs.db.Connexion;

/**
 * Servlet implementation class AjouterMatiere
 */

public class AjouterMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_NUM = "num";
	public static final String CHAMP_NOM= "nom"; 
	public static final String CHAMP_COEF= "coef";
	public static final String CHAMP_GRP= "grp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterMatiere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter( CHAMP_NOM);
		String COEF = request.getParameter( CHAMP_COEF);
		int num =Integer.parseInt(request.getParameter( CHAMP_NUM));
		int grp = Integer.parseInt(request.getParameter( CHAMP_GRP));
		Matiere m=new Matiere();
		m.setCOEF(Float.parseFloat(COEF));
		m.setNOM(nom);
try {
			
			Connexion conn=new Connexion();
			conn.AjouterMatiere(m, num, grp);
			
					
			
				response.sendRedirect("GestionMatieres.jsp");
				
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
