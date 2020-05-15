package resistencia;

public class Animal {
  private String animalName;
  private int animalAge;
  private int animalSex;
  private Tratament[] trataments;

  public Animal() {
  }

  public Animal(String animalName, int animalAge, int animalSex, Tratament[] trataments) {
    this.animalName = animalName;
    this.animalAge = animalAge;
    this.animalSex = animalSex;
    this.trataments = trataments;
  }

  public void String

  getAnimalName() {
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

  public Tratament[] getTrataments() {
    return this.trataments;
  }

  public void setTrataments(Tratament[] trataments) {
    this.trataments = trataments;
  }

  public String viewAnimal() {
    return "";
  }

  public String consultAnimal() {
    return "";

  }
}
