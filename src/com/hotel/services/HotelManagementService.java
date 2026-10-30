package com.hotel.services;

import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class HotelManagementService {
    private final HotelRepository repository;

    public HotelManagementService(HotelRepository repository) {
        this.repository = Objects.requireNonNull(repository, "repository");
    }

    public void addHotel(Hotel hotel) {
        repository.addHotel(Objects.requireNonNull(hotel, "hotel"));
    }

    public List<Hotel> getAllHotels() {
        return repository.getAllHotels();
    }

    public Optional<Hotel> findHotelById(int hotelId) {
        return repository.findById(hotelId);
    }
}
