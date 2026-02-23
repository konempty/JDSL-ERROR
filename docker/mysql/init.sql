DROP DATABASE IF EXISTS jdsl_demo;
CREATE DATABASE jdsl_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'app'@'%' IDENTIFIED BY 'app';
GRANT ALL PRIVILEGES ON jdsl_demo.* TO 'app'@'%';
FLUSH PRIVILEGES;

USE jdsl_demo;

CREATE TABLE IF NOT EXISTS member (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO member(name, email) VALUES
  ('Alice', 'alice@example.com'),
  ('Bob', 'bob@example.com');
