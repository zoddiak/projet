package client.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import messagerie.ejb.service.IMessagerie;

/**
 * Servlet implementation class ServletClientInscription
 */
@WebServlet("/ServletClientInscription")
public class ServletClientInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMessagerie messagerie;
       
    /**
     * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public ServletClientInscription() throws NamingException {
    	 super();
         Context context = new InitialContext();
 		 this.messagerie = (IMessagerie) context.lookup("ejb/maMessagerieBean");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String password = request.getParameter("password");
		String repeatPwd = request.getParameter("psw-repeat");
		RequestDispatcher dispatch;
		
		if(password.equals(repeatPwd)) {
			this.messagerie.ouvrirCompte(pseudo, password, nom);
			request.setAttribute("login", pseudo);
			dispatch = request.getRequestDispatcher("./login.html");
			dispatch.forward(request, response);
		}
		else {
			 dispatch = request.getRequestDispatcher("./inscription_error.html");
			 dispatch.forward(request, response);
		}
	}

}
