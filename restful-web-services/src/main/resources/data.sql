insert into user_details(id,birth_date,name)
values (10001,current_date(),'Adam'),
(10002,current_date(),'Mark'),
(10003,current_date(),'Joe');

insert into post(id,description,user_id)
values (20001,'I want to learn aws',10001),
(20002,'I want to learn cybersecurity',10001),
(20003,'I want to learn devops',10002);