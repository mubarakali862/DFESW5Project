drop table if exists student CASCADE;
create table student (
id integer auto_increment, 
address varchar(255), 
name varchar(255), 
roll integer not null, 
primary key (id)
);