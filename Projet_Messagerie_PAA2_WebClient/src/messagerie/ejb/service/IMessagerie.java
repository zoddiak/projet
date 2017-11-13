package messagerie.ejb.service;

import java.util.List;

import javax.ejb.Remote;

import messagerie.ejb.entity.Message;

@Remote
public interface IMessagerie {
	public void ouvrirCompte (String login, String mdp, String nom);
	public boolean connexion (String login, String password);
	public boolean envoyerMessage (String recepteur, String objetMessage, String corpsMessage, String destinataire);
	public List recupererMessage(String login);
}
