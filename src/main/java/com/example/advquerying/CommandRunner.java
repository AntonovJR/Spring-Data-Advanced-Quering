package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.service.IngredientService;
import com.example.advquerying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRunner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public CommandRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) {
        //printShampooBySize();
        //printShampooBySizeAndLabel();
        //printShampooExpensiveThan();
        // printIngredientsByNameStartWith();
        //printSortedIngredientsByPrice();
        //printCountOfShampoosCheaperThan();
        //printShampooWithIngredients();
        //printShampooByIngredientsCount();
        //deleteIngredientByName();
        //updateIngredientsPrice();
        //updateIngredientsPriceByName();

    }

    private void deleteIngredientByName() {
        ingredientService.deleteByName("Apple");
    }

    private void updateIngredientsPriceByName() {
        ingredientService.updatePricesByName("Apple");
    }

    private void updateIngredientsPrice() {
        ingredientService.updatePrices();
    }

    private void printShampooByIngredientsCount() {
        shampooService.findShampooByIngredientCount(2).forEach(System.out::println);
    }

    private void printShampooWithIngredients() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Berry");
        stringList.add("Mineral-Collagen");

        shampooService.findShampooByIngredients(stringList)
                .forEach(System.out::println);
    }

    private void printCountOfShampoosCheaperThan() {
        int count = shampooService.getCountOfShampoosCheaperThan(new BigDecimal("8.5"));
        System.out.println(count);
    }

    private void printSortedIngredientsByPrice() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Lavender");
        stringList.add("Herbs");
        stringList.add("Apple");
        ingredientService.sortListOfIngredientsByPrice(stringList)
                .forEach(System.out::println);
    }

    private void printIngredientsByNameStartWith() {
        ingredientService.getAllByNameStartWith("M").forEach(System.out::println);

    }


    private void printShampooExpensiveThan() {
        shampooService.getAllExpensiveThan(new BigDecimal(5)).forEach(System.out::println);
    }

    private void printShampooBySizeAndLabel() {
        shampooService.getAllBySizeAndLabel(Size.MEDIUM, 10L).forEach(System.out::println);
    }

    private void printShampooBySize() {
        shampooService.getAllBySizeOrderById(Size.MEDIUM).forEach(System.out::println);
    }
}
