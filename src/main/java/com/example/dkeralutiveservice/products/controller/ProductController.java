package com.example.dkeralutiveservice.products.controller;


import com.example.dkeralutiveservice.products.dto.ProductDto;
import com.example.dkeralutiveservice.products.resp.ProductResponse;
import com.example.dkeralutiveservice.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/products", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductDto productDto) {
        ProductResponse responseDto= productService.addProduct(productDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }



    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductDto productDto) {
        ProductResponse responseDto= productService.updateProduct(productDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/all" ,method = RequestMethod.GET)
    public ResponseEntity<ProductResponse> allProduct() {
        ProductResponse responseDto= productService.allProducts();
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public ResponseEntity<ProductResponse> deleteProduct(@RequestBody ProductDto productDto) {
        ProductResponse responseDto= productService.deleteProduct(productDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<ProductResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<ProductResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

}
