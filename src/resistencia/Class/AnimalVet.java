package resistencia;

public class AnimalVet {
    String vet_name;
    String vet_address;
    String vet_phone;


    public void AnimalVet() {

    }

    public void AnimalVet(String vet_name, String vet_address, String vet_phone) {
    	this.spacie_name = vet_name;
    	this.spacie_name = vet_address;
    	this.spacie_name = vet_phone;
    }

    public String getVetName() {
    	return this.vet_name;
    }

    public void setVetName(String vet_name) {
    	this.vet_name = vet_name;
    }

    public String getVetAddress() {
    	return this.vet_address;
    }

    public void setVetAddress(String vet_address) {
    	this.vet_address = vet_address;
    }

    public String getVetPhone() {
    	return this.vet_phone;
    }

    public void setVetPhone(String vet_phone) {
    	this.vet_phone = vet_phone;
    }
}
