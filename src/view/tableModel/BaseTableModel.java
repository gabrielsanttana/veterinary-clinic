package view.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class BaseTableModel<T> extends AbstractTableModel 
{

	private static final long serialVersionUID = 1L;

	protected List<T> list;
	protected String[] columns;    

    public BaseTableModel(List<T> list) {
    	this.list = list;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    } 

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public abstract Object getValueAt(int row, int col);	
}
