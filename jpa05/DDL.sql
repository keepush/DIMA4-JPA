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


-- 샘플 테이블 생성 (jpa05 프로젝트와 연동하는 테이블의 생성)
DROP TABLE jpatest.hotel_05;

CREATE TABLE jpatest.hotel_05
(
	hotel_id varchar(50) PRIMARY KEY			-- 호텔 아이디
	, name varchar(50)							-- 호텔명
	, created_date datetime						-- 호텔 오픈일
	, grade varchar(3)							-- 호텔 등급
	, addr1 varchar(100)						-- 첫 번째 주소
	, addr2 varchar(100)						-- 두 번째 주소
	, zipcode varchar(10)						-- 우편번호
);

DROP TABLE jpatest.address;
CREATE TABLE jpatest.address
(
	addr1 varchar(100)							-- 첫 번째 주소
	, addr2 varchar(100)						-- 두 번째 주소
	, zipcode varchar(10)						-- 우편번호
);
