--用户表
create TABLE t_user
(
    id       int(6) primary key auto_increment,
    username varchar(60),
    password varchar(60),
    email    varchar(60)
);
--省份表
CREATE TABLE t_province
(
    id          int(6) primary key auto_increment,
    name        varchar(60),
    tags        varchar(80),
    placecounts INT(4)
)


--景点表
CREATE table t_place
(
    id        int(6) primary key auto_increment,
    name      VARCHAR(60),
    picpath   VARCHAR(60),
    hottime   TIMESTAMP,
    hotticket DOUBLE(7, 2
) ,
	dimticket DOUBLE(7,2),
	placedes VARCHAR(300),
	provinceid int(6) REFERENCES t_province(id)
	)


