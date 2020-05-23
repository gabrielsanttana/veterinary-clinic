package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class ExamDAO extends Observable{
	

    private static ExamDAO instance;
    private Map<Integer,Exam> listExam;
    private Integer id;
    
    private ExamDAO(){
    	listExam = new HashMap<Integer,Exam>();
        id = 0;
    }
    
    // Singleton
    public static ExamDAO getInstance(){
       if (instance == null) {
            instance = new ExamDAO();
        }
        return instance;
    }

    
    
    // Partial CRUD    
    // Create
    public void addExam(String exam_desc){
    	Exam exam = new Exam(id,exam_desc);
        listExam.put(id,exam);
        id++;
        setChanged();
        notifyObservers(exam);
    }
    
    // RetrieveAll
    public Map<Integer,Exam> getAllExam(){        
        return listExam;
    }
    
    // RetrieveById
    public Exam getExamById(int id){
    	return listExam.get(id);
    }
    
    // RetrieveByName
    
    // Updade
    
    // Delete   
    public void deleteExam(Exam exam){
    	listExam.remove(exam.getId());
    }
}
