drop table testdb;
CREATE TABLE testdb (
	num INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(10) NULL DEFAULT NULL,
	nalja TIMESTAMP NULL DEFAULT NULL,
	cnt INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (num)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
insert into testdb (name,nalja,cnt) values ('�׽�Ʈ1',now(),1);
insert into testdb (name,nalja,cnt) values ('�׽�Ʈ2',now(),2);
insert into testdb (name,nalja,cnt) values ('�׽�Ʈ3',now(),3);
insert into testdb (name,nalja,cnt) values ('�׽�Ʈ4',now(),4);
commit;