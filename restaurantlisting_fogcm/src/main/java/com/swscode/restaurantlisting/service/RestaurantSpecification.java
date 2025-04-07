package com.swscode.restaurantlisting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import com.swscode.restaurantlisting.entity.Restaurant;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class RestaurantSpecification {
	
	public static Specification<Restaurant> getRestaurantList(Map<String, String> filters) {

		return new Specification<Restaurant>() {

			@Override
			public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				
				System.out.println("inside RestaurantSpecification.getRestaurantList");

				List<Predicate> predicates = new ArrayList<>();
                // for like query
				/*
				if (filters.containsKey("name")) {
					predicates.add(criteriaBuilder.like(root.get("name"), "%" + filters.get("name") + "%"));
				}

				if (filters.containsKey("address")) {
					predicates.add(criteriaBuilder.like(root.get("address"), "%" + filters.get("address") + "%"));
				}

				if (filters.containsKey("city")) {
					predicates.add(criteriaBuilder.like(root.get("city"), "%" + filters.get("city")));
				} */
				
				// for equal query
				if (filters.containsKey("name")) {
					predicates.add(criteriaBuilder.equal(root.get("name"), filters.get("name")));
				}

				if (filters.containsKey("address")) {
					predicates.add(criteriaBuilder.like(root.get("address"), filters.get("address")));
				}

				if (filters.containsKey("city")) {
					predicates.add(criteriaBuilder.like(root.get("city"), filters.get("city")));
				}
				
				System.out.println(">>>predicates.size()  " + predicates.size());
				System.out.println(">>>predicates.size()  " + predicates);
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}
