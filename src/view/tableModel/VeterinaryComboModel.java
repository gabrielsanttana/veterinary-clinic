package view.tableModel;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import model.Veterinary;

public class VeterinaryComboModel extends AbstractListModel<Veterinary> implements ComboBoxModel<Veterinary> {
	
	private static final long serialVersionUID = 8089116544555428084L;

	protected List<Veterinary> list;  
	private Veterinary selected;
    
    public VeterinaryComboModel(List<Veterinary> listVeterinary) {
    	list = listVeterinary;
    	if (getSize() > 0)
            setSelectedItem(list.get(0));
    }    

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public Veterinary getElementAt(int index) {
		return list.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selected = (Veterinary) anItem;		
	}

	@Override
	public Object getSelectedItem() {
		return selected;
	}
}
