-- 幣別資料
CREATE TABLE COIN (
	code varchar(10) PRIMARY KEY,
	code_name_zh nvarchar(30) NOT NULL,
	symbol varchar(10) NOT NULL,
	rate_float decimal(10,4) NOT NULL,
	description varchar(100),
	create_time datetime default now(),
	update_time datetime
);