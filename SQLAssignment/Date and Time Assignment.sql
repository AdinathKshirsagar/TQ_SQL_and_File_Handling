use testcoursedb;

# 2. write a query to display first day of the  month

select subdate(adddate(curdate(),interval 1 day),interval day(curdate()) day);

# 3. Write a query to display last day of the month

select subdate(adddate(curdate(),interval 1 month),interval day(curdate())day);

# 4. Write a query to get first day of the year

# makeDate(year,day of year)

select extract(year from curdate());

select makedate(extract(year from curdate()),1);

# fromDays : Make date from number of days

select from_days(738981); 

#_____________________________payrolldb_______________________________
use payroll;

select ename,birth_date, date_format(from_days(datediff(curdate(),birth_date)),'%Y')+0 as Age
from emoployee;

#_____________________________testcoursedb_______________________________
use testcoursedb;

# 1. Show the employee names who have been hired in june
select first_name , last_name
from employees
where monthname(hire_date)='June';

# 2. Write a query to get the years in which more than 2 employees joined. 

select date_format(hire_date,'%Y')as HireYear
from employees
group by HireYear
having count(EMPLOYEE_ID)>2;

# 3. Write a query to get first name of employees who joined in 1986.
select first_name
from employees
where year(hire_date)=1986;

# 4. Write a query to get department name, manager name, and salary of 
#    manager for all managers whose experience is more than 5 years.

select d.DEPARTMENT_NAME, e.FIRST_NAME , e.SALARY
from departments d join employees e
on e.MANAGER_ID = d.MANAGER_ID
and (datediff(curdate(),hire_date)/365)>5;

# 5. write a query to get employee_ID , last_name , and date of first salary of the employees.
select employee_id , last_name , LAST_DAY(hire_date) as 'Day of first salary'
from employees;

# 6. Write a query to get first name, hire_date and experience of the employees.
select first_name , hire_date , datediff(curdate(),hire_date)/365 as 'Experience'
from employees;



