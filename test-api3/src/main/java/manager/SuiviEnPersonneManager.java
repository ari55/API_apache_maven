package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.InfoGenerale;
import entity.SuiviEnPersonne;
import service.DBConnexion;

public class SuiviEnPersonneManager {
	static private final String QUERY_CREATE_NEW_SUIVI_PERSONNE = "insert into suivie_en_personn (date_dentrevue,courriel_remerciement,invitation_linkedin,courriel_ouappel_de_suivie) values (?, ?, ?, ?)";
	static private final String QUERY_UPDATE_SUIVI_EN_PERSONNE = "update suivie_en_personn "
			+ "set date_dentrevue = ?, courriel_remerciement = ?, invitation_linkedin = ? , courriel_ouappel_de_suivie = ? "
			+ "where id = ?";
	static private final String GET_LAST_ID_SUIV_EN_PERSONNE = "SELECT MAX (id) FROM suivie_en_personn;";
	static private final String DELETE_SUIVI_EN_PERSONNE = "delete from suivie_en_personn where id = ?";

	public static int getLastSuiviEnPersonneId() {
		int retour = -1;

		try {
			PreparedStatement ps = DBConnexion.getPs(GET_LAST_ID_SUIV_EN_PERSONNE);
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

	static public final boolean updateSuiviEnPersonne(SuiviEnPersonne sp, int id) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_UPDATE_SUIVI_EN_PERSONNE);
			preparedStatement.setDate(1, sp.getDateEntrevue());
			preparedStatement.setDate(2, sp.getCourrielRemerciement());
			preparedStatement.setDate(3, sp.getInvitationLinkedIn());
			preparedStatement.setDate(4, sp.getCourrielOuAppelSuivi());

			preparedStatement.setInt(5,id);
			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}

	static public final boolean createSuiviEnPersonne(SuiviEnPersonne newSuiviPersonne) {
		int nbModDansBd = 0;
		try {

			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_CREATE_NEW_SUIVI_PERSONNE);
			preparedStatement.setDate(1, newSuiviPersonne.getDateEntrevue());
			preparedStatement.setDate(2, newSuiviPersonne.getCourrielRemerciement());
			preparedStatement.setDate(3, newSuiviPersonne.getInvitationLinkedIn());
			preparedStatement.setDate(4, newSuiviPersonne.getCourrielOuAppelSuivi());

			nbModDansBd = preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBConnexion.close();
		return nbModDansBd > 0;
	}
	
	static public final boolean deleteSuiviePersonne(int idSuivieEnPers) {
		int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = DBConnexion.getPs(DELETE_SUIVI_EN_PERSONNE);
            preparedStatement.setInt(1, idSuivieEnPers);
            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DBConnexion.close();
        return nbModDansBd > 0;
	}
	
	
}
