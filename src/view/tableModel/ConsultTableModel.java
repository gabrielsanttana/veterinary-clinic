package view.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Consult;

public class ConsultTableModel extends AbstractTableModel {

    private List<Consult> listConsult;
    private String[] colunas = {"ID","Data da Consulta","Historico","Animal","Veterinario"};    


    public ConsultTableModel(List<Consult> listConsult) {
        this.listConsult = listConsult; 
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    } 

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return listConsult.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {        
    	Consult consult = listConsult.get(linha);         
        switch (coluna) {
			case 0:
				return consult.getId();
            case 1:
                return consult.getConsultDate();
            case 2:
                return consult.getHistoric();    
            case 3:
            	if (consult.getTreatment() != null) {
            		if(consult.getTreatment().getAnimal() != null) {
            			return consult.getTreatment().getAnimal().getAnimalName();
            		}
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



    /**
     * 
     */
    private static final long serialVersionUID = 8089116544555428084L;


}
