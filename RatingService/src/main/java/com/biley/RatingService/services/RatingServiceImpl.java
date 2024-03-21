package com.biley.RatingService.services;

import com.biley.RatingService.entities.Rating;
import com.biley.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepo;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getAllRatingsbyUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingsbyHotel(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
