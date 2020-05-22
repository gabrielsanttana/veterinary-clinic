package model;

import java.util.Date;

public class Consult {
	private int id;
	private Date consultDate;
	private String historic;
	private Veterinary veterinary;
	private Exam exam;

	public Consult() {
	}

	public Consult(int id,Date consultDate, String historic, Veterinary veterinary, Exam exam) {
		this.id = id;
		this.consultDate = consultDate;
		this.historic = historic;
		this.veterinary = veterinary;

	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHistoric() {
		return historic;
	}

	public void setHistoric(String historico) {
		this.historic = historico;
	}

	public Date getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(Date consultaDate) {
		this.consultDate = consultaDate;
	}

	public Veterinary vetveterinary() {
		return veterinary;
	}

	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String listConsults() {
		return "";
	}

	public String viewConsult() {
		return "";
	}

	public int registryConsult() {
		return 0;
	}
}
