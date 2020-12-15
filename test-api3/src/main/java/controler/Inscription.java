package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.HttpBodyBeanUser;
import entity.User;
import manager.UserManager;
import service.Serializer;

/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Methode non autorisee ! ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String httpRequest = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodyBeanUser body = Serializer.deserializeHttpBodyBeanUser(httpRequest);

		if (body.prenom != null && body.nom != null && body.email != null && body.dateNaissance != null
				&& body.pwd != null && body.idProgramme != null && body.telephone != null) {
			
			User userToAdd = new User(Date.valueOf(body.dateNaissance), body.prenom, body.nom, body.telephone,
					body.idProgramme, body.email, body.pwd);
			
			if (UserManager.verifierSiEmailExiste(body.email)) {
				response.getWriter().append("Email deja utilise  !!!");
			}else {
				if (UserManager.addUser(userToAdd)) {
					response.getWriter().append("Inscription reussie !");
					response.addHeader("Access-Control-Allow-Origin", "*");
					response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
					response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
				}
			}

			/*if (UserManager.addUser(userToAdd)) {
				response.getWriter().append("Inscription reussie !");
				response.addHeader("Access-Control-Allow-Origin", "*");
				response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
				response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
			}*/

		} else {
			response.getWriter().append("Il manque des informations");
		}
	}

}
