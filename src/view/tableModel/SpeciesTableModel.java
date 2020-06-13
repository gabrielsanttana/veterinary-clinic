package view.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.*;

public class SpeciesTableModel extends AbstractTableModel {

    private List<Species> listSpecies;
    private String[] colunas = {"ID","Nome"};    


    public SpeciesTableModel(List<Species> listSpecies) {
        this.listSpecies = listSpecies; 
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
        return listSpecies.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {        
    	Species species = listSpecies.get(linha);         
        switch (coluna) {
            case 0:
                return species.getId();
            case 1:
                return species.getspeciesName();    
        }        
        return null;        
    }



    /**
     * 
     */
    private static final long serialVersionUID = 8089116544555428084L;


}
