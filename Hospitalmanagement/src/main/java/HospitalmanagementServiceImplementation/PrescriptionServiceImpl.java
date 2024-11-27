package HospitalmanagementServiceImplementation;

import java.sql.Date;
import java.time.LocalDate;
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
import Hospitalmanagement.entities.Prescription;
import Hospitalmanagement.entities.Rooms;
import HospitalmanagementService.PrescriptionService;

public class PrescriptionServiceImpl implements PrescriptionService {
	Scanner sc = new Scanner(System.in);
	Session session;
	//========================INSERT prescription====================================
	@Override
	public void insertPrescription(SessionFactory sf) {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
			try {
				Prescription prescription = new Prescription();

						System.out.println("welcome to Prescription");

						System.out.println("enter Prescription id");
						int  Prescription_id = sc.nextInt();
						prescription.setPrescription_id(Prescription_id);
						sc.nextLine();
						
						System.out.println("enter Prescription Date");
						System.out.println("Enter event date (YYYY-MM-DD): ");
			            String dateInput = sc.nextLine();
			   
			                LocalDate eventDate = LocalDate.parse(dateInput);
			                prescription .setPrescription_date(Date.valueOf(eventDate));  // Convert LocalDate to java.sql.Date
			            
			               
			                

			   
			            //Patient is foreign key here
			                
			                System.out.println("Enter Patient ID:");
			                Patient patient = session.get(Patient.class, sc.nextInt());
			               
			              

			               
			                if (patient != null) {
			                	prescription.setPatient(patient);  // Associate Patient with prescription
			                } else {
			                    System.out.println("Patient not found.");
			                    return;
			                }
			//doctor is foreign key here
			   
			                System.out.println("Enter Doctor ID:");
			              //  int doctorId = sc.nextInt();
			              //  sc.nextLine();

			                Doctor doctor = session.get(Doctor.class, sc.nextInt());
			                if (doctor != null) {
			                	prescription.setDoctor(doctor);// Associate Doctor with Medical
			                	prescription.setPatient(patient);
			                } else {
			                    System.out.println("Doctor not found.");
			                    return;
			                }
			                session.persist(prescription);
			                tx.commit();
			                System.out.println("The prescription record inserted successfully.");

			            } catch (Exception e) {
			                if (tx != null) tx.rollback();
			                e.printStackTrace();
			            } finally {
			                session.close();
			               
			            }
			        }
			
//========================UPDATE Prescription================================
//	@Override
//	public void updatePrescription(SessionFactory sf) {
//		session = sf.openSession();
//		Transaction tx = session.beginTransaction(); // Start transaction
//
//		// org.hibernate.Transaction tx= session.beginTransaction();
//
//		try {
//			while (true) {
//				System.out.println("Choose an Option for Update "
//						+ "\n1.Update Prescription Date \n2. Update PatientId \n3.update DoctorId \n4.Exit");
//
//				int option = sc.nextInt();
//				switch (option) {
//				case 1:
//					System.out.println("Enter Prescription Id:");
//					Prescription prescription = session.get(Prescription.class, sc.nextInt());
//                       
//				    sc.nextLine(); 
//					if (prescription != null) {
//						System.out.println("Update Prescription Date:");
//						   String dateInput = sc.nextLine().trim();
//						   
//						   if (dateInput.isEmpty()) {
//							    System.out.println("Date input cannot be empty. Please enter a valid date in YYYY-MM-DD format.");
//							    return; // Exit or prompt for input again
//							}
//						   
//						   try {
//						LocalDate eventDate = LocalDate.parse(dateInput);
//		                prescription .setPrescription_date(Date.valueOf(eventDate));
//		                tx = session.beginTransaction();
//						session.saveOrUpdate(prescription);
//						tx.commit();
//
//						System.out.println("Prescription date updated successfully");
//						
//						   } catch (Exception e) {
//					            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
//					        }
//					} else {
//						System.out.println("Prescription not found for the given Id");
//					}
//					break;
//				
//	
//					
//				case 2:
//
//					System.out.println("Enter Prescription   Id:");
//					Prescription	prescription1  = session.get(Prescription.class, sc.nextInt());
//					
//				    sc.nextLine(); 
//		 if (prescription1  != null) {
//					System.out.println("enter new Patient ID:");
//					int newPatient_id = sc.nextInt(); 
//					sc.nextLine();						
//					// Assuming you have a method to get the Patient by ID
//					
//						Patient newPatient = session.get(Patient.class, newPatient_id);
//					if (newPatient != null) {
//						   tx = session.beginTransaction();
//						prescription1 .setPatient(newPatient);							
//							session.saveOrUpdate(prescription1);
//							session.flush();
//							System.out.println("Patient id updated successfully.");						
//							
//					} else {					
//						System.out.println(" patient not found for the given ID.");
//					}
//					} else {
//						System.out.println("medical not found for the given Id.");					
//						}
//					break;
//					
//				case 3:
//					System.out.println("Enter prescription Id:");
//	   	     prescription = session.get( Prescription.class, sc.nextInt());
//	   	  sc.nextLine();
//					if ( prescription != null) {
//						System.out.println("enter new Doctor ID:");
//						int newDoctor_id = sc.nextInt();
//                         sc.nextLine();
//						// Assuming you have a method to get the Patient by ID
//						Doctor newDoctor = session.get(Doctor.class, newDoctor_id);
//						if (newDoctor != null) {
//							   tx = session.beginTransaction();
//							 prescription.setDoctor(newDoctor);
//							session.saveOrUpdate( prescription);
//							tx.commit();
//							System.out.println(" Doctor id updated successfully.");
//						} else {
//							System.out.println("Doctor not found for the given ID.");
//						}
//					} else {
//						System.out.println(" prescription not found for the given Id.");
//					}
//					break;
//					
//				
//				case 4:
//					System.out.println("Exiting update...");
//					tx.commit();
//					return;
//
//				default:
//					System.out.println("Choose correct option!!");
//				 }
//	        }
//	    } catch (Exception e) {
//	        if (tx != null) tx.rollback(); // Rollback if any exception occurs
//	        e.printStackTrace();
//	    } finally {
//	        session.close();
//	    }
//	}
	@Override
	public void updatePrescription(SessionFactory sf) {
	    session = sf.openSession();
	    Transaction tx = session.beginTransaction(); // Start transaction only once

	    try {
	        while (true) {
	            System.out.println("Choose an Option for Update "
	                    + "\n1.Update Prescription Date \n2. Update PatientId \n3.update DoctorId \n4.Exit");

	            int option = sc.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter Prescription Id:");
	                    Prescription prescription = session.get(Prescription.class, sc.nextInt());
	                    sc.nextLine(); // Consume newline character after nextInt()

	                    if (prescription != null) {
	                        System.out.println("Update Prescription Date:");
	                        String dateInput = sc.nextLine().trim();

	                        if (dateInput.isEmpty()) {
	                            System.out.println("Date input cannot be empty. Please enter a valid date in YYYY-MM-DD format.");
	                            return; // Exit or prompt for input again
	                        }

	                        try {
	                            // Try to parse the date
	                            LocalDate eventDate = LocalDate.parse(dateInput);
	                            prescription.setPrescription_date(Date.valueOf(eventDate));
	                            session.saveOrUpdate(prescription);  // Save or update the prescription

	                            System.out.println("Prescription date updated successfully");

	                        } catch (Exception e) {
	                            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
	                        }
	                    } else {
	                        System.out.println("Prescription not found for the given Id");
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter Prescription Id:");
	                    Prescription prescription1 = session.get(Prescription.class, sc.nextInt());
	                    sc.nextLine(); // Consume newline character after nextInt()

	                    if (prescription1 != null) {
	                        System.out.println("Enter new Patient ID:");
	                        int newPatientId = sc.nextInt();
	                        sc.nextLine(); // Consume newline character after nextInt()

	                        Patient newPatient = session.get(Patient.class, newPatientId);
	                        if (newPatient != null) {
	                            prescription1.setPatient(newPatient);
	                            session.saveOrUpdate(prescription1);
	                            System.out.println("Patient ID updated successfully.");
	                        } else {
	                            System.out.println("Patient not found for the given ID.");
	                        }
	                    } else {
	                        System.out.println("Prescription not found for the given Id.");
	                    }
	                    break;

	                case 3:
	                    System.out.println("Enter Prescription Id:");
	                    Prescription prescription2 = session.get(Prescription.class, sc.nextInt());
	                   // sc.nextLine(); // Consume newline character after nextInt()

	                    if (prescription2 != null) {
	                        System.out.println("Enter new Doctor ID:");
	                        int newDoctorId = sc.nextInt();
	                       // sc.next(); // Consume newline character after nextInt()

	                        Doctor newDoctor = session.get(Doctor.class, newDoctorId);
	                        if (newDoctor != null) {
	                            prescription2.setDoctor(newDoctor);
	                            newDoctor.
	                            session.saveOrUpdate(prescription2);
	                            System.out.println("Doctor ID updated successfully.");
	                        } else {
	                            System.out.println("Doctor not found for the given ID.");
	                        }
	                    } else {
	                        System.out.println("Prescription not found for the given Id.");
	                    }
	                    break;

	                case 4:
	                    System.out.println("Exiting update...");
	                    tx.commit();  // Commit the transaction once all updates are done
	                    return;

	                default:
	                    System.out.println("Choose a correct option!");
	            }
	        }
	    } catch (Exception e) {
	        if (tx != null) tx.rollback(); // Rollback if any exception occurs
	        e.printStackTrace();
	    } finally {
	        session.close(); // Ensure the session is closed after the operation
	    }
	}
				
		
	
//============delete prescription===============================
	@Override
	public void deletePrescription(SessionFactory sf) {
		
		
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter prescription id");
        int prescription_id = sc.nextInt();
        Prescription prescription = session.get(Prescription.class,  prescription_id);

        if (prescription != null) {
            session.delete(prescription);
            tx.commit();
            System.out.println("prescription deleted successfully.");
        } else {
            System.out.println("Please enter a valid prescription Id.");
        }

        session.close();
	}

		
		
		
	
//=================================select prescription=======================
	@Override
	public void getAllPrescription(SessionFactory sf) {
		
		
		
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Prescription");
        List<Prescription>prescriptionList=query.getResultList();
        
        for(Prescription pr:prescriptionList) {
        	System.out.println(pr);
        }

        
        
        tx.commit();
        session.close();
		
		
		
		
	}

	//==========================SELECT PRESCRIPTION =============================================
	@Override
	public void getPrescription(SessionFactory sf) {
	
		
		

		session = sf.openSession();

        System.out.println("Enter Prescription_id:");
        int Prescription_id= sc.nextInt();
        Prescription prescription = session.get(Prescription.class, Prescription_id);

        if (prescription!= null) {
            System.out.println(prescription);
        } else {
            System.out.println("Prescription not found for the given Id.");
        }

        session.close();

		
		
		
	}
	
	//========================get prescription information========================

	@Override
	public void getPrescriptionInformation(SessionFactory sf) {
		
		
		session = sf.openSession();
    	
	       
        Query query = session.createQuery("select count(Prescription_id) from Prescription");
        Long count = (Long) query.getSingleResult();

        System.out.println("Total number of Prescriptions: " + count);
        session.close();
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
}
