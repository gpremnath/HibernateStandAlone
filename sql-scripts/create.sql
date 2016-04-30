create table student_address(address_id serial primary key, street text, city text, country text);
create table student(student_id serial primary key, address_id int , first_name varchar(30), last_name varchar(30), section varchar(15));
alter table student add constraint fk_student_address foreign key(address_id) references student_address;
CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1 ;
