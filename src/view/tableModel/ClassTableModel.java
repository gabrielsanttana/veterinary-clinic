package view.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.*;

public class ClassTableModel extends AbstractTableModel {

    private List<ClassName> varListName;
    private String[] colunas = {"Nome","Endereço","Telefone"};    


    public ClassNameTableModel(List<ClassName> varListName) {
        this.varListName = varListName; 
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
        return varListName.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {        
    	ClassName varName = varListName.get(linha);         
        switch (coluna) {
            case 0:
                return varName.getVeterinaryName();
            case 1:
                return varName.getVeterinaryAddress();    
            case 2:
                return varName.getVeterinaryPhone();
        }        
        return null;        
    }



    /**
     * 
     */
    private static final long serialVersionUID = 8089116544555428084L;


}
