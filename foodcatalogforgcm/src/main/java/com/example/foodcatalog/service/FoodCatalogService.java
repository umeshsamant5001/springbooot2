package com.example.foodcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.foodcatalog.dto.FoodCatalogPage;
import com.example.foodcatalog.dto.FoodItemDTO;
import com.example.foodcatalog.dto.Restaurant;
import com.example.foodcatalog.entity.FoodItem;
import com.example.foodcatalog.mapper.FoodItemMapper;
import com.example.foodcatalog.repo.FoodItemRepo;

@Service
public class FoodCatalogService {
	
	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
		
		FoodItem foodItemSaved  = foodItemRepo.save(FoodItemMapper.INSTANCE.foodItemDTOtoFoodItem(foodItemDTO));
		// TODO Auto-generated method stub
		return FoodItemMapper.INSTANCE.foodItemToFoodItemDTO(foodItemSaved);
	}

	public FoodCatalogPage fetchFoodCatalogPageDetails(Integer restaurantId) {
		// TODO Auto-generated method stub
		// Need FoodItem from Restauramt  from FoodItem table and RestauramtDetails from restuarantdb
		List<FoodItem> foodItemLsit = fetchFoodItemList(restaurantId);
		Restaurant restaurant  = fetchRestaurantDetailsFromRestaurantListingMS(restaurantId);
		return createFoodCataloguePage(foodItemLsit, restaurant);
		
	}

	
	
	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		// TODO Auto-generated method stub
		return foodItemRepo.findByRestaurantId(restaurantId);
		
	}
	

	private Restaurant fetchRestaurantDetailsFromRestaurantListingMS(Integer restaurantId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://RESTAURANTLISTING/restaurant/fetchResturantById/"+restaurantId, Restaurant.class);
		
	}
	
	private FoodCatalogPage createFoodCataloguePage(List<FoodItem> foodItemLsit, Restaurant restaurant) {
		// TODO Auto-generated method stub
		FoodCatalogPage foodCatalogPage = new FoodCatalogPage();
		foodCatalogPage.setFoodItemsList(foodItemLsit);
		foodCatalogPage.setRestaurant(restaurant);
		return foodCatalogPage;
		
	}

	
	

}
