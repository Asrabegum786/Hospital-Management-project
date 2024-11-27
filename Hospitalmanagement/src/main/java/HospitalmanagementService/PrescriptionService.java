package HospitalmanagementService;

import org.hibernate.SessionFactory;

public interface PrescriptionService {

	
	
void insertPrescription(SessionFactory sf);
	
	void updatePrescription(SessionFactory sf);
	
	void deletePrescription(SessionFactory sf);
	
	void getAllPrescription(SessionFactory sf);

	void getPrescription(SessionFactory sf);
	
	void getPrescriptionInformation(SessionFactory sf);

}
	
	
	
	

