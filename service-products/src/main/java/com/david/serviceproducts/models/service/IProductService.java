package com.david.serviceproducts.models.service;

import com.david.serviceproducts.models.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product>  findAll();
    public Product findById(Long id);
}
