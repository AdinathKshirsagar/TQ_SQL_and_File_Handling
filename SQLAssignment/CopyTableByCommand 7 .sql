select distinct(courseId)
from student;

select count(distinct (courseId)) as AllcourseInStudent
from student;

select 
avg(salary) as AvgSalary,
sum(salary) as Total,
max(salary) as Maximum,
min(salary) as Minimun
from faculty;


# Copy a table by command
create table student_copy
(select* from student);

# Copy only Structure
create table faculty_copy like faculty;
