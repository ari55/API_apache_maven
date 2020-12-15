package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SuiviTelephonique;
import manager.SuiviTelephoniqueManager;


public class SuiviTelephoniqueControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SuiviTelephoniqueControler() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		SuiviTelephonique suivi = new SuiviTelephonique();
		SuiviTelephoniqueManager.createSuiviTelephonique(suivi);
	}

}
