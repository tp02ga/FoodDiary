package com.coderscampus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FoodDiary
{
  @Id
  @GeneratedValue
  private Long id;
  private String food;
  private String mealType;
  private String timeOfDay;
  private Double cost;
  @ManyToOne  
  private User user;  
  
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getFood()
  {
    return food;
  }
  public void setFood(String food)
  {
    this.food = food;
  }
  public String getMealType()
  {
    return mealType;
  }
  public void setMealType(String mealType)
  {
    this.mealType = mealType;
  }
  public String getTimeOfDay()
  {
    return timeOfDay;
  }
  public void setTimeOfDay(String timeOfDay)
  {
    this.timeOfDay = timeOfDay;
  }
  public Double getCost()
  {
    return cost;
  }
  public void setCost(Double cost)
  {
    this.cost = cost;
  }
  public User getUser()
  {
    return user;
  }
  public void setUser(User user)
  {
    this.user = user;
  }
  
}
