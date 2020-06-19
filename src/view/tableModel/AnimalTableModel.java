package view.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Animal;

public class AnimalTableModel extends AbstractTableModel {

    private List<Animal> listAnimal;
    private String[] colunas = {"ID","Nome","Idade","Sexo","Espécie","Proprietário"};    


    public AnimalTableModel(List<Animal> listAnimal) {
        this.listAnimal = listAnimal; 
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
        return listAnimal.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {        
    	Animal animal = listAnimal.get(linha);         
        switch (coluna) {
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
