package com.facility.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facility.rest.model.FoodFacility;
import com.facility.rest.repository.FoodFacilityRepository;
import com.facility.rest.service.FoodFacilityService;

@Transactional
@Service("foodFacilityService")
public class FoodFacilityServiceImpl implements FoodFacilityService {

	@Autowired
	private FoodFacilityRepository foodFacilityRepository;



	@Override
	public FoodFacility addFoodFacility(FoodFacility foodFacility) {
		LOGGER.info("addFoodFacility() starts");
		try {
			foodFacility = this.foodFacilityRepository.addFoodFacility(foodFacility);
		}  catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("addFoodFacility() Ends");
		return foodFacility;
	}

	@Override
	public FoodFacility updateFoodFacility(FoodFacility foodFacility) {
		LOGGER.info("updateFoodFacility() starts");
		try {

			if (foodFacility.getLocationid() == null || foodFacility.getLocationid().trim().isEmpty()) {
				throw new Exception("This is not in db");
			}
				
			FoodFacility cs = this.foodFacilityRepository.getByFoodFacilityById(foodFacility.getLocationid());

			if (cs == null)
				throw new Exception("This is not in db");
			cs.merge(foodFacility);
			foodFacility = this.foodFacilityRepository.updateFoodFacility(cs);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("updateFoodFacility() ends");
		return foodFacility;
	}

	@Override
	public FoodFacility getByFoodFacilityByFilter(String name) {
		LOGGER.info("getByFoodFacilityByFilter() starts");
		FoodFacility foodFacility = null;
		try {
			foodFacility = this.foodFacilityRepository.getByFoodFacilityByFilter(name);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("getByFoodFacilityByFilter() ends");
		return foodFacility;
	}

	@Override
	public FoodFacility deleteFoodFacility(String id) {
		LOGGER.info("deleteFoodFacility() starts");
		FoodFacility foodFacility = null;
		try {
			foodFacility = this.foodFacilityRepository.deleteFoodFacility(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("deleteFoodFacility() ends");
		return foodFacility;
	}
}
