package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ProgrammeManager;
import manager.UserManager;
import manager.UserWithProgrammeNameManager;
import service.Serializer;

public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String output = new String();
		//output = Serializer.serialize(UserManager.getAll());

		String idProgramme = request.getParameter("idProgramme");
		String idStatut = request.getParameter("idStatut");
		if (idStatut != null) {
			response.getWriter().append(Serializer.serialize(UserWithProgrammeNameManager.getByIdStatut(idStatut)));
		}else if (idProgramme != null) {
			response.getWriter().append(Serializer.serialize(UserManager.getByIdProgramme(idProgramme)));
		}
		else {
			output = Serializer.serialize(UserManager.getAll());
			 response.getWriter().append(output);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String output = new String();
		String user = request.getParameter("user");
		String passw = request.getParameter("password");

		System.out.println("salut");
		if (request.getParameter("user") != null && request.getParameter("password") != null) // signup
		//output = Boolean.toString(UserManager.create(request.getParameter("user"), request.getParameter("password")));
		response.getWriter().append(output);
		System.out.println(user);
		System.out.println(passw);
	}

}
