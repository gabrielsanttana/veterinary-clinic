package veterinaryclinic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class TreatmentDAO extends Observable {
	
    private static TreatmentDAO instance;
    private List<Treatment> treatments;
    private int id;
	
    private TreatmentDAO(){
        treatments = new ArrayList();
        id = 0;
    }
    
    public static TreatmentDAO getInstance(){
        if (instance == null) {
             instance = new TreatmentDAO();
         }
         return instance;
     }
    
    public void addTreatment(Date startDate, Date endDate){
    	Treatment treatment = new Treatment(startDate, endDate);
        id++;
        treatments.add(treatment);
        setChanged();
        notifyObservers(treatment);       
    }
    public List getAllTreatment(){        
        return treatments;
    }
    
    public Treatment getTreatmentById(int id){
        for(Treatment treatment : treatments){
            if(treatment.getId()==id){
                return treatment;
            }
        }
        return null;
    }
    
    
    public void deleteTreatment(Treatment treatment){
        treatments.remove(treatment);
    }
    
    
    
    
}
