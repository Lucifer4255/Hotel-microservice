package com.biley.hotel.external;

import com.biley.hotel.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserService {

    @GetMapping("/users/{userId}")
    User getUser(@PathVariable String userId);
}
