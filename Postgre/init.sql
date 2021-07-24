CREATE ROLE myname WITH LOGIN;
CREATE TABLE weather (
    city            varchar(80),
    temp_lo         int,           -- 最低気温
    temp_hi         int,           -- 最高気温
    prcp            real,          -- 降水量
    date            date
);
INSERT INTO weather (city, temp_lo, temp_hi, prcp, date) VALUES ('a', 1, 2, 3.5, '1961-06-16');
select * from weather;

