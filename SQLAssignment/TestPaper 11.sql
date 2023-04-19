use bikedb;

# 1. Add the column of email in customer
alter table customer
add column email varchar(20);

# 2. Show the number of bikes sold of a particular model
select * from purchase;
select count(*) as bikes_sold
from purchase where model_id =8004;

# 3. Show the total cost of each model name
select * from model;
select * from purchase;

select Model_Name, sum(M_cost) as Total_cost
from model
group by Model_name;

# 4. Showing the number of ratings of each model for each rating type in decreasing order:
select * from feedback_rating;
select * from model;
select * from purchase;
select model.Model_name, feedback_rating.rating, count(*) as num_ratings
FROM model JOIN purchase ON model.Model_id = purchase.Model_id
JOIN feedback_rating ON purchase.rating_id = feedback_rating.rating_id
GROUP BY model.Model_name, feedback_rating.rating
ORDER BY model.Model_name, num_ratings DESC;

# 5 . Increasing the cost of each bike by 10%:
update model set M_cost = M_cost +(M_cost * 0.1);

# 6 . Show the purchases whose booking amount is greater than 20,000
select * from purchase;
select * from Purchase where booking_amount > 20000;

# 7.  Show the customer whose mobile no is not given
select * from customer;
select * from customer where mobile_no is null;

# 8 . Show the average cost of all the model name
select * from model;
select avg(M_cost) as average_cost from model;



