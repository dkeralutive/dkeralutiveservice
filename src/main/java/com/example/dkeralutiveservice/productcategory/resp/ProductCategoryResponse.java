package com.example.dkeralutiveservice.productcategory.resp;

import com.example.dkeralutiveservice.productcategory.dto.ProductCategoryDto;
import com.example.dkeralutiveservice.productcategory.model.ProductCategory;
import com.example.dkeralutiveservice.response.ResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductCategoryResponse {
    private ResponseDto responseDto;
    private List<ProductCategoryDto> productCategoryDtoList;
}
