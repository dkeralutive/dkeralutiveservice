package com.example.dkeralutiveservice.delivery.model;

import com.example.dkeralutiveservice.user.model.AbstractEntity;
import com.example.dkeralutiveservice.user.model.DekeralutiveUser;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Delivery  extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String zipCode;
    private String state;
    private String city;

    @ManyToOne
    private DekeralutiveUser user;

}
