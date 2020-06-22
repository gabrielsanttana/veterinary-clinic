package model;

import java.util.Date;
import java.util.List;

public class Consult {
	private int id;
	private Date consultDate;
	private String historic;
	private Treatment treatment;
	private Veterinary veterinary;
	private List<Exam> exam;

	public Consult() {}

	public Consult(int id,Date consultDate, String historic, Veterinary veterinary, List<Exam> exam) {
		this.id = id;
		this.consultDate = consultDate;
		this.historic = historic;
		this.veterinary = veterinary;
		this.exam = exam;
	}
	
	public Consult(int id,Date consultDate, String historic, Treatment treatment, Veterinary veterinary, List<Exam> exam) {
		this.id = id;
		this.consultDate = consultDate;
		this.historic = historic;
		this.treatment = treatment;
		this.veterinary = veterinary;
		this.exam = exam;
	}	

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public Veterinary getVeterinary() {
		return veterinary;
	}

	public void setVeterinary(Veterinary veterinary) {
		this.veterinary = veterinary;
	}

	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(List<Exam> exam) {
		this.exam = exam;
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
