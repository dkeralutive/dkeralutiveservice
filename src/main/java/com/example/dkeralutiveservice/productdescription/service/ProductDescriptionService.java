package com.example.dkeralutiveservice.productdescription.service;

import com.example.dkeralutiveservice.productdescription.dto.ProductDescriptionDto;
import com.example.dkeralutiveservice.productdescription.resp.ProductDescriptionResponse;

public interface ProductDescriptionService {

    ProductDescriptionResponse addProductDescription(ProductDescriptionDto productDescriptionDto);

    ProductDescriptionResponse updateProductDescription(ProductDescriptionDto productDescriptionDto);

    ProductDescriptionResponse deleteProductDescription(ProductDescriptionDto productDescriptionDto);

    ProductDescriptionResponse allProductDescription(ProductDescriptionDto productDescriptionDto);
    ProductDescriptionResponse allProductDescriptionByProductCode(String productCode);

    ProductDescriptionResponse getProductDescription(String productDescriptionCode);
}
