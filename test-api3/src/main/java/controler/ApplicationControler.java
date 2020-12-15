package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.HttoBodyBeanInfoSpecifique;
import entity.HttpBodyBeanExtrasPourApp;
import entity.HttpBodyBeanInfoGeneral;
import entity.HttpBodyBeanSuivieApplication;
import entity.HttpBodyBeanUser;
import entity.HttpBodySuiviEnPersonne;
import entity.InfoGenerale;
import entity.InfoSpecifique;
import entity.SuiviApplication;
import entity.SuiviEnPersonne;
import entity.SuiviTelephonique;
import manager.ApplicationManager;
import manager.DocumentAchemineManager;
import manager.InfoGeneralApplicationManager;
import manager.InfoSpecifiqueManager;
import manager.SuiviApplicationManager;
import manager.SuiviEnPersonneManager;
import manager.SuiviTelephoniqueManager;
import service.Serializer;

public class ApplicationControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplicationControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(SuiviEnPersonneManager.getLastSuiviEnPersonneId());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ORDRE POIUR CONSTRUCTION APPLICATION
		// 1-INFOGENEALE_ID
		/*JSONObject obj = new JSONObject(jsonString);
		 String id = obj.getString("id");
		 String error = obj.getString("error");
		 JSONObject result = obj.getJSONObject("result");
		 int nPeople = result.getInt("nPeople");
		 JSONArray people = result.getJSONArray("people");
		 for(int i = 0 ; i < people.length() ; i++){
		   JSONObject p = (JSONObject)people.get(i);
		   String namePeople = p.getString("namePeople");
		   ...
		 }*/
		String httpRequest = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodyBeanInfoGeneral body = Serializer.deserializeHttpBodyBeanInfoGeneral(httpRequest);

		if (body.date != null && body.nomEntreprise != null && body.nomContactDeEntreprise != null
				&& body.telephone != null && body.email != null && body.linkedin != null && body.address != null) {
			InfoGenerale infoGerneToAdd = new InfoGenerale(Date.valueOf(body.date), body.nomEntreprise,
					body.nomContactDeEntreprise, body.telephone, body.email, body.linkedin, body.address);
			InfoGeneralApplicationManager.createInfoGenerale(infoGerneToAdd);
			response.getWriter().append(" reussie !");
		} else {
			response.getWriter().append("Echec !");
		}
		long infoGeneralId = InfoGeneralApplicationManager.getLastInfoGeneral();
//----------------------------------------------------------------------------------------------------
		// 2-INFOSPECIFIQUE_ID
		HttoBodyBeanInfoSpecifique body2 = Serializer.deserializeHttpBodyBeanSpecifique(httpRequest);

		if (body2.titreDuPoste != null && body2.descriptionPoste != null && body2.languageUtilise != null
				&& body2.numeroReference != null && body2.remuneration != null && body2.finAffichage != null
				&& body2.sourcePoste != null && body2.matchPoste != null) {
			InfoSpecifique infoToAdd = new InfoSpecifique(body2.titreDuPoste, body2.descriptionPoste,
					body2.languageUtilise, body2.numeroReference, body2.remuneration, Date.valueOf(body2.finAffichage),
					body2.sourcePoste, body2.matchPoste);
			InfoSpecifiqueManager.createInfoSpecifique(infoToAdd);// .(infoToAdd);
			response.getWriter().append(" reussie !");
		} else {
			response.getWriter().append("Echec !");
		}
		long infoSpecifiqueId = InfoSpecifiqueManager.getLastInfoSpecifique();
		//----------------------------------------------------------------------------------------------
		// 3-DOC ACHEMINER
		//DocumentAchemineManager.creerDocAcheminer();
		long docAchemineId = DocumentAchemineManager.getLastInfoDocAchemine();
		// ---------------------------------------------------------------------------------------------
		// 4 SUIVIE TELEPHONIQUE_ID
		SuiviTelephonique suivi = new SuiviTelephonique();
		SuiviTelephoniqueManager.createSuiviTelephonique(suivi);
		long suiviTelId = SuiviTelephoniqueManager.getLastSuiviTelId();
		// --------------------------------------------------------------------------------------------------------------
		// 5 USERID
		HttpBodyBeanUser body3 = Serializer.deserializeHttpBodyBeanUser(httpRequest);
		long userId = body3.userId;
		HttpBodyBeanExtrasPourApp body4 = Serializer.deserializeHttpBodyExtraPourApp(httpRequest);
		// ---------------------------------------------------------------------------------------------------------
		// 6 COMMENTAIRE
		String commentaire = body4.commentaire;
		// ---------------------------------------------------------------------------------------------------------
		// 7 ETAT SUIVI
		boolean etatSuivi = body4.etatSuivi;
		// ---------------------------------------------------------------------------------------------------------
		// 8 SUIVI APPLICATION ID
		HttpBodyBeanSuivieApplication body5 = Serializer.deserializeHttpBodyBeanSuivieApplication(httpRequest);

		if (body5.dateSuiviTelephone != null && body5.dateSuiviEnPersonne != null
				&& body5.dateRelanceInternet != null) {
			SuiviApplication suivieToAdd = new SuiviApplication(Date.valueOf(body5.dateSuiviTelephone),
					Date.valueOf(body5.dateSuiviEnPersonne), Date.valueOf(body5.dateRelanceInternet));
			SuiviApplicationManager.createSuiVieApplication(suivieToAdd);
			response.getWriter().append(" reussie !");
		} else {
			response.getWriter().append("Echec !");
		}
		long suiviApp = SuiviApplicationManager.getLastSuiviApplicationId();
		// ---------------------------------------------------------------------------------------------------------
		// 9 SUIVI EN PERSONNE
		HttpBodySuiviEnPersonne body6 = Serializer.deserializeHttpBodyBeanSuiviEnPErsonne(httpRequest);
		SuiviEnPersonne suiviEnPersonne = new SuiviEnPersonne();
		boolean resultat = SuiviEnPersonneManager.createSuiviEnPersonne(suiviEnPersonne);
		System.out.println(resultat);
		long suiviEnPersonneId = SuiviEnPersonneManager.getLastSuiviEnPersonneId();
		//ApplicationEntite app = new ApplicationEntite(infoGeneralId, infoSpecifiqueId, docAchemineId, suiviTelId,
		//		userId, commentaire, etatSuivi, suiviApp, suiviEnPersonneId);
		//ApplicationManager.createApplication(app);
	}

}
