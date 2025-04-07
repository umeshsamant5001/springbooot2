package com.swscode.restaurantlisting.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swscode.restaurantlisting.dto.RestaurantDTO;
import com.swscode.restaurantlisting.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restauranrService;
	
	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestaurantDTO> > fetchAllRestaurants(){
		System.out.println("inside fetchAllRestaurants");
		List<RestaurantDTO> allRestaurants = restauranrService.findAllRestaurants();
		
		return new ResponseEntity<>(allRestaurants,null,HttpStatus.SC_OK);
	}
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
		
		System.out.println("inside saveRestaurant");
		RestaurantDTO restaurantAdded = restauranrService.addRestaurantInDB(restaurantDTO);
		
		return new ResponseEntity<RestaurantDTO>(restaurantAdded, null,HttpStatus.SC_CREATED );
		
	}
	
	@GetMapping("/fetchResturantById/{id}")
	public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id){
		System.out.println("in side findRestaurantById");
		RestaurantDTO foundRestaurant = restauranrService.findRestaurantById(id);
		if(null != foundRestaurant ) {
			//return new ResponseEntity<RestaurantDTO>(foundRestaurant, null,HttpStatus.SC_OK );
			return new ResponseEntity<>(foundRestaurant, null,HttpStatus.SC_OK );
		}
		else {
			//return new ResponseEntity<RestaurantDTO>(foundRestaurant, null,HttpStatus.SC_NOT_FOUND );
			return new ResponseEntity<>(foundRestaurant, null,HttpStatus.SC_NOT_FOUND );
		}
		
	}
	
	@GetMapping("/fetchResturantsByCriteria")
	public ResponseEntity<List<RestaurantDTO> > findRestaurantByCriteria(@RequestParam Map<String,String>  filters){
		System.out.println("in side findRestaurantById");
		List<RestaurantDTO> foundRestaurantDtoList = restauranrService.findRestaurantByCriteria(filters);
		if(null != foundRestaurantDtoList ) {
			return new ResponseEntity<>(foundRestaurantDtoList, null,HttpStatus.SC_OK );
			//return foundRestaurantDtoList ;// ResponseEntity<>(foundRestaurantDtoList, null,HttpStatus.SC_OK );
		}
		//else {
		//	//return new ResponseEntity<RestaurantDTO>(foundRestaurant, null,HttpStatus.SC_NOT_FOUND );
		//	return new ResponseEntity<>(foundRestaurant, null,HttpStatus.SC_NOT_FOUND );
		//}
		return null ;		
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/findByDateCreatedBetween")
	public ResponseEntity<List<RestaurantDTO>> findByDateCreatedBetween(@RequestParam String startDate,
			@RequestParam String endDate) throws ParseException {
		System.out.println("in side ontroller  findByDateCreatedBetween");
		System.out.println("startDate " + startDate);
		System.out.println("endDate " + endDate);
		//List<RestaurantDTO> foundRestaurantDtoList = restauranrService.findByDateCreatedBetween(new Date(startDate), new Date(endDate));
		List<RestaurantDTO> foundRestaurantDtoList =  restauranrService.findByDateCreatedBetween(
				new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-15"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-16"));
		   //;new Date(2024,12,15));//
				//, new Date(2024,12,16));
		if (null != foundRestaurantDtoList) {
			return new ResponseEntity<>(foundRestaurantDtoList, null, HttpStatus.SC_OK);
			// return foundRestaurantDtoList ;// ResponseEntity<>(foundRestaurantDtoList,
			// null,HttpStatus.SC_OK );
		}
		// else {
		// //return new ResponseEntity<RestaurantDTO>(foundRestaurant,
		// null,HttpStatus.SC_NOT_FOUND );
		// return new ResponseEntity<>(foundRestaurant, null,HttpStatus.SC_NOT_FOUND );
		// }
		return null;
	}
//	@GetMapping("/fetchAllRestaurants")
//     public void  usingGitCopilot(){
//    	  System.out.println("Using Git Copilot");
//    	  List<RestaurantDTO> allRestaurants = restauranrService.findAllRestaurants();
//    	  System.out.println(allRestaurants);
//    	 
//     }
}
