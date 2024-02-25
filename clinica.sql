create database clinica;
drop database clinica;
use clinica;

create table usuarios (
  DNI varchar(9) primary key,
  nombre varchar(20),
  apellidos varchar(20),
  email varchar(50),
  userName varchar(20),
  contra varchar(20)
);

create table dentistas(
  DNI varchar(9) primary key,
  nombre varchar(20),
  apellidos varchar(20),
  email varchar(50),
  userName varchar(20),
  contra varchar(20)
);

insert into usuarios values ("79256544Q","Ritik","Punjabi","gmail","rit","1234");
insert into usuarios values ("7934544Q","Sailesh","Lakhwani","gmail","rit","1234");
insert into usuarios values ("34556544Q","Pia","Lakhwani","gmail","rit","1234");
insert into usuarios values ("87656544Q","Divya","Gopa","gmail","rit","1234");
insert into usuarios values ("79256345V","Tanya","Lakhwani","gmail","rit","1234");

insert into dentistas values ("79256544Q","Ritik","Punjabi","gmail","rit","1234");
insert into dentistas values ("79256234V","Cynthia","","gmail","cyn","1234");

drop table usuarios;

select * from usuarios;

delete from usuarios where DNI="R";