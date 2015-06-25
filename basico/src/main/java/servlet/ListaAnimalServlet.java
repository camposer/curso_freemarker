package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AnimalService;
import service.AnimalServiceFactory;

@WebServlet("/animales")
public class ListaAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalService animalService = 
				AnimalServiceFactory.createAnimalService();
		request.setAttribute("animales", animalService.obtenerAnimales());
		
		getServletContext()
			.getRequestDispatcher("/WEB-INF/ftl/animales.ftl")
			.forward(request, response);
	}

}
