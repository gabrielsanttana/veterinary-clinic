package model;

public class Client {

	private int id;
	private String name;
	private String address;
	private String tel;
	private String cep;
	private String email;
	private Animal[] animals;

	public Client() {}

	public Client(int id, String name, String address, String tel, String cep, String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.cep = cep;
		this.email = email;
	}

	public int Reg_Cli() {
		return 0;
	}

	public String Con_Cli() {
		return "";
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public Animal[] getAnimals() {
		return animals;
	}

	public void setAnimals(Animal[] animals) {
		this.animals = animals;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
