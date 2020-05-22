package model;

import java.util.Observable;
import java.util.Map;
import java.util.HashMap;

public class AnimalDAO extends Observable {
  private static AnimalDAO instance;
  private Map<Integer, Animal> animals;
  private Integer id;

  private AnimalDAO() {
    animals = new HashMap<Integer, Animal>();
    this.id = 0;
  }

  public static AnimalDAO getInstance() {
    if(instance == null) {
      instance = new AnimalDAO();
    }

    return instance;
  }

  public void addAnimal(String name, int age, String sex, Treatment[] treatments, Species species) {
    Animal animal = new Animal(name, age, sex, treatments, species);
    animals.put(id, animal);
    this.id++;
    setChanged();
    notifyObservers(animal);
  }

  public Map<Integer, Animal> getAllAnimals() {
    return animals;
  }

  public Animal getAnimalById(int id) {
    return animals.get(id);
  }

  public void deleteAnimal(int id) {
    animals.remove(id);
  }
}
