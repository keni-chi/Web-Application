================================================================
PK, FKの両方設定できる
================================================================
CREATE TABLE OYA(
column1 INT(8),
column2 INT(8),
constraint OYA_PKC primary key (column1)
);

CREATE TABLE KO(
column11 INT(8),
column12 INT(8),
constraint KO_PKC primary key (column11),
foreign key (column11) references OYA(column1)
);

CREATE TABLE OYA2(
column1 INT(8),
column2 INT(8),
constraint OYA_PKC primary key (column1)
);

CREATE TABLE KO2(
column11 INT(8),
column12 INT(8),
constraint KO_PKC primary key (column11, column12),
foreign key (column11) references OYA(column1)
);


================================================================
PK, FKの両方設定できない
※参考　https://qa.atmarkit.co.jp/q/6229
================================================================
CREATE TABLE SESSIONS(
sessions_id INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY
);


CREATE TABLE STUDENT_SCHEDULE(
sessions_id INT(8) NOT NULL,
student_id INT(8) NOT NULL,
CONSTRAINT pk_ss
PRIMARY KEY(sessions_id,student_id),

CONSTRAINT fk_ss_sessions_id
FOREIGN KEY (sessions_id) REFERENCES SESSIONS(sessions_id)
ON DELETE SET NULL ON UPDATE CASCADE,
CONSTRAINT fk_ss_student_id
FOREIGN KEY (student_id) REFERENCES STUDENT(student_id)
ON DELETE SET NULL ON UPDATE CASCADE
);
