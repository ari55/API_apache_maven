package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.HttpBodyBeanInfoGeneral;
import entity.HttpBodySuiviEnPersonne;
import entity.InfoGenerale;
import entity.SuiviEnPersonne;
import manager.InfoGeneralApplicationManager;
import manager.SuiviEnPersonneManager;
import service.Serializer;


public class SuiviPersonneControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SuiviPersonneControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String httpRequest = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodySuiviEnPersonne body = Serializer.deserializeHttpBodyBeanSuiviEnPErsonne(httpRequest);
		SuiviEnPersonne suiviEnPersonne = new SuiviEnPersonne();
		boolean resultat = SuiviEnPersonneManager.createSuiviEnPersonne(suiviEnPersonne);
		System.out.println(resultat);
		
	}

}
