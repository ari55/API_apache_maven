package entity;

public class Application {
	private int id;
	private int info_generale_id;
	private int info_specifique_id;	
	private int doc_achemine_id;
	private int suivie_application_id;
	private int suivie_en_personne_id;
	private int suivie_telephonique_id;
	private int user_id;
	private String commentaire;
	private Boolean etat_suivie;
	
	public Application(int info_generale_id, int info_specifique_id, int doc_achemine_id,
			int suivie_application_id, int suivie_en_personne_id, int suivie_telephonique_id, int user_id,
			String commentaire, Boolean etat_suivie) {
		super();
		//this.id = id;
		this.info_generale_id = info_generale_id;
		this.info_specifique_id = info_specifique_id;
		this.doc_achemine_id = doc_achemine_id;
		this.suivie_application_id = suivie_application_id;
		this.suivie_en_personne_id = suivie_en_personne_id;
		this.suivie_telephonique_id = suivie_telephonique_id;
		this.user_id = user_id;
		this.commentaire = commentaire;
		this.etat_suivie = etat_suivie;
	}
	
	public Application() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInfo_generale_id() {
		return info_generale_id;
	}

	public void setInfo_generale_id(int info_generale_id) {
		this.info_generale_id = info_generale_id;
	}

	public int getInfo_specifique_id() {
		return info_specifique_id;
	}

	public void setInfo_specifique_id(int info_specifique_id) {
		this.info_specifique_id = info_specifique_id;
	}

	public int getDoc_achemine_id() {
		return doc_achemine_id;
	}

	public void setDoc_achemine_id(int doc_achemine_id) {
		this.doc_achemine_id = doc_achemine_id;
	}

	public int getSuivie_application_id() {
		return suivie_application_id;
	}

	public void setSuivie_application_id(int suivie_application_id) {
		this.suivie_application_id = suivie_application_id;
	}

	public int getSuivie_en_personne_id() {
		return suivie_en_personne_id;
	}

	public void setSuivie_en_personne_id(int suivie_en_personne_id) {
		this.suivie_en_personne_id = suivie_en_personne_id;
	}

	public int getSuivie_telephonique_id() {
		return suivie_telephonique_id;
	}

	public void setSuivie_telephonique_id(int suivie_telephonique_id) {
		this.suivie_telephonique_id = suivie_telephonique_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Boolean getEtat_suivie() {
		return etat_suivie;
	}

	public void setEtat_suivie(Boolean etat_suivie) {
		this.etat_suivie = etat_suivie;
	}
	
}
