package dao;

import java.util.List;

import to.Producto;

public interface ProductoDao {
	void agregar(Producto p);
	void modificar(Producto p);
	void eliminar(Long id);
	List<Producto> obtenerTodos();
	Producto obtener(Long id);
}
