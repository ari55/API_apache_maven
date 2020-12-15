package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.SuiviEnPersonne;
import entity.SuiviTelephonique;
import service.DBConnexion;

public class SuiviTelephoniqueManager {
	static private final String QUERY_CREATE_SUIVI_TELEPHONIQUE = "insert into suivie_telephonique (date_dentretien,courriel_remerciement,invitation_linkedin,courriel_ouappel_de_suivie) values (?, ?, ?, ?)";
	static private final String QUERY_UPDATE_SUIVIE_TELEPHONIQUE = "update suivie_telephonique "
			+ "set date_dentretien = ?, courriel_remerciement = ? , invitation_linkedin = ?, courriel_ouappel_de_suivie = ? "
			+ "where id = ?";
	static private final String GET_LAST_ID_SUIV_TELEPHONIQUE = "SELECT MAX (id) FROM suivie_telephonique;";
	static private final String DELETE_SUIVIE_TEL = "delete from suivie_telephonique where id = ?";

	public static int getLastSuiviTelId() {
		int retour = -1;

		try {
			PreparedStatement ps = DBConnexion.getPs(GET_LAST_ID_SUIV_TELEPHONIQUE);
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

	static public final boolean updateSuiviTelephonique(SuiviTelephonique st, int id) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_UPDATE_SUIVIE_TELEPHONIQUE);
			preparedStatement.setDate(1, st.getDateEntretien());
			preparedStatement.setDate(2, st.getCourrielRemerciement());
			preparedStatement.setDate(3, st.getInvitationLinked());
			preparedStatement.setDate(4, st.getCourrielOuAppelDeSuivi());
			preparedStatement.setInt(5,id);
			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}

	static public final boolean createSuiviTelephonique(SuiviTelephonique suivi) {
		int nbModDansBd = 0;
		try {

			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_CREATE_SUIVI_TELEPHONIQUE);
			preparedStatement.setDate(1, suivi.getDateEntretien());
			preparedStatement.setDate(2, suivi.getCourrielRemerciement());
			preparedStatement.setDate(3, suivi.getInvitationLinked());
			preparedStatement.setDate(4, suivi.getCourrielOuAppelDeSuivi());

			nbModDansBd = preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBConnexion.close();
		return nbModDansBd > 0;
	}

	static public final boolean deleteSuivieTel(int idSuiviTel) {
		int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = DBConnexion.getPs(DELETE_SUIVIE_TEL);
            preparedStatement.setInt(1, idSuiviTel);
            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DBConnexion.close();
        return nbModDansBd > 0;
	}
}
