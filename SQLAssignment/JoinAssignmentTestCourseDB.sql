use testcoursedb;

# 4. Write a query to find the employee id, name (last_name) along with their manager_id, manager name (last_name).

select e.Employee_ID, e.LAST_NAME, e.MANAGER_ID as ManagerId , m.LAST_NAME as ManagerName
from employees e join employees m
on e.MANAGER_ID = m.EMPLOYEE_ID;

# 5. Find the names (first_name, last_name) and hire date of the employees who were hired after 'Jones'.
# 5 Find the employees whose hire date is less than hiredate of Jones
select * 
from employees
where LAST_NAME like 'Jones';
# 1987-09-20

select e.FIRST_NAME , e.LAST_NAME , e.HIRE_DATE
from employees e join employees c
on e.HIRE_DATE<c.HIRE_DATE
and c.LAST_NAME like 'Jones';

# 6. Write a query to get the department name and number of employees in the department.
select department_name, count(*) as Total
from employees e join departments d
on e.DEPARTMENT_ID=d.DEPARTMENT_ID
group by e.DEPARTMENT_ID
order by Total asc;

# 8. Write a query to display the department ID, department name and manager first name
select d.DEPARTMENT_ID , d.DEPARTMENT_NAME , e.FIRST_NAME
from departments d join employees e
on d.MANAGER_ID = e.EMPLOYEE_ID;

# 9. Write a query to display the department name, manager name, and city.
select d.DEPARTMENT_ID,d.DEPARTMENT_NAME,e.FIRST_NAME, l.CITY 
from departments d join employees e join locations l
on d.MANAGER_ID= e.EMPLOYEE_ID and d.LOCATION_ID = l.LOCATION_ID;


# 10. Write a query to display the job title and average salary of employees. group by job_id
select job_title, avg(salary) as AverageSal
from employees e join jobs j
on e.JOB_ID= j.JOB_ID
group by j.job_id;

# 10 . Write a query to display the job title and average salary of employees. group by job_title

select j.JOB_TITLE, avg(salary) as Average
from employees e join jobs j
on e.JOB_ID=j.JOB_ID
group by j.JOB_TITLE;

# 12. Write a query to display the job history that were done by any employee who is currently drawing more than 10000 of salary
select jh.* , e.SALARY
from job_history jh join employees e
on jh.EMPLOYEE_ID= e.EMPLOYEE_ID
and e.SALARY>10000; 





