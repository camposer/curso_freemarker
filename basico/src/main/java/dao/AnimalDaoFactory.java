package dao;

import java.util.ArrayList;

import to.Animal;

public abstract class AnimalDaoFactory {

	public static AnimalDao createAnimalDao() {
		return new AnimalDaoImpl();
	}

}
