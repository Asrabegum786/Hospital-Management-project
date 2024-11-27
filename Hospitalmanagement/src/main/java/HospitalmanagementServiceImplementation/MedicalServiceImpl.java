package HospitalmanagementServiceImplementation;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Hospitalmanagement.entities.Billing;
import Hospitalmanagement.entities.Doctor;
import Hospitalmanagement.entities.Medical;
import Hospitalmanagement.entities.Patient;
import Hospitalmanagement.entities.Rooms;
import HospitalmanagementService.MedicalService;

public class MedicalServiceImpl   implements  MedicalService{
	Scanner sc = new Scanner(System.in);
	Session session;
    // Method to insert Medical record
//    public void insertMedical(SessionFactory sf) {
//        Session session = sf.openSession();
//        Transaction tx = session.beginTransaction();
//        Scanner sc = new Scanner(System.in);
//
//        try {
//            Medical medical = new Medical();
//
//            System.out.println("Welcome to Medical");
//
//            // Prompt for Patient ID and retrieve Patient entity
//            System.out.println("Enter Patient ID:");
//            int patientId = sc.nextInt();
//            sc.nextLine();  // Consume newline
//
//            Patient patient = session.get(Patient.class, patientId);
//            if (patient != null) {
//                medical.setPatient(patient);  // Associate Patient with Medical
//            } else {
//                System.out.println("Patient not found.");
//                return;
//            }
//
//            // Prompt for Doctor ID and retrieve Doctor entity
//            System.out.println("Enter Doctor ID:");
//            int doctorId = sc.nextInt();
//            sc.nextLine();
//
//            Doctor doctor = session.get(Doctor.class, doctorId);
//            if (doctor != null) {
//                medical.setDoctor(doctor);  // Associate Doctor with Medical
//            } else {
//                System.out.println("Doctor not found.");
//                return;
//            }
//
//            // Persisting the Medical record
//            session.persist(medical);
//            tx.commit();
//            System.out.println("The Medical record inserted successfully.");
//
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//            sc.close();
//        }
//    }
	
	
	public void insertMedical(SessionFactory sf) {
	    Session session = sf.openSession();
	    Transaction tx = null;
	    Scanner sc = new Scanner(System.in);

	    try {
	        tx = session.beginTransaction();

	        Medical medical = new Medical();
	        System.out.println("Welcome to Medical");

	        // Prompt for Patient ID and retrieve Patient entity
	        System.out.println("Enter Patient ID:");
	        int patientId = sc.nextInt();
	        Patient patient = session.get(Patient.class, patientId);

	        if (patient == null) {
	            System.out.println("Patient not found.");
	            return;
	        }
	        medical.setPatient(patient);

	        // Prompt for Doctor ID and retrieve Doctor entity
	        System.out.println("Enter Doctor ID:");
	        int doctorId = sc.nextInt();
	        Doctor doctor = session.get(Doctor.class, doctorId);

	        if (doctor == null) {
	            System.out.println("Doctor not found.");
	            return;
	        }
	        medical.setDoctor(doctor);

	        session.persist(medical);
	        tx.commit();
	        System.out.println("The Medical record inserted successfully.");

	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }

	        // Enhanced error logging
	        System.out.println("Error during insert: " + e.getClass().getSimpleName() + " - " + e.getMessage());
	        e.printStackTrace();  // Print the stack trace for deeper analysis
	    } finally {
	        try {
	            if (session != null && session.isOpen()) {
	                session.close();
	            }
	            sc.close();
	        } catch (Exception ex) {
	            System.out.println("Error while closing session/scanner: " + ex.getMessage());
	            ex.printStackTrace();
	        }
	    }
	}
//===========UPDATE MEDICAL==============================
	@Override
	public void updateMedical(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction(); // Start transaction

		// org.hibernate.Transaction tx= session.beginTransaction();

		try {
			while (true) {
				System.out.println("Choose an Option for Update "
						+ "\n1.Update PatientId \n2.update DoctorId \n3.Exit");

				int option = sc.nextInt();

				switch (option) {
					

				
				case 1:

					System.out.println("Enter Records Id:");
				 Medical	medical = session.get(Medical.class, sc.nextInt());
				 sc.nextLine();
				 
				 
				 
		 if (medical != null) {
					System.out.println("enter new Patient ID:");
					int newPatient_id = sc.nextInt(); 
					sc.nextLine();	
					

					// Assuming you have a method to get the Patient by ID
					
						Patient newPatient = session.get(Patient.class, newPatient_id);
					if (newPatient != null) {
							medical.setPatient(newPatient);							
							session.saveOrUpdate(medical);
							session.flush();
							System.out.println("Patient id updated successfully.");						
							tx.commit();
					} else {					
						System.out.println(" patient not found for the given ID.");
					}
					} else {
						System.out.println("medical not found for the given Id.");					
						}
					break;
					
				 	case 2:
					
					
					System.out.println("Enter Records Id:");
					 	medical = session.get(Medical.class, sc.nextInt());
						sc.nextLine();
					 	
						if (medical != null) {
							System.out.println("enter new Doctor ID:");
							int newDoctor_id = sc.nextInt();
	                         sc.nextLine();
							// Assuming you have a method to get the Patient by ID
							Doctor newDoctor = session.get(Doctor.class, newDoctor_id);
							if (newDoctor != null) {
								medical.setDoctor(newDoctor);
								session.saveOrUpdate(medical);
								session.flush();
								System.out.println("Doctor id updated successfully.");
								tx.commit();
							} else {
								System.out.println(" Doctor not found for the given ID.");
							}
						} else {
							System.out.println("medical not found for the given Id.");
						}
						break;
						
				 	
					
				 		
				 		
				 		

				case 3:
					System.out.println("Exiting update...");
					tx.commit();
					return;

				default:
					System.out.println("Choose correct option!!");
				}
			}
		} finally {
			session.close();
		}


		
	}
//delete medical===============================
	@Override
	public void deleteMedical(SessionFactory sf) {
       
	
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter medical id");
        int recordsId = sc.nextInt();
        Medical medical = session.get(Medical.class, recordsId);

        if (medical != null) {
            session.delete(medical);
            tx.commit();
            System.out.println("Medical deleted successfully.");
        } else {
            System.out.println("Please enter a valid Room Id.");
        }

        session.close();
		
		
		
		
	}
	//================select all records from medical======================

	@Override
	public void getAllMedical(SessionFactory sf) {
		
		
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Medical ");
        List<Medical> medicalList=query.getResultList();
        
        for(Medical m:medicalList) {
        	System.out.println(m);
        }

        
        
        tx.commit();
        session.close();

		
		
		
	}
//select specific record=======================
	@Override
	public void getMedical(SessionFactory sf) {
		
		
		
		session = sf.openSession();

        System.out.println("Enter recordsId:");
        int recordsId= sc.nextInt();
        Medical medical = session.get(Medical.class, recordsId);

        if (medical!= null) {
            System.out.println(medical);
        } else {
            System.out.println("medical not found for the given Id.");
        }

        session.close();

		
		
	}
//=====================count medical tables===========================
	@Override
	public void getMedicalInformation(SessionFactory sf) {
		
		session = sf.openSession();
    	
	       
        Query query = session.createQuery("select count(recordsId) from Medical");
        Long count = (Long) query.getSingleResult();

        System.out.println("Total number of Medical: " + count);
        session.close();
		
		
		
		
	}


}
