use bikedb;

#  Show the name of the customer who have purchase model id 2

select c.first_name, c.last_name
from customer c join  purchase p
on c.cust_id= p.cust_id 
and  p.model_id=8002;

#  Show the number of customers, model_id , model_name who have purchase the same model 

select m.model_id , m.model_name , count((c.cust_id)) as TotalCustomer
from model m join purchase p join customer c
on m.model_id = p.model_id and p.cust_id = c.cust_id
group by m.model_id
having TotalCustomer >1; 

#  Show the names of model model id who have the maximun rating(Rating - 1)

select m.model_name ,m.model_id
from model m join purchase p join feedback_rating f
on m.model_id = p.model_id and p.rating_id = f.rating_id
and f.rating_id =5;


#  Show the names of the customers who have paid in online mode
select c.first_name, c.last_name
from customer c join purchase p join payment_mode f
on c.cust_id = p.cust_id and p.payment_id = f.payment_id and  payment_type='online';

#  Show the total amount paid by each payment mode

select  pm.payment_type,sum(p.booking_Amount) as TotalBooking
from purchase p join  payment_mode pm
on p.payment_id= pm.payment_id
group by p.payment_id;