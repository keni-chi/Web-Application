show databases;

CREATE DATABASE mydb;

use mydb;

create table user(
id int,
username varchar(255),
email varchar(255),
password char(30)
);

SHOW TABLES FROM mydb;

INSERT INTO `user`(`id`, `username`, `email`, `password`) VALUES (1, 'username1','email1','password1');
INSERT INTO `user`(`id`, `username`, `email`, `password`) VALUES (2, 'username2','email2','password2');
INSERT INTO `user`(`id`, `username`, `email`, `password`) VALUES (3, 'username3','email3','password3');

SELECT * FROM user WHERE id = 1;

UPDATE user SET username='test' WHERE id = 1;

SELECT * FROM user WHERE id = 1;

TRUNCATE TABLE user;

DROP TABLE user;
