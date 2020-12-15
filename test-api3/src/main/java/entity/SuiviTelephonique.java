package entity;

import java.sql.Date;

public class SuiviTelephonique {

	private int id;
	private Date dateEntretien;
	private Date courrielRemerciement;
	private Date invitationLinkedIn;
	private Date courrielOuAppelDeSuivi;

	public SuiviTelephonique() {
	}

	public SuiviTelephonique(int id, Date dateEntretien, Date courrielRemerciement, Date invitationLinkedIn,
			Date courrielOuAppelDeSuivi) {
		super();
		this.id = id;
		this.dateEntretien = dateEntretien;
		this.courrielRemerciement = courrielRemerciement;
		this.invitationLinkedIn = invitationLinkedIn;
		this.courrielOuAppelDeSuivi = courrielOuAppelDeSuivi;
	}
	public SuiviTelephonique( Date dateEntretien, Date courrielRemerciement, Date invitationLinkedIn,Date courrielOuAppelDeSuivi) {
		super();
		this.dateEntretien = dateEntretien;
		this.courrielRemerciement = courrielRemerciement;
		this.invitationLinkedIn = invitationLinkedIn;
		this.courrielOuAppelDeSuivi = courrielOuAppelDeSuivi;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEntretien() {
		return dateEntretien;
	}

	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}

	public Date getCourrielRemerciement() {
		return courrielRemerciement;
	}

	public void setCourrielRemerciement(Date courrielRemerciement) {
		this.courrielRemerciement = courrielRemerciement;
	}

	public Date getInvitationLinked() {
		return invitationLinkedIn;
	}

	public void setInvitationLinked(Date invitationLinkedIn) {
		this.invitationLinkedIn = invitationLinkedIn;
	}

	public Date getCourrielOuAppelDeSuivi() {
		return courrielOuAppelDeSuivi;
	}

	public void setCourrielOuAppelDeSuivi(Date courrielOuAppelDeSuivi) {
		this.courrielOuAppelDeSuivi = courrielOuAppelDeSuivi;
	}

}
