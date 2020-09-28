
-- KarmaDolkar-HotelData.sql.

INSERT INTO RoomType (RoomTypeId, RoomName, ExtraPersonCost, BasePrice, StandardOccupancy, MaxOccupancy)
VALUES
(1, 'Single', 0.00, 149.99, 2, 2),
(2, 'Double', 10.00, 174.99, 2, 4),
(3, 'Suite', 20.00, 399.99, 3, 8);


INSERT INTO Amenity(AmenityId, AmenityName, AmenityCost)
VALUES
(1, 'Microwave', 0.00),
(2, 'Refrigerator', 0.00),
(3, 'Oven', 0.00 ),
(4, 'Jaccuzi', 25.00);

INSERT INTO Room(RoomNumber, RoomTypeId, ADAAccessible)
VALUES
(201, 2, false),
    (202, 2, true),
    (203, 2, false),
    (204, 2, true),
    (205, 1, false),
    (206, 1, true),
    (207, 1, false),
    (208, 1, true),
    (301, 2, false),
    (302, 2, true),
    (303, 2, false),
    (304, 2, true),
    (305, 1, false),
    (306, 1, true),
    (307, 1, false),
    (308, 1, true),
    (401, 3, true),
    (402, 3, true);
    
    INSERT INTO RoomAmenity(RoomNumber, AmenityId)
    VALUES
    (201, 1),
    (201, 4),
    (202, 2),
    (203, 1),
    (203, 4),
    (204, 2),
    (205, 1),
    (205, 2),
    (205, 4),
    (206, 1),
    (206, 2),
    (207, 1),
    (207, 2),
    (207, 4),
    (208, 1),
    (208, 2),
    (301, 1),
    (301, 4),
    (302, 2),
    (303, 1),
    (303, 4),
    (304, 2),
    (305, 1),
    (305, 2),
    (305, 4),
    (306, 1),
    (306, 2),
    (307, 1),
    (307, 2),
    (307, 4),
    (308, 1),
    (308, 2),
    (401, 1),
    (401, 2),
    (401, 3),
    (402, 1),
    (402, 2),
    (402, 3);
    
    INSERT INTO Guest (GuestId, FirstName, LastName, Address, City, StateAbbreviation, Zip, Phone)
    VALUES 
    (1, 'Karma', 'Dolkar', '3424 71st street', 'Jackson Heights', 'NY', '11372', '9292459121'),
    (2, 'Mack', 'Simmer', '379 Old Shore Street', 'Council Bluffs', 'IA', '51501', '2915530508'),
    (3, 'Bettyann', 'Seery', '750 Wintergreen Dr.', 'Wasilla', 'AK', '99654', '4782779632'),
    (4, 'Duane', 'Cullison', '9662 Foxrun Lane', 'Harlingen','TX', '78552', '3084940198'),
    (5, 'Karie', 'Yang', '9378 W. Augusta Ave.', 'West Deptford', 'NJ', '08096', '2147300298'),
    (6, 'Aurore', 'Lipton', '762 Wild Rose Street', 'Saginaw', 'MI', '48601',  '3775070974'),
    (7, 'Zachery', 'Luechtefeld', '7 Poplar Dr.', 'Arvada', 'CO', '80003',	'8144852615'),
    (8, 'Jeremiah', 'Pendergrass', '70 Oakwood St.','Zion', 'IL', 60099, '2794910960'),
    (9, 'Walter', 'Holaway', '7556 Arrowhead St.',	'Cumberland', 'RI', '02864', '4463966785'),
    (10, 'Wilfred', 'Vise', '77 West Surrey Street', 'Oswego',	'NY', '13126',	'8347271001'),
    (11, 'Maritza', 'Tilton', '939 Linda Rd.', 'Burke', 'VA', '22015', '4463516860'),
    (12, 'Joleen', 'Tison', '87 Queen St.', 'Drexel Hill',	'PA','19026', '2318932755');
    
    INSERT INTO Reservation(ReservationId, GuestId, RoomNumber, Adults, Children, StartDate, EndDate,TotalRoomCost)
    VALUES
     (1, 2, 308, 1, 0, '2023-2-2', '2023-2-4', 299.98),
	 (2, 3, 203, 2, 1, '2023-2-5', '2023-2-10', 999.95),
 	(3, 4, 305, 2, 0, '2023-02-22', '2023-02-24', 349.98),
 	(4, 5, 201, 2, 2, '2023-03-06', '2023-03-07', 199.99),
	(5, 1, 307, 1, 1, '2023-03-17', '2023-03-20', 524.97),
    (6, 6, 302, 3, 0, '2023-03-18', '2023-03-23', 924.95),
    (7, 7, 202, 2, 2, '2023-03-29', '2023-03-31', 349.98),
    (8, 8, 304, 2, 0, '2023-03-31', '2023-04-05', 874.95),
    (9, 9, 301, 1, 0, '2023-04-09', '2023-04-13', 799.96),
    (10, 10, 207, 1, 1, '2023-04-23', '2023-04-24', 174.99),
    (11, 11, 401, 2, 4, '2023-05-30', '2023-06-02', 1199.97),
    (12, 12, 206, 2, 0, '2023-06-10', '2023-06-14', 599.96),
    (13, 12, 208, 1, 0, '2023-06-10', '2023-06-14', 599.96),
    (14, 6, 304, 3, 0, '2023-06-17', '2023-06-18', 184.99),
    (15, 1, 205,  2, 0, '2023-06-28', '2023-07-02', 699.96),
    (16, 9, 204, 3, 1, '2023-07-13', '2023-07-14', 184.99),
    (17, 10, 401, 4, 2, '2023-07-18', '2023-07-21', 1259.97),
    (18, 3, 303, 2, 1, '2023-07-28', '2023-07-29', 199.99),
    (19, 3, 305, 1, 0, '2023-08-30', '2023-09-01', 349.98),
    (20, 2, 208, 2, 0, '2023-09-16', '2023-09-17', 149.99),
    (21, 5, 203, 2, 2, '2023-09-13', '2023-09-15', 399.98),
    (22, 4, 401, 2, 2, '2023-11-22', '2023-11-25', 1199.97),
    (23, 2, 206, 2, 0, '2023-11-22', '2023-11-25', 449.97),
    (24, 2, 301, 2, 2, '2023-11-22', '2023-11-25', 599.97),
   (25, 11, 302, 2, 0, '2023-12-24', '2023-12-28', 699.96);
    
    
    -- DELETE JEREMIAH
    DELETE FROM Reservation
    WHERE GuestId = 8;
    DELETE FROM Guest
    WHERE GuestId = 8;
   
    
SELECT * FROM guest;

    
    
    
    
    
    
    