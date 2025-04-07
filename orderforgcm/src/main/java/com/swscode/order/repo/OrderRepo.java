package com.swscode.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swscode.order.entity.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order , Long> {
	
	

}
