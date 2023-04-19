# Update tableName
# set .....
# where

select * from faculty;
# increase salary by 10000

update faculty
set salary = salary + 10000;
select * from faculty;

# increase salary by 10% whose experience is greater than 5
update faculty
set salary = salary + (0.1*salary)
where experience >=5;
select * from faculty;

update faculty
set experience= experience+2
where fname="Adinath";

select * from student;

update student
set courseId=102
where sname like "vivek";

update student
set courseId=104
where courseId=106;

select * from course;

update course
set duration= "4 months"
where cname = "Java";

update course 
set duration = "4 months"
where cname="Java" or cname="Python";

update course
set fees = fees+5000
where duration="4 months";



