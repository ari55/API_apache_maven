package manager;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import controler.Resources;
import entity.User;
import service.DBConnexion;
import service.Serializer;

public class UserManager {
	static private final String TABLE_NAME = "users";
	static private final String OP_SELECT = Resources.OP_SELECT;
	static private final String OP_EQUALS = Resources.OP_EQUALS;
	static private final String OP_REPLACE = Resources.OP_REPLACE;
	static private final String CLAUSE_FROM = Resources.CLAUSE_FROM;
	static private final String CLAUSE_WHERE = Resources.CLAUSE_WHERE;
	static private final String COL_ALL = Resources.COL_ALL;
	static private final String END_QUERY = Resources.END_QUERY;
	static private final String QUERY_GET_ALL_PRIVILEGE = "select * from users";
	static private final String QUERY_GET_ALL = "select * from users where id_privilege = 0";
	static private final String QUERY_GET_BY_ID_PROGRAMME = "select * from users where id_privilege = 0 and CAST(programme_id as varchar) = ?";
	static private final String QUERY_GET_USET_BY_ID = "select * from users WHERE CAST( id as varchar) = ?";
	static private final String INSERT_NEW_USER = "insert into users(date_naissance, prenom, nom, telephone, programme_id, email, password) values (?, ?, ?, ?, ?, ?, ?)";
	static private final String UPDATE_STATUS_USER = "update users set status = ? where id = ? ";
	static private final String QUERY_GET_ALL_EMAIL = "select email from users ";

	static public final User[] getAll() {
		return get(QUERY_GET_ALL);
	}
	static public final User[] getAllPrivilege() {
		return get(QUERY_GET_ALL_PRIVILEGE);
	}

	static private final String QUERY_GET_BY_USERNAME_AND_PWD = OP_SELECT + " " + COL_ALL + " " + CLAUSE_FROM + " "
			+ TABLE_NAME + " " + CLAUSE_WHERE + " " + "email" + OP_EQUALS + OP_REPLACE + " " + "and" + " " + "password"
			+ OP_EQUALS + OP_REPLACE + END_QUERY;

	static public final User authenticate(String userName, String pwd) {
		User[] ca = get(QUERY_GET_BY_USERNAME_AND_PWD, userName, pwd);
		// System.out.println(ca);
		if (ca.length == 1)
			return ca[0];
		else
			return null;
	}

	static public User[] getUserById(String id) {

		return get(QUERY_GET_USET_BY_ID, id);
	}

	static public User[] getByIdProgramme(String id) {
		return get(QUERY_GET_BY_ID_PROGRAMME, id);
	}

	static private final User[] get(String query, String... stringParams) {
		ArrayList<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = DBConnexion.getPs(query);
			if (stringParams != null)
				for (int i = 0; i < stringParams.length; i++)
					ps.setString(i + 1, stringParams[i]);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			// rs.getFetchSize();
			while (rs.next())
				users.add(new User(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getBoolean(11)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnexion.close();
		User[] ua = new User[users.size()];
		return users.toArray(ua);
	}

	static private final int update(String query, String... stringParams) {
		int r = 0;
		try {
			PreparedStatement ps = DBConnexion.getPs(query);
			if (stringParams != null)
				for (int i = 0; i < stringParams.length; i++)
					// ps.setObject(i + 1, stringParams[i]);
					ps.setString(i + 1, stringParams[i]);
			r = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnexion.close();

		return r;
	}

	static public final boolean addUser(User userToAdd) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(INSERT_NEW_USER);
			preparedStatement.setDate(1, userToAdd.getDate_naissance());
			preparedStatement.setString(2, userToAdd.getPrenom());
			preparedStatement.setString(3, userToAdd.getNom());
			preparedStatement.setLong(4, userToAdd.getTelephone());
			preparedStatement.setInt(5, userToAdd.getProgramme_id());
			preparedStatement.setString(6, userToAdd.getEmail());
			preparedStatement.setString(7, userToAdd.getPassword());
			nbModDansBd = preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBConnexion.close();
		return nbModDansBd > 0;
	}
	
	///
	static public boolean updateStatutUser(boolean statut, int idUser) {
		int nbModDansBd = 0;
		try {
			PreparedStatement preparedStatement = DBConnexion.getPs(UPDATE_STATUS_USER);
			preparedStatement.setBoolean(1, statut);
			preparedStatement.setInt(2, idUser);
			nbModDansBd = preparedStatement.executeUpdate();
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnexion.close();
		}
		return nbModDansBd > 0;
	}

	static public ArrayList<String> getEmailUser(){
		ArrayList<String> listEmail = null;
		PreparedStatement preparedStatement = DBConnexion.getPs(QUERY_GET_ALL_EMAIL);
		try {
			ResultSet result = preparedStatement.executeQuery();
            if (result.isBeforeFirst()) {
                listEmail = new ArrayList<>();
                while (result.next()) {
                    listEmail.add(result.getString("email"));
                }
            }
		}catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		DBConnexion.close();
        return listEmail;		
	}
	
	public static boolean verifierSiEmailExiste(String email) {
        boolean retour = false;
        ArrayList<String> listEmailBd = getEmailUser();

        if (listEmailBd != null) {
            for (String e : listEmailBd) {
                if (e.equals(email)) {
                    retour = true;
                }
            }
        }
        return retour;
    }
}