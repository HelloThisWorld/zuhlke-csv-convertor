CREATE DATABASE IF NOT EXISTS zuhlke;
USE zuhlke;
 
CREATE TABLE IF NOT EXISTS STORE_ORDER (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  ORDER_ID VARCHAR(20) UNIQUE NOT NULL,
  ORDER_DATE DATE NOT NULL,
  SHIP_DATE DATE NOT NULL,
  SHIP_MODE VARCHAR(20),
  QUANTITY INT NOT NULL,
  DISCOUNT DECIMAL(3,2),
  PROFIT DECIMAL(6,2) NOT NULL,
  PRODUCT_ID VARCHAR(20) UNIQUE NOT NULL,
  CUSTOMER_NAME VARCHAR(255) NOT NULL,
  CATEGORY VARCHAR(255) NOT NULL,
  CUSTOMER_ID VARCHAR(20) UNIQUE NOT NULL,
  PRODUCT_NAME VARCHAR(255)
);