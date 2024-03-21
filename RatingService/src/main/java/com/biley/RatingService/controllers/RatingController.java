package com.biley.RatingService.controllers;

import com.biley.RatingService.entities.Rating;
import com.biley.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;


    @PostMapping
    public ResponseEntity<Rating>create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingbyUser(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getAllRatingsbyUserId(userId));
    };

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingbyHotels(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getAllRatingsbyHotel(hotelId));
    }
}
