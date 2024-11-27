package HospitalmanagementService;

import org.hibernate.SessionFactory;

public interface PatientService {
void insertPatient(SessionFactory sf);
	
	void updatePatient(SessionFactory sf);
	
	void deletePatient(SessionFactory sf);
	
	void getAllPatient(SessionFactory sf);

	void getPatient(SessionFactory sf);
	
	void getPatientInformation(SessionFactory sf);

}



