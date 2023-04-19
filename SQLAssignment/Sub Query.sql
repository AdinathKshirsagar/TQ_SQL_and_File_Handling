select sname , feestatus
from student
where courseid=(select courseId
					from course
						where cname ="Python");
                        
# single values : =
# single row : >,<,>=,<=
# more than one value : in

select sname, feestatus
from student
where courseId= (select courseId
					from course
						where cname="Python")and feeStatus="Half";
                        
# Show student whose faculty is same
select * from student
where courseId in  (select courseId
					from coursefaculty
                    where facultyId=(select facultyId
										from faculty
                                        where fname="Gatha"));
                                        
# Student details whose coursename is java
select * from student
where courseId=(select courseId
				from course
                where cname="Java");
                
# Show Student details whose course duration is 4 months
select * from student
where courseId in (select courseId
				from course
                where duration="4 months");
                
# Show the course whose faculty salary is greater than 60000

select * from course
where courseId in (select courseId
					from coursefaculty
                    where facultyId in ( select facultyId
											from faculty
                                            where salary>6000));
                                            
# show the course where number of student enrolled is greater than 2;

select courseId , count(*) as Total
from student
group by courseId
having total>=2;

# show the course details where number of student enrolled is greater than 2;
select * from course 
where exists ( select courseId,count(*) as Total
				from student
                where course.courseId= student.courseId
                group by courseId
                having Total>=2);
                
# within the table
# show the names of have faculty whose salary is greater than salary of Adinath

select * from faculty
where salary > ( select salary
				from faculty
                where fname = "Adinath");
                
# Show the names whose experience is greater than jayshree
select * from faculty 
where experience>(select experience
					from faculty
						where fname="Manas");
                        
# show faculty name whose salary is greater than average salary

select fname
from faculty
where salary>=( select avg(salary)
				from faculty);
							
# update the salary of faculty whose salary is greater than average salary

update faculty
set salary = salary+1000
where salary>30000;

select * from faculty;
#////////////////////////Not understand////////////////////

update faculty f1
set salary= salary+1000
where salary>(select avg(salary)
			from faculty f2
            where f1.facultyId=f2.facultyId);
#______________________________________________________________

# update the salary of faculty whose are teaching more than one course
select * from coursefaculty;

select facultyId, count(*) as Totalcourse
from coursefaculty
group by facultyId
having Totalcourse>1;

select * from faculty
where exists ( select facultyId, count(*) as Totalcourse
				from coursefaculty
                where faculty.facultyId=coursefaculty.facultyId
                group by facultyId
                having Totalcourse>1);
                
 select * from coursefaculty
 where facultyId=5;
 
 select * from course
 where courseId in ( select courseId from coursefaculty 
						where facultyId=5);
 