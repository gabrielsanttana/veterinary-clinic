package view.tableModel;

import java.util.List;

import model.Consult;

public class ConsultTableModel extends BaseTableModel<Consult> {

    public ConsultTableModel(List<Consult> listConsult) {
    	super(listConsult);
        columns = new String[]{"ID","Data da Consulta","Historico","Animal","Veterinario"};
    }

    @Override
    public Object getValueAt(int row, int col) {        
    	Consult consult = list.get(row);         
        switch (col) {
			case 0:
				return consult.getId();
            case 1:
                return consult.getConsultDate();
            case 2:
                return consult.getHistoric();    
            case 3:
            	if (consult.getTreatment() != null) {
                    return consult.getTreatment().getId();
            	}
                return null; 
            case 4:
            	if (consult.getVeterinary() != null) {
                    return consult.getVeterinary().getVeterinaryName();
            	}
                return null;
        }        
        return null;        
    }



    private static final long serialVersionUID = 8089116544555428084L;


}
