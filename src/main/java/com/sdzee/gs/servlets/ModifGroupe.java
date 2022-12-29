package com.sdzee.gs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.gs.beans.Groupe;
import com.sdzee.gs.db.Connexion;

/**
 * Servlet implementation class ModifGroupe
 */

public class ModifGroupe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_ID = "id";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifGroupe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter( CHAMP_NOM);
		String id = request.getParameter( CHAMP_ID);
		Groupe grp=new Groupe(Integer.parseInt(id),nom);
try {
			
			Connexion conn=new Connexion();
			conn.ModifierGroupe(grp);
			
					
			
				response.sendRedirect("GestionGroupes.jsp");
				
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
