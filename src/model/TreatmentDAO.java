package model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class TreatmentDAO extends Observable {
	
    private static TreatmentDAO instance;
    private Map<Integer,Treatment> treatments;
    private int id;
	
    private TreatmentDAO(){
        treatments = new HashMap<Integer,Treatment>();
        this.id = 0;
    }
    
    public static TreatmentDAO getInstance(){
        if (instance == null) {
             instance = new TreatmentDAO();
         }
         return instance;
     }
    
    public void addTreatment(int id,Date startDate, Date endDate){
    	Treatment treatment = new Treatment(id,startDate, endDate);
          
    }
    public Map getAllTreatment(){        
        return  treatments;
    }
    
    public Treatment getTreatmentById(int id){
    	return treatments.get(id);

    }
    
    
    public void deleteTreatment(Treatment treatment){
        treatments.remove(treatment);
    }
    
    
    
    
}
