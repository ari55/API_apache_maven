package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.HttoBodyBeanInfoSpecifique;
import entity.HttpBodyBeanInfoGeneral;
import entity.InfoGenerale;
import entity.InfoSpecifique;
import manager.InfoGeneralApplicationManager;
import manager.InfoSpecifiqueManager;
import service.Serializer;

public class InfoSpecifiqueControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InfoSpecifiqueControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String httpRequest = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttoBodyBeanInfoSpecifique body = Serializer.deserializeHttpBodyBeanSpecifique(httpRequest);

		if (body.titreDuPoste != null && body.descriptionPoste != null && body.languageUtilise != null && body.numeroReference != null && body.remuneration != null && body.finAffichage != null && body.sourcePoste != null && body.matchPoste !=null) {
			InfoSpecifique infoToAdd = new InfoSpecifique(body.titreDuPoste, body.descriptionPoste,body.languageUtilise, body.numeroReference, body.remuneration, Date.valueOf(body.finAffichage),body.sourcePoste,body.matchPoste);
			InfoSpecifiqueManager.createInfoSpecifique(infoToAdd);
			response.getWriter().append("reussie !");
		} else {
			response.getWriter().append("Echec !");
		}
		
	}

}
