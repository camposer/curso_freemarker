package service;

import java.util.List;

import dao.ProductoDao;
import dao.ProductoDaoFactory;
import to.Producto;

public class ProductoServiceImpl implements ProductoService {
	private ProductoDao productoDao;

	public ProductoServiceImpl() {
		productoDao = ProductoDaoFactory.createProductoDao();
	}
	
	@Override
	public void agregarProducto(Producto p) {
		productoDao.agregar(p);
	}

	@Override
	public void modificarProducto(Producto p) {
		productoDao.modificar(p);
	}

	@Override
	public void eliminarProducto(Long id) {
		productoDao.eliminar(id);
	}

	@Override
	public Producto obtenerProducto(Long id) {
		return productoDao.obtener(id);
	}

	@Override
	public List<Producto> obtenerProductos() {
		return productoDao.obtenerTodos();
	}

}
