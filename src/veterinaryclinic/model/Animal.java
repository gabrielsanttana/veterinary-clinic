package veterinaryclinic.model;

public class Animal {
  private String animalName;
  private int animalAge;
  private int animalSex;
  private Treatment[] treataments;

  public Animal() {
  }

  public Animal(String animalName, int animalAge, int animalSex, Treatment[] trataments) {
    this.animalName = animalName;
    this.animalAge = animalAge;
    this.animalSex = animalSex;
    this.setTreataments(trataments);
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

  public int getAnimalSex() {
    return this.animalSex;
  }

  public void setAnimalSex(int sex) {
    this.animalSex = sex;
  }

  public Treatment[] getTrataments() {
    return this.treataments;
  }

  public void setTrataments(Treatment[] trataments) {
    this.treataments = trataments;
  }

  public String viewAnimal() {
    return "";
  }

  public String consultAnimal() {
    return "";

  }

public Treatment[] getTreataments() {
	return treataments;
}

public void setTreataments(Treatment[] treataments) {
	this.treataments = treataments;
}
}
