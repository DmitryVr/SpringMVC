-- Database: testDatabase
-- CREATE DATABASE testDatabase CHARACTER SET utf8;

-- Table: developers
CREATE TABLE testDatabase.developers (
  id   INT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(40) NOT NULL
)CHARACTER SET utf8;

-- Insert data
INSERT INTO testDatabase.developers VALUES (1, 'Batman');
INSERT INTO testDatabase.developers VALUES (2, 'Joker');