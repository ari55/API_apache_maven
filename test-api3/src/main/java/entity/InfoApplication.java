package entity;

import java.sql.Date;

public class InfoApplication {
	int id;
	String commentaire;
	boolean etat_suivie;
	//
	int id_doc_achemine;
	boolean cv;
	boolean letre_motivation;
	boolean releve_note;
	boolean autres;
	boolean lesreferences;
	//
	int id_info_generale_application;
	Date date_application;
	String nom_de_lentreprise;
	String nom_contact_de_lentreprise;
	long telephone;
	String email;
	String linkedin;
	String addresse;
	//
	int id_info_specifique;
	String titre_du_poste;
	String description_poste;
	String language_utilise;
	String numero_reference;
	double remuneration;
	Date date_fin_affichage;
	String source_poste;
	String match_poste;
	//
	int id_suivie_application;
	Date date_suivie_telephonique;
	Date date_suivie_en_personne;
	Date relance_interet;
	//
	int id_suivie_en_personne;
	Date date_entrevue;
	Date courriel_remerciement;
	Date invitation_linkedin;
	Date courriel_ouappel_suivie;
	//
	int id_suivie_telephonique;
	Date date_entretien;
	Date courriel_remerciement_st;
	Date invitation_linkedin_st;
	Date courriel_ouappel_suivie_st;
	//

	public InfoApplication() {
		// TODO Auto-generated constructor stub
	}

	public InfoApplication(int id, String commentaire, boolean etat_suivie, int id_doc_achemine, boolean cv,
			boolean letre_motivation, boolean releve_note, boolean autres, boolean lesreferences,
			int id_info_generale_application, Date date_application, String nom_de_lentreprise,
			String nom_contact_de_lentreprise, long telephone, String email, String linkedin, String addresse,
			int id_info_specifique, String titre_du_poste, String description_poste, String language_utilise,
			String numero_reference, double remuneration, Date date_fin_affichage, String source_poste,
			String match_poste, int id_suivie_application, Date date_suivie_telephonique, Date date_suivie_en_personne,
			Date relance_interet, int id_suivie_en_personne, Date date_entrevue, Date courriel_remerciement,
			Date invitation_linkedin, Date courriel_ouappel_suivie, int id_suivie_telephonique, Date date_entretien,
			Date courriel_remerciement_st, Date invitation_linkedin_st, Date courriel_ouappel_suivie_st) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.etat_suivie = etat_suivie;
		this.id_doc_achemine = id_doc_achemine;
		this.cv = cv;
		this.letre_motivation = letre_motivation;
		this.releve_note = releve_note;
		this.autres = autres;
		this.lesreferences = lesreferences;
		this.id_info_generale_application = id_info_generale_application;
		this.date_application = date_application;
		this.nom_de_lentreprise = nom_de_lentreprise;
		this.nom_contact_de_lentreprise = nom_contact_de_lentreprise;
		this.telephone = telephone;
		this.email = email;
		this.linkedin = linkedin;
		this.addresse = addresse;
		this.id_info_specifique = id_info_specifique;
		this.titre_du_poste = titre_du_poste;
		this.description_poste = description_poste;
		this.language_utilise = language_utilise;
		this.numero_reference = numero_reference;
		this.remuneration = remuneration;
		this.date_fin_affichage = date_fin_affichage;
		this.source_poste = source_poste;
		this.match_poste = match_poste;
		this.id_suivie_application = id_suivie_application;
		this.date_suivie_telephonique = date_suivie_telephonique;
		this.date_suivie_en_personne = date_suivie_en_personne;
		this.relance_interet = relance_interet;
		this.id_suivie_en_personne = id_suivie_en_personne;
		this.date_entrevue = date_entrevue;
		this.courriel_remerciement = courriel_remerciement;
		this.invitation_linkedin = invitation_linkedin;
		this.courriel_ouappel_suivie = courriel_ouappel_suivie;
		this.id_suivie_telephonique = id_suivie_telephonique;
		this.date_entretien = date_entretien;
		this.courriel_remerciement_st = courriel_remerciement_st;
		this.invitation_linkedin_st = invitation_linkedin_st;
		this.courriel_ouappel_suivie_st = courriel_ouappel_suivie_st;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isEtat_suivie() {
		return etat_suivie;
	}

	public void setEtat_suivie(boolean etat_suivie) {
		this.etat_suivie = etat_suivie;
	}

	public int getId_doc_achemine() {
		return id_doc_achemine;
	}

	public void setId_doc_achemine(int id_doc_achemine) {
		this.id_doc_achemine = id_doc_achemine;
	}

	public boolean isCv() {
		return cv;
	}

	public void setCv(boolean cv) {
		this.cv = cv;
	}

	public boolean isLetre_motivation() {
		return letre_motivation;
	}

	public void setLetre_motivation(boolean letre_motivation) {
		this.letre_motivation = letre_motivation;
	}

	public boolean isReleve_note() {
		return releve_note;
	}

	public void setReleve_note(boolean releve_note) {
		this.releve_note = releve_note;
	}

	public boolean isAutres() {
		return autres;
	}

	public void setAutres(boolean autres) {
		this.autres = autres;
	}

	public boolean isLesreferences() {
		return lesreferences;
	}

	public void setLesreferences(boolean lesreferences) {
		this.lesreferences = lesreferences;
	}

	public int getId_info_generale_application() {
		return id_info_generale_application;
	}

	public void setId_info_generale_application(int id_info_generale_application) {
		this.id_info_generale_application = id_info_generale_application;
	}

	public Date getDate_application() {
		return date_application;
	}

	public void setDate_application(Date date_application) {
		this.date_application = date_application;
	}

	public String getNom_de_lentreprise() {
		return nom_de_lentreprise;
	}

	public void setNom_de_lentreprise(String nom_de_lentreprise) {
		this.nom_de_lentreprise = nom_de_lentreprise;
	}

	public String getNom_contact_de_lentreprise() {
		return nom_contact_de_lentreprise;
	}

	public void setNom_contact_de_lentreprise(String nom_contact_de_lentreprise) {
		this.nom_contact_de_lentreprise = nom_contact_de_lentreprise;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public int getId_info_specifique() {
		return id_info_specifique;
	}

	public void setId_info_specifique(int id_info_specifique) {
		this.id_info_specifique = id_info_specifique;
	}

	public String getTitre_du_poste() {
		return titre_du_poste;
	}

	public void setTitre_du_poste(String titre_du_poste) {
		this.titre_du_poste = titre_du_poste;
	}

	public String getDescription_poste() {
		return description_poste;
	}

	public void setDescription_poste(String description_poste) {
		this.description_poste = description_poste;
	}

	public String getLanguage_utilise() {
		return language_utilise;
	}

	public void setLanguage_utilise(String language_utilise) {
		this.language_utilise = language_utilise;
	}

	public String getNumero_reference() {
		return numero_reference;
	}

	public void setNumero_reference(String numero_reference) {
		this.numero_reference = numero_reference;
	}

	public double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}

	public Date getDate_fin_affichage() {
		return date_fin_affichage;
	}

	public void setDate_fin_affichage(Date date_fin_affichage) {
		this.date_fin_affichage = date_fin_affichage;
	}

	public String getSource_poste() {
		return source_poste;
	}

	public void setSource_poste(String source_poste) {
		this.source_poste = source_poste;
	}

	public String getMatch_poste() {
		return match_poste;
	}

	public void setMatch_poste(String match_poste) {
		this.match_poste = match_poste;
	}

	public int getId_suivie_application() {
		return id_suivie_application;
	}

	public void setId_suivie_application(int id_suivie_application) {
		this.id_suivie_application = id_suivie_application;
	}

	public Date getDate_suivie_telephonique() {
		return date_suivie_telephonique;
	}

	public void setDate_suivie_telephonique(Date date_suivie_telephonique) {
		this.date_suivie_telephonique = date_suivie_telephonique;
	}

	public Date getDate_suivie_en_personne() {
		return date_suivie_en_personne;
	}

	public void setDate_suivie_en_personne(Date date_suivie_en_personne) {
		this.date_suivie_en_personne = date_suivie_en_personne;
	}

	public Date getRelance_interet() {
		return relance_interet;
	}

	public void setRelance_interet(Date relance_interet) {
		this.relance_interet = relance_interet;
	}

	public int getId_suivie_en_personne() {
		return id_suivie_en_personne;
	}

	public void setId_suivie_en_personne(int id_suivie_en_personne) {
		this.id_suivie_en_personne = id_suivie_en_personne;
	}

	public Date getDate_entrevue() {
		return date_entrevue;
	}

	public void setDate_entrevue(Date date_entrevue) {
		this.date_entrevue = date_entrevue;
	}

	public Date getCourriel_remerciement() {
		return courriel_remerciement;
	}

	public void setCourriel_remerciement(Date courriel_remerciement) {
		this.courriel_remerciement = courriel_remerciement;
	}

	public Date getInvitation_linkedin() {
		return invitation_linkedin;
	}

	public void setInvitation_linkedin(Date invitation_linkedin) {
		this.invitation_linkedin = invitation_linkedin;
	}

	public Date getCourriel_ouappel_suivie() {
		return courriel_ouappel_suivie;
	}

	public void setCourriel_ouappel_suivie(Date courriel_ouappel_suivie) {
		this.courriel_ouappel_suivie = courriel_ouappel_suivie;
	}

	public int getId_suivie_telephonique() {
		return id_suivie_telephonique;
	}

	public void setId_suivie_telephonique(int id_suivie_telephonique) {
		this.id_suivie_telephonique = id_suivie_telephonique;
	}

	public Date getDate_entretien() {
		return date_entretien;
	}

	public void setDate_entretien(Date date_entretien) {
		this.date_entretien = date_entretien;
	}

	public Date getCourriel_remerciement_st() {
		return courriel_remerciement_st;
	}

	public void setCourriel_remerciement_st(Date courriel_remerciement_st) {
		this.courriel_remerciement_st = courriel_remerciement_st;
	}

	public Date getInvitation_linkedin_st() {
		return invitation_linkedin_st;
	}

	public void setInvitation_linkedin_st(Date invitation_linkedin_st) {
		this.invitation_linkedin_st = invitation_linkedin_st;
	}

	public Date getCourriel_ouappel_suivie_st() {
		return courriel_ouappel_suivie_st;
	}

	public void setCourriel_ouappel_suivie_st(Date courriel_ouappel_suivie_st) {
		this.courriel_ouappel_suivie_st = courriel_ouappel_suivie_st;
	}

}
