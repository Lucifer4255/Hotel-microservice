package com.biley.RatingService.services;

import com.biley.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating createRating(Rating rating);

    //get all ratings
    List<Rating> getAllRatings();

    //get all ratings by userId

    List<Rating> getAllRatingsbyUserId(String userId);

    //get all ratings by hotel

    List<Rating> getAllRatingsbyHotel(String hotelId);

}
