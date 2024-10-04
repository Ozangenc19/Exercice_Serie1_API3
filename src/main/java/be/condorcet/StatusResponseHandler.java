package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/StatusResponseHandler")
public class StatusResponseHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StatusResponseHandler() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("identifiant");
		
		response.setContentType("text/html");
		
		
		if(id == null || id.isEmpty())
		{
			response.getWriter().write("<html><body><p>Code de statut : <b>400 Bad Request</b></p></body></html>");

			 response.getWriter().write("<html><body<p>Message : <b>Identifiant d'utilisateur requis.</b></p></body></html>");
			 return;
		}
		
		
		try {
			
			int id_user = Integer.parseInt(id);
			
			if (id_user > 0) {
				response.getWriter().write("<html><body><p>Code de statut : <b>200 OK</b></p></body></html>");
				response.getWriter().write("<html><body><p>Message : Identifiant valide : <b>" +  id_user + "</b></p></body></html>");
				
			}else if (id_user <= 0)
			{
	            response.getWriter().write("<html><body><p>Code de statut : <b>404 Not Found</b></p></body></html>");
                response.getWriter().write("<html><body><p>Message : <b>Identifiant d'utilisateur introuvable.</b></p></body></html>");

			}
			
		}catch(NumberFormatException e) {
            response.getWriter().write("<html><body><p>Code de statut : <b>404 Not Found</b></p></body></html>");

            response.getWriter().write("<html><body><p>Message : <b>Identifiant d'utilisateur introuvable.</b></p></body></html>");

		}
		
	
	}

}
