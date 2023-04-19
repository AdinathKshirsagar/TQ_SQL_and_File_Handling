#String functions

select length("java")from dual;

select concat("Virat "," Kolhi");

# Check Index
select instr('java','a');

# Return substring(start , length)
select substr('hello',3,4);

select substr('Programming',3,5);	# 5 character from 3rd index

select substr('Programming',-3,2);	# from backside then forward direction

select length(concat('Virat','Kohli'));

select ascii('t');

select format('0.481','Percent');
select format('78.61','Percent'); 

select upper('jadeja');
select lower('DHONI');

# repeat
select repeat('Java ',5);

#________________________________testcoursedb__________________________________
# add @gmail.com to all employees
use testcoursedb;
select * from employees;

update employees
set email=concat(email,'@gmail.com');

update employees
set email=lower(email);

update employees
set email=upper(email);

update employees
set email=replace(email,'@GMAIL.COM','@gmail.com');

#________________________________bikedb__________________________________
use bikedb;
select * from customer;

select if(gender like 'female',concat('Mrs.',first_name),concat('Mr.',first_name))as firstname, last_name
from customer;

# Title case

select concat(upper(substring(first_name,1,1)),lower(substring(first_name,2,length(first_name)))) as TitleName
from customer;

# Replace String
update customer 
set last_name = replace(last_name,'Patil','Kshirsagar');

select * from customer;



