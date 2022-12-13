package com.example.dkeralutiveservice.user.controller;

import com.example.dkeralutiveservice.stock.dto.StockDto;
import com.example.dkeralutiveservice.stock.resp.StockResponse;
import com.example.dkeralutiveservice.user.dto.DekeralutiveUserDto;
import com.example.dkeralutiveservice.user.resp.UserResponse;
import com.example.dkeralutiveservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<UserResponse> addUser(@RequestBody DekeralutiveUserDto dto) {
        UserResponse responseDto= userService.addUser(dto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<UserResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<UserResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public ResponseEntity<UserResponse> updateUser(@RequestBody DekeralutiveUserDto dto) {
        UserResponse responseDto= userService.updateUser(dto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<UserResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<UserResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public ResponseEntity<UserResponse> deleteUser(@RequestBody DekeralutiveUserDto dto) {
        UserResponse responseDto= userService.deleteUser(dto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<UserResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<UserResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/all" ,method = RequestMethod.GET)
    public ResponseEntity<UserResponse> allUser() {
        UserResponse responseDto= userService.getAllUser();
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<UserResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<UserResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

    
}
