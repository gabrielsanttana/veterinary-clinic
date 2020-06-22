package view.tableModel;

import java.util.List;

import model.Species;

public class SpeciesTableModel extends BaseTableModel<Species> {

    public SpeciesTableModel(List<Species> listSpecies) {
    	super(listSpecies);
    	columns = new String[]{"ID","Nome"};    
    }

    @Override
    public Object getValueAt(int row, int col) {        
    	Species species = list.get(row);         
        switch (col) {
            case 0:
                return species.getId();
            case 1:
                return species.getspeciesName();    
        }        
        return null;        
    }



    private static final long serialVersionUID = 8089116544555428084L;


}
