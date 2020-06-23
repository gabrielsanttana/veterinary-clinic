package view.comboBoxModel;

import java.util.List;

import model.Species;

public class SpeciesComboBoxModel extends BaseComboBoxModel<Species> {
	
	private static final long serialVersionUID = 8089116544555428084L;
    
    public SpeciesComboBoxModel(List<Species> listVeterinary) {
    	super(listVeterinary);
    }    
}
