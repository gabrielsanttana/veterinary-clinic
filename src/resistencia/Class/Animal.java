package resistencia;

public class Animal {
  String animalName;
  int animalAge;
  int animalSex;

  private viewAnimal() {}

  private consultAnimal() {}

  private String getAnimalName() {
    return this.animalName;
  }

  private setAnimalName(String name) {
    this.animalName = name;
  }

  private int getAnimalAge() {
    return this.animalAge;
  }

  private setAnimalAge(int age) {
    this.animalAge = age;
  }

  private int getAnimalSex() {
    return this.animalSex;
  }

  private setAnimalSex(int sex) {
    this.animalSex = sex;
  }
}
