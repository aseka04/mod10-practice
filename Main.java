package practice;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        RestaurantSystem restaurantSystem = new RestaurantSystem();
        RoomBookingSystem roomBookingSystem = new RoomBookingSystem();
        CleaningService cleaningService = new CleaningService();
        TaxiSystem taxiSystem = new TaxiSystem();

        HotelFacade hotelFacade = new HotelFacade(restaurantSystem,roomBookingSystem,cleaningService, taxiSystem);

        hotelFacade.rent_room();
    }
}
class HotelFacade{
    RestaurantSystem restaurantSystem;
    RoomBookingSystem roomBookingSystem;
    CleaningService cleaningService;
    TaxiSystem taxiSystem;

    public HotelFacade(RestaurantSystem restaurantSystem, RoomBookingSystem roomBookingSystem, CleaningService cleaningService, TaxiSystem taxiSystem) {
        this.restaurantSystem = restaurantSystem;
        this.roomBookingSystem = roomBookingSystem;
        this.cleaningService = cleaningService;
        this.taxiSystem = taxiSystem;
    }

    void rent_room(){
        roomBookingSystem.Check(56);
        cleaningService.NotificationCleaner(56,"please clean this room");
        restaurantSystem.OrderFood(56, new String[]{"pasta", "pizza"});
        taxiSystem.rentTaxi(56, "Satbayev, 22");
    }
    
}
class RoomBookingSystem{

    void rent(){
        System.out.println("room rented");
    }
    void Check(int room_col){
        System.out.println("room: " + room_col+"\nempty\n");
    }
}
class RestaurantSystem{

    void RentTable(int count){
        System.out.println("table: "+count+"\nrented\n");
    }
    void OrderFood(int room_col, String[] foods) {
        System.out.println("\nRoom: " + room_col + "\nOrdered: " + String.join(", ", foods));
    }


}

class TaxiSystem{
    void rentTaxi(int rool_col, String address){
        System.out.println("room: "+rool_col+"\nrented taxi to address: "+address);
    }
}

class CleaningService{
    void NotificationCleaner(int room_col, String message){
        System.out.println("room: "+room_col+"\nmessage: "+message);
    }
}