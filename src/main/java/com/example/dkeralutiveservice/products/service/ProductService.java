package com.example.dkeralutiveservice.products.service;

import com.example.dkeralutiveservice.products.dto.ProductDto;
import com.example.dkeralutiveservice.products.resp.ProductResponse;

public interface ProductService {

    ProductResponse addProduct(ProductDto productDto);

    ProductResponse updateProduct(ProductDto productDto);

    ProductResponse deleteProduct(ProductDto productDto);

    ProductResponse allProducts();

}
