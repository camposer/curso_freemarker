package service;

public abstract class ProductoServiceFactory {
	private static ProductoService INSTANCE = new ProductoServiceImpl();
	
	public static ProductoService createProductoService() {
		return INSTANCE;
	}
}
