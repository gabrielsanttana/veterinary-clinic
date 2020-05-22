package model;

import java.util.Observable;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO extends Observable {
  private static AnimalDAO instance;
  private List<Animal> animals;
  private int id;

  private AnimalDAO() {
    animals = new ArrayList<Animal>();
    id = 0;
  }

  public static AnimalDAO getInstance() {
    if(instance == null) {
      instance = new AnimalDAO();
    }

    return instance;
  }

  public void addAnimal(String nome, int age, String sex, Treatment[] treatments, Species[] species) {
    Animal animal = new Animal(nome, age, sex, treatments, species);
    id++;
    animals.add(animal);
    setChanged();
    notifyObservers(animal);
  }

  public List<Animal> getAllAnimals() {
    return animals;
  }

  public Animal getAnimalById(int id) {
    for(Animal animal : animals) {
      if(animal.getId() == id) {
        return animal;
      }
    }
  }

  public void deleteAnimal(Animal animal) {
    animals.remove(animal);
  }
}
