package com.example.advquerying.repository;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartsWith(String name);

    List<Ingredient> findIngredientsByNameInOrderByPriceAsc(List<String> nameList);


    @Query(value = "update Ingredient set price = price*1.1")
    @Modifying
    void updatePrices();

    @Query(value = "update Ingredient i set i.price = i.price*1.1 where i.name = :name")
    @Modifying
    void updatePriceByName(@Param(value = "name") String name);

    @Query(value = "delete from Ingredient i where i.name = :name")
    @Modifying
    void deleteByName(String name);
}
