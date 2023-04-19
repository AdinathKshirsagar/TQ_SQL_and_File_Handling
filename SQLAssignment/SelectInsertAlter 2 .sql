show databases;
insert into faculty
values(1,"Adinath",3737373,7777,"adinath@gmail.com");

select * from faculty;

insert into faculty
values(2,"Manas",98467363,88883.89,"manas@gmail.com");

insert into faculty
values(3,"Gatha",87493748,66666.4573,"gatha@gmail.com");

insert into faculty
values (4,"Rohit",73683683,55555.987,"rohit@gmail.com");

select fname,salary
from faculty;

insert into faculty
values(5,"Pritish",74847282,44444.67,"pritish@gmail.com"),
(6,"Rupali",8373830,99999.76,"rupali@gmail.com");

alter table course
drop column facultyId;

desc course;

alter table course
modify fees float;

alter table course
drop column duration;

alter table course
add column dur varchar(10);

alter table course
rename column cduration to duration;

alter table course
change column duration cduration varchar(13);

alter table course
drop column duration;

alter table course
add column duration varchar(10)
after cname;

insert into course
values (101,"Java","3 months",5000);

select * from course;

truncate table course;

alter table course
rename to courses;

alter table courses
rename to course;

insert into coursefaculty
values(1,102,2),
(2,103,1),
(3,103,5),
(4,104,4),
(5,106,3),
(6,105,5),
(7,108,2),
(8,102,6);
