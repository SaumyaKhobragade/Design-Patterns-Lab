CREATE DATABASE IF NOT EXISTS LEAVE_MANAGEMENT_SYSTEM;

USE LEAVE_MANAGEMENT_SYSTEM;

CREATE TABLE Faculty(
	FacultyID INT PRIMARY KEY,
    Name VARCHAR(20),
    Type VARCHAR(10),
    Password VARCHAR(100) NOT NULL
);

CREATE TABLE LeaveRequest(
    LeaveID INT PRIMARY KEY AUTO_INCREMENT,
	FacultyID INT NOT NULL,
    Days INT NOT NULL,
    LeaveType VARCHAR(20) NOT NULL,
    Status VARCHAR(10) NOT NULL,
    FOREIGN KEY (FacultyID) REFERENCES Faculty(FacultyID)
);

CREATE TABLE ACC(
	FacultyID INT PRIMARY KEY,
    Salary INT,
    FOREIGN KEY (FacultyID) REFERENCES Faculty(FacultyID)
);

CREATE TABLE HR(
	FacultyID INT PRIMARY KEY,
    LeaveBalance INT,
    FOREIGN KEY (FacultyID) REFERENCES Faculty(FacultyID)
);

INSERT INTO Faculty
(FacultyID, Name, Type, Password)
VALUES
(1001, 'Aarav Sharma', 'Permanent', 'aarav123'),
(1002, 'Priya Mehta', 'Permanent', 'priya123'),
(1003, 'Rahul Verma', 'Contract', 'rahul123'),
(1004, 'Sneha Patil', 'Contract', 'sneha123'),
(1005, 'Vikram Joshi', 'Permanent', 'vikram123'),
(1006, 'Neha Kulkarni', 'Permanent', 'neha123'),
(1007, 'Rohan Deshmukh', 'Contract', 'rohan123'),
(1008, 'Ananya Rao', 'Contract', 'ananya123'),
(1009, 'Karan Malhotra', 'Permanent', 'karan123'),
(1010, 'Isha Gupta', 'Contract', 'isha123'),
(1011, 'Aditya Shah', 'Permanent', 'aditya123'),
(1012, 'Meera Nair', 'Permanent', 'meera123'),
(1013, 'Arjun Kapoor', 'Contract', 'arjun123'),
(1014, 'Kavya Singh', 'Permanent', 'kavya123'),
(1015, 'Nikhil Jain', 'Permanent', 'nikhil123'),
(1016, 'Pooja Sinha', 'Contract', 'pooja123'),
(1017, 'Siddharth Bose', 'Permanent', 'siddharth123'),
(1018, 'Riya Choudhary', 'Contract', 'riya123'),
(1019, 'Manish Agarwal', 'Permanent', 'manish123'),
(1020, 'Tanvi Mishra', 'Contract', 'tanvi123'),
(1021, 'Harsh Vyas', 'Contract', 'harsh123'),
(1022, 'Divya Iyer', 'Permanent', 'divya123'),
(1023, 'Yash Thakur', 'Contract', 'yash123'),
(1024, 'Nandini Joshi', 'Permanent', 'nandini123'),
(1025, 'Akash Bansal', 'Permanent', 'akash123'),
(1026, 'Simran Kaur', 'Contract', 'simran123'),
(1027, 'Varun Reddy', 'Permanent', 'varun123'),
(1028, 'Shreya Das', 'Permanent', 'shreya123'),
(1029, 'Mohit Tiwari', 'Contract', 'mohit123'),
(1030, 'Aditi Menon', 'Contract', 'aditi123');

INSERT INTO HR
(FacultyID, LeaveBalance)
SELECT FacultyID, 20
FROM Faculty
WHERE Type = 'Permanent';

INSERT INTO HR
(FacultyID, LeaveBalance)
SELECT FacultyID, 15
FROM Faculty
WHERE Type = 'Contract';

INSERT INTO ACC
(FacultyID, Salary)
SELECT FacultyID, 50000
FROM Faculty;

DROP TABLE HR;
DROP TABLE ACC;
DROP TABLE LeaveRequest;
DROP TABLE Faculty;
