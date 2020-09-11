package com.facility.rest.repository.impl;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.facility.rest.model.FoodFacility;
import com.facility.rest.repository.FoodFacilityRepository;

@Repository("FoodFacilityRepository")
public class FoodFacilityRepositoryImpl implements FoodFacilityRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public FoodFacility addFoodFacility(FoodFacility foodFacility) {
		LOGGER.info("addFoodFacility() starts");
		try {
			String Uuid = "L_" + String.valueOf((new SecureRandom()).nextInt((999999 - 100000) + 1) + 100000);
			foodFacility.setLocationid(Uuid);
			;
			this.jdbcTemplate.update("INSERT INTO food_facility(address,applicant,approved,block,blocklot,cnn,days_hours,expiration_date,facility_type,fire_prevention_districts,"
					+ "food_items,latitude,location,location_desc,longitude,location_id,lot,neighborhoods,noi_sent,permit,police_districts,prior_permit,received,schedule,"
					+ "status,supervisor_districts,x_axis,y_axis,zip_codes) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new Object[] { foodFacility.getAddress(), foodFacility.getApplicant(), foodFacility.getApproved(),
							foodFacility.getBlock(), foodFacility.getBlocklot(), foodFacility.getCnn(),
							foodFacility.getDayshours(), foodFacility.getExpirationDate(),
							foodFacility.getFacilityType(), foodFacility.getFirePreventionDistricts(),
							foodFacility.getFoodItems(), foodFacility.getLatitude(), foodFacility.getLocation(),
							foodFacility.getLocationDescription(), foodFacility.getLongitude(),
							foodFacility.getLocationid(), foodFacility.getLot(), foodFacility.getNeighborhoods(),
							foodFacility.getNOISent(), foodFacility.getPermit(), foodFacility.getPoliceDistricts(),
							foodFacility.getPriorPermit(), foodFacility.getReceived(), foodFacility.getSchedule(),
							foodFacility.getStatus(), foodFacility.getSupervisorDistricts(), foodFacility.getxAxis(),
							foodFacility.getyAxis(), foodFacility.getZipCodes() });

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("addFoodFacility() ends");
		return foodFacility;
	}

	@Override
	public FoodFacility updateFoodFacility(FoodFacility foodFacility) {
		LOGGER.info("updateFoodFacility() starts");
		try {
			this.jdbcTemplate.update("UPDATE food_facility SET address = ?, applicant=  ?, approved= ?, block= ?, blocklot = ?, cnn = ?, days_hours = ? , expiration_date = ?,"
					+ "facility_type = ?, fire_prevention_districts=  ?, food_items= ?, latitude= ?, location = ?, location_desc = ?, longitude = ? , lot = ?,"
					+ "neighborhoods = ?, noi_sent=  ?, permit= ?, police_districts= ?, prior_permit = ?, received = ?, schedule = ? , status = ?,"
					+ "supervisor_districts = ?, x_axis=  ?, y_axis= ?, zip_codes= ? WHERE location_id = ? ",
					new Object[] {foodFacility.getAddress(), foodFacility.getApplicant(), foodFacility.getApproved(),
							foodFacility.getBlock(), foodFacility.getBlocklot(), foodFacility.getCnn(),
							foodFacility.getDayshours(), foodFacility.getExpirationDate(),
							foodFacility.getFacilityType(), foodFacility.getFirePreventionDistricts(),
							foodFacility.getFoodItems(), foodFacility.getLatitude(), foodFacility.getLocation(),
							foodFacility.getLocationDescription(), foodFacility.getLongitude(), foodFacility.getLot(), foodFacility.getNeighborhoods(),
							foodFacility.getNOISent(), foodFacility.getPermit(), foodFacility.getPoliceDistricts(),
							foodFacility.getPriorPermit(), foodFacility.getReceived(), foodFacility.getSchedule(),
							foodFacility.getStatus(), foodFacility.getSupervisorDistricts(), foodFacility.getxAxis(),
							foodFacility.getyAxis(), foodFacility.getZipCodes(),
							foodFacility.getLocationid()});
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("updateFoodFacility() ends");
		return foodFacility;
	}

	@Override
	public FoodFacility getByFoodFacilityByFilter(String name) {
		LOGGER.info("deleteFoodFacility() starts");
		FoodFacility deleteFoodFacility = null;
		try {
			deleteFoodFacility = this.jdbcTemplate.queryForObject("SELECT * FROM food_facility WHERE applicant = ? or facility_type=? or status = ?", new Object[] { name,name,name }, new FoodFacility());
		}  catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("deleteFoodFacility() ends");
		return deleteFoodFacility;
	}

	@Override
	public FoodFacility deleteFoodFacility(String id) {
		LOGGER.info("deleteFoodFacility() starts");
		FoodFacility deleteFoodFacilityDelete = new FoodFacility();
		try {
			deleteFoodFacilityDelete.setLocationid(id);
			 this.jdbcTemplate.update("DELETE FROM food_facility WHERE location_id = ?", new Object[] { deleteFoodFacilityDelete.getLocationid() });
		}  catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("deleteFoodFacility() ends");
		return deleteFoodFacilityDelete;
	}

	@Override
	public FoodFacility getByFoodFacilityById(String name) {
		LOGGER.info("deleteFoodFacility() starts");
		FoodFacility deleteFoodFacility = null;
		try {
			deleteFoodFacility = this.jdbcTemplate.queryForObject("SELECT * FROM food_facility WHERE location_id = ?", new Object[] { name }, new FoodFacility());
		}  catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("deleteFoodFacility() ends");
		return deleteFoodFacility;
	}
}