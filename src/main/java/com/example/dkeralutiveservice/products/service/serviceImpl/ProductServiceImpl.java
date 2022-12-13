package com.example.dkeralutiveservice.products.service.serviceImpl;

import com.example.dkeralutiveservice.products.dto.ProductDto;
import com.example.dkeralutiveservice.products.model.Products;
import com.example.dkeralutiveservice.products.repository.ProductRepository;
import com.example.dkeralutiveservice.products.resp.ProductResponse;
import com.example.dkeralutiveservice.products.service.ProductService;
import com.example.dkeralutiveservice.response.ResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MessageSource messageSource;

    @Override
    public ProductResponse addProduct(ProductDto productDto) {
        ResponseDto responseDto=new ResponseDto();
        ProductResponse productResponse=new ProductResponse();
        Products products= modelMapper.map(productDto, Products.class);
        products.setCreatedOn(new Date());
        productRepository.save(products);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.add.success",null,Locale.ENGLISH));
        productResponse.setResponseDto(responseDto);
        return productResponse;
    }

    @Override
    public ProductResponse updateProduct(ProductDto productDto) {
        try{
            ResponseDto responseDto=new ResponseDto();
            ProductResponse productResponse=new ProductResponse();
            Products products=  productRepository.findByCode(productDto.getCode());
            productDto.setId(products.getId());
            Products products1= modelMapper.map(productDto,Products.class);
            productRepository.save(products1);
            responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
            responseDto.setMessage(messageSource.getMessage("product.update.success",null,Locale.ENGLISH));
            productResponse.setResponseDto(responseDto);
            return productResponse;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public ProductResponse deleteProduct(ProductDto productDto) {
        ResponseDto responseDto=new ResponseDto();
        ProductResponse productResponse=new ProductResponse();
        Products products= productRepository.findByCode(productDto.getCode());
        products.setDelFlag("Y");
        productRepository.save(products);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.delete.success",null,Locale.ENGLISH));
        productResponse.setResponseDto(responseDto);
        return productResponse;
    }

    @Override
    public ProductResponse allProducts() {
        ResponseDto responseDto=new ResponseDto();
        ProductResponse productResponse=new ProductResponse();
        List<Products>  products=productRepository.findAll();
        System.out.println("getting all the products"+products);
        productResponse.setProductDtoList(convertProductModelToDto(products));
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.all.success",null,Locale.ENGLISH));
        productResponse.setResponseDto(responseDto);
        return  productResponse;
    }


    private List<ProductDto> convertProductModelToDto(List<Products> products){
        List<ProductDto> productDtoList=new ArrayList<>();
        for(Products products1:products){
            ProductDto productDto= modelMapper.map(products1,ProductDto.class);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
 }
