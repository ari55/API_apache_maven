package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Application;
import entity.SuiviTelephonique;
import service.DBConnexion;

public class ApplicationManager {

	public static final String INSERT_APPLICATION = "insert into application(info_generale_id, info_specifique_id, doc_achemine_id, suivie_application_id, suivie_en_personn_id, suivie_telephonique_id, user_id, commentaire, etat_suivie) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String GET_APPLICATION_BY_ID = "select * from application where id = ?";
	static private final String QUERY_UPDATE_ETAT_SUIVIE_APP = "update application "+ "set etat_suivie = ?"+"where id = ?";
	static private final String QUERY_UPDATE_ETAT_COMMENTAIRE = "update application "+ "set commentaire = ?"+"where id = ?";

	public static boolean createApplication(Application app) {

		int nbModDansBd = 0;
		try {


			PreparedStatement preparedStatement = DBConnexion.getPs(INSERT_APPLICATION);
			preparedStatement.setInt(1, app.getInfo_generale_id());
			preparedStatement.setInt(2, app.getInfo_specifique_id());
			preparedStatement.setInt(3, app.getDoc_achemine_id());
			preparedStatement.setInt(4, app.getSuivie_application_id());
			preparedStatement.setInt(5, app.getSuivie_en_personne_id());
			preparedStatement.setInt(6, app.getSuivie_telephonique_id());
			preparedStatement.setInt(7, app.getUser_id());
			preparedStatement.setString(8, app.getCommentaire());
			preparedStatement.setBoolean(9, app.getEtat_suivie());
			

			nbModDansBd = preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBConnexion.close();
		return nbModDansBd > 0;
		
	}
	
	public static Application getApplicationById(int id) {
        Application retour = null;
        PreparedStatement preparedStatement = DBConnexion.getPs(GET_APPLICATION_BY_ID);

        try {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.isBeforeFirst()) {
            	retour = new entity.Application();
                while (result.next()) {     	
                    retour.setId(result.getInt("id"));
                    retour.setInfo_generale_id(result.getInt("info_generale_id"));
                    retour.setInfo_specifique_id(result.getInt("info_specifique_id"));
                    retour.setDoc_achemine_id(result.getInt("doc_achemine_id"));
                    retour.setSuivie_application_id(result.getInt("suivie_application_id"));
                    retour.setSuivie_application_id(result.getInt("suivie_en_personn_id"));
                    retour.setSuivie_application_id(result.getInt("suivie_telephonique_id"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DBConnexion.close();
        return retour;

    }
	static public final boolean updateEtatSuivi(int idApp, boolean valeur) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_UPDATE_ETAT_SUIVIE_APP);
			preparedStatement.setBoolean(1, valeur);
			preparedStatement.setInt(2,idApp);
			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}
	static public final boolean updateCommentaire( String commentaire,int idApp) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_UPDATE_ETAT_COMMENTAIRE);
			preparedStatement.setString(1,commentaire);
			preparedStatement.setInt(2,idApp);
			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}
}

