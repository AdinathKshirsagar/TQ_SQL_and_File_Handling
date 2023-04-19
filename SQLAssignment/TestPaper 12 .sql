create database bankdatabase;
use bankdatabase;

create table Bank (
    bankid int primary key,
    name varchar(50) not null,
    Address varchar(100) not null,
    city varchar(50) not null,
    state varchar(50) not null
);

create table Customer (
    cust_id int primary key,
    bank_id int not null,
    foreign key (bank_id) references Bank(bankid)
);

create table Accounts (
    Acc_no int primary key,
    cust_id int not null,
    Acctype_id int not null,
    Balance float not null,
    open_date date not null,
    foreign key (cust_id) references Customer(cust_id),
    foreign key (Acctype_id) references AccountType(acctype_id)
);

create table AccountType (
    acctype_id int primary key,
    acctype varchar(50) not null
);

create table Transaction (
    transaction_id int primary key,
    Acc_no int not null,
    amount float not null,
    transaction_type int not null,
    date date not null,
    foreign key (Acc_no) references Accounts(Acc_no)
);

create table Customer_Master (
    Cust_id int primary key,
    cname varchar(50) not null,
    contact varchar(15) not null,
    birth_date date not null,
    pan_no varchar(10) not null
);


insert into Bank (bankid, name, Address, city, state)
values (1, 'HDFC Bank', '123 Main St', 'Mumbai', 'Maharashtra'),
       (2, 'ICICI Bank', '456 Broadway', 'Bangalore', 'Karnataka'),
       (3, ' SBI', 'pabal phata', 'shirur', 'Maharashtra'),
       (4, 'Axis', 'samta lane', 'New Delhi', 'Delhi'),
       (5, 'PDC', '789 Park Ave', 'sitanagar', 'Kerala');
       
insert into Customer (cust_id, bank_id)
values (1, 1),
       (2, 2),
       (3, 3), (4, 4), (5, 5);
       
       
insert into AccountType (acctype_id, acctype)
values (1, 'Saving'),
       (2, 'Current');
       
insert into Accounts (Acc_no, cust_id, Acctype_id, Balance, open_date)
values (1001, 1, 1, 10000, '2022-01-01'),
		(1002, 2,2, 5000, '2022-02-01'),
		(1003, 3, 2, 20000, '2022-03-01'),
		(1004, 4, 1, 15000, '2022-04-01'),
		(1005, 5, 2, 30000, '2022-05-01');
          
          
insert into Transaction (transaction_id, Acc_no, amount, transaction_type , date)
values (1, 1001, 5000, 1, '2022-01-05'),
       (2, 1002, 1000, 1, '2022-02-05'),
       (3, 1003, 2000, 2, '2022-03-05'),
       (4, 1004, 500, 2, '2022-04-05'),
       (5, 1005, 10000, 2, '2022-05-05');
       
       
insert into Customer_Master (Cust_id, cname, contact, birth_date, pan_no)
values (1, 'Rahul ', '9999999999', '1990-01-01', 'ABCDE1234F'),
       (2, 'Pratik', '8888888888', '1999-03-01', 'FGHIJ5678K'),
	   (3, 'Suyog', '8888888888', '1992-02-01', 'GFDHIJ567K'),
		(4, 'Vivek', '9755888888', '1995-02-01', 'FGHIJ5678K'),
		(5, 'Omkar', '856888888', '1996-06-07', 'SDFJ5678K');
             
             
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

#f) create procedure which display all  bank name of customer  whose pan_no is 'APS1023MA' and customer is senior citizen.

# g) Find the number of customer on the basis of account type
select acctype, count(distinct cust_id) as number_of_customers
from Accounts a
join AccountType atp on a.Acctype_id = atp.acctype_id
group by acctype;

# h) Display the time span of the account being opened
select Acc_no, datediff(curdate(), open_date) as time_span_days
from Accounts;


#e) Display the accountno, balance, customer name, age of the customer
select a.Acc_no, a.Balance, cm.cname as customer_name, year(curdate()) - year(cm.birth_date) as age
from Accounts a
join Customer c on a.cust_id = c.cust_id
join Customer_Master cm on c.cust_id = cm.Cust_id;