SET MODE postgreSQL;

CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;
CREATE TABLE if NOT EXISTS endangered(id SERIAL PRIMARY KEY, name VARCHAR,health VARCHAR,age VARCHAR,location VARCHAR,ranger VARCHAR);
CREATE TABLE if NOT EXISTS animals(id SERIAL PRIMARY KEY, name VARCHAR)
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
