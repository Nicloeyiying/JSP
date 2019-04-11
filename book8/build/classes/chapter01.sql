/*在MySQL中创建一个名称为chapter01的数据库，
  然后在该数据库中创建一个users表，SQL语句如下所示*/
-- CREATE DATABASE chapter01;
-- USE chapter01;
CREATE TABLE users(
		id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(40),
		password VARCHAR(40),
		email VARCHAR(60),
		birthday DATE 
)CHARACTER SET utf8 COLLATE utf8_general_ci;


/*数据库和表创建成功后，再向users表中插入3条数据，SQL语句如下所示*/
INSERT INTO users(NAME,PASSWORD,email,birthday) 
VALUES('zs','123456','zs@sina.com','1980-12-04');
INSERT INTO users(NAME,PASSWORD,email,birthday) 
VALUES('lisi','123456','lisi@sina.com','1981-12-04');
INSERT INTO users(NAME,PASSWORD,email,birthday) 
VALUES('wangwu','123456','wangwu@sina.com','1979-12-04');


/*为了查看数据是否添加成功，使用SELECT语句查询users表，SQL语句如下所示*/
SELECT * FROM users;