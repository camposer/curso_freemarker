package dao;

import java.util.ArrayList;
import java.util.List;

import to.Animal;

public class AnimalDaoImpl implements AnimalDao {
	private List<Animal> animales;
	
	public AnimalDaoImpl() {
		animales = new ArrayList<Animal>();
		init();
	}
	
	private void init() {
		animales.add(new Animal("elefante", Animal.Tipo.GRANDE));
		animales.add(new Animal("jirafa", Animal.Tipo.MEDIO));
		animales.add(new Animal("perro", Animal.Tipo.PEQUENIO));
	}

	@Override
	public List<Animal> obtenerTodos() {
		return animales;
	}

}
