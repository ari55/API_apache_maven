package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.DocumentAchemine;
import entity.HttpBodyBeanDocAchemine;
import entity.HttpBodyBeanInfoGeneral;
import entity.InfoGenerale;
import manager.DocumentAchemineManager;
import manager.InfoGeneralApplicationManager;
import service.Serializer;

public class DocumentAchemineControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DocumentAchemineControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String httpRequest = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodyBeanDocAchemine body = Serializer.deserializeHttpBodyBeanDocAchemine(httpRequest);

//			DocumentAchemine infoGerneToAdd = new DocumentAchemine(false,false,false,false,false);
		// DocumentAchemineManager.creerDocAcheminer(infoGerneToAdd);
		response.getWriter().append(" reussie !");
	}
}
