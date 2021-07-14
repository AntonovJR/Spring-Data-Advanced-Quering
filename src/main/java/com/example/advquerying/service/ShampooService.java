package com.example.advquerying.service;

import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<String> getAllBySizeOrderById(Size size);

    List<String> getAllBySizeAndLabel(Size size, long label);

    List<String> getAllExpensiveThan(BigDecimal v);


    int getCountOfShampoosCheaperThan(BigDecimal bigDecimal);

    List<String> findShampooByIngredients(List<String> stringList);

    List<String> findShampooByIngredientCount(int count);
}
