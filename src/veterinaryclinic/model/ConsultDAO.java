package veterinaryclinic.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class ConsultDAO extends Observable{
	

    private static ConsultDAO instance;
    private Map<Integer,Consult> listConsult;
    private Integer id;
    
    private ConsultDAO(){
    	listConsult = new HashMap<Integer,Consult>();
        id = 0;
    }
    
    // Singleton
    public static ConsultDAO getInstance(){
       if (instance == null) {
            instance = new ConsultDAO();
        }
        return instance;
    }

    
    
    // Partial CRUD    
    // Create
    public void addConsult(int id,Date consultDate, String historic, Veterinary veterinary, Exam exam){
    	Consult consult = new Consult(id,consultDate,historic,veterinary,exam);
    	listConsult.put(id,consult);
        id++;
        setChanged();
        notifyObservers(consult);
    }
    
    // RetrieveAll
    public Map getAllConsult(){        
        return listConsult;
    }
    
    // RetrieveById
    public Consult getConsultById(int id){
    	return listConsult.get(id);
    }
    
    // RetrieveByName
    
    // Updade
    
    // Delete   
    public void deleteConsult(Consult consult){
    	listConsult.remove(consult.getId());
    }

}
