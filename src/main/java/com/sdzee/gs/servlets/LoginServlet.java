package com.sdzee.gs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sdzee.gs.db.Connexion;

public class LoginServlet extends HttpServlet {


	public static final String CHAMP_USER = "user";
	public static final String CHAMP_MDP = "mdp";
	public static final String ATT_MESSAGE = "message";
	public static final String ATT_ERREUR = "erreur";
	public static final String VUE ="/Home.jsp";
	public void doGet( HttpServletRequest request,
			HttpServletResponse response ) throws ServletException, IOException
			{


			String user = request.getParameter( CHAMP_USER );
			String mdp = request.getParameter( CHAMP_MDP );
			
			
			try {
				Connexion conn=new Connexion();
				int isUser=conn.VerifUsers(user,mdp);
				if (isUser==1) {
						System.out.println("verified");
				}else {
					System.out.println("notVerified");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute( ATT_MESSAGE, "hello" );
			request.setAttribute( ATT_ERREUR, "erreur" );
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
			}
}
