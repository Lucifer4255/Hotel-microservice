package com.biley.hotel.repositories;

import com.biley.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,String> {
    List<Hotel> findByLocation(String location);
    Hotel findByLatitudeAndLongitude(Double latitude,Double longitude);
}
