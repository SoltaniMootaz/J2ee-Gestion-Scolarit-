package com.sdzee.gs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.gs.db.Connexion;

/**
 * Servlet implementation class AjouterNote
 */

public class AjouterNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_DS= "DS";  
	public static final String CHAMP_PROJET= "PROJET";  
	public static final String CHAMP_CC= "CC";  
	public static final String CHAMP_EXAMEN= "EXAMEN";  
	public static final String CHAMP_MAT= "mtr"; 
	public static final String CHAMP_NUM= "num"; 

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter( CHAMP_NUM );
		String mtr = request.getParameter( CHAMP_MAT );
		String ds = request.getParameter( CHAMP_DS );
		String projet = request.getParameter( CHAMP_PROJET );
		String cc = request.getParameter( CHAMP_CC );
		String examen = request.getParameter( CHAMP_EXAMEN );
try {
			
			Connexion conn=new Connexion();
			conn.AjouterNote(Float.parseFloat(ds), Integer.parseInt(num), Integer.parseInt(mtr), 1);
			conn.AjouterNote(Float.parseFloat(projet), Integer.parseInt(num), Integer.parseInt(mtr), 2);
			conn.AjouterNote(Float.parseFloat(cc), Integer.parseInt(num), Integer.parseInt(mtr), 3);
			conn.AjouterNote(Float.parseFloat(examen), Integer.parseInt(num), Integer.parseInt(mtr), 4);
			
					
			
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
