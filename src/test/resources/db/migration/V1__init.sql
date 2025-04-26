CREATE TABLE PRODUCT (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    quantity_in_stock INTEGER NOT NULL,
    CONSTRAINT id UNIQUE (id)
);

INSERT INTO PRODUCT (name, price, quantity_in_stock) VALUES
('Product A', 10.00, 100),
('Product B', 20.00, 200),
('Product C', 30.00, 300),
('Product D', 40.00, 400),
('Product E', 50.00, 500);