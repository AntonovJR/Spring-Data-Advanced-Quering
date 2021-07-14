package com.example.advquerying.repository;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, long label);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal priceTag);

    Integer countShampooByPriceLessThan(BigDecimal price);

    @Query(value = "select s from Shampoo s join s.ingredients i where i.name in :ingredientsList")
    List<Shampoo> findShampoosByIngredientsNames(@Param(value = "ingredientsList") List<String> ingredientsList);

    @Query(value = "Select s from Shampoo s where s.ingredients.size < :count")
    List<Shampoo> findShampoosByIngredientsCount(@Param(value = "count") int count);

}
