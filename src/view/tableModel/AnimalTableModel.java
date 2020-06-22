package view.tableModel;

import java.util.List;

import model.Animal;

public class AnimalTableModel extends BaseTableModel<Animal> {    


    public AnimalTableModel(List<Animal> listAnimal) {
    	super(listAnimal);
    	columns = new String[]{"ID","Nome","Idade","Sexo","Espécie","Proprietário"};    
    }


    @Override
    public Object getValueAt(int row, int col) {        
    	Animal animal = list.get(row);         
        switch (col) {
			case 0:
				return animal.getId();
            case 1:
                return animal.getAnimalName();
            case 2:
                return animal.getAnimalAge();    
            case 3:
                return animal.getAnimalSex();
            case 4:
                return animal.getSpecies().getspeciesName();
            case 5:
                return animal.getClient().getName();
        }        
        return null;        
    }



    /**
     * 
     */
    private static final long serialVersionUID = 8089116544555428084L;


}
