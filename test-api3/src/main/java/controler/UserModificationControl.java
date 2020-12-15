package controler;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.HttpBodyBeanUser;
import manager.UserManager;
import service.Serializer;

public class UserModificationControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserModificationControl() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Cette methode n'est pas autorise ! ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodyBeanUser body = Serializer.deserializeHttpBodyBeanUser(json);
		
		if (body.statut != null && body.userId != null) {
			if (UserManager.updateStatutUser(body.statut, body.userId)) {
				response.getWriter().append("Statut modifie avec succes");
			}else {
				response.getWriter().append("Echec !");
			}
		}else {
			response.getWriter().append("Il manque des informations");
		}
	}
}