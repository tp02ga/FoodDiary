package com.coderscampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.domain.FoodDiary;

public interface FoodDiaryRepository extends JpaRepository<FoodDiary, Long> 
{
  //it can be empty inside if you want, or later, you can add any custom queries if the standard set of CRUD operations aren't enough. 
}
