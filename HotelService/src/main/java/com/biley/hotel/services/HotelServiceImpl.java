package com.biley.hotel.services;

import com.biley.hotel.entities.Hotel;
import com.biley.hotel.entities.Rating;
import com.biley.hotel.entities.User;
import com.biley.hotel.exceptions.ResourceNotFoundException;
import com.biley.hotel.external.RatingService;
import com.biley.hotel.external.UserService;
import com.biley.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private UserService userService;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        Hotel hotel =  hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel not Found with id:" + id));
        List<Rating> ratings = ratingService.getRatingbyHotels(id);
        List<Rating> ratingsList = ratings.stream().map(rating -> {
            User user = userService.getUser(rating.getUserId());
            rating.setUser(user);
            return rating;
        }).collect(Collectors.toList());
        hotel.setRatings(ratingsList);
        return hotel;
    }

    @Override
    public List<Hotel> getHotelbyLocation(String location) {
        return hotelRepo.findByLocation(location);
    }

    @Override
    public Hotel getHotelbyLatitudeandLogitude(Double lat, Double lon) {
        return hotelRepo.findByLatitudeAndLongitude(lat, lon);
    }

}
