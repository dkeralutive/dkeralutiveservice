package com.example.dkeralutiveservice.delivery.service;

import com.example.dkeralutiveservice.delivery.dto.Deliverydto;
import com.example.dkeralutiveservice.delivery.resp.DeliveryResponse;

public interface DeliveryService {

    public DeliveryResponse addDelivery(Deliverydto deliverydto);
}
