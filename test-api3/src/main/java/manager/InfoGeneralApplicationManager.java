package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.InfoGenerale;
import service.DBConnexion;

public class InfoGeneralApplicationManager {

	static private final String INSERT_NEW_INFO_GENERAL = "insert into info_generale_application (date, nom_de_lentreprise, nom_contact_de_lentreprise, telephone,email, linkedin,adresse) values (?, ?, ?, ?, ?, ?, ?)";
	static private final String GET_INFOGENERALE_BY_ID = "select * from info_generale_application where id  = ? ;";
	static private final String GET_LAST_ID_INFO_GENERAL = "SELECT MAX (id) FROM info_generale_application;";
	static private final String UPDATE_INFO_GENERALE = "update info_generale_application "
			+ "set nom_de_lentreprise = ?, nom_contact_de_lentreprise = ?, telephone = ?, email = ?, linkedin = ?, adresse = ? "
			+ "where id = ?";
	
	static private final String DELETE_INFO_GENERALE = "delete from info_generale_application where id = ?";

	public static int getLastInfoGeneral() {
		int retour = -1;

		try {
			PreparedStatement ps = DBConnexion.getPs(GET_LAST_ID_INFO_GENERAL);
			ResultSet result = ps.executeQuery();
			if (result.isBeforeFirst()) {
				result.next();
				retour = result.getInt(1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		DBConnexion.close();
		return retour;
	}

	public static InfoGenerale getInfoById(int id) {
		InfoGenerale retour = null;
		PreparedStatement ps = DBConnexion.getPs(GET_INFOGENERALE_BY_ID);
		try {
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			// traitement des resultats
			// verifier si i y a des données dans le resultat
			if (result.isBeforeFirst()) {
				retour = new InfoGenerale();
				while (result.next()) {// pour parcourir le resultset

					retour.setId(result.getInt("id"));
					retour.setDate(result.getDate("date"));
					retour.setNomEntreprise(result.getString("nom_de_lentreprise"));
					retour.setNomContactDeEntreprise(result.getString("nom_contact_de_lentreprise"));
					retour.setTelephone(result.getLong("telephone"));
					retour.setEmail(result.getString("email"));
					retour.setLinkedin(result.getString("linkedin"));
					retour.setAddress(result.getString("addresse"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// fermer la connection
		DBConnexion.close();

		return retour;
	}

	static public final boolean createInfoGenerale(InfoGenerale newInfoGenerale) {
		int nbModDansBd = 0;
		try {

			PreparedStatement preparedStatement = DBConnexion.getPs(INSERT_NEW_INFO_GENERAL);
			preparedStatement.setDate(1, newInfoGenerale.getDate());
			preparedStatement.setString(2, newInfoGenerale.getNomEntreprise());
			preparedStatement.setString(3, newInfoGenerale.getNomContactDeEntreprise());
			preparedStatement.setLong(4, newInfoGenerale.getTelephone());
			preparedStatement.setString(5, newInfoGenerale.getEmail());
			preparedStatement.setString(6, newInfoGenerale.getLinkedin());
			preparedStatement.setString(7, newInfoGenerale.getAddress());

			nbModDansBd = preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBConnexion.close();
		return nbModDansBd > 0;
	}

	static public final boolean updateInfoGenerale(InfoGenerale ig, int id) {
		int nbModDansBd = 0;
		try {

			PreparedStatement preparedStatement = DBConnexion.getPs(UPDATE_INFO_GENERALE);
			
			preparedStatement.setString(1, ig.getNomEntreprise());
			preparedStatement.setString(2, ig.getNomContactDeEntreprise());
			preparedStatement.setLong(3, ig.getTelephone());
			preparedStatement.setString(4, ig.getEmail());
			preparedStatement.setString(5, ig.getLinkedin());
			preparedStatement.setString(6, ig.getAddress());
			preparedStatement.setInt(7, id);

			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}

	static public final boolean deleteInfoGenerale(int idInfoGen) {
		int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = DBConnexion.getPs(DELETE_INFO_GENERALE);
            preparedStatement.setInt(1, idInfoGen);
            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DBConnexion.close();
        return nbModDansBd > 0;
	}
}
