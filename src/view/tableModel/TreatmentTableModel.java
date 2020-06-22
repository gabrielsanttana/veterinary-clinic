package view.tableModel;

import java.util.List;

import model.Treatment;

public class TreatmentTableModel extends BaseTableModel<Treatment> {   


    public TreatmentTableModel(List<Treatment> listTreatment) {
    	super(listTreatment);
    	columns = new String[]{"ID","Data inicio","Data fim","Animal"};    
    }
    
    @Override
    public Object getValueAt(int row, int col) {        
    	Treatment treatment = list.get(row);         
        switch (col) {
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


    private static final long serialVersionUID = 8089116544555428084L;


}
