drop database officeDatabase;

CREATE DATABASE officeDatabase;

GRANT ALL ON officeDatabase.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON officeDatabase.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE officeDatabase;

CREATE TABLE office (
  id INTEGER PRIMARY KEY,
  idBank INTEGER,
  idOffice INTEGER,
  address varchar(50),
  totalExpenses INTEGER,
  totalIncome INTEGER
);
CREATE INDEX office_idOffice ON office(idOffice);