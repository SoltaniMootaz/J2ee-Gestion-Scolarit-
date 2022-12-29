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
 * Servlet implementation class ModifierMatiere
 */

public class ModifierMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_ID = "id";

	public static final String CHAMP_NOM= "nom"; 
	public static final String CHAMP_COEF= "coef";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierMatiere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter( CHAMP_NOM);
		String id = request.getParameter( CHAMP_ID);
		String COEF = request.getParameter( CHAMP_COEF);
	
		Matiere m=new Matiere();
		m.setID(Integer.parseInt(id));
		m.setCOEF(Float.parseFloat(COEF));
		m.setNOM(nom);
		
try {
			
			Connexion conn=new Connexion();
			conn.ModifierMatiere(m);
			
					
			
				response.sendRedirect("GestionMatieres.jsp");
				
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
