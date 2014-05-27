CREATE DATABASE officesDatabase;
GRANT ALL ON officesDatabase.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser'
GRANT ALL ON officesDatabase.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE officesDatabase;

CREATE TABLE offices(
	idOffice INTEGER PRIMARY KEY,
	address varchar(30),
	balance INTEGER
	--decimal(15,2)
);

CREATE INDEX offices_id ON offices(idOffice);