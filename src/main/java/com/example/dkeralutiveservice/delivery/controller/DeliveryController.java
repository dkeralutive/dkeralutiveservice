package com.example.dkeralutiveservice.delivery.controller;


import com.example.dkeralutiveservice.delivery.dto.Deliverydto;
import com.example.dkeralutiveservice.delivery.resp.DeliveryResponse;
import com.example.dkeralutiveservice.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/delivery", produces = {MediaType.APPLICATION_JSON_VALUE})
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<DeliveryResponse> addDelivery(@RequestBody Deliverydto deliverydto) {
        DeliveryResponse responseDto= deliveryService.addDelivery(deliverydto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<DeliveryResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<DeliveryResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

}
