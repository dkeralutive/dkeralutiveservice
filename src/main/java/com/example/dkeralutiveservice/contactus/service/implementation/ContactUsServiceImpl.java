package com.example.dkeralutiveservice.contactus.service.implementation;

import com.example.dkeralutiveservice.contactus.dto.ContactUsDto;
import com.example.dkeralutiveservice.contactus.model.ContactUs;
import com.example.dkeralutiveservice.contactus.repository.ContactUsRepository;
import com.example.dkeralutiveservice.contactus.resp.ContactUsResponse;
import com.example.dkeralutiveservice.contactus.service.ContactUsService;
import com.example.dkeralutiveservice.response.ResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ContactUsRepository contactUsRepository;

    @Autowired
    MessageSource messageSource;

    @Override
    public ContactUsResponse addContact(ContactUsDto contactUsDto) {
        ResponseDto responseDto=new ResponseDto();
        ContactUsResponse contactUsResponse=new ContactUsResponse();
        ContactUs contactUs=modelMapper.map(contactUsDto, ContactUs.class);
        contactUsRepository.save(contactUs);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("contactus.add.success",null,Locale.ENGLISH));
        contactUsResponse.setResponseDto(responseDto);
        return contactUsResponse;
    }
}
