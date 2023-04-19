use testcoursedb;

# Nth highest salary

select distinct(salary) from employees;

select distinct (salary) from employees
order by salary desc ;

select count(distinct(salary))
from employees;

# 3rd highest 
select distinct salary
from employees e1 
where 3= ( select count(distinct(salary))
			from employees e2
            where e1.SALARY<=e2.SALARY);
            
# 4th lowest
select distinct salary
from employees e1
where 4=(select count(distinct(SALARY))
			from employees e2
            where e1.SALARY>=e2.SALARY);

select distinct salary
from employees
order by salary desc
limit 2,1;

select min(salary) from
(select distinct(salary) from employees
order by salary desc
limit 3) as ThirdHighest;


select distinct(salary) from employees
order by salary asc
limit 4;


select max(salary) from
(select distinct(salary) from employees
order by salary asc
limit 4) as FourthLowest;


select i.itemName, i.cost
from item i
where 3 =(select count(distinct cost)
						from item i1
                        where i1.cost>=i.cost);


select e.ename, e.salary
from employee e
where 3= (select count(distinct salary)
			from employee e1
            where e1.salary>= e.salary);
            








 

