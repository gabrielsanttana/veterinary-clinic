package model;

public class Exam {
	private String examDesc;
	private int id;
	private Consult consult;

	public Exam() {

	}

	public Exam(int id, String examDesc) {
		this.id = id;
		this.examDesc = examDesc;
	}

	public Exam(int id, String examDesc, Consult consult) {
		this.id = id;
		this.examDesc = examDesc;
		this.consult = consult;
	}

	public Consult getConsult() {
		return consult;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public String getExamDesc() {
		return examDesc;
	}

	public void setExamDesc(String examDesc) {
		this.examDesc = examDesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
