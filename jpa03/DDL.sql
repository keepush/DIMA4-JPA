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



-- 샘플 테이블 생성 (Java jpa03 프로젝트와 연동하는 테이블의 생성)
DROP TABLE jpatest.fitness;

CREATE TABLE jpatest.fitness
(
	id int AUTO_INCREMENT PRIMARY KEY
	, name varchar(40)
	, gender varchar(10)
	, height decimal(10, 2)
	, weight decimal(10, 2)
	, std_weight decimal(10, 2)
	, bmi decimal(10, 2)
	, bmi_result varchar(100)
);

SELECT * FROM jpatest.fitness;