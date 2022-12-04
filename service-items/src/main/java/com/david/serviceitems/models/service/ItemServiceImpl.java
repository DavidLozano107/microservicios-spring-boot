package com.david.serviceitems.models.service;

import com.david.serviceitems.models.Item;
import com.david.serviceitems.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private RestTemplate restClient;

    public ItemServiceImpl(RestTemplate restTemplate) {
        this.restClient = restTemplate;
    }

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(Objects.requireNonNull(restClient.getForObject("http://localhost:8001/api/product/", Product[].class)));
        return products.stream()
                .map(p -> new Item(p,1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id,Integer amount) {
        Map<String,String> pathVariables = new HashMap<String,String>();
        pathVariables.put("id",id.toString());
        Product product = restClient.getForObject("http://localhost:8001/api/product/{id}",Product.class,pathVariables);
        return new Item(product,amount);
    }
}
