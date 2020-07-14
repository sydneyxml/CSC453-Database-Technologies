--Ximan Liu
--CSC 453
--HW2
--Part C: Analysis SQL
--Dataset: Restaurants


--Q1
SELECT name
FROM Restaurant
WHERE cuisine = 'Indian';


--Q2
SELECT DISTINCT name
FROM Restaurant, Rating
WHERE Restaurant.rID = Rating.rID AND stars IN (4, 5)
ORDER BY name;


--Q3
SELECT name
FROM Restaurant
WHERE rID NOT IN (SELECT rID FROM Rating);


--Q4
SELECT name
FROM Reviewer
INNER JOIN Rating USING(vID)
WHERE ratingDate IS NULL;


--Q5
SELECT Reviewer.name, Restaurant.name
FROM Restaurant
INNER JOIN Rating R1 USING(rID)
INNER JOIN Rating R2 USING(vID, rID)
INNER JOIN Reviewer USING(vID)
WHERE R1.ratingDate < R2.ratingDate AND R1.stars < R2.stars;


--Q6
SELECT name, MAX(stars)
FROM Restaurant
INNER JOIN Rating USING(rID)
GROUP BY rID, name
ORDER BY name;


--Q7
SELECT name, (MAX(stars) - MIN(stars)) AS rating_spread
FROM Restaurant
INNER JOIN Rating USING(rID)
GROUP BY rID, name
ORDER BY rating_spread DESC, name;


--Q8
SELECT AVG(Indian.avg) - AVG(Chinese.avg)
FROM
(
SELECT AVG(stars) AS avg
FROM Restaurant
INNER JOIN Rating USING(rID)
WHERE cuisine = 'Indian'
GROUP BY rID
)
Indian,
(
SELECT AVG(stars) AS avg
FROM Restaurant
INNER JOIN Rating USING(rID)
WHERE cuisine = 'Chinese'
GROUP BY rID
)
Chinese;

