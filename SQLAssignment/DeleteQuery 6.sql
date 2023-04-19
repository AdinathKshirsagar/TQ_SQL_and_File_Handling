# delete from tablename where......

select * from course;

delete from course
where courseId=103;

select * from student;
delete from student
where feeStatus="Notpaid" and courseId=103;

