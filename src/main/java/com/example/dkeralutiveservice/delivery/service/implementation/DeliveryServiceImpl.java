package com.example.dkeralutiveservice.delivery.service.implementation;

import com.example.dkeralutiveservice.delivery.dto.Deliverydto;
import com.example.dkeralutiveservice.delivery.model.Delivery;
import com.example.dkeralutiveservice.delivery.repository.DeliveryRepository;
import com.example.dkeralutiveservice.delivery.resp.DeliveryResponse;
import com.example.dkeralutiveservice.delivery.service.DeliveryService;
import com.example.dkeralutiveservice.response.ResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class DeliveryServiceImpl  implements DeliveryService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    MessageSource messageSource;


    @Override
    public DeliveryResponse addDelivery(Deliverydto deliverydto) {
        ResponseDto responseDto=new ResponseDto();
        DeliveryResponse deliveryResponse=new DeliveryResponse();
        Delivery delivery=  modelMapper.map(deliverydto, Delivery.class);
        deliveryRepository.save(delivery);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("delivery.add.success",null,Locale.ENGLISH));
        deliveryResponse.setResponseDto(responseDto);
        return deliveryResponse;
    }
}
