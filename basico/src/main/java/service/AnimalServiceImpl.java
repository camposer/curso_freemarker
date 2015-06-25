package service;

import java.util.List;

import dao.AnimalDao;
import dao.AnimalDaoFactory;
import to.Animal;

public class AnimalServiceImpl implements AnimalService {
	private AnimalDao animalDao;

	public AnimalServiceImpl() {
		animalDao = AnimalDaoFactory.createAnimalDao();
	}
	
	@Override
	public List<Animal> obtenerAnimales() {
		return animalDao.obtenerTodos();
	}

}
