CREATE SCHEMA IF NOT EXISTS productdb;
DROP TABLE IF EXISTS productdb.product;
CREATE TABLE productdb.product (product_id integer not null, 
                        environment varchar(255),
                        num_in_stock integer,
                        product_category varchar(255),
                        product_name varchar(255),
                        product_price double precision,
                        primary key (product_id));