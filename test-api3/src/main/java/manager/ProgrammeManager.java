package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controler.Resources;
import entity.Programme;
import service.DBConnexion;

public class ProgrammeManager {
	static private final String TABLE_NAME = "programme";

	static private final String OP_SELECT = Resources.OP_SELECT;
	static private final String OP_EQUALS = Resources.OP_EQUALS;
	static private final String OP_REPLACE = Resources.OP_REPLACE;

	static private final String CLAUSE_FROM = Resources.CLAUSE_FROM;
	static private final String CLAUSE_WHERE = Resources.CLAUSE_WHERE;
	static private final String COL_NAME = Resources.COL_NAME;

	static private final String COL_ALL = Resources.COL_ALL;
	static private final String COL_ID = Resources.COL_ID;
	static private final String END_QUERY = Resources.END_QUERY;
	static public final String COL_ID_CATEGORY = Resources.COL_ID_CATEGORY;
	static private final String QUERY_GET_BY_CATEGORY = OP_SELECT + " " + COL_ALL + " " + CLAUSE_FROM + " " + TABLE_NAME
			+ " " + CLAUSE_WHERE + " " + COL_ID_CATEGORY + " " + OP_EQUALS + " " + OP_REPLACE + END_QUERY;
	static private final String QUERY_GET_ALL = OP_SELECT + " " + COL_ALL + " " + CLAUSE_FROM + " " + TABLE_NAME
			+ END_QUERY;

	static public Programme[] getAll() {
		return get(QUERY_GET_ALL);
	}

	static private final Programme[] get(String query, String... stringParams) {
		ArrayList<Programme> programme = new ArrayList<Programme>();
		try {
			PreparedStatement ps = DBConnexion.getPs(query);
			if (stringParams != null)
				for (int i = 0; i < stringParams.length; i++)
					ps.setString(i + 1, stringParams[i]);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while (rs.next())
				programme.add(new Programme(rs.getInt(1), rs.getString(2)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnexion.close();
		Programme[] pa = new Programme[programme.size()];
		return programme.toArray(pa);
	}

}
