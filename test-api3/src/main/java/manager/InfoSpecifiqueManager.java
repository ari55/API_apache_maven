package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.InfoGenerale;
import entity.InfoSpecifique;
import service.DBConnexion;

public class InfoSpecifiqueManager {
	static private final String INSERT_NEW_INFO_SPECIFIQUE = "insert into info_specifique_application (titre_du_poste,description_poste,language_utilise,numero_rederence,remuneration,date_fin_affichage,source_poste,match_poste) values (?, ?, ?, ?, ?, ?, ?,?)";
	static private final String QUERY_UPDATE_INFO_SPECIFIQUE = "update info_specifique_application "
			+ "set titre_du_poste = ?, description_poste = ?, language_utilise = ? , numero_rederence = ?, remuneration = ?, date_fin_affichage = ?, source_poste = ?, match_poste = ? "
			+ "where id = ?";
	static private final String GET_LAST_ID_INFO_SPECIFIQUE = "SELECT MAX (id) FROM info_specifique_application;";

	//static private final String GET_INFO_SPECIFIQUE_BY_ID = "select * from info_specifique_application where id  = ? ;";

	static private final String DELETE_INFO_SPECIFIQUE = "delete from info_specifique_application where id = ?";


	public static int getLastInfoSpecifique() {
		int retour = -1;

		try {
			PreparedStatement ps = DBConnexion.getPs(GET_LAST_ID_INFO_SPECIFIQUE);
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
	
	static public final boolean updateInfoSpecifique(InfoSpecifique isp, int id) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_UPDATE_INFO_SPECIFIQUE);
			preparedStatement.setString(1, isp.getTitreDuPoste());
			preparedStatement.setString(2, isp.getDescriptionPsote());
			preparedStatement.setString(3, isp.getLanguageUtilise());
			preparedStatement.setString(4, isp.getNumeroReference());
			preparedStatement.setDouble(5, isp.getRemuneration());
			preparedStatement.setDate(6, isp.getDateFinAffichage());
			preparedStatement.setString(7, isp.getSourcePoste());
			preparedStatement.setString(8, isp.getMatchPoste());
			preparedStatement.setInt(9, id);

			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}

	static public final boolean createInfoSpecifique(InfoSpecifique info) {
		int nbModDansBd = 0;

		try {

			PreparedStatement preparedStatement = DBConnexion.getPs(INSERT_NEW_INFO_SPECIFIQUE);
			preparedStatement.setString(1, info.getTitreDuPoste());
			preparedStatement.setString(2, info.getDescriptionPsote());
			preparedStatement.setString(3, info.getLanguageUtilise());
			preparedStatement.setString(4, info.getNumeroReference());
			preparedStatement.setDouble(5, info.getRemuneration());
			preparedStatement.setDate(6, info.getDateFinAffichage());
			preparedStatement.setString(7, info.getSourcePoste());
			preparedStatement.setString(8, info.getMatchPoste());
			nbModDansBd = preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBConnexion.close();
		return nbModDansBd > 0;
	}

	static public final boolean deleteInfoSpecifique(int idInfoSpec) {
		int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = DBConnexion.getPs(DELETE_INFO_SPECIFIQUE);
            preparedStatement.setInt(1, idInfoSpec);
            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DBConnexion.close();
        return nbModDansBd > 0;
	}
}
