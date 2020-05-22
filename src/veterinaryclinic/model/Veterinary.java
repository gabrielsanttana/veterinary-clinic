package model;

public class Veterinary {
    private String veterinaryName;
    private String veterinaryAddress;
    private String veterinaryPhone;

    public Veterinary(String veterinaryName, String veterinaryAddress, String veterinaryPhone) {
        this.veterinaryName = veterinaryName;
        this.veterinaryAddress = veterinaryAddress;
        this.veterinaryPhone = veterinaryPhone;
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
