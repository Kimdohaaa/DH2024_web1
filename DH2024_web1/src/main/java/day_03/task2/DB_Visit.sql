drop database if exists mydb0120;
create database mydb0120;
use mydb0120;
create table visit(
   num int auto_increment ,
    content longtext , 
    age int ,
    constraint primary key(num)
);
select * from visit;

create table waiting(
	num int auto_increment,
    tel varchar(30),
    count int,
    constraint primary key (num)
);
select * from waiting;