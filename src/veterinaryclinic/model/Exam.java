package veterinaryclinic.model;

public class Exam {
    private String exam_desc;
    private int id;


    public Exam() {

    }

    public Exam(int id,String exam_desc) {
    	this.id = id;
    	this.exam_desc = exam_desc;
    }

    public String getExamDesc() {
    	return this.exam_desc;
    }

    public void setExamDesc(String exam_desc) {
    	this.exam_desc = exam_desc;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
}
