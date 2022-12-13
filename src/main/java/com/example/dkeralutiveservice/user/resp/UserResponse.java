package com.example.dkeralutiveservice.user.resp;

import com.example.dkeralutiveservice.response.ResponseDto;
import com.example.dkeralutiveservice.user.dto.DekeralutiveUserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserResponse {

    private ResponseDto responseDto;
    private DekeralutiveUserDto userDto;
    private List<DekeralutiveUserDto> userDtoList;
}
