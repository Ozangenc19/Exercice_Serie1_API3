package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/PokemonReceiver")
public class PokemonReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PokemonReceiver() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        String[] selectedPokemons = request.getParameterValues("pokemon");

        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       
        out.println("<html><body>");
        out.println("<h2>Vous avez choisi :</h2>");

        if (selectedPokemons != null && selectedPokemons.length > 0) {
            out.println("<ul>");
            for (String pokemon : selectedPokemons) {
                out.println("<li>" + pokemon + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>Aucun Pokémon sélectionné.</p>");
        }

        out.println("<p>Merci pour votre choix !</p>");
        out.println("<p>Amusez-vous bien avec vos Pokémon !</p>");
        out.println("</body></html>");

       
        out.close();
    }

}
