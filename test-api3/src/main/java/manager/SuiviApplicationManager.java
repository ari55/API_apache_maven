package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.InfoGenerale;
import entity.SuiviApplication;
import service.DBConnexion;

public class SuiviApplicationManager {
	static private final String QUERY_UPDATE_SUIVIE_APPLICATION = "update suivie_de_application "
			+ "set date_suivie_telephonique = ?, date_suivie_en_personne = ?, date_relance_interet = ? "
			+ "where id = ?";
	static private final String INSERT_NEW_SUIVIE_APPLICATION = "insert into suivie_de_application  (date_suivie_telephonique, date_suivie_en_personne, date_relance_interet) values (?, ?, ?)";
	static private final String GET_SUIVIE_APPLICATION_BY_ID = "select * from suivie_de_application where id  = ? ;";
	static private final String GET_LAST_ID_SUIV_APPLICATION = "SELECT MAX (id) FROM suivie_de_application;";

	//static private final String GET_SUIVI_APPLICATION_BY_ID = "select * from suivie_de_application where id  = ? ;";

	static private final String DELETE_SUIVI_APPLICATION = "delete from suivie_de_application where id = ?";


	public static SuiviApplication getInfoById(int id) {
		SuiviApplication retour = null;
		PreparedStatement ps = DBConnexion.getPs(GET_SUIVIE_APPLICATION_BY_ID);
		try {
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
					if (result.isBeforeFirst()) {
				retour = new SuiviApplication();
				while (result.next()) {

					retour.setId(result.getInt("id"));
					retour.setDateSuiviTelephone(result.getDate("date_suivie_telephonique"));
					retour.setDateSuiviEnPersonne(result.getDate("date_suivie_en_personne"));
					retour.setDateRelanceInternet(result.getDate("date_relance_interet"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// fermer la connection
		DBConnexion.close();

		return retour;
	}
	
	public static int getLastSuiviApplicationId() {
		int retour = -1;

		try {
			PreparedStatement ps = DBConnexion.getPs(GET_LAST_ID_SUIV_APPLICATION);
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

	public static final boolean updateSuivieApplication(SuiviApplication sa, int id) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_UPDATE_SUIVIE_APPLICATION);
			preparedStatement.setDate(1, sa.getDateSuiviTelephone());
			preparedStatement.setDate(2, sa.getDateSuiviEnPersonne());
			preparedStatement.setDate(3, sa.getDateRelanceInternet());
			preparedStatement.setInt(4,id);
			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}

	static public final boolean createSuiVieApplication(SuiviApplication info) {
		int nbModDansBd = 0;

		try {

			PreparedStatement preparedStatement = DBConnexion.getPs(INSERT_NEW_SUIVIE_APPLICATION);
			preparedStatement.setDate(1, info.getDateSuiviTelephone());
			preparedStatement.setDate(2, info.getDateSuiviEnPersonne());
			preparedStatement.setDate(3, info.getDateRelanceInternet());
			nbModDansBd = preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBConnexion.close();
		return nbModDansBd > 0;
	}
	
	static public final boolean deleteSuiviApp(int idSuiviApp) {
		int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = DBConnexion.getPs(DELETE_SUIVI_APPLICATION);
            preparedStatement.setInt(1, idSuiviApp);
            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DBConnexion.close();
        return nbModDansBd > 0;
	}
}
