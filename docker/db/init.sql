-- CREATE USER postgres;
-- CREATE DATABASE university_db;
-- GRANT ALL PRIVILEGES ON DATABASE university_db TO docker;

CREATE TABLE IF NOT EXISTS students (
    ID      BIGINT          NOT NULL    PRIMARY KEY,
    EMAIL   VARCHAR(50)     NOT NULL
);

INSERT INTO students VALUES
(1, 'a1@gmail.com'),
(2, 'a2@gmail.com'),
(3, 'a3@gmail.com');

