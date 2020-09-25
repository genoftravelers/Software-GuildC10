USE HotelData;
SELECT *
FROM Reservation;
-- Write a query that returns a list of reservations that end in July 2023, 
-- including the name of the guest, the room number(s), and the reservation dates.
SELECT g.FirstName, g.LastName,
	ro.RoomNumber,
    re.StartDate,
    re.EndDate
FROM Guest g
INNER JOIN Reservation re ON re.GuestId = g.GuestId
INNER JOIN Room ro ON ro.RoomNumber = re.RoomNumber
WHERE re.EndDate BETWEEN '2023-07-01' AND '2023-07-31';
-- 4 rows
-- Write a query that returns a list of all reservations for rooms with a jacuzzi,
--  displaying the guest's name, the room number, and the dates of the reservation.
SELECT g.FirstName, g.LastName,
	ro.RoomNumber, 
	re.StartDate, 
	re.EndDate
FROM Reservation re
INNER JOIN Guest g ON re.GuestId = g.GuestId
INNER JOIN Room ro ON re.RoomNumber = ro.RoomNumber
INNER JOIN RoomAmenity roa ON ro.RoomNumber = roa.RoomNumber
INNER JOIN Amenity a ON roa.AmenityId = a.AmenityId
WHERE a.AmenityName = 'Jaccuzi';
-- 11

-- Write a query that returns all the rooms reserved for a specific guest, 
-- including the guest's name, the room(s) reserved, the starting date of the reservation, 
-- and how many people were included in the reservation.
--  (Choose a guest's name from the existing data.)

SELECT g.FirstName, g.LastName,
	res.RoomNumber,
    res.StartDate,
    res.EndDate,
    res.Adults + res.Children AS 'TotalGuests'
FROM Reservation res
INNER JOIN Guest g ON g.GuestId = res.GuestId 
WHERE g.FirstName = 'Karie';
-- 2

-- Write a query that returns a list of rooms, reservation ID,
--  and per-room cost for each reservation. The results should include 
--  all rooms, whether or not there is a reservation associated with the room.

SELECT ro.RoomNumber,
	res.ReservationId,
    res.TotalRoomCost
FROM Room ro
LEFT OUTER JOIN Reservation res ON res.RoomNumber = ro.RoomNumber;
-- 26

-- Write a query that returns all the rooms accommodating at 
-- least three guests and that are reserved on any date in April 2023.

SELECT re.RoomNumber,
	re.Adults + re.Children AS 'TotalGuests'
FROM Reservation re
WHERE re.Adults + re.Children >= 3
AND re.StartDate BETWEEN 2023-04-01 AND 2023-04-31;
-- 0 has diff solutions, 

-- Write a query that returns a list of all guest names and the number of reservations 
-- per guest, sorted starting with the guest with the most reservations and then by the guest's last name.

SELECT g.FirstName, g.LastName,
	COUNT(res.GuestId) AS 'TotalReservation'
    FROM Reservation res
    INNER JOIN Guest g ON g.GuestId = res.GuestId
    GROUP BY res.GuestId
    ORDER BY COUNT(res.GuestId) DESC, LastName ASC;
    -- 11 rows


-- Write a query that displays the name, address, and phone number of
--  a guest based on their phone number. (Choose a phone number from the existing data.)
SELECT g.FirstName, g.LastName,
	g.Address,
    g.City,
    g.StateAbbreviation,
    g.Zip,
    g.Phone
FROM Guest g 
WHERE g.Phone = '2147300298';
-- 1 row.
-- 
    