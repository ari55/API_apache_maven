package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.UserWithProgrammeName;
import service.DBConnexion;

public class UserWithProgrammeNameManager {

	static private final String QUERY_GET_BY_ID_STATUT = "select users.id, users.prenom, users.nom, programme.nom FROM users INNER JOIN programme ON programme.id = users.programme_id WHERE users.id_privilege = 0 and CAST(users.status as varchar) = ? ";

	static public UserWithProgrammeName[] getByIdStatut(String id) {
		return getByProgrammeId(QUERY_GET_BY_ID_STATUT, id);
	}

	static public final UserWithProgrammeName[] getByProgrammeId(String query, String... stringParams) {
		ArrayList<UserWithProgrammeName> usersp = new ArrayList<>();
		try {
			PreparedStatement ps = DBConnexion.getPs(query);
			if (stringParams != null)
				for (int i = 0; i < stringParams.length; i++)
					ps.setString(i + 1, stringParams[i]);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while (rs.next())
				usersp.add(new UserWithProgrammeName(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnexion.close();
		UserWithProgrammeName[] ua = new UserWithProgrammeName[usersp.size()];
		return usersp.toArray(ua);
	}
}
