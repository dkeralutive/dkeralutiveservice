package com.example.dkeralutiveservice.user.service.Implementation;

import com.example.dkeralutiveservice.response.ResponseDto;
import com.example.dkeralutiveservice.user.dto.DekeralutiveUserDto;
import com.example.dkeralutiveservice.user.model.DekeralutiveUser;
import com.example.dkeralutiveservice.user.repository.UserRepository;
import com.example.dkeralutiveservice.user.resp.UserResponse;
import com.example.dkeralutiveservice.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageSource messageSource;

    @Override
    public UserResponse addUser(DekeralutiveUserDto dto) {
        UserResponse userResponse=new UserResponse();
        ResponseDto responseDto=new ResponseDto();
        DekeralutiveUser dekeralutiveUser=modelMapper.map(dto, DekeralutiveUser.class);
        userRepository.save(dekeralutiveUser);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("user.add.success",null,Locale.ENGLISH));
        userResponse.setResponseDto(responseDto);
        return userResponse;
    }

    @Override
    public UserResponse updateUser(DekeralutiveUserDto dto) {
        UserResponse userResponse=new UserResponse();
        ResponseDto responseDto=new ResponseDto();
        DekeralutiveUser dekeralutiveUser= userRepository.findByUserName(dto.getUserName());
        Long id=dekeralutiveUser.getId();
        dto.setId(id);
        DekeralutiveUser dekeralutiveUser1=modelMapper.map(dto,DekeralutiveUser.class);
        userRepository.save(dekeralutiveUser1);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("user.update.success",null,Locale.ENGLISH));
        userResponse.setResponseDto(responseDto);
        return userResponse;
    }

    @Override
    public UserResponse deleteUser(DekeralutiveUserDto dto) {
        UserResponse userResponse=new UserResponse();
        ResponseDto responseDto=new ResponseDto();
        DekeralutiveUser dekeralutiveUser= userRepository.findByUserName(dto.getUserName());
        dekeralutiveUser.setDelFlag("Y");
        userRepository.save(dekeralutiveUser);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("user.delete.success",null,Locale.ENGLISH));
        userResponse.setResponseDto(responseDto);
        return userResponse;
    }

    @Override
    public UserResponse getAllUser() {
        UserResponse userResponse=new UserResponse();
        ResponseDto responseDto=new ResponseDto();
        List<DekeralutiveUser> dekeralutiveUser= userRepository.findAll();
        userResponse.setUserDtoList(convertDekeralutiveModelToDto(dekeralutiveUser));
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("user.delete.success",null,Locale.ENGLISH));
        userResponse.setResponseDto(responseDto);
        return userResponse;
    }

    List<DekeralutiveUserDto> convertDekeralutiveModelToDto(List<DekeralutiveUser> dekeralutiveUsers){
        List<DekeralutiveUserDto> dekeralutiveUserDtos=new ArrayList<>();
        for(DekeralutiveUser dekeralutiveUse:dekeralutiveUsers){
         DekeralutiveUserDto dto=modelMapper.map(dekeralutiveUse,DekeralutiveUserDto.class);
            dekeralutiveUserDtos.add(dto);
        }
        return dekeralutiveUserDtos;
    }
}
