create table products(
product_id int(11) AUTO_INCREMENT NOT NULL,
product_name varchar(255),
price int(11) DEFAULT NULL,
constraint ID_PK primary key (product_id)
);
desc products;


-- 待機（未実行）
insert ignore into products values (15, 'ipos', 23000); #Tx1
select * from products where product_id = 15 lock in share mode; #Tx1
select * from products where product_id = 15 for update;


-- ERROR 1213 (40001): Deadlock found when trying to get lock; try restarting transaction（未実行）
select * from products where product_id = 15 lock in share mode; #Tx1
select * from products where product_id = 15 for update; #Tx2
select * from products where product_id = 15 for update; #Tx1


-- SELECT ~ FOR UPDATE
-- 排他ロックの一種。取得した値を利用して更新をかける際に使われることを想定しており、全てのクエリを通さない。


-- SELECT ~ LOCK IN SHARE MODE
-- 共有ロックの一種。排他ロックを伴うクエリを通さないため、UPDATEやDELETEはもちろん、SELECT ~ FOR UPDATEも通さない。SELECT ~ LOCK IN SHARE MODE同士のような、共有ロックを伴うクエリは通す。
