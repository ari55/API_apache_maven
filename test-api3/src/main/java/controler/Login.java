package controler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwts;
import manager.UserManager;
import service.Serializer;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	String uriInfo = "https://test-api3.herokuapp.com/";
	private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
	private String secret = "ThisIsASecret";
	private String tokenPrefix = "Bearer";
	private String headerString = "Authorization";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request,
		// response);

	}

	private String issueToken(String login) {
		/// Key key = keyGenerator.generateKey();
		String jwtToken = Jwts.builder().setSubject(login).setIssuer(uriInfo).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				// .signWith(SignatureAlgorithm.HS512, secret)
				.compact();
		return jwtToken;
	}
	// response.addHeader(headerString, tokenPrefix + " " + JWT);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String output = new String();
		String prenom = request.getParameter("prenom");
		String password = request.getParameter("password");
		if (prenom != null) {
			if (request.getParameter("password") != null) {
				output = Serializer.serialize(UserManager.authenticate(prenom, password));
				System.out.println("oui");
			}
			System.out.println("end");

		}
		if (output != null)
			System.out.println("oui");
		String token = issueToken(prenom);
		// RandomString r = new RandomString();
		System.out.println(token);
		  response.addHeader("Access-Control-Allow-Origin", "*");
		  response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		  response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		  response.setHeader("Access-Control-Expose-Headers", "Authorization");
		response.addHeader(headerString, token);
		response.getWriter().append(output);
	}
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
	        response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
	        if ("OPTIONS".equals(request.getMethod())) {
	            response.setStatus(HttpServletResponse.SC_OK);
	        } else { 
	            filterChain.doFilter(request, response);
	        }
	    }
}
