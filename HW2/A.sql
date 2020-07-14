--Ximan Liu
--CSC 453
--HW2
--Part A: Basic SQL Operators
--Dataset: Trips


--Q1
SELECT DISTINCT RentalCompany
FROM ByCar
WHERE Mileage >= 27;


--Q2
SELECT TID
FROM Trips
WHERE TravelMode = 'Train' AND Fare > 150;


--Q3
SELECT TID, Fare
FROM Trips
WHERE TripState = 'Non-US';


--Q4
SELECT t.TID
FROM ByPlane p, Trips t
WHERE p.Class = 'Business' AND t.Fare > 1000 AND p.TID = t.TID;


--Q5
SELECT T1.TID, T1.TripState, T1.TravelMode, T1.Fare
FROM Trips T1
JOIN Trips T2 ON t1.Fare > t2.Fare
WHERE t1.TripState = t2.TripState AND t1.TravelMode = 'Car' AND t2.TravelMode = 'Train';


--Q6
SELECT c1.TID, c2.TID
FROM ByCar c1
INNER JOIN ByCar c2
ON c1.Mileage = c2.Mileage
AND c1.TID != c2.TID;


--Q7
SELECT tr1.TID, tr2.TID
FROM ByTrain tr1
INNER JOIN ByTrain tr2
ON tr1.TrainSpeed != tr2.TrainSpeed
AND tr1.TID != tr2.TID;


--Q8
SELECT t1.TID, t2.TID
FROM Trips t1
INNER JOIN Trips t2
ON t1.TripState = t2.TripState
AND t1.TravelMode = t2.TravelMode
AND t1.TID < t2.TID;


--Q9
SELECT DISTINCT t1.TripState
FROM Trips t1, Trips t2, Trips t3
WHERE t1.TravelMode = 'Train' AND t2.TravelMode = 'Plane' AND t3.TravelMode = 'Car' AND t1.TripState = t2.TripState AND t2.TripState = t3.TripState
AND t1.TID != t2.TID AND t2.TID != t3.TID AND t1.TID != t3.TID;


--10
--a) the most costly trip
SELECT t1.TID, t1.TripState, t1.TravelMode, t1.Fare
FROM Trips t1
LEFT JOIN Trips t2
ON t2.Fare > t1.Fare AND t2.Fare IS NOT NULL
WHERE t2.Fare IS NULL;


--b) the cheapest trip
SELECT t1.TID, t1.TripState, t1.TravelMode, t1.Fare
FROM Trips t1
LEFT JOIN Trips t2
ON t2.Fare < t1.Fare AND t2.Fare IS NOT NULL
WHERE t2.Fare IS NULL;


