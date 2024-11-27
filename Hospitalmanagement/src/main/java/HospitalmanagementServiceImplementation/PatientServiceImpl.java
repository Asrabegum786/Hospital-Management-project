package HospitalmanagementServiceImplementation;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Hospitalmanagement.entities.Billing;
import Hospitalmanagement.entities.Patient;
import HospitalmanagementService.BillingService;
import HospitalmanagementService.PatientService;

public class PatientServiceImpl implements PatientService  {
	Scanner sc = new Scanner(System.in);
	Session session;
	@Override
	public void insertPatient(SessionFactory sf) {
		Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
		try {
			Patient patient= new Patient();

			System.out.println("welcome patient");

			System.out.println("enter patient id");
			int patient_id = sc.nextInt();
			sc.nextLine();
			patient.setPatient_id(patient_id);

			System.out.println("welcome to patient name");
			String name = sc.nextLine();
			patient.setPatientname(name);

			System.out.println("welcome to patient age");
			int age = sc.nextInt();
			patient.setAge(age);

			System.out.println("welcome to patient gender");
			String Gender = sc.next();
			patient.setGender(Gender);

			System.out.println("enter Contactinfo:");
			String Contactinfo=sc.next();
			patient.setContactinfo(Contactinfo);
			
			System.out.println("enter Email:");
			String Email=sc.next();
			patient.setEmail(Email);
			
			
			System.out.println("enter  address:");
			String   address=sc.next();
			patient.setAddress(address);

			session.persist(patient);
			tx.commit();
		} finally {
			session.close();

		}


		
	}
//===============================patient update===============================================================
//	@Override
//	public void updatePatient(SessionFactory sf) {
//	    session = sf.openSession();
//	    Transaction tx = session.beginTransaction(); // Start transaction
//
//	    try {
//	        while (true) {
//	            System.out.println("Choose an Option for Update "
//	                    + "\n1.Update patient name \n2.patient age \n3.Update patient gender \n4.Update patient contactinfo \n5.update Email  \n6.address \n7.Exit");
//
//	            int option = sc.nextInt();
//	            sc.nextLine();
//	            switch (option) {
//	                case 1:
//	                	
//	                    System.out.println("Enter patient Id:");
//	                    Patient patient = session.get(Patient.class, sc.nextInt());
//                        
//	                    sc.nextLine();
//	                    
//	                    if (patient != null) {
//	                        System.out.println("Enter patient name:");
//	                        String name = sc.nextLine();
//	                        if (!name.isEmpty()) {
//	                        patient.setPatientname(name);
//                        
//	                       
//	                        if (tx == null || !tx.isActive()) {
//	                            // If no active transaction exists, begin a new one
//	                            tx = session.beginTransaction();
//	                        }
//	                        
//	                        session.saveOrUpdate(patient);
//	                        tx.commit();
//
//	                        System.out.println("Patient name updated successfully");
//	                    }else {
//	                      
//	                    
//	                    	
//	                    	System.out.println("Name cannot be empty.");
//                        }
//	                    }else {
//	                        System.out.println("Patient not found for the given Id");
//	                    }
//	                    break;
//
//	                case 2:
//	                	
//	                	
//	                	 System.out.println("Enter patient Id:");
//		                     patient = session.get(Patient.class, sc.nextInt());
//
//		                    if (patient != null) {
//		                        System.out.println("Enter patient age:");
//		                        int age = sc.nextInt();
//		                        if (age > 0) {
//		                        patient.setAge(age);
//		                        
//		                        if (tx == null || !tx.isActive()) {
//	                                tx = session.beginTransaction();
//	                            }
//
//		                      
//		                        session.saveOrUpdate(patient);
//		                        tx.commit();
//
//		                        System.out.println("Patient age updated successfully");
//			                    }else {
//			                      
//			                    
//			                    	
//			                    	System.out.println("age  must be a positive value.");
//		                        }
//			                    }else {
//			                        System.out.println("Patient not found for the given Id");
//			                    }
//			                    break;
//	                case 3:
//	                	
//	                	
//	                    System.out.println("Enter patient id:");
//	                    patient = session.get(Patient.class, sc.nextInt());
//
//	                    if (patient != null) {
//	                        System.out.println("Update patient Gender:");
//	                        String gender = sc.nextLine();
//	                        if (!gender.isEmpty()) {
//	                        patient.setGender(gender);
//	                        
//	                        if (tx == null || !tx.isActive()) {
//                                tx = session.beginTransaction();
//                            }
//
//
//	                        
//	                        tx = session.beginTransaction();
//	                        session.saveOrUpdate(patient);
//	                        tx.commit();
//
//	                        System.out.println("Patient gender updated successfully.");
//	                        }else {
//			                      
//			                    
//		                    	
//		                    	System.out.println("Gender cannot be empty.");
//	                        }
//		                    }else {
//		                    	System.out.println("Patient not found for the given Id");
//		                    }
//		                    break;
//	                case 4:
//	                	
//	                	 
//	                    System.out.println("Enter patient Id:");
//	                    patient = session.get(Patient.class, sc.nextInt());
//
//	                    if (patient != null) {
//	                        System.out.println("Enter Patient Contactinfo:");
//	                        String Contactinfo = sc.nextLine();
//	                        if (!Contactinfo.isEmpty()) {
//	                        patient.setContactinfo(Contactinfo);
//                            
//	                        tx = session.beginTransaction();
//	                        session.saveOrUpdate(patient);
//	                        tx.commit();
//
//	                        System.out.println("Patient contact info updated successfully.");
//                           }else {
//			                      
//			                    
//		                    	
//		                    	System.out.println("  Contactinfo cannot be empty.");
//	                        }
//		                    }else {
//		                    	System.out.println("Patient not found for the given Id");
//		                    }
//		                    break;
//	                case 5:
//	                	
//	                    System.out.println("Enter patient Id:");
//	                    patient = session.get(Patient.class, sc.nextInt());
//
//	                    if (patient != null) {
//	                        System.out.println("Enter Patient email:");
//	                        String email = sc.next();
//	                        if (!email.isEmpty()) {
//	                        patient.setEmail(email);
//
//	                       tx = session.beginTransaction(); // Start transaction
//	                        session.saveOrUpdate(patient); // Update patient record
//	                        tx.commit(); // Commit transaction
//
//	                        System.out.println("Patient email updated successfully.");
//                         }else {
//			                      
//			                    
//		                    	
//		                    	System.out.println("  Contactinfo cannot be empty.");
//	                        }
//		                    }else {
//		                    	System.out.println("Patient not found for the given Id");
//		                    }
//		                    break;
//
//	                case 6:
//	                	
//	                	 
//	                    System.out.println("Enter patient Id:");
//	                    patient = session.get(Patient.class, sc.nextInt());
//
//	                    if (patient != null) {
//	                        System.out.println("Enter Patient address:");
//	                        String address = sc.next();
//	                        
//	                        if (!address.isEmpty()) {
//	                        patient.setAddress(address);
//                             
//	                        
//	                        
//	                        tx = session.beginTransaction();
//	                        session.saveOrUpdate(patient);
//	                        tx.commit();
//
//	                        System.out.println("Patient address updated successfully.");
//                            }else {
//			                      
//			                    
//		                    	
//		                    	System.out.println("  Contactinfo cannot be empty.");
//	                        }
//		                    }else {
//		                    	System.out.println("Patient not found for the given Id");
//		                    }
//	                case 7:
//	                    System.out.println("Exiting update...");
//	                    return;
//
//	                default:
//	                    System.out.println("Choose correct option!!");
//	            }
//
//	            // Ask the user if they want to continue updating
//	            System.out.println("Do you want to update more details for this patient? (yes/no)");
//	            String continueUpdate = sc.next();
//	            if (!continueUpdate.equalsIgnoreCase("yes")) {
//	                break;
//	            }
//	        }
//	    } finally {
//	        session.close();
//	    }
//}
	@Override
	public void updatePatient(SessionFactory sf) {
	    session = sf.openSession();
	    Transaction tx = session.beginTransaction(); // Start transaction at the beginning

	    try {
	        while (true) {
	            System.out.println("Choose an Option for Update "
	                    + "\n1.Update patient name \n2.patient age \n3.Update patient gender \n4.Update patient contactinfo \n5.update Email  \n6.address \n7.Exit");

	            int option = sc.nextInt();
	            sc.nextLine();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter patient Id:");
	                    Patient patient = session.get(Patient.class, sc.nextInt());
	                    sc.nextLine();

	                    if (patient != null) {
	                        System.out.println("Enter patient name:");
	                        String name = sc.nextLine();
	                        if (!name.isEmpty()) {
	                            patient.setPatientname(name);

	                            // Begin transaction only if none is active
	                            if (tx == null || !tx.isActive()) {
	                                tx = session.beginTransaction();
	                            }

	                            session.saveOrUpdate(patient);
	                            tx.commit(); // Commit transaction

	                            System.out.println("Patient name updated successfully");
	                        } else {
	                            System.out.println("Name cannot be empty.");
	                        }
	                    } else {
	                        System.out.println("Patient not found for the given Id");
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter patient Id:");
	                    patient = session.get(Patient.class, sc.nextInt());
	                    sc.nextLine();

	                    if (patient != null) {
	                        System.out.println("Enter patient age:");
	                        int age = sc.nextInt();
	                        if (age > 0) {
	                            patient.setAge(age);

	                            // Begin transaction only if none is active
	                            if (tx == null || !tx.isActive()) {
	                                tx = session.beginTransaction();
	                            }

	                            session.saveOrUpdate(patient);
	                            tx.commit(); // Commit transaction

	                            System.out.println("Patient age updated successfully");
	                        } else {
	                            System.out.println("Age must be a positive value.");
	                        }
	                    } else {
	                        System.out.println("Patient not found for the given Id");
	                    }
	                    break;

	                case 3:
	                    System.out.println("Enter patient Id:");
	                    patient = session.get(Patient.class, sc.nextInt());
	                    sc.nextLine();

	                    if (patient != null) {
	                        System.out.println("Update patient Gender:");
	                        String gender = sc.nextLine();
	                        if (!gender.isEmpty()) {
	                            patient.setGender(gender);

	                            // Begin transaction only if none is active
	                            if (tx == null || !tx.isActive()) {
	                                tx = session.beginTransaction();
	                            }

	                            session.saveOrUpdate(patient);
	                            tx.commit(); // Commit transaction

	                            System.out.println("Patient gender updated successfully.");
	                        } else {
	                            System.out.println("Gender cannot be empty.");
	                        }
	                    } else {
	                        System.out.println("Patient not found for the given Id");
	                    }
	                    break;

	                case 4:
	                    System.out.println("Enter patient Id:");
	                    patient = session.get(Patient.class, sc.nextInt());
	                    sc.nextLine();

	                    if (patient != null) {
	                        System.out.println("Enter Patient Contactinfo:");
	                        String contactInfo = sc.nextLine();
	                        if (!contactInfo.isEmpty()) {
	                            patient.setContactinfo(contactInfo);

	                            // Begin transaction only if none is active
	                            if (tx == null || !tx.isActive()) {
	                                tx = session.beginTransaction();
	                            }

	                            session.saveOrUpdate(patient);
	                            tx.commit(); // Commit transaction

	                            System.out.println("Patient contact info updated successfully.");
	                        } else {
	                            System.out.println("Contact info cannot be empty.");
	                        }
	                    } else {
	                        System.out.println("Patient not found for the given Id");
	                    }
	                    break;

	                case 5:
	                    System.out.println("Enter patient Id:");
	                    patient = session.get(Patient.class, sc.nextInt());
	                    sc.nextLine();

	                    if (patient != null) {
	                        System.out.println("Enter Patient email:");
	                        String email = sc.nextLine();
	                        if (!email.isEmpty()) {
	                            patient.setEmail(email);

	                            // Begin transaction only if none is active
	                            if (tx == null || !tx.isActive()) {
	                                tx = session.beginTransaction();
	                            }

	                            session.saveOrUpdate(patient);
	                            tx.commit(); // Commit transaction

	                            System.out.println("Patient email updated successfully.");
	                        } else {
	                            System.out.println("Email cannot be empty.");
	                        }
	                    } else {
	                        System.out.println("Patient not found for the given Id");
	                    }
	                    break;

	                case 6:
	                    System.out.println("Enter patient Id:");
	                    patient = session.get(Patient.class, sc.nextInt());
	                    sc.nextLine();

	                    if (patient != null) {
	                        System.out.println("Enter Patient address:");
	                        String address = sc.nextLine();
	                        if (!address.isEmpty()) {
	                            patient.setAddress(address);

	                            // Begin transaction only if none is active
	                            if (tx == null || !tx.isActive()) {
	                                tx = session.beginTransaction();
	                            }

	                            session.saveOrUpdate(patient);
	                            tx.commit(); // Commit transaction

	                            System.out.println("Patient address updated successfully.");
	                        } else {
	                            System.out.println("Address cannot be empty.");
	                        }
	                    } else {
	                        System.out.println("Patient not found for the given Id");
	                    }
	                    break;

	                case 7:
	                    System.out.println("Exiting update...");
	                    return;

	                default:
	                    System.out.println("Choose correct option!");
	            }

	            // Ask the user if they want to continue updating
	            System.out.println("Do you want to update more details for this patient? (yes/no)");
	            String continueUpdate = sc.next();
	            if (!continueUpdate.equalsIgnoreCase("yes")) {
	                break;
	            }
	        }
	    } finally {
	        // Close session after completing the operation
	        if (tx != null && tx.isActive()) {
	            tx.commit();  // Ensure the transaction is committed if it's still active
	        }
	        session.close();
	    }
	}

//===========================delete patient============================================================		

//	@Override
//	public void deletePatient(SessionFactory sf) {
//		session = sf.openSession();
//        Transaction tx = session.beginTransaction();
//
//        System.out.println("Enter patient id");
//        int patient_id = sc.nextInt();
//        Patient patient = session.get(Patient.class, patient_id);
//
//        if (patient != null) {
//            session.delete(patient);
//            tx.commit();
//            System.out.println("Patient deleted successfully.");
//        } else {
//            System.out.println("Please enter a valid patient_id.");
//           
//        }
//        session.close();
//}
	
	@Override
	public void deletePatient(SessionFactory sf) {
	    session = sf.openSession();
	    Transaction tx = session.beginTransaction();

	    System.out.println("Enter patient id");
	    int patient_id = sc.nextInt();
	    Patient patient = session.get(Patient.class, patient_id);

	    if (patient != null) {
	        // Remove the patient references in related tables (e.g., rooms)
	        // First, retrieve and delete rooms associated with the patient
	        Query deleteRoomsQuery = session.createQuery("DELETE FROM Rooms WHERE patient.id = :patientId");
	        deleteRoomsQuery.setParameter("patientId", patient_id);
	        deleteRoomsQuery.executeUpdate();

	        // Now delete the patient
	        session.delete(patient);
	        tx.commit();
	        System.out.println("Patient deleted successfully.");
	    } else {
	        System.out.println("Please enter a valid patient_id.");
	    }
	    session.close();
	}

	   


//============================getAllPatient ==========================================	
	@Override
	public void getAllPatient(SessionFactory sf) {
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Patient");
        List<Patient> patientList=query.getResultList();
        
        for(Patient b:patientList) {
        	System.out.println(b);
        }

        
        
        tx.commit();
        session.close();

	}
	//===========================SPECIFIC record===========================================	
	@Override
	public void getPatient(SessionFactory sf) {
		session = sf.openSession();

        System.out.println("Enter patient_id:");
        int patient_id= sc.nextInt();
        Patient patient = session.get(Patient.class, patient_id);

        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Patient not found for the given Id.");
        }

        session.close();

		
		
	}
	@Override
	public void getPatientInformation(SessionFactory sf) {
		session = sf.openSession();
    	
	       
        Query query = session.createQuery("select count(Patient_id) from Patient");
        Long count = (Long) query.getSingleResult();

        System.out.println("Total number of Patients: " + count);
        session.close();
        } 
		
	}
