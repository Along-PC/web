create database weimo default character set utf8;

create table SYS_USER
(
    ID  INT  primary key auto_increment,
    LOGIN_NAME VARCHAR(64),
    LOGIN_PASSWORD  varchar(64)
);