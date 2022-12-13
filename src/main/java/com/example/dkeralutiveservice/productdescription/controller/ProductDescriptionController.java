package com.example.dkeralutiveservice.productdescription.controller;

import com.example.dkeralutiveservice.productcategory.dto.ProductCategoryDto;
import com.example.dkeralutiveservice.productcategory.resp.ProductCategoryResponse;
import com.example.dkeralutiveservice.productdescription.dto.ProductDescriptionDto;
import com.example.dkeralutiveservice.productdescription.resp.ProductDescriptionResponse;
import com.example.dkeralutiveservice.productdescription.service.ProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/productdescription", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductDescriptionController {

    @Autowired
    ProductDescriptionService productDescriptionService;

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<ProductDescriptionResponse> addProductDescription(@RequestBody ProductDescriptionDto productDescriptionDto) {
        ProductDescriptionResponse responseDto= productDescriptionService.addProductDescription(productDescriptionDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductDescriptionResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductDescriptionResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public ResponseEntity<ProductDescriptionResponse> updateProductDescription(@RequestBody ProductDescriptionDto productDescriptionDto) {
        ProductDescriptionResponse responseDto= productDescriptionService.updateProductDescription(productDescriptionDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductDescriptionResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductDescriptionResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public ResponseEntity<ProductDescriptionResponse> deleteProductDescription(@RequestBody ProductDescriptionDto productDescriptionDto) {
        ProductDescriptionResponse responseDto= productDescriptionService.deleteProductDescription(productDescriptionDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductDescriptionResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductDescriptionResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }



    @RequestMapping(value = "/all" ,method = RequestMethod.POST)
    public ResponseEntity<ProductDescriptionResponse> deleteProductDescription(@RequestBody String productCode) {
        ProductDescriptionResponse responseDto= productDescriptionService.getProductDescription(productCode);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductDescriptionResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductDescriptionResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

}
