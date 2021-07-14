package com.example.advquerying.service;

import com.example.advquerying.entities.Size;
import com.example.advquerying.repository.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<String> getAllBySizeOrderById(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size)
                .stream()
                .map((s -> String.format("%s %s %.2flv.", s.getBrand(), s.getSize().name(), s.getPrice())))
                .collect(Collectors.toList());

    }

    @Override
    public List<String> getAllBySizeAndLabel(Size size, long label) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPriceAsc(size, label)
                .stream()
                .map((s -> String.format("%s %s %.2flv.", s.getBrand(), s.getSize().name(), s.getPrice())))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllExpensiveThan(BigDecimal v) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(v)
                .stream()
                .map((s -> String.format("%s %s %.2flv.", s.getBrand(), s.getSize().name(), s.getPrice())))
                .collect(Collectors.toList());
    }

    @Override
    public int getCountOfShampoosCheaperThan(BigDecimal bigDecimal) {
        return this.shampooRepository.countShampooByPriceLessThan(bigDecimal);
    }

    @Override
    public List<String> findShampooByIngredients(List<String> stringList) {

        return shampooRepository.findShampoosByIngredientsNames(stringList)
                .stream()
                .map((s -> String.format("%s", s.getBrand())))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findShampooByIngredientCount(int count) {
        return shampooRepository.findShampoosByIngredientsCount(count)
                .stream()
                .map((s -> String.format("%s", s.getBrand())))
                .collect(Collectors.toList());
    }


}
