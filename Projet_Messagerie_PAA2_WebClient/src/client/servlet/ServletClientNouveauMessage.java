package client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ServletClientNouveauMessage
 */
@WebServlet("/ServletClientNouveauMessage")
public class ServletClientNouveauMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMessagerie messagerie;
    /**
     * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public ServletClientNouveauMessage() throws NamingException {
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
		String login = (String) request.getSession(false).getAttribute("login");
		String email = request.getParameter("email");
		String sujet = request.getParameter("sujet");
		String message = request.getParameter("message");
		RequestDispatcher dispatch;
		this.messagerie.envoyerMessage(email, sujet, message, login);
		
		
	}
}
