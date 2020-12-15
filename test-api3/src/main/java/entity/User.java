package entity;

import java.sql.Date;

public class User {
	private int id;
	private long telephone;
	private String nom;
	private String prenom;
	private int programme_id;
	private String email;
	private String password;
	private Date date_naissance;
	private int id_privilege;
	private boolean status;
	private String image_name;

	public User() {
		super();
	}

	public User(Date date_naissance, String prenom, String nom, long telephone, int programme_id, boolean status,
			String image_name, String email, String password, int id_privilege) {
		super();
		this.date_naissance = date_naissance;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.programme_id = programme_id;
		this.status = status;
		this.image_name = image_name;
		this.email = email;
		this.password = password;
		this.id_privilege = id_privilege;
	}

	public User(int id, Date date_naissance, String prenom, String nom, long telephone, int programme_id,
			String image_name, String email, String password, int id_privilege, boolean status) {
		super();
		this.id = id;
		this.date_naissance = date_naissance;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.programme_id = programme_id;
		this.status = status;
		this.image_name = image_name;
		this.email = email;
		this.password = password;
		this.id_privilege = id_privilege;
	}

	public User(Date date_naissance, String prenom, String nom, long telephone, int programme_id, String email,
			String password) {
		super();
		this.date_naissance = date_naissance;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.programme_id = programme_id;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public boolean getStatus() {
		return status;
	}

	public String getImgName() {
		return image_name;

	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getProgramme_id() {
		return programme_id;
	}

	public void setProgramme_id(int programme_id) {
		this.programme_id = programme_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public int getId_privilege() {
		return id_privilege;
	}

	public void setId_privilege(int id_privilege) {
		this.id_privilege = id_privilege;
	}
}

