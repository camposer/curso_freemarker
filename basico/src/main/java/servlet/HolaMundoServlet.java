package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import to.Animal;

@WebServlet("/hola-mundo")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Preparando data-model (uso temporal)
		request.setAttribute("nombre", "Juan");
		/*
		// ESTO ES UNA CHAPUZA MUY FEA!
		request.setAttribute("animales", new Object[] {
			new Hashtable<String, String>() {{ 
				put("nombre", "elefante");
				put("tipo", "GRANDE");
			}},
			new Hashtable<String, String>() {{ 
				put("nombre", "jirafa");
				put("tipo", "MEDIO");
			}},
			new Hashtable<String, String>() {{ 
				put("nombre", "perro");
				put("tipo", "PEQUEÑO");
			}}
		});
		*/
		List<Animal> animales = new ArrayList<Animal>();
		animales.add(new Animal("elefante", Animal.Tipo.GRANDE));
		animales.add(new Animal("jirafa", Animal.Tipo.MEDIO));
		animales.add(new Animal("perro", Animal.Tipo.PEQUENIO));
		request.setAttribute("animales", animales);
		
		// Redireccionando al template
		getServletContext()
			.getRequestDispatcher("/WEB-INF/ftl/holaMundo.ftl")
			.forward(request, response);
	}

}
