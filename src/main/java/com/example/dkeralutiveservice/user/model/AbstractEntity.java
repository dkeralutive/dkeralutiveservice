package com.example.dkeralutiveservice.user.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Version
    protected int version;

    protected String delFlag = "N";

//    @NotNull
    private Date createdOn;

    private Date modifiedOn;


//    @PrePersist
//    void onCreate(){
//        if(createdOn == null){
//            createdOn = new Date();
//        }
//    }
}
