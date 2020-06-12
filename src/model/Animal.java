package model;

import java.util.List;

public class Animal {
	private int id;
	private String animalName;
	private int animalAge;
	private String animalSex;
	private int clientId;
	private Client client;
	private List<Treatment> treatments;
	private Species species;

	public Animal() {
	}
	
	public Animal(int id, String animalName, int animalAge, String animalSex, Client client, List<Treatment> treatments,
			Species species) {
		this.id = id;
		this.animalName = animalName;
		this.animalAge = animalAge;
		this.animalSex = animalSex;
		this.client = client;
		this.treatments = treatments;
		this.species = species;
	}

	public Animal(int id, String animalName, int animalAge, String animalSex, int clientId, List<Treatment> treatments,
			Species species) {
		this.id = id;
		this.animalName = animalName;
		this.animalAge = animalAge;
		this.animalSex = animalSex;
		this.clientId = clientId;
		this.treatments = treatments;
		this.species = species;
	}

	public Animal(int id, String animalName, int animalAge, String animalSex, List<Treatment> treatments,
			Species species) {
		this.id = id;
		this.animalName = animalName;
		this.animalAge = animalAge;
		this.animalSex = animalSex;
		this.treatments = treatments;
		this.species = species;
	}
	
	

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
