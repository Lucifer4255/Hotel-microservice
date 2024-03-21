package com.biley.hotel.controllers;

import com.biley.hotel.entities.Hotel;
import com.biley.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //create

    @PostMapping
    public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    //get All Items
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    //get single item
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.ok(hotelService.getHotel(hotelId));
    }
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Hotel>> getHotelsbyLocation(@PathVariable String location){
        return ResponseEntity.ok(hotelService.getHotelbyLocation(location));
    }
    @GetMapping("/coord")
    public ResponseEntity<Hotel> getHotelbycoordinates(@RequestParam Double lat,@RequestParam Double lon){
        return ResponseEntity.ok(hotelService.getHotelbyLatitudeandLogitude(lat, lon));
    }
}
