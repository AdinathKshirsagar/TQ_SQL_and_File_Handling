# foreign key constraints 

# --------------------constraints--------------------------
 
# restricts :  Not allowed to delete or update [ by default resticts mode ]

alter table student
add constraint fk_course
foreign key (courseId) references course(courseId)
on delete restrict
on update restrict;

alter table student
drop foreign key fk_course;

alter table coursefaculty
add constraint fk_course1
foreign key (courseId) references course(courseId)
on delete restrict
on update restrict;

alter table coursefaculty
drop foreign key fk_course1;

delete from course
where courseid= 105;

# No action : It is same as the restrict mode

# Cascade : To reflect the action into other table
# change from evverywhere , foreign key every where should be in Cascade mode

alter table student
add constraint fk_course
foreign key (courseId) references course(courseId)
on delete cascade
on update cascade;

alter table student
drop foreign key fk_course;

alter table coursefaculty
add constraint fk_coursefaculty1
foreign key (courseId) references course(courseId)
on delete cascade
on update cascade;

alter table coursefaculty
drop foreign key fk_coursefaculty1;

delete from course
where courseid= 105;

# Set Null : set values which are deleted as a null : on facultyId

alter table coursefaculty
add constraint fk_faculty1
foreign key (facultyId) references faculty(facultyId)
on delete set Null
on update set Null;

alter table coursefaculty
drop foreign key fk_faculty1;

delete from faculty
where facultyId= 6;
