SELECT * FROM studentdb.student;

alter table student
add column joiningDate date;

select * from student;

# order by arraging data

# order by Ascending 
select * from student
order by joiningDate;

# order by Ascending 
select * from student
order by joiningDate desc;

select * from student
where courseId = 103
order by joiningDate desc;

# show student by asc order of course and is the course is same then descending order of joining date 

select * from student
order by courseId asc, joiningDate desc;

# In clause : show the studen who have enrolled in course 103,104

select * from student
where courseId in (103,104)
order by courseId asc;

select * from student
where courseId not in (103,104);

# between 
select * from faculty;

select * from faculty
where salary between 50000 and 90000;

select * from faculty
where salary not between 50000 and 90000;

# limit
select * from faculty
where salary between 50000 and 90000 limit 2;

select * from faculty
where salary between 50000 and 90000 
order by salary desc limit 2;

select * from student
where courseId=103 limit 3;

# aggregate function : count , sum , avg , max , min

select sum(salary) as TotalSalary
from faculty;

# Alias name
select count(*) as Count
from student 
where courseId=103;

select * from student;

select count(*) as Student
from student;

# column name : does not count null values

select count(courseId) as Student
from student;

alter table faculty
add column experience int;

select * from faculty;

select avg(salary) as AverageSalary
from faculty;

select max(salary) as MaxSalary
from faculty;

select min(salary) as MinSalary
from faculty;

select avg(salary) as AvgSalary
from faculty
where experience>=4;


# Like
# start  with s 
select * from student
where sname like 's%';

# End with a
select * from student
where sname like '%a';

# minimum 5 character starting from S
select * from student
where sname like 's____%';

select * from student
where sname like '%y%';

select * from student
where sname like 'm%a';

select * from student
where courseId like 103;

select * from faculty
order by salary;

select * from faculty
order by salary desc;

# Group by
select * from student;

select feestatus, count(*)
from student
group by feeStatus;

select courseId , count(*) as Total
from student
group by courseId;

select courseId , count(*) as Total
from student
group by courseId
order by Total desc;

select courseId , count(*) as Total
from student
where courseId in(103,104)
group by courseId
order by Total desc;

select courseId , count(*) as Total
from student
group by courseId
having courseId in (103,104)
order by Total desc;

select * from faculty;

# on the basis of experience sum of salary of experience
select experience , sum(salary)
from faculty
group by experience;



