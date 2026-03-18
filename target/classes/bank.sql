CREATE DATABASE bank;

USE bank;

CREATE TABLE customer(
	customer_id INT NOT NULL,
	customer_name TEXT NOT NULL,
	bank_number INT NOT NULL,
    customer_amount FLOAT,
    PRIMARY KEY (customer_id)
);

DESC customer;