#a) Display all bank name, cname , city from all  bank in ascending order of bankname  and descending order of city name 
select b.name as bank_name, cm.cname as customer_name, b.city
from Bank b
join Customer c on b.bankid = c.bank_id
join Customer_Master cm on c.cust_id = cm.Cust_id
order by b.name asc, b.city desc ;

#b) write query to increase balance increase it by 25%  of existing balance for customer whose bank is SBI. 
update Accounts
set Balance = Balance+(0.25*Balance)
where cust_id in (
select c.cust_id
from Customer c join Bank b on c.bank_id = b.bankid
where b.name = "SBI"
);


#c)  find the count of SBI bank customers as per the city. 
select b.city, count(c.cust_id) as sbi_customers
from Bank b
join Customer c on b.bankid = c.bank_id
where b.name = 'SBI'
group by b.city;

#e) find the 3rd largest transaction from Axis bank.
select t.transaction_id, t.amount, cm.cname as customer_name
from Transaction t
join Accounts a on t.Acc_no = a.Acc_no
join Customer c on a.cust_id = c.cust_id
join Bank b on c.bank_id = b.bankid
join Customer_Master cm on c.cust_id = cm.Cust_id
where b.name = 'Axis'
order by t.amount desc
limit 2,1;


#f)create procedure which display all  bank name of customer  whose pan_no is 'APS1023MA' and customer is senior citizen.

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `displaybanknames`(IN pan_number VARCHAR(45))
BEGIN 
SELECT b.name FROM bank b 
JOIN customer c ON b.bank_id=c.bank_id
JOIN customer_master cm ON c.cust_id=cm.custid WHERE cm.pan_no=KPOUR8951Q AND DATEDIFF(NOW(),cm.birth_date)>=60;
END*/