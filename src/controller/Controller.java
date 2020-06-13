package controller;

import java.util.Date;
import java.util.List;
import model.*;

public class Controller {


	public static List<Client> getAllClientes() {
		return ClientDAO.getInstance().getAllClients();
	}

	public static Client getClienteById(int id) {
		return ClientDAO.getInstance().getClientById(id);
	}

	public static void deleteCliente(Client cliente) {
		ClientDAO.getInstance().deleteClient(cliente);
	}

	// --------------------------------------------------------------------------------
	// ------------------------------  GET ALL ----------------------------------------
	// --------------------------------------------------------------------------------

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
