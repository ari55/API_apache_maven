package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.DocumentAchemine;
import service.DBConnexion;

public class DocumentAchemineManager {
	static private final String GET_LAST_ID_INFO_GENERAL = "SELECT MAX (id) FROM document_achemine;";
	static private final String INSERT_NEW_DOC_ACHEMINE = "insert into document_achemine (cv,letre_motivation, releve_note, autres, lesreferences) values (?, ?, ?, ?, ?)";
	static private final String QUERY_UPDATE_DOC_ACHEMNINE = "update document_achemine "
			+ "set cv = ?, letre_motivation = ?, releve_note = ?, autres = ?, lesreferences = ? " + "where id = ?";
	
	static private final String DELETE_DOC_ACHEMINE_QUERY = "delete from document_achemine where id = ?";

	public static int getLastInfoDocAchemine() {
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

	// static public final updateDocAchemine()
	static public final boolean updateDocAchemine(DocumentAchemine docs, int id) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_UPDATE_DOC_ACHEMNINE);
			preparedStatement.setBoolean(1, docs.isCv());
			preparedStatement.setBoolean(2, docs.isLettre_motivation());
			preparedStatement.setBoolean(3, docs.isReleve_note());
			preparedStatement.setBoolean(4, docs.isAutres());
			preparedStatement.setBoolean(5, docs.isLesreferences());
			preparedStatement.setInt(6, id);
			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}

	static public final boolean creerDocAcheminer(DocumentAchemine doc) {
		int nbModDansBd = 0;
		//DocumentAchemine doc = new DocumentAchemine(false, false, false, false, false);

		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(INSERT_NEW_DOC_ACHEMINE);

			preparedStatement.setBoolean(1, doc.isCv());
			preparedStatement.setBoolean(2, doc.isLettre_motivation());
			preparedStatement.setBoolean(3, doc.isReleve_note());
			preparedStatement.setBoolean(4, doc.isAutres());
			preparedStatement.setBoolean(5, doc.isLesreferences());

			nbModDansBd = preparedStatement.executeUpdate();
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBConnexion.close();
		return nbModDansBd > 0;

	}
	
	static public final boolean deleteDocumentAchemine(int idDocAchemine) {
		int nbModDansBd = 0;
        try {
            PreparedStatement preparedStatement = DBConnexion.getPs(DELETE_DOC_ACHEMINE_QUERY);
            preparedStatement.setInt(1, idDocAchemine);
            nbModDansBd = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DBConnexion.close();
        return nbModDansBd > 0;
	}

}
