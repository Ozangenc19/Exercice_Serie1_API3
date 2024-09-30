package be.condorcet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/DataReceiver")
public class DataReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DataReceiver() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String nom = request.getParameter("lastname");
        String prenom = request.getParameter("firstname");
        String description = request.getParameter("description");

       
        response.setContentType("text/html");

       
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Données reçues</h2>");
        out.println("<p><strong>Nom :</strong> " + nom + "</p>");
        out.println("<p><strong>Prénom :</strong> " + prenom + "</p>");
        out.println("<p><strong>Description :</strong> " + description + "</p>");
        out.println("</body></html>");
	}

}
