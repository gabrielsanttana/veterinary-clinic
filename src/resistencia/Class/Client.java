package resistencia;

public class Client {
    int id;
    
    private String name;
    private String address;
    private String tel;
    private double cep;
    private String email;
    
    
    public Client(String name, String address, String tel, double cep, String email) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getCep() {
		return cep;
	}

	public void setCep(double cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    

}
