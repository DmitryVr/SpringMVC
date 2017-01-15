-- Database: testDatabaseImages
-- CREATE DATABASE testDatabaseImages CHARACTER SET utf8;

CREATE TABLE testDatabaseImages.upload (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  content MEDIUMBLOB NOT NULL
)CHARACTER SET utf8;

INSERT INTO testDatabaseImages.upload VALUES(1, 'Темный рыцарь', LOAD_FILE('/home/apps/images/1.jpg'));
INSERT INTO testDatabaseImages.upload VALUES(2, 'Бойцовский клуб', LOAD_FILE('/home/apps/images/2.jpg'));

