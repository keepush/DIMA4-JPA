-- 데이터베이스 생성
DROP DATABASE jpatest;
CREATE DATABASE jpatest CHARACTER SET utf8mb4;

-- 사용자 계정 생성 (jpauser)
DROP USER 'jpauser'@'localhost';
CREATE USER 'jpauser'@'localhost' identified BY 'jpauser';

DROP USER 'jpauser'@'%';
CREATE USER 'jpauser'@'%' identified BY 'jpauser';

-- 권한 부여
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'localhost';
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'%';


-- 샘플 테이블 생성 (jpa06 프로젝트와 연동하는 테이블의 생성)
-- 1:1, 1:다, 다:다, 다:1
DROP TABLE jpatest.survey;
CREATE TABLE jpatest.survey
(
	id varchar(10) PRIMARY KEY
	, name varchar(50)
);


DROP TABLE jpatest.question;
CREATE TABLE jpatest.question
(
	id varchar(10) PRIMARY KEY
	, survey_id varchar(10) REFERENCES jpatest.survey(id)		-- FK
	, order_no int
	, title varchar(50)
);

