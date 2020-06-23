package controller;

import java.util.Date;
import java.util.List;
import model.*;

public class Controller {


	public static Client getClienteById(int id) {
		return ClientDAO.getInstance().getClientById(id);
	}
	
	public static void deleteCliente(Client cliente) {
		ClientDAO.getInstance().deleteClient(cliente);
	}
	

	public static List<Animal> getAnimalsByClient(int clientID) {
		return AnimalDAO.getInstance().getAnimalByClient(clientID);
	}
	
	public static Animal getAnimalById(int id) {
		return AnimalDAO.getInstance().getAnimalById(id);
	}
	
	public static Client getClientById(int id) {
		return ClientDAO.getInstance().getClientById(id);
	}
	
	public static void deleteAnimal(Animal animal) {
		AnimalDAO.getInstance().deleteAnimal(animal);
	}
	
	public static void updateAnimal(Animal animal) {
		AnimalDAO.getInstance().update(animal);
	}
	
	public static void deleteClient(Client client) {
		ClientDAO.getInstance().deleteClient(client);
	}
	
	public static void updateClient(Client client) {
		ClientDAO.getInstance().update(client);
	}

	
	public static void deleteConsult(Consult model) {
		ConsultDAO.getInstance().deleteConsult(model);
	}
	
	public static void updateConsult(Consult model) {
		ConsultDAO.getInstance().update(model);
	}
	
	public static Consult getConsultById(int id) {
		return ConsultDAO.getInstance().getConsultById(id);
	}

	public static List<Consult> getConsultByTreatmentId(int id) {
		return ConsultDAO.getInstance().getConsultByTreatmentId(id);
	}
	public static List<Consult> getConsultByVeterinaryId(int id) {
		return ConsultDAO.getInstance().getConsultByVeterinaryId(id);
	}
	
	public static void deleteExam(Exam model) {
		ExamDAO.getInstance().deleteExam(model);
	}
	
	public static void updateExam(Exam model) {
		ExamDAO.getInstance().update(model);
	}
	
	public static List<Exam> getExamByConsultId(int id) {
		return ExamDAO.getInstance().getExamByConsultId(id);
	}
	
	public static Exam getExamById(int id) {
		return ExamDAO.getInstance().getExamById(id);
	}
	
	public static void deleteSpecies(Species model) {
		SpeciesDAO.getInstance().deleteSpecies(model);
	}
	
	public static void updateSpecies(Species model) {
		SpeciesDAO.getInstance().update(model);
	}
	
	public static Species getSpeciesById(int id) {
		return SpeciesDAO.getInstance().getSpeciesById(id);
	}
	

	
	public static void deleteTreatment(Treatment model) {
		TreatmentDAO.getInstance().deleteTreatment(model);
	}
	
	public static void updateTreatment(Treatment model) {
		TreatmentDAO.getInstance().update(model);
	}
	
	public static List<Treatment> getTreatmentByAnimalId(int id){
		return TreatmentDAO.getInstance().getTreatmentByAnimalId(id);
	}
	
	public static Treatment getTreatmentById(int id){
		return TreatmentDAO.getInstance().getTreatmentById(id);
	}
	
	public static void deleteVeterinary(Veterinary model) {
		VeterinaryDAO.getInstance().deleteVeterinary(model);
	}
	
	public static void updateVeterinary(Veterinary model) {
		VeterinaryDAO.getInstance().update(model);
	}
	
	public static Veterinary getVeterinaryById(int id) {
		return VeterinaryDAO.getInstance().getVeterinaryById(id);
	}
	
	// --------------------------------------------------------------------------------
	// ------------------------------  GET ALL ----------------------------------------
	// --------------------------------------------------------------------------------
	

	public static List<Client> getAllClientes() {
		return ClientDAO.getInstance().getAllClients();
	}

	public static List<Animal> getAllAnimal() {
		return AnimalDAO.getInstance().getAllAnimals();
	}

	public static List<Client> getAllClient() {
		return ClientDAO.getInstance().getAllClients();
	}

	public static List<Consult> getAllConsult() {
		return ConsultDAO.getInstance().getAllConsults();
	}

	public static List<Exam> getAllExam() {
		return ExamDAO.getInstance().getAllExams();
	}

	public static List<Species> getAllSpecies() {
		return SpeciesDAO.getInstance().getAllSpecies();
	}

	public static List<Treatment> getAllTreatment() {
		return TreatmentDAO.getInstance().getAllTreatments();
	}

	public static List<Veterinary> getAllVeterinary() {
		return VeterinaryDAO.getInstance().getAllVeterinary();
	}
	

	// --------------------------------------------------------------------------------
	// ------------------------------  ADD 1  -----------------------------------------
	// --------------------------------------------------------------------------------


	public static void addAnimal(String animalName, int animalAge, String animalSex, int clientId) {
		AnimalDAO.getInstance().addAnimal(animalName, animalAge, animalSex, clientId);
	}
	
	public static void addCliente(String name, String address, String email, String phone, String cep) {
		ClientDAO.getInstance().addClient(name, address, phone, cep, email);
	}
	public static void addConsult(Date consultDate,String historic, int treatment, int veterinary) {
		ConsultDAO.getInstance().addConsult(consultDate, historic, treatment, veterinary);
	}
	public static void addExam(String examDesc,int consult) {
		ExamDAO.getInstance().addExam(examDesc, consult);
	}
	public static void addSpecies(String speciesName) {
		SpeciesDAO.getInstance().addSpecies(speciesName);
	}
	public static void addTreatment(Date startDate, Date endDate, int animal) {
		TreatmentDAO.getInstance().addTreatment(startDate, endDate, animal);
	}

	public static void addVeterinary(String veterinaryName, String veterinaryAddress, String veterinaryPhone) {
		VeterinaryDAO.getInstance().addVeterinary(veterinaryName, veterinaryAddress, veterinaryPhone);
	}


}
