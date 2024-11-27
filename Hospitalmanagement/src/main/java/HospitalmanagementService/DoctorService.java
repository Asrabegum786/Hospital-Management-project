package HospitalmanagementService;

import org.hibernate.SessionFactory;

public interface DoctorService {
void insertDoctor(SessionFactory sf);
	
	void updateDoctor(SessionFactory sf);
	
	void deleteDoctor(SessionFactory sf);
	
	void getAllDoctor(SessionFactory sf);

	void getDoctor(SessionFactory sf);
	
	void getDoctorInformation(SessionFactory sf);

}

