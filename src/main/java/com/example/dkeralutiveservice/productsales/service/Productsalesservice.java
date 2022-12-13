package com.example.dkeralutiveservice.productsales.service;

import com.example.dkeralutiveservice.productsales.dto.ProductSalesDto;
import com.example.dkeralutiveservice.productsales.resp.ProductSalesResponse;

public interface Productsalesservice {

    ProductSalesResponse updateProductSales(ProductSalesDto productSalesDto);
}
