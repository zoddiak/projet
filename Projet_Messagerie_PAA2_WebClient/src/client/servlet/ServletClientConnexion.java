package client.servlet;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import messagerie.ejb.entity.Message;
import messagerie.ejb.service.IMessagerie;


/**
 * Servlet implementation class ServletClient
 */
@WebServlet("/ServletClientConnexion")
public class ServletClientConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMessagerie messagerie;
       
    /**
     * @throws NamingException 
     * @see HttpServlet#HttpServlet()
     */
    public ServletClientConnexion() throws NamingException {
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
		 String login = request.getParameter("login");
		 String password = request.getParameter("password");
		 boolean bool = this.messagerie.connexion(login, password);
		 
		 HttpSession session = request.getSession(true);
		 RequestDispatcher dispatch;
		 
		 if (bool == true) {
			 session.setAttribute("login", login );
			 System.err.println("TEST1");
			 List messages = this.messagerie.recupererMessage(login);
			 session.setAttribute("messages",messages);
			 System.err.println("TEST2");/*
			 session.setAttribute("messages", messages);
			 System.err.println("TEST3");
			 String testObjet = messages.get(0).getCorps();
			 System.err.println("TEST4");
			 session.setAttribute("testObjet", testObjet);*/
			 System.err.println("TEST3");
			 dispatch = request.getRequestDispatcher("./accueil.jsp");
			 dispatch.forward(request, response);
		 }
		 else {
			 dispatch = request.getRequestDispatcher("./login_error.html");
			 dispatch.forward(request, response);
		 }
		 		
	}

}
