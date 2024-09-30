package be.condorcet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/QueryStringReceiver")
public class QueryStringReceiver extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des paramètres
        String nom = request.getParameter("name");
        String prenom = request.getParameter("firstname");
        String age = request.getParameter("age");

        // Préparation de la réponse
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Affichage du message
        out.println("<html><body>");
        out.println("<h1>Bonjour " + prenom + " " + nom + ", vous avez " + age + " ans.</h1>");
        out.println("</body></html>");
    }
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}