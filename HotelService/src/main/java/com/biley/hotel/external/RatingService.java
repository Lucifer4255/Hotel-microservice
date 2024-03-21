package com.biley.hotel.external;


import com.biley.hotel.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/hotels/{hotelId}")
    ArrayList<Rating> getRatingbyHotels(@PathVariable String hotelId);

}
