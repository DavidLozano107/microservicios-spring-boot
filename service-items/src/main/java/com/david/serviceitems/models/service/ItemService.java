package com.david.serviceitems.models.service;

import com.david.serviceitems.models.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id,Integer amount);
}
