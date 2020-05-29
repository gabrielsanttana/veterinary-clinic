package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VeterinaryDAO extends Observable {
    private static VeterinaryDAO instance;
    private Map<Integer,Veterinary> listVeterinaries;
    private Integer id;

    private VeterinaryDAO(){
        listVeterinaries = new HashMap<Integer, Veterinary>();
        this.id = 0;
    }

    public static VeterinaryDAO getInstance(){
        if(instance == null) {
            instance = new VeterinaryDAO();
        }
        return instance;
    }

    public void addVeterinay(String veterinaryName, String veterinaryAddress,String veterinaryPhone){
        Veterinary veterinary = new Veterinary(id, veterinaryName, veterinaryAddress, veterinaryPhone);
        listVeterinaries.put(id, veterinary);
        this.id++;
        setChanged();
        notifyObservers(veterinary);
    }

    public Map<Integer,Veterinary> getAllVeterinaries(){
        return listVeterinaries;
    }

    public Veterinary getVeterinary(int id){
        return listVeterinaries.get(id);
    }

    public void deleteVeterinay(Veterinary veterinary){
        listVeterinaries.remove(veterinary.getId());
    }
}