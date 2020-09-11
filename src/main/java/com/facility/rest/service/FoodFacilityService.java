package com.facility.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facility.rest.model.FoodFacility;



public interface FoodFacilityService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(FoodFacilityService.class);
	public FoodFacility addFoodFacility(FoodFacility foodFacility);

	public FoodFacility updateFoodFacility(FoodFacility foodFacility);

	public FoodFacility getByFoodFacilityByFilter(String name);
	
	public FoodFacility deleteFoodFacility(String id);
}
