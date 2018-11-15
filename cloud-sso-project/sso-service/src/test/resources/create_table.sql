
CREATE TABLE user_mobile_related(
	
	ID INT(5) PRIMARY KEY NOT NULL,
	USER_ID INT(5) NOT NULL,
	MOBILE VARCHAR(15) NOT NULL,
	CREATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	
);
CREATE INDEX mobile_index on USER_MOBILE_RELATED(mobile);
ALTER TABLE USER_MOBILE_RELATED modify ID INT(5) auto_increment;
ALTER TABLE USER_MOBILE_RELATED AUTO_INCREMENT = 1;

INSERT INTO USER_MOBILE_RELATED (USER_ID, MOBILE) VALUE(10001, '12155246731')
INSERT INTO USER_MOBILE_RELATED (USER_ID, MOBILE) VALUE(10002, '13755874456');
INSERT INTO USER_MOBILE_RELATED (USER_ID, MOBILE) VALUE(10003, '15488795564');


CREATE TABLE user_info(

	USER_ID INT(5) PRIMARY KEY NOT NULL,
	USER_NAME VARCHAR(20) NOT NULL,
	MOBILE VARCHAR(15),
	SEX SMALLINT(5) NOT NULL COMMENT "0 女， 1 男",
	BIRTHDAY_DATE DATE,
	EMAIL VARCHAR(20),
	USER_STATUS SMALLINT(5) DEFAULT 0,
	CRT_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	LST_UPD_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	
);

ALTER TABLE USER_INFO MODIFY USER_ID AUTO_INCREMENT;
ALTER TABLE USER_INFO AUTO_INCREMENT=1001;

INSERT INTO USER_INFO (USER_NAME, MOBILE, SEX ) VALUES ('测试', '12155246731',  1);
INSERT INTO USER_INFO (USER_NAME, MOBILE, SEX ) VALUES ('测试2', '13755874456',  0);
INSERT INTO USER_INFO (USER_NAME, MOBILE, SEX ) VALUES ('测试3', '15488795564',  1);



