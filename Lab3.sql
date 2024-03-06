create database hrManagementLavanya;
use hrManagementLavanya;

create table user
(
id int primary key auto_increment,
firstName varchar(50) not null,
lastName varchar(50) not null,
email varchar(50) not null unique,
password varchar(50) not null,
phoneNo varchar(14) not null,
position varchar(50) not null,
type varchar(20) not null);


describe user;
insert into user(firstname,lastname,email,password,phoneNo,type)
values
("Ana","Higgins","demo@yahoo.com","1234","2222","employee"),("Ana","Higgins","ana@yahoo.com","5678","2222","employee"),
("thomas","Higgins","thomas@yahoo.com","5678","2222","admin"),
("sna","Higgins","sana@yahoo.com","5678","2222","admin"),
("bell","Higgins","bell@yahoo.com","5678","2222","employee"),
("gia","Higgins","gia@yahoo.com","5678","2222","employee")

;
select * from user;

create table salary(
id int primary key auto_increment,
employeeId int not null unique,
salary double not null,
datePaid varchar(20) not null,
foreign key (employeeId) references user(id)
on update cascade
on delete cascade
);
truncate salary;
drop table salary;

insert into salary(employeeId,salary,datePaid)
values 
(1,1000,current_date()),
(2,2000,current_date()),
(3,3000,current_date()),
(4,4000,current_date()),
(5,5000,current_date()),
(6,6000,current_date());

select * from user;
select * from salary;

truncate user;

truncate table user;

select user.*,salary.salary,salary.datePaid from salary,user where user.id=salary.employeeId;
truncate hrmanagementlavanya;
drop database hrmanagementlavanya;

delete from user where id=6;