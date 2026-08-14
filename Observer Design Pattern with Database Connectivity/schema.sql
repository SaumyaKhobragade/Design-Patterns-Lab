CREATE DATABASE IF NOT EXISTS LEAVE_MANAGEMENT_SYSTEM;

USE LEAVE_MANAGEMENT_SYSTEM;

CREATE TABLE Faculty(
	FacultyID INT PRIMARY KEY,
    Name VARCHAR(20),
    Type VARCHAR(10)
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

INSERT INTO Faculty (FacultyID, Name, Type) VALUES
(1001, 'Aarav Sharma', 'Permanent'),
(1002, 'Priya Mehta', 'Permanent'),
(1003, 'Rahul Verma', 'Contract'),
(1004, 'Sneha Patil', 'Contract'),
(1005, 'Vikram Joshi', 'Permanent'),
(1006, 'Neha Kulkarni', 'Permanent'),
(1007, 'Rohan Deshmukh', 'Contract'),
(1008, 'Ananya Rao', 'Contract'),
(1009, 'Karan Malhotra', 'Permanent'),
(1010, 'Isha Gupta', 'Contract'),
(1011, 'Aditya Shah', 'Permanent'),
(1012, 'Meera Nair', 'Permanent'),
(1013, 'Arjun Kapoor', 'Contract'),
(1014, 'Kavya Singh', 'Permanent'),
(1015, 'Nikhil Jain', 'Permanent'),
(1016, 'Pooja Sinha', 'Contract'),
(1017, 'Siddharth Bose', 'Permanent'),
(1018, 'Riya Choudhary', 'Contract'),
(1019, 'Manish Agarwal', 'Permanent'),
(1020, 'Tanvi Mishra', 'Contract'),
(1021, 'Harsh Vyas', 'Contract'),
(1022, 'Divya Iyer', 'Permanent'),
(1023, 'Yash Thakur', 'Contract'),
(1024, 'Nandini Joshi', 'Permanent'),
(1025, 'Akash Bansal', 'Permanent'),
(1026, 'Simran Kaur', 'Contract'),
(1027, 'Varun Reddy', 'Permanent'),
(1028, 'Shreya Das', 'Permanent'),
(1029, 'Mohit Tiwari', 'Contract'),
(1030, 'Aditi Menon', 'Permanent');

DROP TABLE HR;
DROP TABLE ACC;
DROP TABLE LeaveRequest;
DROP TABLE Faculty;
