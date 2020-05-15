package resistencia.Class;

import java.util.Date;

public class Consulta 
{
	private Date consultaDate;
	private String historico;
	
	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public Date getConsultaDate() {
		return consultaDate;
	}

	public void setConsultaDate(Date consultaDate) {
		this.consultaDate = consultaDate;
	}		
	
	
	public String Lista_Consulta()
	{
		return "";		
	}
	
	public String Ver_Consulta() 
	{
		return "";		
	}
	
	public int Registra_Consulta() 
	{
		return 0;		
	}
}
