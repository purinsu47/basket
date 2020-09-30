DROP TABLE IF EXISTS BASKET;
  
CREATE TABLE BASKET (
  id INT AUTO_INCREMENT  PRIMARY KEY
);

DROP TABLE IF EXISTS ITEM;
  
CREATE TABLE ITEM (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  basket_id INT NOT NULL,
  product_id INT NOT NULL
);

DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price INT NOT NULL,
  description VARCHAR(250) DEFAULT NULL
);


INSERT INTO PRODUCT (name,price,description) 
values ('Apple','25','Fruit');
INSERT INTO PRODUCT (name,price,description) 
values ('Orange','20','Fruit');
INSERT INTO PRODUCT (name,price,description) 
values ('Grapes','100','Fruit');


