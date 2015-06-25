package servlet.producto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductoService;
import service.ProductoServiceFactory;
import to.Producto;

@WebServlet("/producto/mostrar")
public class MostrarServlet extends HttpServlet {
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
			request.setAttribute("productos", productoService.obtenerProductos());
			request.setAttribute("producto", productoService.obtenerProducto(id));
			getServletContext()
				.getRequestDispatcher("/WEB-INF/ftl/producto/inicio.ftl")
				.forward(request, response);
		} else {
			// TODO Retornar la página 404
			response.setStatus(404);
		}
	}

}
