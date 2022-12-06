drop database customer;
create database if not exists customer;

use customer;

create table customer(
id int primary key auto_increment,
`name` varchar(45),
age int,
address varchar(255),
phone_number varchar(45),
status_delete bit default 0
);

insert into customer (`name`, age, address, phone_number)  values
("Trường", 20, "Trần Phú", 1234567),
("Tùng", 25, "Đống Đa", 346346),
("Thái", 24, "Trần Phú", 34634634),
("Nick", 27, "Trần Phú", 123126546),
("Đạt", 21, "Trần Phú", 777777),
("Hoàng", 22, "Trần Phú", 555555),
("Hòa", 20, "Trần Phú", 222222);
