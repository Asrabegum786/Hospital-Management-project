package HospitalmanagementService;

import org.hibernate.SessionFactory;

public interface MedicalService {
void insertMedical(SessionFactory sf);
	
	void updateMedical(SessionFactory sf);
	
	void deleteMedical(SessionFactory sf);
	
	void getAllMedical(SessionFactory sf);

	void getMedical(SessionFactory sf);
	
	void getMedicalInformation(SessionFactory sf);

}





