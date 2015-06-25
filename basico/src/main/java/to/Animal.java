package to;

public class Animal {
	private String nombre;
	private Tipo tipo;
	
	public static enum Tipo {
		GRANDE, MEDIO, PEQUENIO;
	}
	
	public Animal(String nombre, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
