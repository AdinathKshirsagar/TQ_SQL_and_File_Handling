use studentdb;
select * from student;
select * from course;

select s.sname , s.feestatus
from student s join course c
on s.courseid= c.courseid and c.cname="Python";

# show student whose faculty and name is Gatha
select s.sname, s.joiningDate, s.studId, s.feestatus,f.fname
from student s join coursefaculty cs join faculty f
on s.courseid= cs.courseid and cs.facultyId = f.facultyId and f.fname="Gatha";

# show the student table and course table by using join 
select * 
from student s join course c
on s.courseId= c.courseId;

# show student details whose coursename is java
select s.sname, s.studid, s.feestatus, c.cname
from student s join course c
on s.courseid = c.courseid  and cname="Java";

# show student details whose corse duration is 4 Months
select s.*, c.cname
from student s join course c
on s.courseId=c.courseId and c.duration like "4 months";

# show the course who faculty salary is greater than 60000
select c.cname, f.fname,f.salary
from course c join  coursefaculty cs join faculty f
on c.courseId=cs.courseId and cs.facultyId= f.facultyId and f.salary>60000;

# self join

# show the names of have faculty whose salary is greater than salary of Adinath
select f1.fname, f1.salary
from faculty f1 join faculty f2
on f1.salary>f2.salary and f2.fname="Adinath";

# show the names whose experience is greater than Yogesh
select f1.fname, f1.experience
from faculty f1 join faculty f2
on f1.experience > f2.experience and f2.fname ="Yogesh";

# show faculty name whose salary is greater than average salary
# better with subquery

# show the course details where faculty id 5
select c.*
from course c join coursefaculty cf join faculty f
on c.courseId = cf.courseId and cf.facultyId = f.facultyId and f.facultyId= 5;

# show the faculty details who are teaching more than one course
select f.*  , count(cf.courseId)as TotalCourse
from faculty f join coursefaculty cf
on f.facultyId = cf.facultyId
group by cf.facultyId
having TotalCourse>1;