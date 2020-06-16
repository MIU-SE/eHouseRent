
insert into roles(role)values ("ROLE_OWNER")
insert into roles(role)values ("ROLE_USER")

insert into addresses(house_number,state,city,street,zip_code)values("12","tx","sanantonio","123",12345)
insert into addresses(house_number,state,city,street,zip_code)values("13","tx","Dallas","15",75243)
insert into addresses(house_number,state,city,street,zip_code)values("14","tx","Dallas","16",75243)
insert into addresses(house_number,state,city,street,zip_code)values("15","tx","Dallas","18",75243)
insert into addresses(house_number,state,city,street,zip_code)values("16","tx","Dallas","15",75243)

insert into addresses(house_number,state,city,street,zip_code)values("12","iowa","fairfield","123",12345)
insert into addresses(house_number,state,city,street,zip_code)values("13","iowa","fairfield","13",75243)
insert into addresses(house_number,state,city,street,zip_code)values("14","iowa","fairfield","13",75243)
insert into addresses(house_number,state,city,street,zip_code)values("15","iowa","fairfield","13",75243)

-- owners
insert into users(first_name,last_name,phone_no,pass_word,user_name,address_id)values ("selam","ghide","123456","selam","selam",1)
insert into users(first_name,last_name,phone_no,pass_word,user_name,address_id)values ("Jirom","ghide","123456","1212","jirom@g",2)
-- customers
insert into users(first_name,last_name,phone_no,pass_word,user_name,address_id)values ("Bruk","ghide","123456","bruk","bruk",1)
insert into users(first_name,last_name,phone_no,pass_word,user_name,address_id)values ("Eyob","ghide","123456","111","eyob@e",2)

insert into houses(price,description,owner_id,addres_id,house_type,number_of_rooms)values(100,"downtown and clean",1,2,"house",2)
insert into houses(price,description,owner_id,addres_id,house_type,number_of_rooms)values(50,"near airport",2,3,"appartment",3)
insert into houses(price,description,owner_id,addres_id,house_type,number_of_rooms)values(300,"downtown and clean",1,4,"luxury",2)
insert into houses(price,description,owner_id,addres_id,house_type,number_of_rooms)values(200,"near airport",2,5,"house",3)
insert into houses(price,description,owner_id,addres_id,house_type,number_of_rooms)values(300,"calm place",2,6,"appartment",4)
insert into houses(price,description,owner_id,addres_id,house_type,number_of_rooms)values(250,"downtown",2,7,"luxury",3)
insert into houses(price,description,owner_id,addres_id,house_type,number_of_rooms)values(350,"confortable",2,8,"house",3)
insert into houses(price,description,owner_id,addres_id,house_type,number_of_rooms)values(200,"downtown",2,9,"luxury",4)




insert into booking_records(check_in_date,check_out_date,total_price,house_id,user_id)values("2020-06-06","2020-06-10",100,1,3)
insert into booking_records(check_in_date,check_out_date,total_price,house_id,user_id)values("2020-06-06","2020-06-10",100,2,4)


insert into users_roles(user_id,role_id) value (1,1)
insert into users_roles(user_id,role_id) value (2,2)
insert into users_roles(user_id,role_id) value (3,1)
