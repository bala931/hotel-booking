package com.hotel.CLI;

import com.hotel.model.Hotel;
import com.hotel.services.HotelManagementService;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class HotelCLI {
    private final HotelManagementService service;
    private final Scanner scanner;

    public HotelCLI(HotelManagementService service) {
        this.service = Objects.requireNonNull(service, "service");
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nHotel Management");
            System.out.println("1. Add hotel");
            System.out.println("2. List hotels");
            System.out.println("3. Find hotel by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            switch (readInt()) {
                case 1:
                    addHotel();
                    break;
                case 2:
                    listHotels();
                    break;
                case 3:
                    findHotel();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose 0, 1, 2, or 3.");
            }
        }
        System.out.println("Goodbye.");
    }

    private void addHotel() {
        try {
            System.out.print("Hotel ID: ");
            int id = readInt();
            System.out.print("Hotel name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Location: ");
            String location = scanner.nextLine().trim();
            System.out.print("Contact number: ");
            String contactNumber = scanner.nextLine().trim();
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            System.out.print("Star rating (1-5): ");
            int rating = readInt();

            service.addHotel(new Hotel(id, name, location, contactNumber, email, rating));
            System.out.println("Hotel added.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not add hotel: " + exception.getMessage());
        }
    }

    private void listHotels() {
        if (service.getAllHotels().isEmpty()) {
            System.out.println("No hotels have been added.");
            return;
        }
        service.getAllHotels().forEach(Hotel::displayDetails);
    }

    private void findHotel() {
        System.out.print("Hotel ID: ");
        int id = readInt();
        Optional<Hotel> hotel = service.findHotelById(id);
        if (hotel.isPresent()) {
            hotel.get().displayDetails();
        } else {
            System.out.println("No hotel found with ID " + id + ".");
        }
    }

    private int readInt() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.print("Enter a whole number: ");
            }
        }
    }
}
