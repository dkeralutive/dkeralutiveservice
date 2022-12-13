package com.example.dkeralutiveservice.productcategory.service;

import com.example.dkeralutiveservice.productcategory.dto.ProductCategoryDto;
import com.example.dkeralutiveservice.productcategory.resp.ProductCategoryResponse;

public interface ProductCategoryService {

    ProductCategoryResponse addProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategoryResponse updateProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategoryResponse deleteProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategoryResponse getAllProductCategory();
}
