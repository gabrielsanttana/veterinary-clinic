package view.comboBoxModel;

import java.util.List;

import model.Veterinary;

public class VeterinaryComboBoxModel extends BaseComboBoxModel<Veterinary> {
	
	private static final long serialVersionUID = 8089116544555428084L;
    
    public VeterinaryComboBoxModel(List<Veterinary> listVeterinary) {
    	super(listVeterinary);
    }    
}
