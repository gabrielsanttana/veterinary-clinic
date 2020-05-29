package model;

public class Animal {
  private int id;
  private String animalName;
  private int animalAge;
  private String animalSex;
  private int clientId;
  private Treatment[] treataments;
  private Species species;

  public Animal() {
  }
  
  
  public Animal(int id, String animalName, int animalAge, String animalSex, int clientId, Treatment[] treataments, Species species) {
    this.id = id;
    this.animalName = animalName;
    this.animalAge = animalAge;
    this.animalSex = animalSex;
    this.clientId = clientId;
    this.treataments = treataments;
    this.species = species;
  }

  public Animal(int id, String animalName, int animalAge, String animalSex, Treatment[] treataments, Species species) {
	this.id = id;
    this.animalName = animalName;
    this.animalAge = animalAge;
    this.animalSex = animalSex;
    this.treataments = treataments;
    this.species = species;
  }
	
  public int getClientId() {
    return this.clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAnimalName() {
    return this.animalName;
  }

  public void setAnimalName(String name) {
    this.animalName = name;
  }

  public int getAnimalAge() {
    return this.animalAge;
  }

  public void setAnimalAge(int age) {
    this.animalAge = age;
  }

  public String getAnimalSex() {
    return this.animalSex;
  }

  public void setAnimalSex(String sex) {
    this.animalSex = sex;
  }

  public Treatment[] getTrataments() {
    return this.treataments;
  }

  public void setTrataments(Treatment[] trataments) {
    this.treataments = trataments;
  }

  public Treatment[] getTreataments() {
	  return treataments;
  }
  
  public void setTreataments(Treatment[] treataments) {
	  this.treataments = treataments;
  }
  
  public Species getSpecies() {
	  return species;
  }
  
  public void setSpecies(Species species) {
	  this.species = species;
  }
  
  public String viewAnimal() {
    return "";
  }

  public String consultAnimal() {
    return "";

  }

}
