package dao;


public abstract class ProductoDaoFactory {

	public static ProductoDao createProductoDao() {
		return new ProductoDaoImpl();
	}

}
