package com.coderscampus.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity  
public class User  
{  
  @Id @GeneratedValue  
  private Long id;  
  private String username;  
  private String password;  
  @OneToMany(mappedBy="user")  
  private Set<FoodDiary> foodDiaries = new HashSet<>();
  
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getUsername()
  {
    return username;
  }
  public void setUsername(String username)
  {
    this.username = username;
  }
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  public Set<FoodDiary> getFoodDiaries()
  {
    return foodDiaries;
  }
  public void setFoodDiaries(Set<FoodDiary> foodDiaries)
  {
    this.foodDiaries = foodDiaries;
  }  
  
}  