package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.HttpBodyBeanInfoGeneral;
import entity.HttpBodyBeanUser;
import entity.InfoGenerale;
import entity.User;
import manager.InfoGeneralApplicationManager;
import manager.InfoGeneraleManager;
import manager.UserWithProgrammeNameManager;
import service.Serializer;

public class InfoGeneraleAppControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InfoGeneraleAppControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int id = Integer.parseInt(userId);
		if (userId != null) {
			response.getWriter().append(Serializer.serialize(InfoGeneralApplicationManager.getInfoById(id)));
			// System.out.println(Serializer.serialize(InfoGeneralApplicationManager.getInfoById(id)));

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create info general
		String httpRequest = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodyBeanInfoGeneral body = Serializer.deserializeHttpBodyBeanInfoGeneral(httpRequest);

		if (body.date != null && body.nomEntreprise != null && body.nomContactDeEntreprise != null && body.telephone != null && body.email != null && body.linkedin != null && body.address != null) {
			InfoGenerale infoGerneToAdd = new InfoGenerale(Date.valueOf(body.date), body.nomEntreprise,
					body.nomContactDeEntreprise, body.telephone, body.email, body.linkedin, body.address);
			InfoGeneralApplicationManager.createInfoGenerale(infoGerneToAdd);
			response.getWriter().append(" reussie !");
		} else {
			response.getWriter().append("Echec !");
		}
		// response.getWriter().append(Serializer.serialize(InfoGeneral;ApplicationManager.createInfoGenerale(info)));
	}

}
