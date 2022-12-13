package com.example.dkeralutiveservice.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DekeralutiveUserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String passwordhash;
    private String userType;
    private String userName;
    private Long id;
}
