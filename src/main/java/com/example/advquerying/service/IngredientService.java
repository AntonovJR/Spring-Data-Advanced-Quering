package com.example.advquerying.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IngredientService {
    List<String> getAllByNameStartWith(String m);

    List<String> sortListOfIngredientsByPrice(List<String> namesList);

    @Transactional
    void updatePrices();

    @Transactional
    void updatePricesByName(String name);

    @Transactional
    void deleteByName(String name);
}
