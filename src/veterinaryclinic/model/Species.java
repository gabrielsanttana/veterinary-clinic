package veterinaryclinic.model;

public class Species {
    private String speciesName;
    private int id;

    public Species() {

    }

    public Species(int id,String speciesName) {
    	this.id = id;
        this.speciesName = speciesName;
    }

    public String getspeciesName() {
        return this.speciesName;
    }

    public void setspeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    

}
