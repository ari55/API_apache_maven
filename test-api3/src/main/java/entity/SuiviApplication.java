package entity;

import java.sql.Date;

public class SuiviApplication {

	private int id;
	private Date dateSuiviTelephone;
	private Date dateSuiviEnPersonne;
	private Date dateRelanceInternet;

	public SuiviApplication() {}
	public SuiviApplication(int id, Date dateSuiviTelephone, Date dateSuiviEnPersonne, Date dateRelanceInternet) {
		super();
		this.id = id;
		this.dateSuiviTelephone = dateSuiviTelephone;
		this.dateSuiviEnPersonne = dateSuiviEnPersonne;
		this.dateRelanceInternet = dateRelanceInternet;
	}

	public SuiviApplication(Date dateSuiviTelephone, Date dateSuiviEnPersonne, Date dateRelanceInternet) {
		super();
		this.dateSuiviTelephone = dateSuiviTelephone;
		this.dateSuiviEnPersonne = dateSuiviEnPersonne;
		this.dateRelanceInternet = dateRelanceInternet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateSuiviTelephone() {
		return dateSuiviTelephone;
	}

	public void setDateSuiviTelephone(Date dateSuiviTelephone) {
		this.dateSuiviTelephone = dateSuiviTelephone;
	}

	public Date getDateSuiviEnPersonne() {
		return dateSuiviEnPersonne;
	}

	public void setDateSuiviEnPersonne(Date dateSuiviEnPersonne) {
		this.dateSuiviEnPersonne = dateSuiviEnPersonne;
	}

	public Date getDateRelanceInternet() {
		return dateRelanceInternet;
	}

	public void setDateRelanceInternet(Date dateRelanceInternet) {
		this.dateRelanceInternet = dateRelanceInternet;
	}

}
