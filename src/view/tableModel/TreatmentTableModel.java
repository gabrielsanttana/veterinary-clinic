package view.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.*;

public class TreatmentTableModel extends AbstractTableModel {

    private List<Treatment> listTreatment;
    private String[] colunas = {"ID","Data inicio","Data fim","Animal"};    


    public TreatmentTableModel(List<Treatment> listTreatment) {
        this.listTreatment = listTreatment; 
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
        return listTreatment.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {        
    	Treatment treatment = listTreatment.get(linha);         
        switch (coluna) {
            case 0:
                return treatment.getId();
            case 1:
                return treatment.getStartDate();
            case 2:
                return treatment.getEndDate();
            case 3:
                return treatment.getAnimal().getAnimalName();
        }        
        return null;        
    }



    /**
     * 
     */
    private static final long serialVersionUID = 8089116544555428084L;


}
