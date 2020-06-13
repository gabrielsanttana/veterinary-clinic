package view.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.*;

public class ExamTableModel extends AbstractTableModel {

    private List<Exam> listExam;
    private String[] colunas = {"ID","Descricao","Consulta data","Consulta ID"};    


    public ExamTableModel(List<Exam> listExam) {
        this.listExam = listExam; 
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
        return listExam.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {        
    	Exam exam = listExam.get(linha);         
        switch (coluna) {
			case 0:
				return exam.getId();
            case 1:
                return exam.getId();
            case 2:
                return exam.getExamDesc();    
            case 3:
                return exam.getConsult().getConsultDate();
            case 4:
                return exam.getConsult().getId();
        }        
        return null;        
    }



    /**
     * 
     */
    private static final long serialVersionUID = 8089116544555428084L;


}
