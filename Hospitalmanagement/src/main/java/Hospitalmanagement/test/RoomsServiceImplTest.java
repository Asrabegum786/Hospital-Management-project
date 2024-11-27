//package Hospitalmanagement.test;
//
//import org.junit.jupiter.api.Assertions;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//
//import com.EcommercemgmtServiceImpl.InventoryServiceImpl;
//
//import HospitalmanagementServiceImplementation.RoomsServiceImpl;
//
//public class RoomsServiceImplTest {
//
//    RoomsServiceImpl service = new RoomsServiceImpl();
//
//    @ParameterizedTest
//    @ValueSource(ints = {-1, 5, 10})  
//    void testCheckRoomsAvailable(int qnt) {
//        int actual = service.testcheckRoomsUnavailableException(qnt);
//        Assertions.assertEquals(1, actual, "Quantity should be positive");
//    }
//    
//
//    
//}

package Hospitalmanagement.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import HospitalmanagementServiceImplementation.RoomsServiceImpl;

public class RoomsServiceImplTest {

    RoomsServiceImpl service = new RoomsServiceImpl();

    // Test for checking valid and invalid room names
    @ParameterizedTest
    @ValueSource(strings = {"Room101", "Room A", "RoomXYZ", " "})  
    void testCheckRoomNameValidity(String roomName) {
        int actual = service.testCheckRoomNameValidity(roomName);
        
        // In this test case, we expect valid room names starting with "Room" to return 1.
        if (roomName != null && !roomName.trim().isEmpty() && roomName.startsWith("Room")) {
            Assertions.assertEquals(1, actual, "Room name should be valid.");
        } else {
            Assertions.assertEquals(0, actual, "Room name should be invalid.");
        }
    }
}

