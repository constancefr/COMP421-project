-- Include your create table DDL statements in this file.
-- Make sure to terminate each statement with a semicolon (;)

-- LEAVE this statement on. It is required to connect to your database.
CONNECT TO COMP421;

-- Remember to put the create table ddls for the tables with foreign key references
--    ONLY AFTER the parent tables have already been created.

-- This is only an example of how you add create table ddls to this file.
--   You may remove it.

--CREATE TABLE MYTEST01
--(
--  id INTEGER NOT NULL,
--  value INTEGER 
--  PRIMARY KEY(id)
--);

CREATE TABLE Customer (
	cid INTEGER NOT NULL,
	name VARCHAR(50),
	email VARCHAR(50),
	phone_number VARCHAR(10) CONSTRAINT phonum CHECK (phone_number like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') UNIQUE NOT NULL,
	address VARCHAR(100),
	ccnum INTEGER UNIQUE NOT NULL,
	ccexpdate DATE NOT NULL,
	PRIMARY KEY(cid)
);

CREATE TABLE RewardsMember (
	cid INTEGER NOT NULL,
	login VARCHAR(30) UNIQUE NOT NULL,
	pwd VARCHAR(30) CHECK(LENGTH(pwd)>=8) NOT NULL,
	points INTEGER,
	PRIMARY KEY(cid),
	FOREIGN KEY(cid) REFERENCES Customer

);

CREATE TABLE Guest (
	cid INT PRIMARY KEY NOT NULL,
	FOREIGN KEY(cid) REFERENCES Customer
);

CREATE TABLE Event (
	location VARCHAR(100),
	eventDate DATE,
	venue VARCHAR(50),
	cateredFlag BOOLEAN,
	rid INTEGER NOT NULL UNIQUE,
	PRIMARY KEY (location, eventDate, venue),
	FOREIGN KEY (location) references Hotel
);

CREATE TABLE Room (
	location VARCHAR(30),
	roomNumber INT,
	roomType VARCHAR(30) NOT NULL,
	roomAvail BIT NOT NULL,
	roomPrice DOUBLE NOT NULL,
	cleaned BOOLEAN NOT NULL,
	capacity INT NOT NULL,
	PRIMARY KEY(location, roomNumber)
);


