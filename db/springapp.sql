drop database springapp;

CREATE DATABASE springapp;

GRANT ALL ON springapp.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON springapp.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE springapp;

CREATE TABLE office (
  id INTEGER PRIMARY KEY,
   idOffice varchar(4),
  address varchar(50),
  balance decimal(15,2)
);
CREATE INDEX office_idOffice ON office(idOffice);