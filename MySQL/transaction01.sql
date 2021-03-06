create table sample(
id int(11) AUTO_INCREMENT NOT NULL,
val int(11) DEFAULT NULL,
constraint ID_PK primary key (id)
);
desc sample;


-- TRUNCATEした時点で暗黙的にコミット(最後にデータは空)
select @@autocommit;
set autocommit = 0;

insert into sample(val) values(10),(20),(30);
start transaction;
select * from sample;
truncate table sample;
rollback;
select * from sample;


-- TRUNCATEした時点で暗黙的にコミット(最後にデータはあり)
select @@autocommit;
set autocommit = 0;

insert into sample(val) values(10),(20),(30);
select * from sample;
start transaction;
delete from sample;
select * from sample;
rollback;
select * from sample;


-- ロック中はトランザクションが効いている(最後にデータはあり)
select @@autocommit;
set autocommit = 0;

insert into sample(val) values(10),(20),(30);
lock table sample write;
delete from sample;
rollback;
select * from sample;


-- ROLLBACK は MySQL の非トランザクション テーブル ロックを解除しません(最後にデータは空)※未検証
lock table sample write;
rollback;
unlock tables;
-- 別セッション --
select * from sample;


-- 暗黙コミットは動くけどロックは解除されない
lock table sample write;
truncate table sample;
select * from sample;
rollback;
select * from sample;
※truncateしたあとに別セッションから参照しようとしても止まる。


-- ロック中に参照するすべてのテーブルに対してロックを取らなくてはいけない
-- 利用する予定の全てのテーブルをロックしなければいけません
create table sample2(id int(11));
lock table sample write;
select * from sample2;

-- すべてのテーブルロックを取る必要があります。
unlock tables;
lock tables sample write, sample2 write;
select * from sample2;


-- 1セッション内で続けてLOCK TABLESすると最初のロックはUNLOCKされる  ※未実行
-- セッションA
unlock tables;
lock tables sample write;
-- セッションB
-- ロックされているので待機中
select * from sample;
-- セッションA
-- 別のロックを取得(と同時に既存のロックを解放)
lock tables sample2 write;
-- セッションB
-- 参照出来るようになって結果が出力される  


-- lockの件数を確認する
show open tables;
