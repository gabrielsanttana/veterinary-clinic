package model;

import java.util.List;

public class Client {

	private int id;
	private String name;
	private String address;
	private String phone;
	private String cep;
	private String email;
	private List<Animal> animals;

	public Client() {}
	
	public Client(String name, String address, String phone, String cep, String email) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cep = cep;
		this.email = email;
	}
	
	public Client(int id, String name, String address, String phone, String cep, String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cep = cep;
		this.email = email;
	}

	public Client(int id, String name, String address, String phone, String cep, String email, List<Animal> animals) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cep = cep;
		this.email = email;
		this.animals = animals;
	}
	

	public int Reg_Cli() {
		return 0;
	}

	public String Con_Cli() {
		return "";
	}
	
	

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
