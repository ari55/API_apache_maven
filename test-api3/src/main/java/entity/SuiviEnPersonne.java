package entity;

import java.sql.Date;

public class SuiviEnPersonne {
	private int id;
	private Date dateEntrevue;
	private Date courrielRemerciement;
	private Date invitationLinkedIn;
	private Date courrielOuAppelSuivi;

	public SuiviEnPersonne() {};
	public SuiviEnPersonne( Date dateEntrevue, Date courrielRemerciement, Date invitationLinkedIn,
			Date courrielOuAppelSuivi) {
		super();
		this.dateEntrevue = dateEntrevue;
		this.courrielRemerciement = courrielRemerciement;
		this.invitationLinkedIn = invitationLinkedIn;
		this.courrielOuAppelSuivi = courrielOuAppelSuivi;
	}
	
	public SuiviEnPersonne(int id, Date dateEntrevue, Date courrielRemerciement, Date invitationLinkedIn,
			Date courrielOuAppelSuivi) {
		super();
		this.id = id;
		this.dateEntrevue = dateEntrevue;
		this.courrielRemerciement = courrielRemerciement;
		this.invitationLinkedIn = invitationLinkedIn;
		this.courrielOuAppelSuivi = courrielOuAppelSuivi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEntrevue() {
		return dateEntrevue;
	}

	public void setDateEntrevue(Date dateEntrevue) {
		this.dateEntrevue = dateEntrevue;
	}

	public Date getCourrielRemerciement() {
		return courrielRemerciement;
	}

	public void setCourrielRemerciement(Date courrielRemerciement) {
		this.courrielRemerciement = courrielRemerciement;
	}

	public Date getInvitationLinkedIn() {
		return invitationLinkedIn;
	}

	public void setInvitationLinkedIn(Date invitationLinkedIn) {
		this.invitationLinkedIn = invitationLinkedIn;
	}

	public Date getCourrielOuAppelSuivi() {
		return courrielOuAppelSuivi;
	}

	public void setCourrielOuAppelSuivi(Date courrielOuAppelSuivi) {
		this.courrielOuAppelSuivi = courrielOuAppelSuivi;
	}

}
