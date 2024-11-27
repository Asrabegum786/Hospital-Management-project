package Hospitalmanagement.main;

import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Hospitalmanagement.Utility.RoomUNAvailabilityException;

import HospitalmanagementServiceImplementation.PatientServiceImpl;
import HospitalmanagementServiceImplementation.DoctorServiceImpl;
import HospitalmanagementServiceImplementation.BillingServiceImpl;
import HospitalmanagementServiceImplementation.MedicalServiceImpl;
import HospitalmanagementServiceImplementation.PrescriptionServiceImpl;
import HospitalmanagementServiceImplementation.RoomsServiceImpl;


public class HospitalManagementOperations {

    public static void main(String[] args) {
        // Initialize Hibernate SessionFactory
        Configuration cf = new Configuration();
        cf.configure("config.xml");  // Hibernate configuration file
        SessionFactory factory = null;
        factory = cf.buildSessionFactory();
        Scanner sc = new Scanner(System.in);
        try {
        
            while (true) {
                System.out.println("Select an Entity to Manage:" +
                        "\n1. Patient" +
                        "\n2. Doctor" +
                        "\n3. Billing" +
                        "\n4. Medical" +
                        "\n5. Prescription" +
                        "\n6. Rooms" +
                        "\n7. Exit");

                int serviceOption = sc.nextInt();
                switch (serviceOption) {
                    case 1:
                        managePatient(sc, factory);
                        break;
                    case 2:
                        manageDoctor(sc, factory);
                        break;
                    case 3:
                        manageBilling(sc, factory);
                        break;
                    case 4:
                        manageMedical(sc, factory);
                        break;
                    case 5:
                        managePrescription(sc, factory);
                        break;
                    case 6:
                        manageRooms(sc, factory);
                        break;
                    case 7:
                        System.out.println("Exiting the application");
                        System.exit(0); // Exit the application
                    default:
                        System.out.println("Enter a valid option!");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close resources safely
            if (factory != null) {
                factory.close();
            }
            if (sc != null) {
                sc.close();
            }
            
        }
    }

    // Manage Rooms
    private static void manageRooms(Scanner sc, SessionFactory factory) throws RoomUNAvailabilityException {
        RoomsServiceImpl roomsService = new RoomsServiceImpl();
        while (true) {
            System.out.println("Select Room Option" +
                    "\n1. Insert\n2. Update\n3. Delete\n4. Select All\n5. Get a Specific Record\n6. Count of All Records\n7. Exit");

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    roomsService.insertRooms(factory);
                    break;
                case 2:
                    roomsService.updateRooms(factory);
                    break;
                case 3:
                    roomsService.deleteRooms(factory);
                    break;
                case 4:
                    roomsService.getAllRooms(factory);
                    break;
                case 5:
                    roomsService.getRooms(factory);
                    break;
                case 6:
                    roomsService.getRoomsInformation(factory);
                    break;
                case 7:
                    System.exit(0); // Go back to main menu
                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }
    }

    // Manage Prescription
    private static void managePrescription(Scanner sc, SessionFactory factory) {
        PrescriptionServiceImpl prescriptionService = new PrescriptionServiceImpl();
        while (true) {
            System.out.println("Select Prescription Option" +
                    "\n1. Insert\n2. Update\n3. Delete\n4. Select All\n5. Get a Specific Record\n6. Count of All Records\n7. Exit");

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    prescriptionService.insertPrescription(factory);
                    break;
                case 2:
                    prescriptionService.updatePrescription(factory);
                    break;
                case 3:
                    prescriptionService.deletePrescription(factory);
                    break;
                case 4:
                    prescriptionService.getAllPrescription(factory);
                    break;
                case 5:
                    prescriptionService.getPrescription(factory);
                    break;
                case 6:
                    prescriptionService.getPrescriptionInformation(factory);
                    break;
                case 7:
                	System.exit(0); // Go back to main menu
                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }
    }

    // Manage Medical
    private static void manageMedical(Scanner sc, SessionFactory factory) {
        MedicalServiceImpl medicalService = new MedicalServiceImpl();
        while (true) {
            System.out.println("Select Medical Option" +
                    "\n1. Insert\n2. Update\n3. Delete\n4. Select All\n5. Get a Specific Record\n6. Count of All Records\n7. Exit");

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    medicalService.insertMedical(factory);
                    break;
                case 2:
                    medicalService.updateMedical(factory);
                    break;
                case 3:
                    medicalService.deleteMedical(factory);
                    break;
                case 4:
                    medicalService.getAllMedical(factory);
                    break;
                case 5:
                    medicalService.getMedical(factory);
                    break;
                case 6:
                    medicalService.getMedicalInformation(factory);
                    break;
                case 7:
                	System.exit(0); // Go back to main menu
                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }
    }

    // Manage Billing
    private static void manageBilling(Scanner sc, SessionFactory factory) {
        BillingServiceImpl billingService = new BillingServiceImpl();
        while (true) {
            System.out.println("Select Billing Option" +
                    "\n1. Insert\n2. Update\n3. Delete\n4. Select All\n5. Get a Specific Record\n6. Count of All Records\n7. Exit");

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    billingService.insertBilling(factory);
                    break;
                case 2:
                    billingService.updateBilling(factory);
                    break;
                case 3:
                    billingService.deleteBilling(factory);
                    break;
                case 4:
                    billingService.getAllBilling(factory);
                    break;
                case 5:
                    billingService.getBilling(factory);
                    break;
                case 6:
                    billingService.getBillingInformation(factory);
                    break;
                case 7:
                	System.exit(0); // Go back to main menu
                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }
    }

 // Manage Doctors
    private static void manageDoctor(Scanner sc, SessionFactory factory) {
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        while (true) {
            System.out.println("Select Doctor Option" +
                    "\n1. Insert\n2. Update\n3. Delete\n4. Select All\n5. Get a Specific Record\n6. Count of All Records\n7. Exit");

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    doctorService.insertDoctor(factory);
                    break;
                case 2:
                    doctorService.updateDoctor(factory);
                    break;
                case 3:
                    doctorService.deleteDoctor(factory);
                    break;
                case 4:
                    doctorService.getAllDoctor(factory);
                    break;
                case 5:
                    doctorService.getDoctor(factory);
                    break;
                case 6:
                    doctorService.getDoctorInformation(factory);
                    break;
                case 7:
                    return; // Exit and return to the main menu
                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }
    }
    // Manage Patients
    private static void managePatient(Scanner sc, SessionFactory factory) {
        PatientServiceImpl patientService = new PatientServiceImpl();
        while (true) {
            System.out.println("Select Patient Option" +
                    "\n1. Insert\n2. Update\n3. Delete\n4. Select All\n5. Get a Specific Record\n6. Count of All Records\n7. Exit");

            int option = sc.nextInt();
            switch (option) {
                case 1:
                    patientService.insertPatient(factory);
                    break;
                case 2:
                    patientService.updatePatient(factory);
                    break;
                case 3:
                    patientService.deletePatient(factory);
                    break;
                case 4:
                    patientService.getAllPatient(factory);
                    break;
                case 5:
                    patientService.getPatient(factory);
                    break;
                case 6:
                    patientService.getPatientInformation(factory);
                    break;
                case 7:
                	System.exit(0); // Go back to main menu
                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }
    }
}
//public class HospitalManagementOperations {
//
//    public static void main(String[] args) throws RoomUNAvailabilityException {
//        Configuration cf = new Configuration();
//        cf.configure("config.xml");
//        SessionFactory factory = cf.buildSessionFactory();
//
//        Scanner sc = new Scanner(System.in);
//
////        PatientServiceImpl patientService = new PatientServiceImpl();
////        DoctorServiceImpl doctorService = new DoctorServiceImpl();
////        BillingServiceImpl billingService = new BillingServiceImpl();
////        MedicalServiceImpl medicalService = new MedicalServiceImpl();
////        PrescriptionServiceImpl prescriptionService = new PrescriptionServiceImpl();
////        RoomsServiceImpl roomsService = new RoomsServiceImpl();
//
//        try {
//            while (true) {
//                System.out.println("Select an Entity to Manage:" +
//                        "\n1. Patient" +
//                        "\n2. Doctor" +
//                        "\n3. Billing" +
//                        "\n4. Medical" +
//                        "\n5. Prescription" +
//                        "\n6. Rooms" +
//                        "\n7. Exit");
//
////                int entityOption = sc.nextInt();
////                if (entityOption == 7) {
////                    System.out.println("Exiting...");
////                    break;
////                }
//
//                int serviceOption = sc.nextInt();
//                switch (serviceOption) {
//                    case 1:
//                        managePatient(sc, factory);
//                        break;
//                    case 2:
//                        manageDoctor(sc, factory);
//                        break;
//                    case 3:
//                        manageBilling(sc, factory);
//                        break;
//                    case 4:
//                        manageMedical(sc, factory);
//                        break;
//                    case 5:
//                        managePrescription(sc, factory);
//                        break;
//                    case 6:
//                        manageRooms(sc, factory);
//                        break;
//                    case 7:
//                        System.out.println("Exiting the application");
//                        System.exit(0);
//                        break;
//                    default:
//                        System.out.println("Enter correct option!!");
//                        break;
//                }
//            }
//        } finally {
//       
//        }
//    }
//            
//            
//            
//        
//    
//  //========================================Room main==================================================  
//    
//   private static void manageRooms(Scanner sc, SessionFactory factory) throws RoomUNAvailabilityException {
//		
//	   
//	   
//	   RoomsServiceImpl roomsService = new RoomsServiceImpl();
//       while (true) {
//           System.out.println("Select Payment Option" 
//               + "\n1.Insert\n2.Update\n3.Delete\n4.Select All"
//               + "\n5.Get a Specific record\n6.Count of all records\n7.Exit");
//
//           
//           
//           int option = sc.nextInt();
//           switch (option) {
//               case 1:
//            	   roomsService.insertRooms(factory);
//                   break;
//               case 2:
//            	   roomsService.updateRooms(factory);
//                   break;
//               case 3:
//            	   roomsService.deleteRooms(factory);
//                   break;
//               case 4:
//            	   roomsService.getAllRooms(factory);
//                   break;
//               case 5:
//            	   roomsService.getRooms(factory);
//                   break;
//               case 6:
//            	   roomsService.getRoomsInformation(factory);
//                   break;
//               case 7:
//                   return; // Go back to the main menu
//               default:
//                   System.out.println("Enter correct option!!");
//                   break;
//           }
//       }
//   
//		
//	}
//
//
//
//// ===========================Prescription main========================================================
//    private static void managePrescription(Scanner sc, SessionFactory factory) {
//	
//    	
//    	
//    	
//    	PrescriptionServiceImpl prescriptionService = new PrescriptionServiceImpl();
//        while (true) {
//            System.out.println("Select Payment Option" 
//                + "\n1.Insert\n2.Update\n3.Delete\n4.Select All"
//                + "\n5.Get a Specific record\n6.Count of all records\n7.Exit");
//
//            
//            
//            int option = sc.nextInt();
//            switch (option) {
//                case 1:
//                	prescriptionService.insertPrescription(factory);
//                    break;
//                case 2:
//                	prescriptionService.updatePrescription(factory);
//                    break;
//                case 3:
//                	prescriptionService.deletePrescription(factory);
//                    break;
//                case 4:
//                	prescriptionService.getAllPrescription(factory);
//                    break;
//                case 5:
//                	prescriptionService.getPrescription(factory);
//                    break;
//                case 6:
//                	prescriptionService.getPrescriptionInformation(factory);
//                    break;
//                case 7:
//                    return; // Go back to the main menu
//                default:
//                    System.out.println("Enter correct option!!");
//                    break;
//            }
//        }
//    	
//    	
//    	
//    	
//    	
//    	
//		
//	}
//	//=====================================Medical main==========================================
//    private static void manageMedical(Scanner sc, SessionFactory factory) {
//    	
//    	
//    	
//    	
//    	MedicalServiceImpl medicalService = new MedicalServiceImpl();
//        while (true) {
//            System.out.println("Select Payment Option" 
//                + "\n1.Insert\n2.Update\n3.Delete\n4.Select All"
//                + "\n5.Get a Specific record\n6.Count of all records\n7.Exit");
//
//            
//            
//            int option = sc.nextInt();
//            switch (option) {
//                case 1:
//                	medicalService.insertMedical(factory);
//                    break;
//                case 2:
//                	medicalService.updateMedical(factory);
//                    break;
//                case 3:
//                	medicalService.deleteMedical(factory);
//                    break;
//                case 4:
//                	medicalService.getAllMedical(factory);
//                    break;
//                case 5:
//                	medicalService.getMedical(factory);
//                    break;
//                case 6:
//                	medicalService.getMedicalInformation(factory);
//                    break;
//                case 7:
//                    return; // Go back to the main menu
//                default:
//                    System.out.println("Enter correct option!!");
//                    break;
//            }
//        }
//
//
//    	
//    	
//    	
//    	
//    	
//		
//		
//	}
//	//=====================================Billing main===========================================
//private static void manageBilling(Scanner sc, SessionFactory factory) {
//
//	
//	BillingServiceImpl billingService = new BillingServiceImpl();
//    while (true) {
//        System.out.println("Select Payment Option" 
//            + "\n1.Insert\n2.Update\n3.Delete\n4.Select All"
//            + "\n5.Get a Specific record\n6.Count of all records\n7.Exit");
//
//        
//        
//        int option = sc.nextInt();
//        switch (option) {
//            case 1:
//            	billingService.insertBilling(factory);
//                break;
//            case 2:
//            	billingService.updateBilling(factory);
//                break;
//            case 3:
//            	billingService.deleteBilling(factory);
//                break;
//            case 4:
//            	billingService.getAllBilling(factory);
//                break;
//            case 5:
//            	billingService.getBilling(factory);
//                break;
//            case 6:
//            	billingService.getBillingInformation(factory);
//                break;
//            case 7:
//                return; // Go back to the main menu
//            default:
//                System.out.println("Enter correct option!!");
//                break;
//        }
//    }
//
//	
//	
//	
//	
//	
//	
//		
//	}
////=======================================Doctor main=============================================================
//    private static void manageDoctor(Scanner sc, SessionFactory factory) {
//		
//  	
//    	
//    	DoctorServiceImpl doctorService = new DoctorServiceImpl();
//        while (true) {
//            System.out.println("Select Payment Option" 
//                + "\n1.Insert\n2.Update\n3.Delete\n4.Select All"
//                + "\n5.Get a Specific record\n6.Count of all records\n7.Exit");
//
//            
//            
//            int option = sc.nextInt();
//            switch (option) {
//                case 1:
//                	doctorService.insertDoctor(factory);
//                    break;
//                case 2:
//                	doctorService.updateDoctor(factory);
//                    break;
//                case 3:
//                	doctorService.deleteDoctor(factory);
//                    break;
//                case 4:
//                	doctorService.getAllDoctor(factory);
//                    break;
//                case 5:
//                	doctorService.getDoctor(factory);
//                    break;
//                case 6:
//                	doctorService.getDoctorInformation(factory);
//                    break;
//                case 7:
//                    return; // Go back to the main menu
//                default:
//                    System.out.println("Enter correct option!!");
//                    break;
//            }
//        }
//    }
//
//    	
//    	
//		
//
////=========================Patient main===========================
//	private static void managePatient(Scanner sc, SessionFactory factory) {
//    	PatientServiceImpl patientService = new PatientServiceImpl();
//            while (true) {
//                System.out.println("Select Payment Option" 
//                    + "\n1.Insert\n2.Update\n3.Delete\n4.Select All"
//                    + "\n5.Get a Specific record\n6.Count of all records\n7.Exit");
//
//                
//                
//                int option = sc.nextInt();
//                switch (option) {
//                    case 1:
//                    	patientService.insertPatient(factory);
//                        break;
//                    case 2:
//                    	patientService.updatePatient(factory);
//                        break;
//                    case 3:
//                    	patientService.deletePatient(factory);
//                        break;
//                    case 4:
//                    	patientService.getAllPatient(factory);
//                        break;
//                    case 5:
//                    	patientService.getPatient(factory);
//                        break;
//                    case 6:
//                    	patientService.getPatientInformation(factory);
//                        break;
//                    case 7:
//                        return; // Go back to the main menu
//                    default:
//                        System.out.println("Enter correct option!!");
//                        break;
//                }
//            }
//        }
//
//}
//		
//	
//
//	    
