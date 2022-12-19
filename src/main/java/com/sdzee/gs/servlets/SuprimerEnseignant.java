package com.sdzee.gs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.gs.db.Connexion;

/**
 * Servlet implementation class SuprimerEnseignant
 */
public class SuprimerEnseignant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_ID= "id";
	public static final String CHAMP_NUM= "num";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuprimerEnseignant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter( CHAMP_NUM );
		String id = request.getParameter( CHAMP_ID );
		
		
		try {
			Connexion conn=new Connexion();
			conn.SuprimerEnseignant(Integer.parseInt(num), Integer.parseInt(id));
			response.sendRedirect("GestionEnseignants.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

}
