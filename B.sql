--Ximan Liu
--CSC 453
--HW2
--Part B: Advanced SQL
--Dataset: Company


--Q1
SELECT Fname, Minit, Lname
FROM Employee
WHERE Ssn IN
(SELECT Essn FROM Works_On);


--Q2
SELECT d.Dnumber, d.Dname, AVG(e.salary)
FROM Department d
JOIN Employee e ON e.Dno = d.Dnumber
GROUP BY d.Dnumber, d.Dname;


--Q3
SELECT e.Lname
FROM Employee e
minus
SELECT e.Lname
FROM Dependent d, Employee e
WHERE d.Essn = e.Ssn AND d.Dependent_name IS NOT NULL;


--Q4
SELECT Fname, Minit, Lname
FROM Employee WHERE Dno =
(SELECT Dno FROM Employee WHERE Salary =
(SELECT MIN(Salary) FROM Employee));


--Q5
--EMPLOYEE
SELECT d1.Dname, COUNT(e.Dno) total_EMPLOYEE
FROM EMPLOYEE e, DEPARTMENT d1
WHERE e.Dno = d1.Dnumber
GROUP BY d1.Dname, e.Dno;
--DEPENDENT
SELECT d1.Dname, COUNT(*) total_DEPENDENT
FROM DEPARTMENT d1, DEPENDENT d2, EMPLOYEE e
WHERE d2.essn = e.ssn AND e.Dno = d1.Dnumber
GROUP BY d1.Dname, e.Dno;


--Q6
SELECT Fname, Minit, Lname
FROM Employee
WHERE Salary <
(SELECT MAX(Salary)
FROM Employee)
INTERSECT
SELECT Fname, Minit, Lname
FROM Employee
WHERE Salary >=
(SELECT MAX(Salary) - 20000
FROM Employee);

