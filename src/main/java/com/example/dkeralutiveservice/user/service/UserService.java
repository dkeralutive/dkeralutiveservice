package com.example.dkeralutiveservice.user.service;

import com.example.dkeralutiveservice.user.dto.DekeralutiveUserDto;
import com.example.dkeralutiveservice.user.resp.UserResponse;

public interface UserService {

    UserResponse addUser(DekeralutiveUserDto dto);
    UserResponse updateUser(DekeralutiveUserDto dto);
    UserResponse deleteUser(DekeralutiveUserDto dto);
    UserResponse getAllUser();

}
