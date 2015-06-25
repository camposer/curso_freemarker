package servlet.producto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductoService;
import service.ProductoServiceFactory;

@WebServlet("/producto/eliminar")
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoService productoService = 
				ProductoServiceFactory.createProductoService();
		Long id = null;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if (id != null) {
			productoService.eliminarProducto(id);
			response.sendRedirect("/ejercicio1/producto/inicio");
		} else {
			response.setStatus(404);
		}
	}

}
