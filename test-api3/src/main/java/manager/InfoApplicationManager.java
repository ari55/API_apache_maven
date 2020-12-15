package manager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import entity.InfoApplication;
import entity.InfoGenerale;
import entity.UserWithProgrammeName;
import service.DBConnexion;

public class InfoApplicationManager {

	static private final String QUERY_GET_ALL_INFO_APPLICATION = "select a.id, a.commentaire, a.etat_suivie, dc.*, ig.*, isp.*, sa.*, sp.*, st.* "
			+ "from application a " + "inner join document_achemine dc on dc.id = a.doc_achemine_id "
			+ "inner join info_generale_application ig on ig.id = a.info_generale_id "
			+ "inner join info_specifique_application isp on isp.id = a.info_specifique_id "
			+ "inner join suivie_de_application sa on sa.id = a.suivie_application_id "
			+ "inner join suivie_en_personn sp ON sp.id = a.suivie_en_personn_id "
			+ "inner join suivie_telephonique st on st.id = a.suivie_telephonique_id "
			+ "where CAST(user_id as varchar) = ?";

	static private final String QUERY_GET_APPLICATION_BY_ID_APP= "select a.id, a.commentaire, a.etat_suivie, dc.*, ig.*, isp.*, sa.*, sp.*, st.* "
			+ "from application a " + "inner join document_achemine dc on dc.id = a.doc_achemine_id "
			+ "inner join info_generale_application ig on ig.id = a.info_generale_id "
			+ "inner join info_specifique_application isp on isp.id = a.info_specifique_id "
			+ "inner join suivie_de_application sa on sa.id = a.suivie_application_id "
			+ "inner join suivie_en_personn sp ON sp.id = a.suivie_en_personn_id "
			+ "inner join suivie_telephonique st on st.id = a.suivie_telephonique_id "
			+ "where CAST( a.id as varchar) = ?" ;
	static private final String QUERY_FILTER_INFO_APPLICATION_BY_DATE_DESC = "select a.id, a.commentaire, a.etat_suivie, dc.*, ig.*, isp.*, sa.*, sp.*, st.* "
			+ "from application a " + "inner join document_achemine dc on dc.id = a.doc_achemine_id "
			+ "inner join info_generale_application ig on ig.id = a.info_generale_id "
			+ "inner join info_specifique_application isp on isp.id = a.info_specifique_id "
			+ "inner join suivie_de_application sa on sa.id = a.suivie_application_id "
			+ "inner join suivie_en_personn sp ON sp.id = a.suivie_en_personn_id "
			+ "inner join suivie_telephonique st on st.id = a.suivie_telephonique_id "
			+ "where CAST(user_id as varchar) = ?" + "order by ig.date desc";

	static private final String QUERY_DELETE_APPLICATION = "delete from application where CAST(id as varchar) = ?";

	static public boolean delete(String id) {
		return update(QUERY_DELETE_APPLICATION, id) == 1;
	}

	static public InfoApplication[] getById(String id) {
		return get(QUERY_GET_ALL_INFO_APPLICATION, id);
	}
	static public InfoApplication[] getByIdApp(String id) {
		return get(QUERY_GET_APPLICATION_BY_ID_APP, id);
	}
	static public InfoApplication[] filterByDate() {
		return get(QUERY_FILTER_INFO_APPLICATION_BY_DATE_DESC);
	}

	
	  public static InfoApplication getInfoById(String id) { InfoApplication retour
	  = null; PreparedStatement ps =
	  DBConnexion.getPs(QUERY_GET_APPLICATION_BY_ID_APP); try { ps.setString(1,
	  id); ResultSet rs = ps.executeQuery();
	  
	  if (rs.isBeforeFirst()) { retour = new InfoApplication(); while (rs.next()) {
	  
	  retour.setId(rs.getInt(1)); retour.setCommentaire(rs.getString(2));
	  retour.setEtat_suivie(rs.getBoolean(3));
	  
	  retour.setId_doc_achemine(rs.getInt(4)); retour.setCv(rs.getBoolean(5));
	  retour.setLetre_motivation(rs.getBoolean(6));
	  retour.setReleve_note(rs.getBoolean(7)); retour.setAutres(rs.getBoolean(8));
	  retour.setLesreferences(rs.getBoolean(9));
	  retour.setId_info_generale_application(rs.getInt(10));
	  retour.setDate_application(rs.getDate(11));
	  retour.setNom_de_lentreprise(rs.getString(12));
	  retour.setNom_contact_de_lentreprise(rs.getString(13));
	  retour.setTelephone(rs.getLong(14)); retour.setEmail(rs.getString(15));
	  retour.setLinkedin(rs.getString(16)); retour.setAddresse(rs.getString(17));
	  retour.setId_info_specifique(rs.getInt(18));
	  retour.setTitre_du_poste(rs.getString(19));
	  retour.setDescription_poste(rs.getString(20));
	  retour.setLanguage_utilise(rs.getString(21));
	  retour.setNumero_reference(rs.getString(22));
	  retour.setRemuneration(rs.getDouble(23));
	  retour.setDate_fin_affichage(rs.getDate(24));
	  retour.setSource_poste(rs.getString(25));
	  retour.setMatch_poste(rs.getString(26));
	  retour.setId_suivie_application(rs.getInt(27));
	  retour.setDate_suivie_telephonique(rs.getDate(28));
	  retour.setDate_suivie_en_personne(rs.getDate(29));
	  retour.setRelance_interet(rs.getDate(30));
	  
	  retour.setId_suivie_en_personne(rs.getInt(31));
	  retour.setDate_entrevue(rs.getDate(32));
	  retour.setCourriel_remerciement(rs.getDate(33));
	  retour.setInvitation_linkedin(rs.getDate(34));
	  retour.setCourriel_ouappel_suivie(rs.getDate(35));
	  
	  retour.setId_suivie_telephonique(rs.getInt(36));
	  retour.setDate_entretien(rs.getDate(37));
	  retour.setCourriel_remerciement_st(rs.getDate(38));
	  retour.setInvitation_linkedin_st(rs.getDate(39));
	  retour.setCourriel_ouappel_suivie_st(rs.getDate(40));
	  
	  } } } catch (SQLException e) { e.printStackTrace(); } // fermer la connection
	  DBConnexion.close();
	  
	  return retour; }
	 
	////
	static private final InfoApplication[] get(String query, String... stringParams) {
		ArrayList<InfoApplication> info = new ArrayList<>();
		try {
			PreparedStatement ps = DBConnexion.getPs(query);
			if (stringParams != null)
				for (int i = 0; i < stringParams.length; i++)
					ps.setString(i + 1, stringParams[i]);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				InfoApplication i = new InfoApplication();
				i.setId(rs.getInt(1));
				i.setCommentaire(rs.getString(2));
				i.setEtat_suivie(rs.getBoolean(3));
				//
				i.setId_doc_achemine(rs.getInt(4));
				i.setCv(rs.getBoolean(5));
				i.setLetre_motivation(rs.getBoolean(6));
				i.setReleve_note(rs.getBoolean(7));
				i.setAutres(rs.getBoolean(8));
				i.setLesreferences(rs.getBoolean(9));
				//
				i.setId_info_generale_application(rs.getInt(10));
				i.setDate_application(rs.getDate(11));
				i.setNom_de_lentreprise(rs.getString(12));
				i.setNom_contact_de_lentreprise(rs.getString(13));
				i.setTelephone(rs.getLong(14));
				i.setEmail(rs.getString(15));
				i.setLinkedin(rs.getString(16));
				i.setAddresse(rs.getString(17));
				//
				i.setId_info_specifique(rs.getInt(18));
				i.setTitre_du_poste(rs.getString(19));
				i.setDescription_poste(rs.getString(20));
				i.setLanguage_utilise(rs.getString(21));
				i.setNumero_reference(rs.getString(22));
				i.setRemuneration(rs.getDouble(23));
				i.setDate_fin_affichage(rs.getDate(24));
				i.setSource_poste(rs.getString(25));
				i.setMatch_poste(rs.getString(26));
				//
				i.setId_suivie_application(rs.getInt(27));
				i.setDate_suivie_telephonique(rs.getDate(28));
				i.setDate_suivie_en_personne(rs.getDate(29));
				i.setRelance_interet(rs.getDate(30));
				//
				i.setId_suivie_en_personne(rs.getInt(31));
				i.setDate_entrevue(rs.getDate(32));
				i.setCourriel_remerciement(rs.getDate(33));
				i.setInvitation_linkedin(rs.getDate(34));
				i.setCourriel_ouappel_suivie(rs.getDate(35));
				//
				i.setId_suivie_telephonique(rs.getInt(36));
				i.setDate_entretien(rs.getDate(37));
				i.setCourriel_remerciement_st(rs.getDate(38));
				i.setInvitation_linkedin_st(rs.getDate(39));
				i.setCourriel_ouappel_suivie_st(rs.getDate(40));
				info.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnexion.close();
		InfoApplication[] ia = new InfoApplication[info.size()];
		return info.toArray(ia);
	}

	static private int update(String query, String... stringParams) {
		int retour = 0;
		try {
			PreparedStatement ps = DBConnexion.getPs(query);
			if (stringParams != null)
				for (int i = 0; i < stringParams.length; i++)
					ps.setString(i + 1, stringParams[i]);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnexion.close();
		return retour;
	}

}
