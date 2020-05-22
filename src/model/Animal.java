package model;

public class Animal {
  private String animalName;
  private int animalAge;
  private String animalSex;
  private Treatment[] treataments;
  private Species species;

  public Animal() {
  }
  
  

  public Animal(String animalName, int animalAge, String animalSex, Treatment[] treataments, Species species) {
    this.animalName = animalName;
    this.animalAge = animalAge;
    this.animalSex = animalSex;
    this.treataments = treataments;
    this.species = species;
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
