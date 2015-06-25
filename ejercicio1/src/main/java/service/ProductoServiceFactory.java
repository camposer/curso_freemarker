package service;

public abstract class ProductoServiceFactory {
	public static ProductoService createProductoService() {
		return new ProductoServiceImpl();
	}
}
