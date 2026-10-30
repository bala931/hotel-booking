package com.hotel.repository;

import com.hotel.model.Hotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HotelRepository {
    private final List<Hotel> hotels = new ArrayList<>();

    public void addHotel(Hotel hotel) {
        if (findById(hotel.getHotelId()).isPresent()) {
            throw new IllegalArgumentException(
                    "A hotel with ID " + hotel.getHotelId() + " already exists.");
        }
        hotels.add(hotel);
    }

    public List<Hotel> getAllHotels() {
        return Collections.unmodifiableList(new ArrayList<>(hotels));
    }

    public Optional<Hotel> findById(int hotelId) {
        return hotels.stream()
                .filter(hotel -> hotel.getHotelId() == hotelId)
                .findFirst();
    }
}
