package model;

import java.util.List;

public class Veterinary {
	private int id;
	private String veterinaryName;
	private String veterinaryAddress;
	private String veterinaryPhone;
	private List<Consult> consults;

	public Veterinary(int id, String veterinaryName, String veterinaryAddress, String veterinaryPhone) {
		this.id = id;
		this.veterinaryName = veterinaryName;
		this.veterinaryAddress = veterinaryAddress;
		this.veterinaryPhone = veterinaryPhone;
	}

	public Veterinary(int id, String veterinaryName, String veterinaryAddress, String veterinaryPhone,
			List<Consult> consults) {
		this.id = id;
		this.veterinaryName = veterinaryName;
		this.veterinaryAddress = veterinaryAddress;
		this.veterinaryPhone = veterinaryPhone;
		this.consults = consults;
	}

	public Veterinary() {
		// TODO Auto-generated constructor stub
	}

	public List<Consult> getConsults() {
		return consults;
	}

	public void setConsults(List<Consult> consults) {
		this.consults = consults;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVeterinaryName() {
		return this.veterinaryName;
	}

	public void setVeterinaryName(String veterinaryName) {
		this.veterinaryName = veterinaryName;
	}

	public String getVeterinaryAddress() {
		return this.veterinaryAddress;
	}

	public void setVeterinaryAddress(String veterinaryAddress) {
		this.veterinaryAddress = veterinaryAddress;
	}

	public String getVeterinaryPhone() {
		return this.veterinaryPhone;
	}

	public void setVeterinaryPhone(String veterinaryPhone) {
		this.veterinaryPhone = veterinaryPhone;
	}
}
