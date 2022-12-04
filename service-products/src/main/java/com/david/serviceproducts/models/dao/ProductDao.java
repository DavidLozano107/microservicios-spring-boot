package com.david.serviceproducts.models.dao;

import com.david.serviceproducts.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Long> {

}
