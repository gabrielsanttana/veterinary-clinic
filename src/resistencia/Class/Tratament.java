import java.util.Date;

public class Tratament {
	private Date startDate;
	private Date endDate;
	
	private Tratament(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
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
	
  public listAppointment() {}
  
  public appointmentTratament() {}
  
	public registerTratament() {}
}
