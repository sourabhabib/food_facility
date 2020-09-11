package com.facility.rest.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facility.rest.model.FoodFacility;
import com.facility.rest.service.FoodFacilityService;
import com.facility.rest.util.Response;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = { "foodFacility/api/v1.0" })
public class FoodFacilityController {
	private static Logger LOGGER = LoggerFactory.getLogger(FoodFacilityController.class);

	@Autowired
	private FoodFacilityService foodFacilityService;
	
	@ApiOperation(value = "ADD_FoodFacilityService", notes = "" + "Add FoodFacilityService"
			+ "<p> { \"Applicant\": \" \", \"FacilityType\": \" \", \"cnn\": \"\", \"LocationDescription\":\"\",\"Address\":\"\",\"blocklot\":\"\", "
			+ "\"block\": \" \", \"lot\": \" \", \"permit\": \"\", \"Status\":\"\",\"FoodItems\":\"\","
			+ "\"xAxis\":\"\", \"yAxis\": \" \", \"Latitude\": \" \", \"Longitude\": \"\", \"Schedule\":\"\",\"dayshours\":\"\",\"NOISent\":\"\","
			+ "\"Approved\":\"\", \"Received\": \" \", \"PriorPermit\": \" \", \"ExpirationDate\": \"\", \"Location\":\"\",\"FirePreventionDistricts\":\"\",\"PoliceDistricts\":\"\","
			+ "\"SupervisorDistricts\":\"\", \"ZipCodes\": \" \", \"Neighborhoods\": \" \"} </p>")
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Add FoodFacilityService."),
			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input data"),
			@io.swagger.annotations.ApiResponse(code = 406, message = "Query error"),
			@io.swagger.annotations.ApiResponse(code = 424, message = "Data dependancy failure"),
			@io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error"), })
	@ApiImplicitParams({ @ApiImplicitParam(name = "foodFacility", required = true, dataType = "FoodFacility", paramType = "body") })
	@RequestMapping(value = { "/foodFacility/addFoodFacility/" }, method = RequestMethod.POST)
	public ResponseEntity<Response<FoodFacility>> addCustomer(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody FoodFacility foodFacility) {
		LOGGER.info("addFoodFacility() start");
		ResponseEntity<Response<FoodFacility>> responseEntity = null;
		try {
			responseEntity = new Response<FoodFacility>(this.foodFacilityService.addFoodFacility(foodFacility), httpRequest.getSession())
					.responseBuilder();
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("addFoodFacility() ends");
		return responseEntity;
	}
	@ApiOperation(value = "Update_FoodFacilityService", notes = "" + "Update FoodFacilityService"
			+ "<p> { \"locationid\": \" \", \"Applicant\": \" \", \"FacilityType\": \" \", \"cnn\": \"\", \"LocationDescription\":\"\",\"Address\":\"\",\"blocklot\":\"\", "
			+ "\"block\": \" \", \"lot\": \" \", \"permit\": \"\", \"Status\":\"\",\"FoodItems\":\"\","
			+ "\"xAxis\":\"\", \"yAxis\": \" \", \"Latitude\": \" \", \"Longitude\": \"\", \"Schedule\":\"\",\"dayshours\":\"\",\"NOISent\":\"\","
			+ "\"Approved\":\"\", \"Received\": \" \", \"PriorPermit\": \" \", \"ExpirationDate\": \"\", \"Location\":\"\",\"FirePreventionDistricts\":\"\",\"PoliceDistricts\":\"\","
			+ "\"SupervisorDistricts\":\"\", \"ZipCodes\": \" \", \"Neighborhoods\": \" \"} </p>")
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Update data"),
			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input data"),
			@io.swagger.annotations.ApiResponse(code = 406, message = "Query error"),
			@io.swagger.annotations.ApiResponse(code = 412, message = "Translation not found"),
			@io.swagger.annotations.ApiResponse(code = 424, message = "Data dependancy failure"),
			@io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error"), })
	@ApiImplicitParams({ @ApiImplicitParam(name = "foodFacility", required = true, dataType = "FoodFacility", paramType = "body") })
	@RequestMapping(value = { "/foodFacility/updateFoodFacility/" }, method = RequestMethod.PUT)
	public ResponseEntity<Response<FoodFacility>> updateCustomer(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
			@RequestBody FoodFacility foodFacility) {
		LOGGER.info("updateFoodFacility() start");
		ResponseEntity<Response<FoodFacility>> responseEntity = null;
		try {
			responseEntity = new Response<FoodFacility>(this.foodFacilityService.updateFoodFacility(foodFacility), httpRequest.getSession())
					.responseBuilder();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("updateFoodFacility() ends");
		return responseEntity;
	}
	@ApiOperation(value = "GET_BY_FILTER", notes = "" + "Get By status or applicant or facility type")
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "results"),
			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input data"),
			@io.swagger.annotations.ApiResponse(code = 406, message = "Query error"),
			@io.swagger.annotations.ApiResponse(code = 424, message = "Data dependancy failure"),
			@io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error"), })
	@ApiImplicitParams({ @ApiImplicitParam(name = "filter", required = true, dataType = "String", paramType = "path"), })

	@RequestMapping(value = { "/foodFacility/getByFilter/{filter}" }, method = RequestMethod.GET)
	public ResponseEntity<Response<FoodFacility>> getByCustomerGstinNo(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse, @PathVariable String filter) {
		LOGGER.info("getByFoodFacilityByFilter() starts");
		ResponseEntity<Response<FoodFacility>> responseEntity = null;
		try {
			responseEntity = new Response<FoodFacility>(this.foodFacilityService.getByFoodFacilityByFilter(filter), httpRequest.getSession())
					.responseBuilder();
		}  catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("getByFoodFacilityByFilter() ends");
		return responseEntity;
	}
	@ApiOperation(value = "Delete", notes = "" + "Delete by location id")
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Deleted"),
			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input data"),
			@io.swagger.annotations.ApiResponse(code = 406, message = "Query error"),
			@io.swagger.annotations.ApiResponse(code = 424, message = "Data dependancy failure"),
			@io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error"), })
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", required = true, dataType = "String", paramType = "path"), })

	@RequestMapping(value = { "/foodFacility/deleteByLocationId/{name}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Response<FoodFacility>> getByCustomerName(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse, @PathVariable String name) {
		LOGGER.info("deleteByLocationId() starts");
		ResponseEntity<Response<FoodFacility>> responseEntity = null;
		try {
			responseEntity = new Response<FoodFacility>(this.foodFacilityService.deleteFoodFacility(name), httpRequest.getSession())
					.responseBuilder();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
		LOGGER.info("deleteByLocationId() ends");
		return responseEntity;
	}
}
