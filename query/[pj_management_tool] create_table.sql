-- account DB 에 사용자 계정/권한 테이블 생성 쿼리

DROP TABLE IF EXISTS tool_authorities;
DROP TABLE IF EXISTS tool_accounts;

create table tool_accounts(
	account_id VARCHAR(20) NOT NULL,
    account_password VARCHAR(32) NOT NULL,
    account_email VARCHAR(100) NOT NULL,
    account_state VARCHAR(20) DEFAULT '가입' NOT NULL,
	PRIMARY KEY (account_id)
);

create table tool_authorities(
	account_id VARCHAR(20) NOT NULL,
    authority VARCHAR(20) NOT NULL,
    PRIMARY KEY (account_id),
    FOREIGN KEY (account_id) REFERENCES tool_accounts (account_id)
);