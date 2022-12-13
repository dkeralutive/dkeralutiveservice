package com.example.dkeralutiveservice.productdescription.service.implementation;

import com.example.dkeralutiveservice.productcategory.model.ProductCategory;
import com.example.dkeralutiveservice.productcategory.repository.Productcategoryrepository;
import com.example.dkeralutiveservice.productcategory.resp.ProductCategoryResponse;
import com.example.dkeralutiveservice.productdescription.dto.ProductDescriptionDto;
import com.example.dkeralutiveservice.productdescription.model.ProductDescription;
import com.example.dkeralutiveservice.productdescription.repository.ProductDescriptionRepository;
import com.example.dkeralutiveservice.productdescription.resp.ProductDescriptionResponse;
import com.example.dkeralutiveservice.productdescription.service.ProductDescriptionService;
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
public class ProductDescriptionServiceImpl implements ProductDescriptionService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductDescriptionRepository productDescriptionRepository;

    @Autowired
    Productcategoryrepository productcategoryrepository;
    @Autowired
    MessageSource messageSource;


    @Override
    public ProductDescriptionResponse addProductDescription(ProductDescriptionDto productDescriptionDto) {
         ResponseDto responseDto=new ResponseDto();
         ProductDescriptionResponse productCategoryResponse=new ProductDescriptionResponse();
         ProductCategory products=productcategoryrepository.findByCode(productDescriptionDto.getProductCategoryCode());
         ProductDescription productDescription=modelMapper.map(productDescriptionDto, ProductDescription.class);
         productDescription.setProductCategory(products);
         productDescriptionRepository.save(productDescription);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.description.add.success",null,Locale.ENGLISH));
        productCategoryResponse.setResponseDto(responseDto);
        return productCategoryResponse;
    }

    @Override
    public ProductDescriptionResponse updateProductDescription(ProductDescriptionDto productDescriptionDto) {
        ResponseDto responseDto=new ResponseDto();
        ProductDescriptionResponse productCategoryResponse=new ProductDescriptionResponse();
        ProductCategory products=productcategoryrepository.findByCode(productDescriptionDto.getProductCategoryCode());
        ProductDescription oldProductDescription= productDescriptionRepository.findByCode(productDescriptionDto.getCode());
        productDescriptionDto.setId(oldProductDescription.getId());
        ProductDescription productDescription=modelMapper.map(productDescriptionDto, ProductDescription.class);
        productDescription.setProductCategory(products);
        productDescriptionRepository.save(productDescription);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.description.update.success",null,Locale.ENGLISH));
        productCategoryResponse.setResponseDto(responseDto);
        return productCategoryResponse;

    }

    @Override
    public ProductDescriptionResponse deleteProductDescription(ProductDescriptionDto productDescriptionDto) {
        ResponseDto responseDto=new ResponseDto();
        ProductDescriptionResponse productCategoryResponse=new ProductDescriptionResponse();
       ProductDescription productDescription=  productDescriptionRepository.findByCode(productDescriptionDto.getCode());
       productDescription.setDelFlag("Y");
       productDescriptionRepository.save(productDescription);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.description.delete.success",null,Locale.ENGLISH));
        productCategoryResponse.setResponseDto(responseDto);
        return productCategoryResponse;
    }

    @Override
    public ProductDescriptionResponse allProductDescription(ProductDescriptionDto productDescriptionDto) {
        ResponseDto responseDto=new ResponseDto();
        ProductDescriptionResponse productCategoryResponse=new ProductDescriptionResponse();
        List<ProductDescription> productDescription=  productDescriptionRepository.findAll();
        productCategoryResponse.setProductDescriptionDtoList(convertModelToDto(productDescription));
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.description.all.success",null,Locale.ENGLISH));
        productCategoryResponse.setResponseDto(responseDto);
        return productCategoryResponse;
    }

    private List<ProductDescriptionDto> convertModelToDto(List<ProductDescription> productDescriptions){
        List<ProductDescriptionDto> productDescriptionDtoList=new ArrayList<>();
        for(ProductDescription productDescription:productDescriptions){
          ProductDescriptionDto productDescriptionDto=   modelMapper.map(productDescription,ProductDescriptionDto.class);
          productDescriptionDtoList.add(productDescriptionDto);
        }
        return productDescriptionDtoList;
    }


    @Override
    public ProductDescriptionResponse allProductDescriptionByProductCode(String productCode) {
        ResponseDto responseDto=new ResponseDto();
        ProductDescriptionResponse productDescriptionResponse=new ProductDescriptionResponse();
        List<ProductDescription> productDescriptions=  productDescriptionRepository.findByProductCode(productCode);
        List<ProductDescriptionDto> productDescriptions1= convertModelToDto(productDescriptions);
        productDescriptionResponse.setProductDescriptionDtoList(productDescriptions1);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.description.all.success",null,Locale.ENGLISH));
        return productDescriptionResponse;
    }

    @Override
    public ProductDescriptionResponse getProductDescription(String productDescriptionCode) {
        ResponseDto responseDto=new ResponseDto();
        ProductDescriptionResponse productDescriptionResponse=new ProductDescriptionResponse();
        System.out.println("getting the product Description code "+productDescriptionCode);
        ProductDescription productDescription=productDescriptionRepository.findByCode(productDescriptionCode);
        System.out.println("getting the product description"+productDescription);
       ProductDescriptionDto productDescriptionDto= modelMapper.map(productDescription,ProductDescriptionDto.class);
        productDescriptionResponse.setProductDescriptionDto(productDescriptionDto);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("product.description.all.success",null,Locale.ENGLISH));
        productDescriptionResponse.setResponseDto(responseDto);
        return productDescriptionResponse;
    }
}
