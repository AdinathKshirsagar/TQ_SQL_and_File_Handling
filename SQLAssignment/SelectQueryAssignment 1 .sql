# Q1 . Show all the student whose course id is either 103,102 .
select * from student
where courseId in (103,102);

# Q2. Show Student name whose name start with s .alter
select * from student
where sname like 's%';

# Q3. Show all the faculty email id is not null .
select * from faculty;

select * from faculty
where email is not null;

# Q4. Show the number of student in each course
select * from student;

select courseId,count(*) as student
from student
group by courseId;

#Q5. show the number of courses according to the duration
select duration, count(*) as Courses
from course
group by duration;

#Q6. Increase the fess of all the courses by 10%
update course
set fees= fees +(0.1*fees);
select * from course;

#Q7. Increase the salary of faculty by 20% whose experience is greater than 5
select * from faculty;

update faculty
set salary = salary+ ( 0.2*salary)
where experience>=5;


#Q8. Delete the course javaScript
delete from course
where courseId=105;

#Q9. Delete the student who has not paid the fees
select * from student;
delete from student
where feeStatus="NotPaid";

#Q10. Show the faculty in desc order of salary
select * from faculty
order by salary desc;

#Q11. show student in asc order of courseId and if the course is same then desc order of joining date
select * from student
order by courseId asc, joiningDate desc;

#Q12. Show the total student in each course in asc order
select * from student;
select courseId , count(*) as Student
from student
group by courseId 
order by courseId asc;

#Q13. Add the column joining date in faculty
alter table faculty
add column joiningDate date;

#Q14. Change the column to exp of experience

alter table faculty
rename column experience to exp;

alter table faculty
rename column exp to experience;




