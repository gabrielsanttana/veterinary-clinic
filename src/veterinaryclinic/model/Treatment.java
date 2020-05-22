package model;

import java.util.Date;

public class Treatment {
	private Date startDate;
	private Date endDate;
	private Consult[] consult;
	
	public Treatment() {
		
	}
	
	public Treatment(Date startDate, Date endDate, Consult[] consult) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.consult = consult;
	}
	
	public Date getDatStart() {
		return startDate;
  }
  
	public void setDatStart(Date startDate) {
		this.startDate = startDate;
  }
  
	public Date getendDate() {
		return endDate;
  }
  
	public void setendDate(Date endDate) {
		this.endDate = endDate;
	}
	
  public String listAppointment() {
    return "";
  }
  
  public String appointmentTreatment() {
    return "";
  }
  
	public Consult[] getConsult() {
		return consult;
	}

	public void setConsult(Consult[] consult) {
		this.consult = consult;
	}

	public int registerTreatment() {
    return 0;
  }
}
