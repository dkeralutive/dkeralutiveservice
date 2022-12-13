package com.example.dkeralutiveservice.user.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class DekeralutiveUser extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String passwordhash;
    private String userType;

    private String userName;

}
