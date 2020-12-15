package entity;

import java.sql.Date;

public class InfoGenerale {
	private int id;
	private Date date;
	private String nomEntreprise;
	private String nomContactDeEntreprise;
	private long telephone;
	private String email;
	private String linkedin;
	private String address;

	public InfoGenerale() {
	}

	public InfoGenerale(int id, Date date, String nomEntreprise, String nomContactDeEntreprise, long telephone,
			String email, String linkedin, String address) {
		super();
		this.id = id;
		this.date = date;
		this.nomEntreprise = nomEntreprise;
		this.nomContactDeEntreprise = nomContactDeEntreprise;
		this.telephone = telephone;
		this.email = email;
		this.linkedin = linkedin;
		this.address = address;
	}

	public InfoGenerale(Date date, String nomEntreprise, String nomContactDeEntreprise, long telephone, String email,
			String linkedin, String address) {
		super();
		this.date = date;
		this.nomEntreprise = nomEntreprise;
		this.nomContactDeEntreprise = nomContactDeEntreprise;
		this.telephone = telephone;
		this.email = email;
		this.linkedin = linkedin;
		this.address = address;
	}
	public InfoGenerale( String nomEntreprise, String nomContactDeEntreprise, long telephone, String email,
			String linkedin, String address) {
		super();
		this.nomEntreprise = nomEntreprise;
		this.nomContactDeEntreprise = nomContactDeEntreprise;
		this.telephone = telephone;
		this.email = email;
		this.linkedin = linkedin;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getNomContactDeEntreprise() {
		return nomContactDeEntreprise;
	}

	public void setNomContactDeEntreprise(String nomContactDeEntreprise) {
		this.nomContactDeEntreprise = nomContactDeEntreprise;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
