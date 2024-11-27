package HospitalmanagementService;


	import org.hibernate.SessionFactory;

import com.Hospitalmanagement.Utility.RoomUNAvailabilityException;
	public interface RoomsService {

	void insertRooms(SessionFactory sf) throws RoomUNAvailabilityException;
		
		void updateRooms(SessionFactory sf);
		
		void deleteRooms(SessionFactory sf);
		
		void getAllRooms(SessionFactory sf);

		void getRooms(SessionFactory sf);
		
		void getRoomsInformation(SessionFactory sf);

	}

