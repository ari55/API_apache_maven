package entity;

import java.sql.Date;

public class InfoSpecifique {

	private int id;
	private String titreDuPoste;
	private String descriptionPsote;
	private String languageUtilise;
	private String numeroReference;
	private double remuneration;
	private Date dateFinAffichage;
	private String sourcePoste;
	private String matchPoste;
public InfoSpecifique () {}
	public InfoSpecifique(String titreDuPoste, String descriptionPsote, String languageUtilise, String numeroReference,
			double remuneration, Date dateFinAffichage, String sourcePoste, String matchPoste) {
		super();
		this.titreDuPoste = titreDuPoste;
		this.descriptionPsote = descriptionPsote;
		this.languageUtilise = languageUtilise;
		this.numeroReference = numeroReference;
		this.remuneration = remuneration;
		this.dateFinAffichage = dateFinAffichage;
		this.sourcePoste = sourcePoste;
		this.matchPoste = matchPoste;
	}

	public InfoSpecifique(int id, String titreDuPoste, String descriptionPsote, String languageUtilise,
			String numeroReference, double remuneration, Date dateFinAffichage, String sourcePoste, String matchPoste) {
		super();
		this.id = id;
		this.titreDuPoste = titreDuPoste;
		this.descriptionPsote = descriptionPsote;
		this.languageUtilise = languageUtilise;
		this.numeroReference = numeroReference;
		this.remuneration = remuneration;
		this.dateFinAffichage = dateFinAffichage;
		this.sourcePoste = sourcePoste;
		this.matchPoste = matchPoste;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitreDuPoste() {
		return titreDuPoste;
	}

	public void setTitreDuPoste(String titreDuPoste) {
		this.titreDuPoste = titreDuPoste;
	}

	public String getDescriptionPsote() {
		return descriptionPsote;
	}

	public void setDescriptionPsote(String descriptionPsote) {
		this.descriptionPsote = descriptionPsote;
	}

	public String getLanguageUtilise() {
		return languageUtilise;
	}

	public void setLanguageUtilise(String languageUtilise) {
		this.languageUtilise = languageUtilise;
	}

	public String getNumeroReference() {
		return numeroReference;
	}

	public void setNumeroReference(String numeroReference) {
		this.numeroReference = numeroReference;
	}

	public double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}

//////
	public Date getDateFinAffichage() {
		return dateFinAffichage;
	}

	public void setDateFinAffichage(Date dateFinAffichage) {
		this.dateFinAffichage = dateFinAffichage;
	}

	public String getSourcePoste() {
		return sourcePoste;
	}

	public void setSourcePoste(String sourcePoste) {
		this.sourcePoste = sourcePoste;
	}

	public String getMatchPoste() {
		return matchPoste;
	}

	public void setMatchPoste(String matchPoste) {
		this.matchPoste = matchPoste;
	}

}
