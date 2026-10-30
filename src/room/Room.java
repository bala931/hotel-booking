package room;

public class Room {

    public enum RoomStatus {
        AVAILABLE, BOOKED, OCCUPIED, MAINTENANCE
    }

    private int roomId;
    private int hotelId;
    private String roomNumber;
    private String roomType;
    private int capacity;
    private double pricePerNight;
    private RoomStatus roomStatus;

    public Room(int roomId, int hotelId, String roomNumber,
                String roomType, int capacity, double pricePerNight) {

        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        setCapacity(capacity);
        setPricePerNight(pricePerNight);
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public void updateRoomDetails(String roomType,
                                  int capacity, double pricePerNight) {
        this.roomType = roomType;
        setCapacity(capacity);
        setPricePerNight(pricePerNight);
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.pricePerNight = pricePerNight;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void markForMaintenance() {
        this.roomStatus = RoomStatus.MAINTENANCE;
    }

    public void completeMaintenance() {
        if (roomStatus != RoomStatus.MAINTENANCE) {
            throw new IllegalStateException("Room is not under maintenance");
        }
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return roomStatus == RoomStatus.AVAILABLE;
    }

    public double calculateRoomPrice(int nights) {
        if (nights <= 0) {
            throw new IllegalArgumentException("Nights must be positive");
        }
        return pricePerNight * nights;
    }

    public void displayRoomDetails() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Hotel ID: " + hotelId);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Capacity: " + capacity);
        System.out.println("Price Per Night: " + pricePerNight);
        System.out.println("Status: " + roomStatus);
    }

    public int getRoomId() {
        return roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }
}