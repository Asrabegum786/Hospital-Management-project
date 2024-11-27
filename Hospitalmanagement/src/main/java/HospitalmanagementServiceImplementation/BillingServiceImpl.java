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

public class BillingServiceImpl implements BillingService {
	Scanner sc = new Scanner(System.in);
	Session session;
//====================billing insert=========================================
	@Override
	public void insertBilling(SessionFactory sf) {

		Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
		try {
			Billing billing = new Billing();

			System.out.println("welcome to billing");

			System.out.println("enter billing id");
			int billing_id = sc.nextInt();
			sc.nextLine();
			billing.setBilling_id(billing_id);

			System.out.println("welcome to payment status");
			String status = sc.nextLine();
			billing.setPayment_status(status);

			System.out.println("welcome to payment amount");
			long amount = sc.nextLong();
			billing.setPayment_amount(amount);

			System.out.println("welcome to payment method");
			String method = sc.next();
			billing.setPayment_method(method);

			System.out.println("enter Patient_id:");
			int Patient_id = sc.nextInt();
			

			Patient patient = session.get(Patient.class, Patient_id);
			if (patient != null) {
				billing.setPatient_id(patient);
			} else {
				System.out.println("The bill is not paid for the patint_id:");
				return;
			}
			session.persist(billing);
			tx.commit();
		} finally {
			session.close();

		}

	}
//============================UPDATE Billing======================
//	@Override
//	public void updateBilling(SessionFactory sf) {
//		session = sf.openSession();
//		Transaction tx = session.beginTransaction(); // Start transaction
//
//		// org.hibernate.Transaction tx= session.beginTransaction();
//
//		try {
//			while (true) {
//				System.out.println("Choose an Option for Update "
//						+ "\n1.Update payment status \n2.Update payment amount \n3.Update payment method \n4.update PatientId \n5.Exit");
//
//				int option = sc.nextInt();
//				switch (option) {
//				case 1:
//					System.out.println("Enter billing Id:");
//					Billing billing = session.get(Billing.class, sc.nextInt());
//
//					if (billing != null) {
//						System.out.println("Update payment status:");
//						billing.setPayment_status(sc.next());
//
//						session.saveOrUpdate(billing);
//						tx.commit();
//
//						System.out.println("Payment status updated successfully");
//					} else {
//						System.out.println("billing not found for the given Id");
//					}
//					break;
//
//				case 2:
//					System.out.println("Enter billing id:");
//					try {
//						billing = session.get(Billing.class, sc.nextInt());
//
//						if (billing != null) {
//							System.out.println("Update payment amount:");
//							billing.setPayment_amount(sc.nextLong());
//							session.saveOrUpdate(billing);
//							session.flush();
//							tx.commit();
//
//							System.out.println("Payment amount updated successfully.");
//						} else {
//							System.out.println("Billing not found for the given Id.");
//						}
//
//					} finally {
//						System.out.println("Succeed!");
//					}
//					break;
//
//				case 3:
//
//					System.out.println("Enter billing id:");
//					billing = session.get(Billing.class, sc.nextInt());
//
//					if (billing != null) {
//						System.out.println("Update payment method:");
//						billing.setPayment_method(sc.next());
//
//						session.saveOrUpdate(billing);
//						tx.commit();
//
//						System.out.println("Payment method updated successfully.");
//					} else {
//						System.out.println("Billing not found for the given Id.");
//					}
//					break;
//
//				case 4:
//
//					System.out.println("Enter billing Id:");
//					billing = session.get(Billing.class, sc.nextInt());
//					if (billing != null) {
//						System.out.println("enter Patient ID:");
//						int newPatient_id = sc.nextInt();
//                         sc.nextLine();
//						// Assuming you have a method to get the Patient by ID
//						Patient newPatient = session.get(Patient.class, newPatient_id);
//						if (newPatient != null) {
//							billing.setPatient(newPatient);
//							session.saveOrUpdate(billing);
//							tx.commit();
//							System.out.println("Patient id updated successfully.");
//						} else {
//							System.out.println(" patient not found for the given ID.");
//						}
//					} else {
//						System.out.println("billing not found for the given Id.");
//					}
//					break;
//
//				case 5:
//					System.out.println("Exiting update...");
//					return;
//
//				default:
//					System.out.println("Choose correct option!!");
//				}
//			}
//		} finally {
//			session.close();
//		}
//
//	}
	@Override
	public void updateBilling(SessionFactory sf) {
	    session = sf.openSession();
	    Transaction tx = null; // Declare tx here

	    try {
	        while (true) {
	            // Start transaction before each loop iteration
	            tx = session.beginTransaction();

	            System.out.println("Choose an Option for Update "
	                    + "\n1.Update payment status \n2.Update payment amount \n3.Update payment method \n4.update PatientId \n5.Exit");

	            int option = sc.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter billing Id:");
	                    Billing billing = session.get(Billing.class, sc.nextInt());

	                    if (billing != null) {
	                        System.out.println("Update payment status:");
	                        billing.setPayment_status(sc.next());

	                        session.saveOrUpdate(billing);
	                        // Commit the transaction after the update
	                        tx.commit();
	                        System.out.println("Payment status updated successfully");
	                    } else {
	                        System.out.println("Billing not found for the given Id");
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter billing id:");
	                    billing = session.get(Billing.class, sc.nextInt());

	                    if (billing != null) {
	                        System.out.println("Update payment amount:");
	                        billing.setPayment_amount(sc.nextLong());
	                        session.saveOrUpdate(billing);
	                        // No need to call session.flush(), just commit after saveOrUpdate
	                        tx.commit();
	                        System.out.println("Payment amount updated successfully.");
	                    } else {
	                        System.out.println("Billing not found for the given Id.");
	                    }
	                    break;

	                case 3:
	                    System.out.println("Enter billing id:");
	                    billing = session.get(Billing.class, sc.nextInt());

	                    if (billing != null) {
	                        System.out.println("Update payment method:");
	                        billing.setPayment_method(sc.next());

	                        session.saveOrUpdate(billing);
	                        tx.commit();
	                        System.out.println("Payment method updated successfully.");
	                    } else {
	                        System.out.println("Billing not found for the given Id.");
	                    }
	                    break;

	                case 4:
	                    System.out.println("Enter billing Id:");
	                    billing = session.get(Billing.class, sc.nextInt());
	                    if (billing != null) {
	                        System.out.println("Enter Patient ID:");
	                        int newPatientId = sc.nextInt();
	                        sc.nextLine(); // Consume the newline character

	                        // Assuming you have a method to get the Patient by ID
	                        Patient newPatient = session.get(Patient.class, newPatientId);
	                        if (newPatient != null) {
	                            billing.setPatient(newPatient);
	                            session.saveOrUpdate(billing);
	                            tx.commit();  // Commit after all the operations for this case
	                            System.out.println("Patient ID updated successfully.");
	                        } else {
	                            System.out.println("Patient not found for the given ID.");
	                        }
	                    } else {
	                        System.out.println("Billing not found for the given Id.");
	                    }
	                    break;

	                case 5:
	                    System.out.println("Exiting update...");
	                    return;

	                default:
	                    System.out.println("Choose correct option!!");
	            }
	        }
	    } catch (Exception e) {
	        // If there is an exception, rollback the transaction
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        // Ensure session is closed
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}

	//======================DELETE BILLING=================================

	@Override
	public void deleteBilling(SessionFactory sf) {
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Billing id");
        int billing_id = sc.nextInt();
        Billing billing = session.get(Billing.class, billing_id);

        if (billing != null) {
            session.delete(billing);
            tx.commit();
            System.out.println("Billing deleted successfully.");
        } else {
            System.out.println("Please enter a valid billing Id.");
        }

        session.close();
	}



//==================SELECT * FROM CART===========================

	@Override
	public void getAllBilling(SessionFactory sf) {
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Billing");
        List<Billing> billingList=query.getResultList();
        
        for(Billing b:billingList) {
        	System.out.println(b);
        }

        
        
        tx.commit();
        session.close();

	}
	


	
//=======SPECIFIC Record=====================
	@Override
	public void getBilling(SessionFactory sf) {
	        session = sf.openSession();

	        System.out.println("Enter billing_id:");
	        int billing_id= sc.nextInt();
	        Billing billing = session.get(Billing.class, billing_id);

	        if (billing != null) {
	            System.out.println(billing);
	        } else {
	            System.out.println("Billing not found for the given Id.");
	        }

	        session.close();

			
		}



//======================getBillingInformation================================

	@Override
	public void getBillingInformation(SessionFactory sf) {
		session = sf.openSession();
        	
       
        Query query = session.createQuery("select count(Billing_id) from Billing");
        Long count = (Long) query.getSingleResult();

        System.out.println("Total number of billings: " + count);
        session.close();
        } 
        
        
        
		

	}
	

