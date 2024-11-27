package HospitalmanagementServiceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Hospitalmanagement.entities.Billing;
import Hospitalmanagement.entities.Doctor;
import Hospitalmanagement.entities.Patient;
import HospitalmanagementService.BillingService;
import HospitalmanagementService.DoctorService;

public class DoctorServiceImpl implements DoctorService{
	Scanner sc = new Scanner(System.in);
	Session session;
	@Override
	public void insertDoctor(SessionFactory sf) {
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    try {
	        Doctor doctor = new Doctor();

	        System.out.println("Welcome to Doctor");

	        System.out.println("Enter Doctor ID:");
	        int doctor_id = sc.nextInt();
	        sc.nextLine();  // Consume newline
	        doctor.setDoctor_id(doctor_id);

	        System.out.println("Enter Doctor Name:");
	        String name = sc.next();
	        doctor.setName(name);

	        System.out.println("Enter Doctor Email:");
	        String email = sc.next();
	        doctor.setEmail(email);

	        System.out.println("Enter Availability:");
	        String availability = sc.next();
	        doctor.setAvailability(availability);

	        System.out.println("Enter Specialization:");
	        String specialization = sc.next();
	        doctor.setSpecialization(specialization);

	        System.out.println("Enter Experience:");
	        String experience = sc.next();
	        doctor.setExperience(experience);

	        System.out.println("Enter Contact:");
	        long contact = sc.nextLong();
	        doctor.setContact(contact);

	        session.persist(doctor);
	        tx.commit();
	    } finally {
	        session.close();
	    } // Closing brace for try-finally
	} // Closing brace for insertDoctor method
	
	
	
	//====================UPDATE Doctor=========================
	@Override
	public void updateDoctor(SessionFactory sf) {
		session = sf.openSession();
		Scanner sc=new Scanner(System.in);
		Transaction tx = session.beginTransaction(); // Start transaction

		// org.hibernate.Transaction tx= session.beginTransaction();

		try {
			while (true) {
				System.out.println("Choose an Option for Update "
						+ " \n1.Update  Doctor name \n2.Update Doctor email \n3.update Doctor availability \n4.update Doctor specialization \n5.update Doctor experience \n6.update Doctor contact \n7. Exit");

				int option = sc.nextInt();
	
	            
				switch (option) {
				case 1:
					System.out.println("Enter Doctor Id:");
					Doctor doctor = session.get(Doctor.class, sc.nextInt());

					if (doctor != null) {
						System.out.println("Update name:");
						doctor.setName(sc.next());

						session.saveOrUpdate(doctor);
						tx.commit();

						System.out.println("Doctor id updated successfully");
					} else {
						System.out.println("Doctor not found for the given Id");
					}
					break;

				case 2:
					System.out.println("Enter  Doctor id:");
					doctor	 = session.get(Doctor.class, sc.nextInt());

						if (doctor!= null) {
							System.out.println("Update doctor email:");
							doctor.setEmail(sc.next());
							session.saveOrUpdate(doctor);
							session.flush();
							tx.commit();

							System.out.println("Doctor email updated successfully.");
						} else {
							System.out.println("Doctor not found for the given Id.");
						}
					
					break;

				case 3:

					System.out.println("Enter doctor id:");
					doctor = session.get(Doctor.class, sc.nextInt());

					if (doctor != null) {
						System.out.println("Update doctor availability:");
						doctor.setAvailability(sc.next());

						session.saveOrUpdate(doctor);
						tx.commit();

						System.out.println("Doctor availability updated successfully.");
					} else {
						System.out.println("Doctor not found for the given Id.");
					}
					break;

				case 4:

					System.out.println("Enter Doctor Id:");
					doctor = session.get(Doctor.class, sc.nextInt());
					if ( doctor!= null) {
						System.out.println("enter  doctor Specialization :");
						doctor  .setSpecialization(sc.next());
                   
				         
				         session.saveOrUpdate(doctor);
				         tx.commit();
				         
				         System.out.println("Doctor Specilalization updated successfully.");
						} else {
						System.out.println("Doctor not found for the given Id.");
					}
					break;
                 
				case 5:
					System.out.println("Enter Doctor Id:");
					doctor = session.get(Doctor.class, sc.nextInt());
					if ( doctor!= null) {
						System.out.println("enter  doctor Experience :");
						doctor.setExperience(sc.next());
                   
				         
				         session.saveOrUpdate(doctor);
				         tx.commit();
				         
				         System.out.println("Doctor Experience updated successfully.");
						} else {
						System.out.println("Doctor not found for the given Id.");
					}
					break;
                 
					
				case 6:
					System.out.println("Enter Doctor Id:");
					doctor = session.get(Doctor.class, sc.nextInt());
					if ( doctor!= null) {
						System.out.println("enter  doctor contact :");
						doctor.setContact(sc.nextLong());
                   
				         
				         session.saveOrUpdate(doctor);
				         tx.commit();
				         
				         System.out.println("Doctor Contact updated successfully.");
						} else {
						System.out.println("Doctor not found for the given Id.");
					}
					break;
					
				case 7:
					System.out.println("Exiting update...");
					return;

				default:
					System.out.println("Choose correct option!!");
				}
			}
		} finally {
			session.close();
			sc.close();
		}

		
	}
//	@Override
//	public void updateDoctor(SessionFactory sf) {
//	    session = sf.openSession();
//	    Scanner sc = new Scanner(System.in);
//	    Transaction tx = null; // Declare tx here to handle it properly within the loop
//
//	    try {
//	        while (true) {
//	            // Start the transaction before each loop
//	            tx = session.beginTransaction();
//
//	            System.out.println("Choose an Option for Update "
//	                    + " \n1.Update Doctor name \n2.Update Doctor email \n3.Update Doctor availability \n4.Update Doctor specialization \n5.Update Doctor experience \n6.Update Doctor contact \n7. Exit");
//
//	            // Check if the next input is a valid integer option
//	            if (sc.hasNextInt()) {
//	                int option = sc.nextInt();
//	              //  sc.nextLine(); // Consume the newline left by nextInt()
//
//	                Doctor doctor = null; // Declare doctor variable
//
//	                switch (option) {
//	                    case 1:
//	                        System.out.println("Enter Doctor Id:");
//	                        if (sc.hasNextInt()) {
//	                            int doctorId = sc.nextInt();
//	                            sc.nextLine(); // Consume the newline
//	                            doctor = session.get(Doctor.class, doctorId);
//	                            if (doctor != null) {
//	                                System.out.println("Update name:");
//	                                doctor.setName(sc.nextLine());  // Consume the full input
//	                                session.saveOrUpdate(doctor);
//	                                System.out.println("Doctor name updated successfully.");
//	                            } else {
//	                                System.out.println("Doctor not found for the given Id");
//	                            }
//	                        } else {
//	                            System.out.println("Invalid Doctor ID input.");
//	                           // sc.nextLine(); // Consume the invalid input
//	                        }
//	                        break;
//
//	                    case 2:
//	                        System.out.println("Enter Doctor Id:");
//	                        if (sc.hasNextInt()) {
//	                            int doctorId = sc.nextInt();
//	                            sc.nextLine(); // Consume the newline
//	                            doctor = session.get(Doctor.class, doctorId);
//	                            if (doctor != null) {
//	                                System.out.println("Update doctor email:");
//	                                doctor.setEmail(sc.nextLine());  // Consume the full input
//	                                session.saveOrUpdate(doctor);
//	                                System.out.println("Doctor email updated successfully.");
//	                            } else {
//	                                System.out.println("Doctor not found for the given Id.");
//	                            }
//	                        } else {
//	                            System.out.println("Invalid Doctor ID input.");
//	                          //  sc.nextLine(); // Consume the invalid input
//	                        }
//	                        break;
//
//	                    case 3:
//	                        System.out.println("Enter Doctor Id:");
//	                        if (sc.hasNextInt()) {
//	                            int doctorId = sc.nextInt();
//	                            sc.nextLine(); // Consume the newline
//	                            doctor = session.get(Doctor.class, doctorId);
//	                            if (doctor != null) {
//	                                System.out.println("Update doctor availability:");
//	                                doctor.setAvailability(sc.nextLine());  // Consume the full input
//	                                session.saveOrUpdate(doctor);
//	                                System.out.println("Doctor availability updated successfully.");
//	                            } else {
//	                                System.out.println("Doctor not found for the given Id.");
//	                            }
//	                        } else {
//	                            System.out.println("Invalid Doctor ID input.");
//	                           // sc.nextLine(); // Consume the invalid input
//	                        }
//	                        break;
//
//	                    case 4:
//	                        System.out.println("Enter Doctor Id:");
//	                        if (sc.hasNextInt()) {
//	                            int doctorId = sc.nextInt();
//	                            sc.nextLine(); // Consume the newline
//	                            doctor = session.get(Doctor.class, doctorId);
//	                            if (doctor != null) {
//	                                System.out.println("Enter doctor specialization:");
//	                                doctor.setSpecialization(sc.nextLine());  // Consume the full input
//	                                session.saveOrUpdate(doctor);
//	                                System.out.println("Doctor specialization updated successfully.");
//	                            } else {
//	                                System.out.println("Doctor not found for the given Id.");
//	                            }
//	                        } else {
//	                            System.out.println("Invalid Doctor ID input.");
//	                           // sc.nextLine(); // Consume the invalid input
//	                        }
//	                        break;
//
//	                    case 5:
//	                        System.out.println("Enter Doctor Id:");
//	                        if (sc.hasNextInt()) {
//	                            int doctorId = sc.nextInt();
//	                            sc.nextLine(); // Consume the newline
//	                            doctor = session.get(Doctor.class, doctorId);
//	                            if (doctor != null) {
//	                                System.out.println("Enter doctor experience:");
//	                                doctor.setExperience(sc.nextLine());  // Consume the full input
//	                                session.saveOrUpdate(doctor);
//	                                System.out.println("Doctor experience updated successfully.");
//	                            } else {
//	                                System.out.println("Doctor not found for the given Id.");
//	                            }
//	                        } else {
//	                            System.out.println("Invalid Doctor ID input.");
//	                          //  sc.nextLine(); // Consume the invalid input
//	                        }
//	                        break;
//	                        tx.commit();
//
//	                    case 6:
//	                        System.out.println("Enter Doctor Id:");
//	                        if (sc.hasNextInt()) {
//	                            int doctorId = sc.nextInt();
//	                            sc.nextLine(); // Consume the newline
//	                            doctor = session.get(Doctor.class, doctorId);
//	                            if (doctor != null) {
//	                                System.out.println("Enter doctor contact:");
//	                                doctor.setContact(sc.nextLong());  // Read long for contact number
//	                                sc.nextLine(); // Consume the newline after nextLong()
//	                                session.saveOrUpdate(doctor);
//	                                System.out.println("Doctor contact updated successfully.");
//	                            } else {
//	                                System.out.println("Doctor not found for the given Id.");
//	                            }
//	                        } else {
//	                            System.out.println("Invalid Doctor ID input.");
//	                           // sc.nextLine(); // Consume the invalid input
//	                        }
//	                        break;
//
//	                    case 7:
//	                        System.out.println("Exiting update...");
//	                        return;
//
//	                    default:
//	                        System.out.println("Choose correct option!!");
//	                }
//
//	                // Commit the transaction after an update operation is successful
//	                 // Commit the transaction at the end of each loop iteration
//	            } else {
//	                System.out.println("Invalid option input.");
//	                sc.nextLine(); // Consume the invalid input
//	            }
//	        }
//	    } catch (Exception e) {
//	        // Rollback transaction in case of any exception
//	        if (tx != null && tx.isActive()) {
//	            tx.rollback();
//	        }
//	        e.printStackTrace();
//	    } finally {
//	        // Ensure the session is closed after all operations
//	        session.close();
//	        sc.close();
//	    }
//	}
	//=======================Delete Doctor=========================================
	@Override
	public void deleteDoctor(SessionFactory sf) {
		
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        try {
        	System.out.println("Enter Doctor id");
            int doctor_id = sc.nextInt();
            Doctor doctor = session.get(Doctor.class, doctor_id);

            if (doctor != null) {
                tx.commit();
                System.out.println("Doctor deleted successfully.");
            } else {
                System.out.println("Please enter a valid doctor Id.");
            }
        }
        finally {
        	session.close();
        }

        
	}
	@Override
	public void getAllDoctor(SessionFactory sf) {
		session = sf.openSession();
        Transaction tx = session.beginTransaction();
  try {
        Query query = session.createQuery("from Doctor");
        List<Doctor> doctorList=query.getResultList();
        
        for(Doctor b:doctorList) {
        	System.out.println(b);
        }
	}
  finally {
	  session.close();
  }
	}
	@Override
	public void getDoctor(SessionFactory sf) {
		session = sf.openSession();

        System.out.println("Enter Doctor_id:");
        int doctor_id= sc.nextInt();
        Doctor doctor = session.get(Doctor.class, doctor_id);

        if (doctor != null) {
            System.out.println(doctor);
        } else {
            System.out.println("Doctor not found for the given Id.");
        }

        session.close();

		
		
	}
	@Override
	public void getDoctorInformation(SessionFactory sf) {
		session = sf.openSession();
    	
	       
        Query query = session.createQuery("select count(doctor_id) from Doctor");
        Long count = (Long) query.getSingleResult();

        System.out.println("Total number of doctors: " + count);
        session.close();
        } 
        
        
		
	}
	
	
	