package com.hotel.model;

public class Hotel {
    private final int hotelId;
    private final String hotelName;
    private final String location;
    private final String contactNumber;
    private final String email;
    private final int starRating;

    public Hotel(int hotelId, String hotelName, String location,
                 String contactNumber, String email, int starRating) {
        if (hotelId <= 0 || starRating < 1 || starRating > 5) {
            throw new IllegalArgumentException("Invalid hotel ID or star rating.");
        }

        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
        this.contactNumber = contactNumber;
        this.email = email;
        this.starRating = starRating;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getStarRating() {
        return starRating;
    }

    public void displayDetails() {
        System.out.println("\nHotel ID: " + hotelId);
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Location: " + location);
        System.out.println("Contact: " + contactNumber);
        System.out.println("Email: " + email);
        System.out.println("Star Rating: " + starRating + " stars");
    }
}
