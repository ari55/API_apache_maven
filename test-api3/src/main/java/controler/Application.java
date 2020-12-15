package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.DocumentAchemine;
import entity.HttoBodyBeanInfoSpecifique;
import entity.HttpBodyBeanApplication;
import entity.HttpBodyBeanDocAchemine;
import entity.HttpBodyBeanInfoGeneral;
import entity.HttpBodyBeanSuivieApplication;
import entity.HttpBodyBeanSuivieTelephonique;
import entity.HttpBodyBeanUser;
import entity.HttpBodySuiviEnPersonne;
import entity.InfoGenerale;
import manager.ApplicationManager;
import manager.DocumentAchemineManager;
import manager.InfoApplicationManager;
import manager.InfoGeneralApplicationManager;
import manager.InfoGeneraleManager;
import manager.InfoSpecifiqueManager;
import manager.SuiviApplicationManager;
import manager.SuiviEnPersonneManager;
import manager.SuiviTelephoniqueManager;
import manager.UserManager;
import service.Serializer;

/**
 * Servlet implementation class Application
 */
public class Application extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Application() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idAppToDelete = request.getParameter("idAppToDelete");
		String idUser = request.getParameter("idUser");
		String filter = request.getParameter("filter");
		String idApp = request.getParameter("idApp");
		//int idApp2 = Integer.parseInt(idApp);
		if (idUser != null) {
			response.getWriter().append(Serializer.serialize(InfoApplicationManager.getById(idUser)));
		}else if (idAppToDelete != null) {
			response.getWriter().append(Serializer.serialize(InfoApplicationManager.delete(idAppToDelete)));
		}
		
		else if (idApp != null) {
			response.getWriter().append(Serializer.serialize(InfoApplicationManager.getInfoById(idApp)));
		}
		else if (filter != null) {

			if (filter == "date") {
				response.getWriter().append(Serializer.serialize(InfoApplicationManager.filterByDate()));
			}
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodyBeanApplication body = Serializer.deserializeHttpBodyApplication(json);
		
		if (body.infoGenerale != null && body.infoSpecifique != null && body.documentAchemine != null  && body.suiviApplication != null && body.suiviEnPersonne != null && body.suiviTelephonique != null && body.id_user != null) {
				
			if(! (InfoGeneralApplicationManager.createInfoGenerale(body.infoGenerale))){
				resp.getWriter().append("Echec d'ajout de l'info generale");
			}
			if( !(InfoSpecifiqueManager.createInfoSpecifique(body.infoSpecifique))) {
				resp.getWriter().append("Echec : InfoSpecifique");
			}
			
			if (!(DocumentAchemineManager.creerDocAcheminer(body.documentAchemine))) {
				resp.getWriter().append("Echec : Document Achemine");
			}
			
			if (! (SuiviApplicationManager.createSuiVieApplication(body.suiviApplication))) {
				resp.getWriter().append("Echec : Suivi Application");
			}
			if (! (SuiviEnPersonneManager.createSuiviEnPersonne(body.suiviEnPersonne))) {
				resp.getWriter().append("Echec : Suivi en personne");
			}
			
			if (!(SuiviTelephoniqueManager.createSuiviTelephonique(body.suiviTelephonique))) {
				resp.getWriter().append("Echec : Suivie telephonique");
			}
			
			int lastIdInfoGenerale = InfoGeneralApplicationManager.getLastInfoGeneral();
			int lastInfoSpecifique = InfoSpecifiqueManager.getLastInfoSpecifique();
			int lastDocAchemine = DocumentAchemineManager.getLastInfoDocAchemine();
			int lastSuiviApp = SuiviApplicationManager.getLastSuiviApplicationId();
			int lastSuiviTel = SuiviTelephoniqueManager.getLastSuiviTelId();
			int lastSuiviEnPerson = SuiviEnPersonneManager.getLastSuiviEnPersonneId();
			int id_user = body.id_user;
			
			entity.Application app = new entity.Application(lastIdInfoGenerale, lastInfoSpecifique, lastDocAchemine, lastSuiviApp, lastSuiviEnPerson,lastSuiviTel, id_user, body.commentaire, body.etat_suivie);
			ApplicationManager.createApplication(app);
		
			
		}else {
			resp.getWriter().write("Il manque des informations");
		}
		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doDelete(req, resp);
		String idAppToDelete = req.getParameter("idAppToDelete");
		String idUser = req.getParameter("idUser");
		
		if (idAppToDelete != null && idUser != null) {
			//1- Recuperer les infos de l'application
			entity.Application app = ApplicationManager.getApplicationById(Integer.parseInt(idAppToDelete));
			
			//-2 recuperer les id des tables etrangeres
			int idInfoGenerale = app.getInfo_generale_id();
			int idInfoSpecifique = app.getInfo_specifique_id();
			int idDocs = app.getDoc_achemine_id();
			int idSuivieApp = app.getSuivie_application_id();
			int idSuiviePers = app.getSuivie_en_personne_id();
			int idSuivieTel = app.getSuivie_telephonique_id();
			
			//3-Supprimer une a une les tables
			InfoGeneralApplicationManager.deleteInfoGenerale(idInfoGenerale);
			InfoSpecifiqueManager.deleteInfoSpecifique(idInfoSpecifique);
			DocumentAchemineManager.deleteDocumentAchemine(idDocs);
			SuiviApplicationManager.deleteSuiviApp(idSuivieApp);
			SuiviEnPersonneManager.deleteSuiviePersonne(idSuiviePers);
			SuiviTelephoniqueManager.deleteSuivieTel(idSuivieTel);
			
			//4-Supprimer l'application
			if (InfoApplicationManager.delete(idAppToDelete)) {
				//resp.getWriter().append("L'applicaion a ete supprime avec succes");
				resp.getWriter().append(Serializer.serialize(InfoApplicationManager.getById(idUser)));
			}else {
				resp.getWriter().append("Echec !");
			}
		}
	}
}
