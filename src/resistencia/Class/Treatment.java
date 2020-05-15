import java.util.Date;

public class Treatment {
	private Date startDate;
	private Date endDate;
	
	private Treatment(Date startDate, Date endDate) {
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
