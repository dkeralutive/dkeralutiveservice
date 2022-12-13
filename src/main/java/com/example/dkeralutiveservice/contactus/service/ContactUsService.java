package com.example.dkeralutiveservice.contactus.service;

import com.example.dkeralutiveservice.contactus.dto.ContactUsDto;
import com.example.dkeralutiveservice.contactus.resp.ContactUsResponse;

public interface ContactUsService {

    ContactUsResponse addContact(ContactUsDto contactUsDto);

}
