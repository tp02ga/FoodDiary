package com.coderscampus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderscampus.domain.FoodDiary;
import com.coderscampus.domain.User;
import com.coderscampus.repository.FoodDiaryRepository;

@Controller
public class RootController
{
  @Autowired
  private FoodDiaryRepository foodDiaryRepository;

  @RequestMapping(value="", method=RequestMethod.GET)
  public String rootMapping (ModelMap model)
  {
    model.put("foodDiary", new FoodDiary());
    return "foodDiary";
  }
  
  @RequestMapping(value="/food-diaries/mealType/{mealType}", method=RequestMethod.GET)
  public String findByMealTypes (@PathVariable String mealType, ModelMap model)
  {
    List<FoodDiary> findByMealType = foodDiaryRepository.findByMealType(mealType);
    
    model.put("foodDiaries", findByMealType);
    
    return "foodDiary";
  }
  
  @RequestMapping(value="/food-diaries/cost-less-than/{cost}", method=RequestMethod.GET)
  public String findByCostLessThan (@PathVariable Double cost, ModelMap model)
  {
    List<FoodDiary> findByMealType = foodDiaryRepository.findByCostLessThan(cost);
    
    model.put("foodDiaries", findByMealType);
    
    return "foodDiary";
  }
  
  @RequestMapping(value="/food-diaries/cost-greater-than/{cost}", method=RequestMethod.GET)
  public String findByCostGreaterThan (@PathVariable Double cost, ModelMap model)
  {
    List<FoodDiary> findByMealType = foodDiaryRepository.findByCostGreaterThan(cost);
    
    model.put("foodDiaries", findByMealType);
    
    return "foodDiary";
  }
  
  @RequestMapping(value="/food-diaries/search/{food}-{mealType}", method=RequestMethod.GET)
  public String findByFoodAndMealType (@PathVariable String food, @PathVariable String mealType, ModelMap model)
  {
    List<FoodDiary> findByMealType = foodDiaryRepository.findByFoodAndMealType(food, mealType);
    
    model.put("foodDiaries", findByMealType);
    
    return "foodDiary";
  }
  
  @RequestMapping(value="/food-diaries/cost-between/{minCost}-{maxCost}", method=RequestMethod.GET)
  public String findByCostBetween(@PathVariable Double minCost, @PathVariable Double maxCost, ModelMap model)
  {
    List<FoodDiary> findByMealType = foodDiaryRepository.findByCostBetween(minCost, maxCost);
    
    model.put("foodDiaries", findByMealType);
    
    return "foodDiary";
  }

  @RequestMapping(value="", method=RequestMethod.POST)
  public String rootMappingPost(@ModelAttribute FoodDiary foodDiary, ModelMap model)
  {
    foodDiaryRepository.save(foodDiary);
    
    return "redirect:/";
  }
  
  @RequestMapping(value="food-diaries/{foodDiaryId}", method=RequestMethod.POST)
  public String updateFoodDiaryEntry(@ModelAttribute FoodDiary foodDiary, @PathVariable Long foodDiaryId, ModelMap model)
  {
    foodDiary.setId(foodDiaryId);
    foodDiaryRepository.save(foodDiary);
    
    return "redirect:/food-diaries/" + foodDiary.getId();
  }
  
  @RequestMapping(value="food-diaries/{foodDiaryId}", method=RequestMethod.GET)
  public String getFoodDiaryItem (@PathVariable Long foodDiaryId, ModelMap model)
  {
    FoodDiary foodDiaryItem = foodDiaryRepository.findOne(foodDiaryId);
    
    model.put("foodDiary", foodDiaryItem);

    return "foodDiary";
  }
  
  @RequestMapping(value="food-diaries/{foodDiaryId}", method=RequestMethod.POST, params="action=delete")  
  public String deleteFoodDiary(@PathVariable Long foodDiaryId)   
  {  
    // we always need to load our entity from the database before we perform a delete  
    FoodDiary foodDiaryItem = foodDiaryRepository.findOne(foodDiaryId);  
     
    // Get the User entity that owns this FoodDiary entity  
    User user = foodDiaryItem.getUser();  

    if (user != null)
    {
      user.getFoodDiaries().remove(foodDiaryItem);  
    }
    
    // now we need to remove the user from our foodDiaryItem;  
    foodDiaryItem.setUser(null);  
    
    foodDiaryRepository.delete(foodDiaryItem);  
    
    return "redirect:/";  
  }  
}
