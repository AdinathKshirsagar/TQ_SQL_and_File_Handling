use products;

select * from item;
select * from supplier;

# show item supplied by Prem and Yogesh

select * from item
where supid in ( select supid
					from supplier
                    where firstname in ( 'Prem', 'Yogesh'));
                    
# show total item supplied by Prem and Yogesh

select supid,count(*) as Total
from item
where supid in ( select supid
					from supplier
                    where firstname in ('Prem','Yogesh'))
                    group by supid;
                    
 select * from item
 where supid > (select supid
				from supplier
                where firstname="Prem");
                
 # >Any , <Any , >all , <all
 # Any : either
 
 select * from item
 where supid >Any (select supid
					from supplier
                    where firstname in ("Prem","Rohit"));
                    
   #All : Both
   select * from item
   where supid <All ( select supid
						from supplier
                        where firstname in ("Prem","Rohit"));
                        
# update the price of item supplied by Prem

update item 
set cost=cost+200
where supid=(select supid
				from supplier
                where firstname="Prem");
                
 select * from item;               
   
