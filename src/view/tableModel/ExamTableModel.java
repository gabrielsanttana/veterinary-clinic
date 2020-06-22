package view.tableModel;

import java.util.List;

import model.Exam;

public class ExamTableModel extends BaseTableModel<Exam> {

    public ExamTableModel(List<Exam> listExam) {
    	super(listExam);
        columns = new String[]{"ID","Descricao","Consulta data","Consulta ID"};
    }

    @Override
    public Object getValueAt(int row, int col) {        
    	Exam exam = list.get(row);         
        switch (col) {
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
