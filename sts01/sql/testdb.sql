use xe;
drop table testdb;
CREATE TABLE testdb (
	num INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(10) NULL,
	nalja TIMESTAMP NULL,
	cnt INT NULL,
	PRIMARY KEY (num)
)
COLLATE='utf8_general_ci';
