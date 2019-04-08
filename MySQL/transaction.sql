create table sample(
id int(11) AUTO_INCREMENT NOT NULL,
val int(11) DEFAULT NULL,
constraint ID_PK primary key (id)
);

desc sample;

select @@autocommit;
set autocommit = 0;
select @@autocommit;
