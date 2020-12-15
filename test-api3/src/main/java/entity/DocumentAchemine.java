package entity;

public class DocumentAchemine {
	int idDocAchemine;
	boolean cv;
	boolean lettre_motivation;
	boolean releve_note;
	boolean autres;
	boolean lesreferences;

	public DocumentAchemine(int idDocAchemine, boolean cv, boolean lettre_motivation, boolean releve_note,
			boolean autres, boolean lesreferences) {
		super();
		this.idDocAchemine = idDocAchemine;
		this.cv = cv;
		this.lettre_motivation = lettre_motivation;
		this.releve_note = releve_note;
		this.autres = autres;
		this.lesreferences = lesreferences;
	}

	public DocumentAchemine(boolean cv, boolean lettre_motivation, boolean releve_note, boolean autres,
			boolean lesreferences) {
		super();
		this.cv = cv;
		this.lettre_motivation = lettre_motivation;
		this.releve_note = releve_note;
		this.autres = autres;
		this.lesreferences = lesreferences;
	}

	public boolean isCv() {
		return cv;
	}

	public void setCv(boolean cv) {
		this.cv = cv;
	}

	public boolean isLettre_motivation() {
		return lettre_motivation;
	}

	public void setLettre_motivation(boolean lettre_motivation) {
		this.lettre_motivation = lettre_motivation;
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

	public int getIdDocAchemine() {
		return idDocAchemine;
	}

	public void setIdDocAchemine(int idDocAchemine) {
		this.idDocAchemine = idDocAchemine;
	}
}
