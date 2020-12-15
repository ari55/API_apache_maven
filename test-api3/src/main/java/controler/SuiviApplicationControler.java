package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.HttpBodyBeanSuivieApplication;
import entity.SuiviApplication;
import manager.InfoSpecifiqueManager;
import manager.SuiviApplicationManager;
import service.Serializer;

/**
 * Servlet implementation class SuiviApplicationControler
 */
public class SuiviApplicationControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuiviApplicationControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idSuiviApp = request.getParameter("idSuiviApp");
		int id = Integer.parseInt(idSuiviApp);
		if (idSuiviApp != null) {
			response.getWriter().append(Serializer.serialize(SuiviApplicationManager.getInfoById(id)));
		 System.out.println(Serializer.serialize(SuiviApplicationManager.getInfoById(id)));

		}
	
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String httpRequest = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodyBeanSuivieApplication body = Serializer.deserializeHttpBodyBeanSuivieApplication(httpRequest);

		if (body.dateSuiviTelephone != null && body.dateSuiviEnPersonne != null && body.dateRelanceInternet != null) {
			SuiviApplication suivieToAdd = new SuiviApplication(Date.valueOf(body.dateSuiviTelephone),
					Date.valueOf(body.dateSuiviEnPersonne), Date.valueOf(body.dateRelanceInternet));
			SuiviApplicationManager.createSuiVieApplication(suivieToAdd);
			response.getWriter().append(" reussie !");
		} else {
			response.getWriter().append("Echec !");
		}
	}

}
