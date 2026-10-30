package com.hotel;

import com.hotel.repository.HotelRepository;
import com.hotel.services.HotelManagementService;
import com.hotel.CLI.HotelCLI;

public class Main {

    public static void main(String[] args) {

        // Step 1: Create repository
        HotelRepository repository = new HotelRepository();

        // Step 2: Create service
        HotelManagementService service =
                new HotelManagementService(repository);

        // Step 3: Create CLI
        HotelCLI cli = new HotelCLI(service);

        // Step 4: Start application
        cli.start();
    }
}