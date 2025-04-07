package com.swscode.restaurantlisting.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.swscode.restaurantlisting.entity.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant , Integer>, JpaSpecificationExecutor<Restaurant> {

	
	List<Restaurant> findAll(Specification<Restaurant> specification);
	List<Restaurant> findByDateCreatedBetween(Date startDate, Date endDate);
	

}
