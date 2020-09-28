DROP DATABASE IF EXISTS HotelData;
CREATE DATABASE HotelData;
USE HotelData;



CREATE TABLE RoomType (
RoomTypeId INT PRIMARY KEY AUTO_INCREMENT,
RoomName VARCHAR(10) NOT NULL,
ExtraPersonCost DECIMAL (5,2) NOT NULL,
StandardOccupancy INT,
BasePrice DECIMAL(5,2) NOT NULL,
MaxOccupancy INT NOT NULL
);

CREATE TABLE Amenity (
AmenityId INT PRIMARY KEY AUTO_INCREMENT,
AmenityName VARCHAR(45) NOT NULL,
AmenityCost	DECIMAL (5,2) NOT NULL
);

CREATE TABLE Room(
RoomNumber INT PRIMARY KEY,
RoomTypeId INT NOT NULL,
ADAaccessible BOOLEAN NOT NULL,
 CONSTRAINT `fk_Room_RoomType` FOREIGN KEY (RoomTypeId)
        REFERENCES RoomType (RoomTypeId)
);

CREATE TABLE RoomAmenity (
    RoomNumber INT NOT NULL,
    AmenityId INT NOT NULL,
    PRIMARY KEY (RoomNumber , AmenityId),
    CONSTRAINT `fk_RoomAmenity_AmenityId` FOREIGN KEY (AmenityId)
        REFERENCES Amenity (AmenityId),
    CONSTRAINT `fk_RoomAmenity_RoomNumber` FOREIGN KEY (RoomNumber)
        REFERENCES Room (RoomNumber)
);


CREATE TABLE Guest (
GuestId INT PRIMARY KEY AUTO_INCREMENT,
FirstName VARCHAR(20) NOT NULL,
LastName VARCHAR(20) NOT NULL,
Address VARCHAR (60) NOT NULL,
City VARCHAR (45) NOT NULL,
StateAbbreviation CHAR(2) NOT NULL,
Phone CHAR(12) NOT NULL,
Zip CHAR(5) NOT NULL
);

CREATE TABLE Reservation (
ReservationId INT PRIMARY KEY AUTO_INCREMENT,
Adults INT NOT NULL,
Children INT NOT NULL,
StartDate DATE NOT NULL,
EndDate DATE NOT NULL,
TotalRoomCost DECIMAL (7,2) NOT NULL,
GuestId INT NOT NULL,
RoomNumber INT NOT NULL,
  CONSTRAINT `fk_Reservation_Guest` FOREIGN KEY (GuestId)
        REFERENCES Guest (GuestId),
    CONSTRAINT `fk_Reservation_Room` FOREIGN KEY (RoomNumber)
        REFERENCES Room (RoomNumber)
);







