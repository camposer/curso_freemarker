package dao;

import java.util.ArrayList;
import java.util.List;

import to.Producto;

public class ProductoDaoImpl implements ProductoDao {
	private List<Producto> productos;
	private long contador = 1L;
	
	public ProductoDaoImpl() {
		productos = new ArrayList<Producto>();
		init();
	}
	
	private void init() {
		agregar(new Producto("TV", 200f));
		agregar(new Producto("Cámara", 300f));
		agregar(new Producto("DVD", 400f));
	}

	@Override
	public List<Producto> obtenerTodos() {
		return productos;
	}

	@Override
	public void agregar(Producto p) {
		p.setId(contador++);
		productos.add(p);
	}

	@Override
	public void modificar(Producto pTmp) {
		Producto p = obtener(pTmp.getId());
		if (p != null)
			productos.set(productos.indexOf(p), pTmp);
	}

	@Override
	public void eliminar(Long id) {
		Producto p = obtener(id);
		if (p != null)
			productos.remove(p);
	}

	@Override
	public Producto obtener(Long id) {
		for (Producto p : productos)
			if (p.getId().equals(id))
				return p;
		return null;
	}

}
