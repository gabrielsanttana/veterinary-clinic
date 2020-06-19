package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Treatment {
	private Date startDate;
	private Date endDate;
	private List<Consult> listConsult;
	private Animal animal;
	private int id;

	public Treatment(int id, Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.listConsult = new ArrayList<Consult>();
	}

	public Treatment(int id, Date startDate, Date endDate, List<Consult> listConsult, Animal animal) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.listConsult = listConsult;
		this.animal = animal;
	}
	
	public Treatment() {
		// TODO Auto-generated constructor stub
	}


	
	public String getStartDateSQL() {
		return Util.DateToStringSQL(this.startDate);
	}
	
	public String getEndDateSQL() {
		return Util.DateToStringSQL(this.endDate);
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Consult> getListConsult() {
		return listConsult;
	}

	public void setListConsult(List<Consult> listConsult) {
		this.listConsult = listConsult;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addConsult(Consult consult) {
		listConsult.add(consult);

	}

	public String listAppointment() {
		return "";
	}

	public String appointmentTreatment() {
		return "";
	}

	public int registerTreatment() {
		return 0;
	}

}
