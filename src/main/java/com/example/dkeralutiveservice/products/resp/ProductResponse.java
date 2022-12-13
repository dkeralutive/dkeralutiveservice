package com.example.dkeralutiveservice.products.resp;

import com.example.dkeralutiveservice.products.dto.ProductDto;
import com.example.dkeralutiveservice.response.ResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductResponse {

    private ResponseDto responseDto;

    List<ProductDto> productDtoList;
}
