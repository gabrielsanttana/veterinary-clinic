package veterinaryclinic.model;

import java.util.Date;

public class Consult {
	private Date consultDate;
	private String historic;
	private AnimalVet animalVet;
	private Exam exam;

	public Consult() {
	}

	public Consult(Date consultDate, String historic, AnimalVet animalVet, Exam exam) {
		this.consultDate = consultDate;
		this.historic = historic;
		this.animalVet = animalVet;

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

	public AnimalVet getAnimalVet() {
		return animalVet;
	}

	public void setAnimalVet(AnimalVet animalVet) {
		this.animalVet = animalVet;
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
