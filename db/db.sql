DROP TABLE IF EXISTS LISTING;

CREATE TABLE LISTING (
	LISTING_NUMBER INT PRIMARY KEY,
	FIRST_NAME VARCHAR(255),
	LAST_NAME VARCHAR(255),
	EMAIL_ADDRESS VARCHAR(255)
);

INSERT INTO LISTING VALUES(1, 'Rod', 'Johnson', 'rod.johnson@springsource.com');
INSERT INTO LISTING VALUES(2, 'Rob', 'Harrop', 'rob.harrop@springsource.com');
INSERT INTO LISTING VALUES(3, 'Glyn', 'Normington', 'glyn.normington@springsource.com');
INSERT INTO LISTING VALUES(4, 'Andy', 'Wilkinson', 'andy.wilkinson@springsource.com');
INSERT INTO LISTING VALUES(5, 'Ben', 'Hale', 'ben.hale@springsource.com');
INSERT INTO LISTING VALUES(6, 'Chris', 'Frost', 'chris.frost@springsource.com');
INSERT INTO LISTING VALUES(7, 'Steve', 'Powell', 'steve.powell@springsource.com');
INSERT INTO LISTING VALUES(8, 'Christian', 'Dupuis', 'christian.dupuis@springsource.com');
