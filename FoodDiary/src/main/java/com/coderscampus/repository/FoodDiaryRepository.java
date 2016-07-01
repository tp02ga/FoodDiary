package com.coderscampus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coderscampus.domain.FoodDiary;

public interface FoodDiaryRepository extends JpaRepository<FoodDiary, Long> 
{
  @Query  
  public List<FoodDiary> findByMealType(String mealType);
  
  @Query
  public List<FoodDiary> findByCostGreaterThan(Double cost);

  @Query
  public List<FoodDiary> findByCostLessThan(Double cost);

  @Query
  public List<FoodDiary> findByCostBetween(Double minCost, Double maxCost);
  
  @Query("from FoodDiary where food = :foodParam and mealType = :mealTypeParam")
  public List<FoodDiary> findByFoodAndMealType(@Param("foodParam") String food, @Param("mealTypeParam") String mealType);
}
