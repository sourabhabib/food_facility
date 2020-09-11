package com.facility.rest.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FoodFacility implements RowMapper<FoodFacility> {

	private String locationid;
	private String Applicant;
	private String FacilityType;
	private String cnn;
	private String LocationDescription;
	private String Address;
	private String blocklot;
	private String block;
	private String lot;
	private String permit;
	private String Status;
	private String FoodItems;
	private String xAxis;
	private String yAxis;
	private String Latitude;
	private String Longitude;
	private String Schedule;
	private String dayshours;
	private String NOISent;
	private String Approved;
	private String Received;
	private String PriorPermit;
	private String ExpirationDate;
	private String Location;
	private String FirePreventionDistricts;
	private String PoliceDistricts;
	private String SupervisorDistricts;
	private String ZipCodes;
	private String Neighborhoods;

	
	
	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

	public String getApplicant() {
		return Applicant;
	}

	public void setApplicant(String applicant) {
		Applicant = applicant;
	}

	public String getFacilityType() {
		return FacilityType;
	}

	public void setFacilityType(String facilityType) {
		FacilityType = facilityType;
	}

	public String getCnn() {
		return cnn;
	}

	public void setCnn(String cnn) {
		this.cnn = cnn;
	}

	public String getLocationDescription() {
		return LocationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		LocationDescription = locationDescription;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getBlocklot() {
		return blocklot;
	}

	public void setBlocklot(String blocklot) {
		this.blocklot = blocklot;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getFoodItems() {
		return FoodItems;
	}

	public void setFoodItems(String foodItems) {
		FoodItems = foodItems;
	}

	public String getxAxis() {
		return xAxis;
	}

	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}

	public String getyAxis() {
		return yAxis;
	}

	public void setyAxis(String yAxis) {
		this.yAxis = yAxis;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getSchedule() {
		return Schedule;
	}

	public void setSchedule(String schedule) {
		Schedule = schedule;
	}

	public String getDayshours() {
		return dayshours;
	}

	public void setDayshours(String dayshours) {
		this.dayshours = dayshours;
	}

	public String getNOISent() {
		return NOISent;
	}

	public void setNOISent(String nOISent) {
		NOISent = nOISent;
	}

	public String getApproved() {
		return Approved;
	}

	public void setApproved(String approved) {
		Approved = approved;
	}

	public String getReceived() {
		return Received;
	}

	public void setReceived(String received) {
		Received = received;
	}

	public String getPriorPermit() {
		return PriorPermit;
	}

	public void setPriorPermit(String priorPermit) {
		PriorPermit = priorPermit;
	}

	public String getExpirationDate() {
		return ExpirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		ExpirationDate = expirationDate;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getFirePreventionDistricts() {
		return FirePreventionDistricts;
	}

	public void setFirePreventionDistricts(String firePreventionDistricts) {
		FirePreventionDistricts = firePreventionDistricts;
	}

	public String getPoliceDistricts() {
		return PoliceDistricts;
	}

	public void setPoliceDistricts(String policeDistricts) {
		PoliceDistricts = policeDistricts;
	}

	public String getSupervisorDistricts() {
		return SupervisorDistricts;
	}

	public void setSupervisorDistricts(String supervisorDistricts) {
		SupervisorDistricts = supervisorDistricts;
	}

	public String getZipCodes() {
		return ZipCodes;
	}

	public void setZipCodes(String zipCodes) {
		ZipCodes = zipCodes;
	}

	public String getNeighborhoods() {
		return Neighborhoods;
	}

	public void setNeighborhoods(String neighborhoods) {
		Neighborhoods = neighborhoods;
	}

	@Override
	public FoodFacility mapRow(ResultSet rs, int rowNum) throws SQLException {
		FoodFacility cs = new FoodFacility();
		cs.setLocation(rs.getString("location"));
		cs.setApplicant(rs.getString("applicant"));
		cs.setFacilityType(rs.getString("facility_type"));
		cs.setCnn(rs.getString("cnn"));
		cs.setLocationDescription(rs.getString("location_desc"));
		cs.setAddress(rs.getString("address"));
		cs.setBlock(rs.getString("block"));
		cs.setBlocklot(rs.getString("blocklot"));
		cs.setLot(rs.getString("lot"));
		cs.setPermit(rs.getString("permit"));
		cs.setStatus(rs.getString("status"));
		cs.setFoodItems(rs.getString("food_items"));
		cs.setxAxis(rs.getString("x_axis"));
		cs.setyAxis(rs.getString("y_axis"));
		cs.setLatitude(rs.getString("latitude"));
		cs.setLongitude(rs.getString("longitude"));
		cs.setSchedule(rs.getString("schedule"));
		cs.setDayshours(rs.getString("days_hours"));
		cs.setNOISent(rs.getString("noi_sent"));
		cs.setApproved(rs.getString("approved"));
		cs.setReceived(rs.getString("received"));
		cs.setPriorPermit(rs.getString("prior_permit"));
		cs.setExpirationDate(rs.getString("expiration_date"));
		cs.setLocationid(rs.getString("location_id"));
		cs.setFirePreventionDistricts(rs.getString("fire_prevention_districts"));
		cs.setPoliceDistricts(rs.getString("police_districts"));
		cs.setSupervisorDistricts(rs.getString("supervisor_districts"));
		cs.setZipCodes(rs.getString("zip_codes"));
		cs.setNeighborhoods(rs.getString("neighborhoods"));
		return cs;
	}

	public void merge(FoodFacility customer) {
		if (customer != null) {
			this.locationid = (customer.locationid == null) ? this.locationid : customer.locationid;
			this.Applicant = (customer.Applicant == null) ? this.Applicant : customer.Applicant;
			this.FacilityType = (customer.FacilityType == null) ? this.FacilityType : customer.FacilityType;
			this.cnn = (customer.cnn == null) ? this.cnn : customer.cnn;
			this.LocationDescription = (customer.LocationDescription == null) ? this.LocationDescription : customer.LocationDescription;
			this.Address = (customer.Address == null) ? this.Address : customer.Address;
			this.blocklot = (customer.blocklot == null) ? this.blocklot : customer.blocklot;
			this.block = (customer.block == null) ? this.block : customer.block;
			this.lot = (customer.lot == null) ? this.lot : customer.lot;
			this.permit = (customer.permit == null) ? this.permit : customer.permit;
			this.Status = (customer.Status == null) ? this.Status : customer.Status;
			this.FoodItems = (customer.FoodItems == null) ? this.FoodItems : customer.FoodItems;
			this.xAxis = (customer.xAxis == null) ? this.xAxis : customer.xAxis;
			this.yAxis = (customer.yAxis == null) ? this.yAxis : customer.yAxis;
			this.Latitude = (customer.Latitude == null) ? this.Latitude : customer.Latitude;
			this.Longitude = (customer.Longitude == null) ? this.Longitude : customer.Longitude;
			this.Schedule = (customer.Schedule == null) ? this.Schedule : customer.Schedule;
			this.dayshours = (customer.dayshours == null) ? this.dayshours : customer.dayshours;
			this.NOISent = (customer.NOISent == null) ? this.NOISent : customer.NOISent;
			this.Approved = (customer.Approved == null) ? this.Approved : customer.Approved;
			this.Received = (customer.Received == null) ? this.Received : customer.Received;
			this.PriorPermit = (customer.PriorPermit == null) ? this.PriorPermit : customer.PriorPermit;
			this.ExpirationDate = (customer.ExpirationDate == null) ? this.ExpirationDate : customer.ExpirationDate;
			this.Location = (customer.Location == null) ? this.Location : customer.Location;
			this.FirePreventionDistricts = (customer.FirePreventionDistricts == null) ? this.FirePreventionDistricts : customer.FirePreventionDistricts;
			this.PoliceDistricts = (customer.PoliceDistricts == null) ? this.PoliceDistricts : customer.PoliceDistricts;
			this.SupervisorDistricts = (customer.SupervisorDistricts == null) ? this.SupervisorDistricts : customer.SupervisorDistricts;
			this.ZipCodes = (customer.ZipCodes == null) ? this.ZipCodes : customer.ZipCodes;
			this.Neighborhoods = (customer.Neighborhoods == null) ? this.Neighborhoods : customer.Neighborhoods;
		}
	}
		@Override
		public String toString() {
			try {
				return new ObjectMapper().writeValueAsString(this);
			} catch (JsonProcessingException e) {
				return null;
			}
		}
}
