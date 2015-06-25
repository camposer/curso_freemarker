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

/**
 * Servlet implementation class Lista
 */
@WebServlet("/producto/inicio")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoService productoService = 
				ProductoServiceFactory.createProductoService();
		request.setAttribute("productos", productoService.obtenerProductos());
		request.setAttribute("producto", new Producto());
		
		getServletContext()
			.getRequestDispatcher("/WEB-INF/ftl/producto/inicio.ftl")
			.forward(request, response);
	}

}
