package com.sdzee.gs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.gs.db.Connexion;

/**
 * Servlet implementation class SuprimerMatiere
 */

public class SuprimerMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_ID = "id";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuprimerMatiere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter( CHAMP_ID );
		System.out.println("hello:"+id);
		
		try {
			Connexion conn=new Connexion();
			conn.SuprimerMatiere(Integer.parseInt(id));
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
