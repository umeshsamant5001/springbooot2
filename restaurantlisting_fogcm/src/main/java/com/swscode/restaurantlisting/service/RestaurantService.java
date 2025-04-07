package com.swscode.restaurantlisting.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.swscode.restaurantlisting.dto.RestaurantDTO;
import com.swscode.restaurantlisting.entity.Restaurant;
import com.swscode.restaurantlisting.exception.ResourceNotFoundException;
import com.swscode.restaurantlisting.mapper.RestaurantMapper;
import com.swscode.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo restauranrRepo;
	
    public List<RestaurantDTO> findAllRestaurants() {
    	
    	List<Restaurant> restaurants  = restauranrRepo.findAll();
    	List<RestaurantDTO> restaurantDToList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
    	// Map to list of DTO
    	return restaurantDToList;
    	
    	
    }
    
    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
    	
    	Restaurant savedRestaurant =  restauranrRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDToRestaurant(restaurantDTO));
    	return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
    }
    
    public RestaurantDTO findRestaurantById(Integer id) {
    	
    	Optional<Restaurant> foundRestaurant  = restauranrRepo.findById(id);
    	if(foundRestaurant.isPresent()) {
    		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(foundRestaurant.get());
    	}
    	else {
    		
    		throw new ResourceNotFoundException("Restaurant not found with Id:  " + id );
    		//return null;
    	}
    	
    }

	public List<RestaurantDTO> findRestaurantByCriteria(Map<String, String> filters) {
		// TODO Auto-generated method stub
		System.out.println(" inside service findRestaurantByCriteria");
		final Specification<Restaurant> specification = RestaurantSpecification.getRestaurantList(filters);
		List<Restaurant> restaurants = restauranrRepo.findAll(specification);
		List<RestaurantDTO> restaurantDToList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
		
		return restaurantDToList;
	}

	public List<RestaurantDTO> findByDateCreatedBetween(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		System.out.println(" inside service findByDateCreatedBetween");
		System.out.println("startDat before calling repoe: " + startDate);
		System.out.println("endDate before calling repoe: " + endDate);
		List<Restaurant> restaurants = restauranrRepo.findByDateCreatedBetween(startDate, endDate);
		List<RestaurantDTO> restaurantDToList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
		return restaurantDToList;
	}
    
}

