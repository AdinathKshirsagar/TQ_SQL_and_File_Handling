# View

create view fees_issue as
select studId,sname,phoneNo,feestatus
from student
where feestatus in("HalfPaid","NotPaid");

select * from fees_issue;

drop view fees_issue;

#change id reflected
update student
set feestatus="Paid"
where studid=6;


# Join

create view student_in_course as
select c.courseid , c.cname, count(s.studid) as TotalStudent
from student s join course c
on s.courseid = c.courseid
group by s.courseid;

alter view student_in_course as 
select c.courseid, c.cname, c.fees, count(s.studid) as Totalstudent
from student s join course c
on s.courseid= c.courseid
group by s.courseid;

select * from student_in_course;

