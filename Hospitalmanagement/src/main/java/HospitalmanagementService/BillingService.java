package HospitalmanagementService;

import org.hibernate.SessionFactory;

public interface BillingService {

void insertBilling(SessionFactory sf);
	
	void updateBilling(SessionFactory sf);
	
	void deleteBilling(SessionFactory sf);
	
	void getAllBilling(SessionFactory sf);

	void getBilling(SessionFactory sf);
	
	void getBillingInformation(SessionFactory sf);

}
