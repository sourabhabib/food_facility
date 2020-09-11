package com.facility.rest.repository;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facility.rest.model.FoodFacility;


public interface FoodFacilityRepository {
	

	public static final Logger LOGGER = LoggerFactory.getLogger(FoodFacilityRepository.class);

	public FoodFacility addFoodFacility(FoodFacility foodFacility);

	public FoodFacility updateFoodFacility(FoodFacility foodFacility);

	public FoodFacility getByFoodFacilityByFilter(String name);

	public FoodFacility getByFoodFacilityById(String name);
	
	public FoodFacility deleteFoodFacility(String id);
	
	
}

