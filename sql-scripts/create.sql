
create table student_address(address_id serial primary key, street text, city text, country text);

create table student(student_id serial primary key, address_id int , first_name varchar(30), last_name varchar(30), section varchar(15));

alter table student add constraint fk_student_address foreign key(address_id) references student_address;

CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1 ;

CREATE table student_fb ( fb_id serial primary key, fb_user_id varchar(50),fb_password varchar(16),fb_profile_page text);

ALTER table student_fb add constraint studuent_fb_fk FOREIGN KEY (fb_id) REFERENCES student(student_id) ON DELETE CASCADE;

create table classroom (
       room_id SERIAL PRIMARY KEY,
       alphabet_id VARCHAR(3) NOT NULL,
       building_name  VARCHAR(30) NOT NULL,
       constraint room_uq unique (alphabet_id)
     );

alter table student  add column classroom_id integer;

alter table student  add constraint fk_classroom FOREIGN KEY (classroom_id) REFERENCES classroom;

create table student_email_details (mail_id integer,mail_username varchar(50), mail_password varchar(16),mail_account varchar(25));

alter table student_email_details add constraint student_email_fk FOREIGN KEY (mail_id) REFERENCES student ON DELETE CASCADE;

ALTER TABLE STUDENT ADD COLUMN university_id integer;

ALTER TABLE STUDENT ADD CONSTRAINT student_university_fk  FOREIGN KEY (university_id) REFERENCES UNIVERSITY; 

CREATE TABLE TEXTBOOK (textbook_id SERIAL PRIMARY KEY, author varchar(60), name varchar (255));

ALTER TABLE STUDENT_TEXTBOOK ADD PRIMARY KEY (student_id,textbook_id);

ALTER TABLE STUDENT_TEXTBOOK ADD CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES STUDENT;

ALTER TABLE STUDENT_TEXTBOOK ADD CONSTRAINT fk_textbook FOREIGN KEY (textbook_id) REFERENCES TEXTBOOK;
