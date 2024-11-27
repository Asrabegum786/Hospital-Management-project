package HospitalmanagementServiceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.Hospitalmanagement.Utility.RoomUNAvailabilityException;

import Hospitalmanagement.entities.Billing;
//import Hospitalmanagement.entities.Billing;
import Hospitalmanagement.entities.Patient;
import Hospitalmanagement.entities.Rooms;
import HospitalmanagementService.RoomsService;

public class RoomsServiceImpl   implements     RoomsService {
	Scanner sc = new Scanner(System.in);
	Session session;
	@Override
//	public void insertRooms(SessionFactory sf) throws RoomUNAvailabilityException {
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//			try {
//				Rooms rooms = new Rooms();
//
//						System.out.println("welcome to Rooms");
//
//						System.out.println("enter Room id");
//						int  Room_id = sc.nextInt();
//						sc.nextLine();
//						rooms.setRoom_id(Room_id);
//						
//						System.out.println("enter Room status");
//						String status = sc.nextLine();
//						//rooms.setRoom_type(status);
//						
//						int status_available = testcheckRoomUNAvailabilityException (status);
//				        if (status_available == 0) { 
//				            throw new RoomUNAvailabilityException("We are sorry for there are no rooms available  in general ward please shift the patient in paid rooms");
//				        }
//				        
//				        // Set quantity only if valid
//				        rooms.setRoom_status(sc.next());
//						
//
//						System.out.println("enter Room_type");
//						String type = sc.next();
//						rooms.setRoom_type(type);
//
//
//						System.out.println("enter Patient_id:");
//						int Patient_id = sc.nextInt();
//		          Patient patient = session.get(Patient.class, Patient_id);
//		
//		
//						if (patient != null) {
//							rooms.setPatient(patient);
//						} else {
//			                throw new RoomUNAvailabilityException("Patient not found for the given ID. Room cannot be allocated.");
//							//System.out.println("The room is not alloted  for the patint_id:");
//							//return;
//						}
//						session.persist(rooms);
//						tx.commit();
//						
//						   System.out.println("Room information saved successfully.");
//					} catch (RoomUNAvailabilityException e) {
//			            System.out.println(e.getMessage());
//			            tx.rollback();
//			        } 
//			finally {
//						session.close();
//					}
//					}
//	
//	
//	private int testcheckRoomUNAvailabilityException(String status) {
//		
//		String  room_avaialble=sc.next();
//		if(room_avaialble=="No") {
//			return 0;
//		}
//		// TODO Auto-generated method stub
//		return 1;
//	}
//
//
	public void insertRooms(SessionFactory sf) {
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Scanner sc = new Scanner(System.in);

	    try {
	        Rooms rooms = new Rooms();

	        System.out.println("Welcome to Rooms");

	        // Prompt for Room ID
	        System.out.println("Enter Rooms ID:");
	        int roomsId = sc.nextInt();   // For integer input like Room ID
	        sc.nextLine();  // Consume newline character
	        rooms.setRoom_id(roomsId);

	        // Prompts for Room Status
	        System.out.println("Enter Room Status (e.g., available, occupied):");
	        String roomsStatus = sc.nextLine();   // For string input like Room Status
	        rooms.setRoom_status(roomsStatus);

	        // If more fields are required, check that they are properly captured.
	        // Example for Room Type:
	        System.out.println("Enter Room Type (e.g., General, ICU, etc.):");
	        String roomType = sc.nextLine();
	        rooms.setRoom_type(roomType);

	        // Persist the Room object to the database
	        session.save(rooms);
	        tx.commit();
	        System.out.println("Room inserted successfully.");
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	        sc.close();
	    }
	}

	//=========================update Rooms========================================
	@Override
	public void updateRooms(SessionFactory sf)   {
		session = sf.openSession();
		Transaction tx = session.beginTransaction(); // Start transaction

		// org.hibernate.Transaction tx= session.beginTransaction();

		try {
			while (true) {
				System.out.println("Choose an Option for Update "
						+ "\n1. Room status \n2.Update Room_type \n3.Update  Patient_id  \n5.Exit");

				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter Rooms Id:");
					Rooms  rooms= session.get(Rooms.class, sc.nextInt());

					if (rooms != null) {
						System.out.println("Update Room status:");
						rooms.setRoom_status(sc.next());

						session.saveOrUpdate(rooms);
						tx.commit();

						System.out.println("Room status updated successfully");
					} else {
						
               

						System.out.println("Room not found for the given Id");
					}
					break;

				case 2:
					System.out.println("Enter Room id:");
					try {
						rooms = session.get(Rooms.class, sc.nextInt());

						if (rooms != null) {
							System.out.println("Update Room_type:");
							rooms.setRoom_type(sc.next());
							session.saveOrUpdate(rooms);
							session.flush();
							tx.commit();

							System.out.println("Room_type is updated successfully.");
						} else {
							System.out.println("Room not found for the given Id.");
						}

					} finally {
						System.out.println("Succeed!");
					}
					break;

				case 3:

					System.out.println("Enter Room id:");
					rooms = session.get(Rooms.class, sc.nextInt());
					if (rooms != null) {
						System.out.println("enter Patient ID:");
						int newPatient_id = sc.nextInt();
                         sc.nextLine();
						// Assuming you have a method to get the Patient by ID
						Patient newPatient = session.get(Patient.class, newPatient_id);
						if (newPatient != null) {
							rooms.setPatient(newPatient);
							session.saveOrUpdate(rooms);
							tx.commit();
							System.out.println("Room id updated successfully.");
						} else {
							System.out.println(" Rooom not found for the given ID.");
						}
					} else {
						System.out.println("Room not found for the given Id.");
					}
					break;

				case 5:
					System.out.println("Exiting update...");
					return;

				default:
					System.out.println("Choose correct option!!");
				}
			}
		} finally {
			session.close();

		}
		
		
		
		
	}
	//===================================Delete Rooms===================================================
	@Override
	public void deleteRooms(SessionFactory sf) {
		
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Room id");
        int Room_id = sc.nextInt();
        Rooms rooms = session.get(Rooms.class,  Room_id);

        if (rooms != null) {
            session.delete(rooms);
            tx.commit();
            System.out.println("Room deleted successfully.");
        } else {
            System.out.println("Please enter a valid Room Id.");
        }

        session.close();
	}

//==========================select Rooms=============================================
		
		
		
	
	@Override
	public void getAllRooms(SessionFactory sf) {
		
		session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Rooms");
        List<Rooms> roomsList=query.getResultList();
        
        for(Rooms b:roomsList) {
        	System.out.println(b);
        }

        
        
        tx.commit();
        session.close();

	}
	
   //=============================select Record====================================
	@Override
	public void getRooms(SessionFactory sf) {
		
		
		
		
		session = sf.openSession();

        System.out.println("Enter Rooms_id:");
        int Room_id= sc.nextInt();
        Rooms rooms = session.get(Rooms.class, Room_id);

        if (rooms!= null) {
            System.out.println(rooms);
        } else {
            System.out.println("Rooms not found for the given Id.");
        }

        session.close();

		
	}

	//======================getRoomsInformation=============================================	

	@Override
	public void getRoomsInformation(SessionFactory sf) {
		
		
		
		
		session = sf.openSession();
    	
	       
        Query query = session.createQuery("select count(Room_id) from Rooms");
        Long count = (Long) query.getSingleResult();

        System.out.println("Total number of Rooms: " + count);
        session.close();
		
	}



//
//	public int testcheckRoomsUnavailableException(int qnt) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//

	public int testCheckRoomNameValidity(String roomName) {
		// TODO Auto-generated method stub
		return 0;
	}


	}

	


	