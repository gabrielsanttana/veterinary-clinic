package resistencia.model;

public class AnimalVet {
    private String vetName;
    private String vetAddress;
    private String vetPhone;

    public AnimalVet() {

    }

    public AnimalVet(String vetName, String vetAddress, String vetPhone) {
        this.vetName = vetName;
        this.vetAddress = vetAddress;
        this.vetPhone = vetPhone;
    }

    public String getVetName() {
        return this.vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getVetAddress() {
        return this.vetAddress;
    }

    public void setVetAddress(String vetAddress) {
        this.vetAddress = vetAddress;
    }

    public String getVetPhone() {
        return this.vetPhone;
    }

    public void setVetPhone(String vetPhone) {
        this.vetPhone = vetPhone;
    }
}
