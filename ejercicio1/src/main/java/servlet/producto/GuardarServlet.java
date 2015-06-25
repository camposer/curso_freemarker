package servlet.producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductoService;
import service.ProductoServiceFactory;
import to.Producto;

@WebServlet("/producto/guardar")
public class GuardarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoService productoService = 
				ProductoServiceFactory.createProductoService();
		List<String> errores = new ArrayList<String>();
		Producto producto = new Producto();
		
		producto.setNombre(request.getParameter("nombre"));
		try {
			producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			producto.setId(Long.parseLong(request.getParameter("productoId")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (producto.getNombre() == null || producto.getNombre().trim().length() < 3)
			errores.add("Nombre inválido");
		if (producto.getPrecio() == null || producto.getPrecio() <= 0)
			errores.add("Precio inválido");
		
		if (errores.size() == 0) {
			try {
				if (producto.getId() != null)
					productoService.modificarProducto(producto);
				else
					productoService.agregarProducto(producto);
			} catch (Exception e) {
				e.printStackTrace();
				errores.add("Error al guardar el producto");
			}
		}

		if (errores.size() > 0) { // Hubo un error
			request.setAttribute("errores", errores);
			request.setAttribute("productos", productoService.obtenerProductos());
			request.setAttribute("producto", producto);
			getServletContext()
				.getRequestDispatcher("/WEB-INF/ftl/producto/inicio.ftl")
				.forward(request, response);
		} else { // Todo salió bien
			response.sendRedirect("/ejercicio1/producto/inicio");
		}

	}

}
