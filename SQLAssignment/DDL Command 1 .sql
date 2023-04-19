create database studentdb;

use studentdb;

# table faculty

create table faculty(
facultyId int primary key,
fname varchar (30) not null,
phoneNo bigint not null,
salary float,
email varchar(30));

drop table faculty;

desc faculty;
describe course;

create table student(
studId int,
sname varchar(40) not null,
email varchar(50),
phoneNo bigint not null,
courseId int,
feeStatus varchar(10),
primary key (studId));  

desc student;
drop table student;

  