# index in sql

# to view index
use studentdb;

show index from faculty;

show index from student;

select * from faculty;

# index create

alter table faculty
add index (phoneno);

select * from faculty
where phoneno="74847282";

# drop

drop index phoneno on faculty;

create index p1 
on faculty(phoneno);


