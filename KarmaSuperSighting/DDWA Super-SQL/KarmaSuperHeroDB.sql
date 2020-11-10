DROP DATABASE IF EXISTS KarmaSuperHeroDB ;	
CREATE DATABASE  KarmaSuperHeroDB;	
USE KarmaSuperHeroDB ;	

CREATE TABLE `Superpower` (	
  `superpowerId` INT PRIMARY KEY AUTO_INCREMENT,	
  `name` VARCHAR(45) NOT NULL);	
  	
  CREATE TABLE `Location` (	
  `locationId` INT PRIMARY KEY AUTO_INCREMENT,	
  `name` VARCHAR(45) NOT NULL,	
  `description` VARCHAR(250) NOT NULL,	
  `address` VARCHAR(45) NOT NULL,	
  `city` VARCHAR(45) NOT NULL,	
  `state` CHAR(2) NULL,	
--   `country` VARCHAR(30) NOT NULL,	
  `zipcode` CHAR(5) NULL,	
  `latitude` DECIMAL(8,6) NOT NULL,	
  `longitude` DECIMAL(9,6) NOT NULL	
);	
CREATE TABLE `Hero` (	
  `heroId` INT PRIMARY KEY AUTO_INCREMENT,	
  `name` VARCHAR(45) NOT NULL,	
  `description` VARCHAR(250) NOT NULL,	
  `superpowerId` INT NOT NULL,	
FOREIGN KEY (`superpowerId`) REFERENCES `Superpower`(`superpowerId`));	
    
CREATE TABLE `Organization` (	
  organizationId INT PRIMARY KEY AUTO_INCREMENT,	
  name VARCHAR(45) NOT NULL,	
  description VARCHAR(250) NOT NULL,	
  phoneNum VARCHAR(15) NULL,
  locationId INT NOT NULL,	
    FOREIGN KEY (locationId)	
    REFERENCES Location(locationId));	
    
CREATE TABLE Sighting (	
	sightingId INT PRIMARY KEY AUTO_INCREMENT,	
	date DATETIME NOT NULL,	
	heroId INT NOT NULL,	
	locationId INT NOT NULL,	
    FOREIGN KEY (heroId)	
    REFERENCES Hero(heroId),	
    FOREIGN KEY (locationId)	
    REFERENCES Location(locationId));	
    
CREATE TABLE HeroOrganization (	
  heroId INT NOT NULL,	
  organizationId INT NOT NULL,	
 	
    FOREIGN KEY (heroId)	
    REFERENCES Hero(heroId),	
    FOREIGN KEY (organizationId)	
    REFERENCES `Organization` (OrganizationId));