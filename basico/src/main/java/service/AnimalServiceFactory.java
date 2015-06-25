package service;

public abstract class AnimalServiceFactory {
	public static AnimalService createAnimalService() {
		return new AnimalServiceImpl();
	}
}
