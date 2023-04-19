SELECT * FROM studentdb.student;

# where clause
select * from student;
select sname , courseId 
from student;

# show the student whose fees is NotPaid
select sname 
from student
where feeStatus= "NotPaid";

select sname 
from student
where feeStatus is null;

select sname
from student
where feeStatus is not null;

select sname
from student
where feeStatus in ("NotPaid","Half");

select sname
from student
where feeStatus="Paid" and courseId=106;

select sname
from student
where feeStatus="NotPaid" or courseId=103;

select sname
from student
where not feeStatus="NotPaid";

select sname
from student
where feeStatus="NotPaid" and (courseId in (103,104));

select sname
from student
where feeStatus="NotPaid" and (courseId=103 or courseId=105);
