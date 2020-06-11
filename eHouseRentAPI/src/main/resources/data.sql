insert into roles(role)values ("owner")
insert into addresses(house_number,state,city,street,zip_code)values("12","tx","sanantonio","123",1234)
insert into addresses(house_number,state,city,street,zip_code)values("13","rx","Dallas","13",1934)

insert into users(first_name,last_name,phone_no,pass_word,user_name,address_id)values ("selam","ghide","123456","1212","selam@g",1)
insert into users(first_name,last_name,phone_no,pass_word,user_name,address_id)values ("Jirom","ghide","123456","1212","selam@g",1)

insert into houses(price,addres_id,owner_id,house_type,number_of_rooms)values(1000,1,1,"villa",2)
insert into houses(price,addres_id,owner_id,house_type,number_of_rooms)values(5000,2,1,"service",3)
-- insert into house(price,addres_id)values(10000,2);
insert into booking_records(check_in_date,check_out_date,total_price)values("2020-06-06","2020-06-10",100)
insert into booking_records(check_in_date,check_out_date,total_price)values("2020-06-06","2020-06-10",100)