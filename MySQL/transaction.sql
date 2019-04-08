create table sample(
id int(11) AUTO_INCREMENT NOT NULL,
val int(11) DEFAULT NULL,
constraint ID_PK primary key (id)
);
desc sample;


select @@autocommit;
set autocommit = 0;

insert into sample(val) values(10),(20),(30);
start transaction;
select * from sample;
truncate table sample;
rollback;
select * from sample;
