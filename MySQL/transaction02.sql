create table products(
product_id int(11) AUTO_INCREMENT NOT NULL,
product_name varchar(255),
price int(11) DEFAULT NULL,
constraint ID_PK primary key (product_id)
);
desc products;


insert ignore into products values (15, 'ipos', 23000);
select * from products where product_id = 15 lock in share mode;
select * from products where product_id = 15 for update;
