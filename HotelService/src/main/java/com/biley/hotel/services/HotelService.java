package com.biley.hotel.services;

import com.biley.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {
    //create
    Hotel create(Hotel hotel);
    //get all hotels

    List<Hotel> getAllHotels();

    //get hotel by id
    Hotel getHotel(String id);

    List<Hotel> getHotelbyLocation(String location);

    Hotel getHotelbyLatitudeandLogitude(Double lat,Double lon);
}
