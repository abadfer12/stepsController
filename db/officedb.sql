drop database officedb;

CREATE DATABASE officedb;

GRANT ALL ON officedb.* TO springappuser@'%' IDENTIFIED BY 'pofficedbuser';
GRANT ALL ON officedb.* TO springappuser@localhost IDENTIFIED BY 'pofficedbuser';

USE officedb;

CREATE TABLE office (
  id INTEGER PRIMARY KEY,
  idBank INTEGER,
  idOffice INTEGER,
  address varchar(50),
  balance decimal(15,2)
);
CREATE INDEX office_idOffice ON office(idOffice);