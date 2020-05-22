package model;

public class Exam {
    String exam_desc;


    public Exam() {

    }

    public Exam(String exam_desc) {
    	this.exam_desc = exam_desc;
    }

    public String getExamDesc() {
    	return this.exam_desc;
    }

    public void setExamDesc(String exam_desc) {
    	this.exam_desc = exam_desc;
    }
}
