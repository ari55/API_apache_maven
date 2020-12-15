package entity;


public class HttpBodyBeanApplication {
	public InfoGenerale infoGenerale;
	public InfoSpecifique infoSpecifique;
	public DocumentAchemine documentAchemine;
	public SuiviApplication suiviApplication;
	public SuiviEnPersonne suiviEnPersonne;
	public SuiviTelephonique suiviTelephonique;
	//
	public Integer id_user;
	public String commentaire;
	public Boolean etat_suivie;
	//
	public Integer id_doc_achemine;
	public Boolean cv;
	public Boolean letre_motivation;
	public Boolean releve_note;
	public Boolean autres;
	public Boolean lesreferences;
	//

	public Integer id_info_generale_application;
	public String date_application;
	public String nom_de_lentreprise;
	public String nom_contact_de_lentreprise;
	public Long telephone;
	public String email;
	public String linkedin;
	public String addresse;
	//
	public Integer id_info_specifique;
	public String titre_du_poste;
	public String description_poste;
	public String language_utilise;
	public String numero_reference;
	public Double remuneration;
	public String date_fin_affichage;
	public String source_poste;
	public String match_poste;
	//
	public Integer id_suivie_application;
	public String date_suivie_telephonique;
	public String date_suivie_en_personne;
	public String relance_interet;
	//
	public Integer id_suivie_en_personne;
	public String date_entrevue;
	public String courriel_remerciement;
	public String invitation_linkedin;
	public String courriel_ouappel_suivie;
	//
	public Integer id_suivie_telephonique;
	public String date_entretien;
	public String courriel_remerciement_st;
	public String invitation_linkedin_st;
	public String courriel_ouappel_suivie_st;
}
