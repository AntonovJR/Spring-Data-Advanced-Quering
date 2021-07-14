package com.example.advquerying.service;

import com.example.advquerying.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public List<String> getAllByNameStartWith(String m) {
        return this.ingredientRepository.findAllByNameStartsWith(m)
                .stream()
                .map((i -> String.format("%s", i.getName())))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> sortListOfIngredientsByPrice(List<String> nameList) {
        return this.ingredientRepository.findIngredientsByNameInOrderByPriceAsc(nameList)
                .stream()
                .map((i -> String.format("%s", i.getName())))
                .collect(Collectors.toList());
    }

    @Override
    public void updatePrices() {
        this.ingredientRepository.updatePrices();
    }

    @Override
    public void updatePricesByName(String name) {
        this.ingredientRepository.updatePriceByName(name);
    }

    @Override
    public void deleteByName(String name) {
        this.ingredientRepository.deleteByName(name);
    }
}
