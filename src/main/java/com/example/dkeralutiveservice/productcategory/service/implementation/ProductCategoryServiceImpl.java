package com.example.dkeralutiveservice.productcategory.service.implementation;

import com.example.dkeralutiveservice.productcategory.dto.ProductCategoryDto;
import com.example.dkeralutiveservice.productcategory.model.ProductCategory;
import com.example.dkeralutiveservice.productcategory.repository.Productcategoryrepository;
import com.example.dkeralutiveservice.productcategory.resp.ProductCategoryResponse;
import com.example.dkeralutiveservice.productcategory.service.ProductCategoryService;
import com.example.dkeralutiveservice.products.model.Products;
import com.example.dkeralutiveservice.products.repository.ProductRepository;
import com.example.dkeralutiveservice.response.ResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    Productcategoryrepository productcategoryrepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MessageSource messageSource;

    @Override
    public ProductCategoryResponse addProductCategory(ProductCategoryDto productCategoryDto) {
        ResponseDto responseDto=new ResponseDto();
        ProductCategoryResponse productResponse=new ProductCategoryResponse();
        ProductCategory productCategory= modelMapper.map(productCategoryDto, ProductCategory.class);
        Products products= productRepository.findByCode(productCategoryDto.getProductCode());
        productCategory.setProducts(products);
        productcategoryrepository.save(productCategory);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.category.add.success",null,Locale.ENGLISH));
        productResponse.setResponseDto(responseDto);
        return productResponse;
    }

    @Override
    public ProductCategoryResponse updateProductCategory(ProductCategoryDto productCategoryDto) {
        ResponseDto responseDto=new ResponseDto();
        ProductCategoryResponse productCategoryResponse=new ProductCategoryResponse();
        Products products= productRepository.findByCode(productCategoryDto.getProductCode());
        ProductCategory productCategory=productcategoryrepository.findByCode(productCategoryDto.getCode());
        productCategory.setProducts(products);
        productCategoryDto.setId(productCategory.getId());
        ProductCategory productCategory1=modelMapper.map(productCategoryDto,ProductCategory.class);
        productcategoryrepository.save(productCategory1);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.category.update.success",null,Locale.ENGLISH));
        productCategoryResponse.setResponseDto(responseDto);
        return productCategoryResponse;
    }

    @Override
    public ProductCategoryResponse deleteProductCategory(ProductCategoryDto productCategoryDto) {
        ResponseDto responseDto=new ResponseDto();
        ProductCategoryResponse productCategoryResponse=new ProductCategoryResponse();
         ProductCategory productCategory=productcategoryrepository.findByCode(productCategoryDto.getCode());
         productCategory.setDelFlag("Y");
         productcategoryrepository.save(productCategory);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.category.delete.success",null,Locale.ENGLISH));
        productCategoryResponse.setResponseDto(responseDto);
        return productCategoryResponse;
    }

    @Override
    public ProductCategoryResponse getAllProductCategory() {
        ResponseDto responseDto=new ResponseDto();
        ProductCategoryResponse productCategoryResponse=new ProductCategoryResponse();
        List<ProductCategory> productCategoryList=  productcategoryrepository.findAll();
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.category.all.success",null,Locale.ENGLISH));
         productCategoryResponse.setProductCategoryDtoList(convertProductCategoryDtoToModel(productCategoryList));
         productCategoryResponse.setResponseDto(responseDto);
         return productCategoryResponse;

    }

    private List<ProductCategoryDto> convertProductCategoryDtoToModel(List<ProductCategory> productCategoryList){
        List<ProductCategoryDto> productCategoryDtos=new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
           ProductCategoryDto productCategoryDto=  modelMapper.map(productCategory,ProductCategoryDto.class);
           productCategoryDtos.add(productCategoryDto);

        }

        return productCategoryDtos;

    }
}


