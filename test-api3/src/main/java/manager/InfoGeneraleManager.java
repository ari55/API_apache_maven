package manager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.InfoGenerale;
import service.DBConnexion;

public class InfoGeneraleManager {

	static private final String UPDATE_INFO_GENERALE = "update info_generale_application set nom_de_lentreprise = ?, nom_contact_de_lentreprise = ?, telephone = ?, email = ?, linkedin = ?, adresse = ? where id = ?";

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
			preparedStatement.setInt(7, ig.getId());

			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}
}
