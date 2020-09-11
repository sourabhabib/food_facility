# food_facility
Food Facility Apis



Created a Rest api for POST,PUT,GET,DELETE

1. I'm using spring-boot to build this rest apis
2. Created four apis to add the food facility, delete by location id, filter by status, update by location id
3. I'm using swagger ui to send the request and response for the database manipulation
4. Swagger Url: http://localhost:8080/swagger-ui.html#/
5. To run the application export the project as maven project and maven update
6. Next step to run the application inside package com.facility.rest.conf right click to this class FoodFacilityApiApplication.java and run as java application
7. Type this url in browser http://localhost:8080/swagger-ui.html#/ to send request to the database the format to send the request is JSON i have already put in swagger description
8. Database cofigurations in the application is defined in resources package file name application.properties




SQL Dump



CREATE DATABASE /*!32312 IF NOT EXISTS*/`facility` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `facility`;

/*Table structure for table `food_facility` */

DROP TABLE IF EXISTS `food_facility`;

CREATE TABLE `food_facility` (
  `location_id` varchar(32) NOT NULL,
  `location` varchar(32) DEFAULT NULL,
  `applicant` varchar(32) DEFAULT NULL,
  `facility_type` varchar(32) DEFAULT NULL,
  `cnn` varchar(32) DEFAULT NULL,
  `location_desc` varchar(32) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `block` varchar(32) DEFAULT NULL,
  `blocklot` varchar(32) DEFAULT NULL,
  `lot` varchar(32) DEFAULT NULL,
  `permit` varchar(32) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `food_items` varchar(32) DEFAULT NULL,
  `x_axis` varchar(32) DEFAULT NULL,
  `y_axis` varchar(32) DEFAULT NULL,
  `latitude` varchar(32) DEFAULT NULL,
  `longitude` varchar(32) DEFAULT NULL,
  `schedule` varchar(32) DEFAULT NULL,
  `days_hours` varchar(32) DEFAULT NULL,
  `noi_sent` varchar(32) DEFAULT NULL,
  `approved` varchar(32) DEFAULT NULL,
  `received` varchar(32) DEFAULT NULL,
  `prior_permit` varchar(32) DEFAULT NULL,
  `expiration_date` varchar(32) DEFAULT NULL,
  `fire_prevention_districts` varchar(32) DEFAULT NULL,
  `police_districts` varchar(32) DEFAULT NULL,
  `supervisor_districts` varchar(32) DEFAULT NULL,
  `zip_codes` varchar(32) DEFAULT NULL,
  `neighborhoods` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `food_facility` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
