package messagerie.ejb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import messagerie.ejb.entity.Compte;
import messagerie.ejb.entity.Message;

/**
 * Session Bean implementation class MessagerieBean
 */
@Stateless (mappedName ="ejb/maMessagerieBean")
public class MessagerieBean implements IMessagerie {

	@PersistenceContext (unitName="configMySQLMessagerie")
	EntityManager em;
	@Override
	public void ouvrirCompte(String login, String mdp, String nom) {
		Compte compte = new Compte(login,mdp,nom);
		em.persist(compte);
		
	}
	
	@Override
	public boolean connexion(String login, String password) {
		 try{
			  Query query = em.createNativeQuery("Select pseudo, mdp from compte where pseudo=? and mdp=?",Compte.class);
			  query.setParameter(1, login);  
			  query.setParameter(2, password);  

			  List<Compte> comptes = query.getResultList();
			  
			  for(Compte c : comptes) {
				  if(!(c.getPseudo().equals(null)) || !(c.getPseudo().equals("")) && !(c.getMdp().equals(null)) || !(c.getMdp().equals(""))) {
					  return true;
				  }
			  }
			  return false;
		   }
		   catch(Exception e){       
			   System.out.println("Something went wrong !! Please try again");       
		   }
		return false;      
		
	}

	@Override
	public boolean envoyerMessage(String recepteur, String objetMessage, String corpsMessage, String destinataire) {
		 try{
			  Query query = em.createNativeQuery("Select pseudo from compte where pseudo=?",Compte.class);
			  query.setParameter(1, destinataire);  

			  List<Compte> comptes = query.getResultList();
			  
			  for(Compte c : comptes) {
				  if(c.getPseudo().equals(destinataire)) {
					  Message m = new Message(recepteur, objetMessage, corpsMessage, destinataire);
					  em.persist(m);
					  c.addMessage(m);
					  em.persist(c);
					  return true;
				  }
			  }
			  return false;
		   }
		   catch(Exception e){       
			   System.out.println("Something went wrong !! Please try again");       
		   }
		return false;      
	}

	@Override
	public List recupererMessage(String login) {
		 try{
			  /*System.err.println("TESTA");
			  Query query = em.createQuery("from message where recepteur= (?)", Message.class);
			  query.setParameter(1, login);  
			  System.err.println("TESTB");
			  List<Message> messages = query.getResultList();
			  System.err.println("TESTC");
			  return messages;
			  */
			  
			  System.err.println("TESTA");
			  Query query = em.createNativeQuery("Select * from message where recepteur= (?)", Message.class);
			  query.setParameter(1, login);  
		
			  System.err.println("TESTB");
			  List<Message> messages = query.getResultList();
			  List<String> mess = new ArrayList<>();
			  
			  for(Message m : messages) {
				  System.out.println(m.getCorps() + " " + m.getEmetteur() + " " + m.getObjetMessage() + " " + m.getRecepteur());
				  mess.add(m.getCorps() + ";" + m.getEmetteur() + ";" + m.getObjetMessage() + ";" + m.getRecepteur());
			  }
		
			  System.err.println("TESTC");
			  
			  for(String s : mess) {
				  System.out.println(s);
			  }
			  return mess;
		   }
		   catch(Exception e){       
			   System.out.println("Something went wrong !! Please try again");       
		   }
		  return null;
		
	}
	
}
