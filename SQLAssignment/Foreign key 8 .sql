# foreign Key

create database products;
use products;

create table supplier(
supid int,
firstname varchar(30),
lastname varchar(30),
phoneNumber bigint,
email varchar(30),
primary key (supid));

desc supplier;
insert into supplier values
(101,"Anand", "Solanke",3883737,"anand@gmail.com"),
(102,"Prem","Patil",9896868,"prem@gmail.com"),
(103,"Rohit","Dange",986676,"rohit@gmail.com"),
(104,"Yogesh","Kshirsagar",986787,"yogesh@gmail.com"),
(105,"Gaurav","Chavan",878367,"gaurav@gmail.com"),
(106,"Sachin","Jadhava",7836737,"saching@gmail.com");

select * from supplier;

create table item(
itemid int,
itemName varchar(30),
cost float,
supid int,
foreign key (supid) references supplier(supid));

desc item;

insert into item values
(1,"Pendrive",7557,102),
(2,"HardDisk",5847,103),
(3,"WebCamera",8373,101),
(4,"Charger",8378,103),
(5,"WebCamera",6683,104),
(6,"HeadPhones",540,106);

drop table item;
select * from item;

desc item;
# does not allow with sup id 107 as it is not present
insert into item values
(7,"Mobil",667367,107);


delete from supplier
where supid = 105;

select * from supplier;

delete from supplier
where supid= 104;

# ________________________________________________________________

use studentdb;

select * from student;
select * from course;

alter table student
add foreign key (courseId) references course(courseid);

alter table coursefaculty
add foreign key (facultyId) references faculty(facultyId);

alter table coursefaculty
add constraint fk_course1
foreign key (courseId) references course(courseId);

alter table coursefaculty
add constraint fk_faculty
foreign key (facultyId) references faculty(facultyId);

#___________________________________________________________________
