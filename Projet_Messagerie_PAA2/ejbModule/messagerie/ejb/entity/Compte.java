package messagerie.ejb.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Compte implements Serializable {

	@Id @GeneratedValue
	private String pseudo;
	private String mdp;
	private String nom;
	private String date;
	private ArrayList<Message> listeMessage;
	
	public Compte() {
		super();
	}

	public Compte(String pseudo, String mdp, String nom) {
		super();
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.nom = nom;
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		this.date = currentTime;
		this.listeMessage = new ArrayList<Message>();
	}

	public ArrayList<Message> getListeMessage() {
		return listeMessage;
	}

	public void setListeMessage(ArrayList<Message> listeMessage) {
		this.listeMessage = listeMessage;
	}
	
	public void addMessage(Message m) {
		this.listeMessage.add(m);
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
