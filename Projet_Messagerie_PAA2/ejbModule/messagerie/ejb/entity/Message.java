package messagerie.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message implements Serializable{
	
	@Id @GeneratedValue
	private String recepteur;
	private String objetMessage;
	private String corps;
	private String emetteur;
	
	public Message() {
		super();
	}

	public Message(String recepteur, String objetMessage, String corps, String emetteur) {
		this.recepteur = recepteur;
		this.objetMessage = objetMessage;
		this.corps = corps;
		this.emetteur = emetteur;
	}
	
	public String getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(String recepteur) {
		this.recepteur = recepteur;
	}

	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}
	
	public String getObjetMessage() {
		return objetMessage;
	}
	public void setObjetMessage(String objetMessage) {
		this.objetMessage = objetMessage;
	}
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
}
