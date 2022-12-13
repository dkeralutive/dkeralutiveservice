package com.example.dkeralutiveservice.productdescription.resp;

import com.example.dkeralutiveservice.productdescription.dto.ProductDescriptionDto;
import com.example.dkeralutiveservice.productdescription.model.ProductDescription;
import com.example.dkeralutiveservice.response.ResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductDescriptionResponse {

    private ResponseDto responseDto;

    List<ProductDescriptionDto> productDescriptionDtoList;

    ProductDescriptionDto productDescriptionDto;
}
