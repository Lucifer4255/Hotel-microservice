package com.biley.user.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    private String userId;
    private String name;
    private String email;
    private String about;

//    @Transient
//    private List<Rating> ratings = new ArrayList<>();
}
