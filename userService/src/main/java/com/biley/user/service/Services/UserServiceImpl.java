package com.biley.user.service.Services;

import com.biley.user.service.entities.Hotel;
import com.biley.user.service.entities.Rating;
import com.biley.user.service.entities.User;
import com.biley.user.service.exceptions.ResourceNotFoundException;
import com.biley.user.service.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {

        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found on Server with Id" + userId));
        //fetch rating of above user
        //http://localhost:8082/ratings/users/100c5dea-e920-4a6a-ae40-3798be96af02
//        Rating[] obj =restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
//        logger.info("{}",obj);
//        List<Rating> ratings = Arrays.stream(obj).toList();
//        List<Rating> ratingList = ratings.stream().map(rating -> {
//            ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = hotelEntity.getBody();
//            logger.info("response status Code : {}",hotelEntity.getStatusCode());
//            rating.setHotel(hotel);
//            return rating;
//        }).collect(Collectors.toList());
//
//        user.setRatings(ratingList);
        return user;

    }
}
