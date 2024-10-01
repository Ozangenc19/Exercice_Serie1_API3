package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ResponseHandler")
public class ResponseHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ResponseHandler() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("username");
	    String reponse = request.getParameter("responseType");
	       
	       
	       
	       String message = "";
	       
	      if("bienvenue".equals(reponse)) {
	    	  message = "Bienvenue " + nom + "! Nous somme ravis de te revoir.";
	      }else if ("encouragement".equals(reponse)) {
	    	  message = "Continue comme ca, " + nom + "! Vous êtes sur la bonne voie";
	      }else if ("remerciement".equals(reponse)) {
	    	  message = "Merci, " + nom + ", d'avoir utilisé notre service";
	      }

	        
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        
	        out.println("<html><body>");
	        out.println("<h1>Bonjour " + message + "</h1>");
	        out.println("</body></html>");
	       
	        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
       
	}

}
