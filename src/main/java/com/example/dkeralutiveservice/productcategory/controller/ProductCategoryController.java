package com.example.dkeralutiveservice.productcategory.controller;

import com.example.dkeralutiveservice.productcategory.dto.ProductCategoryDto;
import com.example.dkeralutiveservice.productcategory.resp.ProductCategoryResponse;
import com.example.dkeralutiveservice.productcategory.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/productcategorycode", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductCategoryController {

    @Autowired
    ProductCategoryService categoryService;

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<ProductCategoryResponse> addProductCategory(@RequestBody ProductCategoryDto categoryDto) {
        ProductCategoryResponse responseDto= categoryService.addProductCategory(categoryDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductCategoryResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductCategoryResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public ResponseEntity<ProductCategoryResponse> updateProductCategory(@RequestBody ProductCategoryDto categoryDto) {
        ProductCategoryResponse responseDto= categoryService.updateProductCategory(categoryDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductCategoryResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductCategoryResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public ResponseEntity<ProductCategoryResponse> deleteProductCategory(@RequestBody ProductCategoryDto categoryDto) {
        ProductCategoryResponse responseDto= categoryService.deleteProductCategory(categoryDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductCategoryResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductCategoryResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/all" ,method = RequestMethod.GET)
    public ResponseEntity<ProductCategoryResponse> allProductCategory() {
        ProductCategoryResponse responseDto= categoryService.getAllProductCategory();
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductCategoryResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductCategoryResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
