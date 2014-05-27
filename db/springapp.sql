CREATE DATABASE springapp;
GRANT ALL ON springapp.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser'
GRANT ALL ON springapp.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE springapp;

CREATE TABLE offices(
	id INTEGER PRIMARY KEY,
	address varchar(30),
	balance INTEGER
	--decimal(15,2)
);

CREATE INDEX offices_address ON offices(address);