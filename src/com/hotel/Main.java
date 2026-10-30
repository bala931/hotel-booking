package com.hotel;

import com.hotel.CLI.HotelCLI;
import com.hotel.repository.HotelRepository;
import com.hotel.services.HotelManagementService;

public class Main {

    public static void main(String[] args) {
        HotelRepository repository = new HotelRepository();
        HotelManagementService service = new HotelManagementService(repository);
        HotelCLI cli = new HotelCLI(service);
        cli.start();
    }
}
