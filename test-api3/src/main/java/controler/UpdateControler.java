package controler;

import java.io.IOException;
import java.sql.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.DocumentAchemine;
import entity.HttpBodyBeanApplication;
import entity.InfoGenerale;
import entity.InfoSpecifique;
import entity.SuiviApplication;
import entity.SuiviEnPersonne;
import entity.SuiviTelephonique;
import manager.DocumentAchemineManager;
import manager.InfoGeneralApplicationManager;
import manager.InfoSpecifiqueManager;
import manager.SuiviApplicationManager;
import manager.SuiviEnPersonneManager;
import manager.SuiviTelephoniqueManager;
import service.Serializer;

/**
 * Servlet implementation class UpdateControler
 */
public class UpdateControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		///
		String idDocs = request.getParameter("idDocs");
		String idInfoGenerale = request.getParameter("idInfoGenerale");
		String idInfoSpecifique = request.getParameter("idInfoSpecifique");
		String idSuiviApplication = request.getParameter("idSuiviApplication");
		String idSuiviTelephonique = request.getParameter("idSuiviTelephonique");
		String idSuiviEnPersonne = request.getParameter("idSuiviEnPersonne");

		String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		HttpBodyBeanApplication body = Serializer.deserializeHttpBodyApplication(json);

		if (idDocs != null) {
			DocumentAchemine docs = new DocumentAchemine(body.cv, body.letre_motivation, body.releve_note, body.autres,
					body.lesreferences);
			if (DocumentAchemineManager.updateDocAchemine(docs, body.id_doc_achemine)) {
				response.getWriter().append("Modification reussie");
			} else {
				response.getWriter().append("Echec de modification");
			}
		} else if (idInfoGenerale != null) {
			InfoGenerale ig = new InfoGenerale(Date.valueOf(body.date_application), body.nom_de_lentreprise,
					body.nom_contact_de_lentreprise, body.telephone, body.email, body.linkedin, body.addresse);
			if (InfoGeneralApplicationManager.updateInfoGenerale(ig, body.id_info_generale_application)) {
				response.getWriter().append("Modification reussie");
			} else {
				response.getWriter().append("Echec de modification");
			}
		} else if (idInfoSpecifique != null) {
			InfoSpecifique isp = new InfoSpecifique(body.titre_du_poste, body.description_poste, body.language_utilise,
					body.numero_reference, body.remuneration, Date.valueOf(body.date_fin_affichage), body.source_poste,
					body.match_poste);
			if (InfoSpecifiqueManager.updateInfoSpecifique(isp, body.id_info_specifique)) {
				response.getWriter().append("Modification reussie");
			} else {
				response.getWriter().append("Echec de modification");
			}
		} else if (idSuiviApplication != null) {
			SuiviApplication sa = new SuiviApplication(body.id_suivie_application,
					Date.valueOf(body.date_suivie_telephonique), Date.valueOf(body.date_suivie_en_personne),
					Date.valueOf(body.relance_interet));
			if (SuiviApplicationManager.updateSuivieApplication(sa, Integer.parseInt(idSuiviApplication))) {
				response.getWriter().append("Modification reussie");
			} else {
				response.getWriter().append("Echec de modification");
			}
		} else if (idSuiviTelephonique != null) {
			SuiviTelephonique st = new SuiviTelephonique(body.id_suivie_telephonique, Date.valueOf(body.date_entretien),
					Date.valueOf(body.courriel_remerciement_st), Date.valueOf(body.invitation_linkedin_st),
					Date.valueOf(body.courriel_ouappel_suivie_st));
			if (SuiviTelephoniqueManager.updateSuiviTelephonique(st, Integer.parseInt(idSuiviTelephonique))) {
				response.getWriter().append("Modification reussie");
			} else {
				response.getWriter().append("Echec de modification");
			}
		} else if (idSuiviEnPersonne != null) {
			SuiviEnPersonne sp = new SuiviEnPersonne(body.id_suivie_en_personne, Date.valueOf(body.date_entrevue),
					Date.valueOf(body.courriel_remerciement), Date.valueOf(body.invitation_linkedin),
					Date.valueOf(body.courriel_ouappel_suivie));
			if (SuiviEnPersonneManager.updateSuiviEnPersonne(sp, Integer.parseInt(idSuiviEnPersonne))) {
				response.getWriter().append("Modification reussie");
			} else {
				response.getWriter().append("Echec de modification");
			}
		}

	}

}
