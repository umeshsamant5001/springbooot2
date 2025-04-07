package com.example.foodcatalog.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodcatalog.dto.FoodCatalogPage;
import com.example.foodcatalog.dto.FoodItemDTO;
import com.example.foodcatalog.service.FoodCatalogService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogController {
	
	@Autowired
	FoodCatalogService foodCatalogService;
	
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
		
		System.out.println("inside addFoodItem");
		FoodItemDTO foodItemSaved = foodCatalogService.addFoodItem(foodItemDTO);
		
		return new ResponseEntity(foodItemSaved , null, HttpStatus.SC_CREATED);
		
	}
	
	@GetMapping("/fetchRestaurantsandFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodCatalogPage> fethRestaurantDetailsWithFoodMenu(@PathVariable Integer restaurantId){
		
		System.out.println("inside fethRestaurantDetailsWithFoodMenu");
		FoodCatalogPage foodCatalogPage = foodCatalogService.fetchFoodCatalogPageDetails(restaurantId);
		return new ResponseEntity<FoodCatalogPage>(foodCatalogPage,null, HttpStatus.SC_OK);
		
		
		
		
	}

}
