package service;

import java.util.List;

import to.Producto;

public interface ProductoService {
	void agregarProducto(Producto p);
	void modificarProducto(Producto p);
	void eliminarProducto(Long id);
	Producto obtenerProducto(Long id);
	List<Producto> obtenerProductos();
}
