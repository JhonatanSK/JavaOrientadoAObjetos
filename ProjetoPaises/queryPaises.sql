create database SistemaPaises;
use SistemaPaises;

create table paises(
id int auto_increment primary key,
nome varchar (100), 
populacao bigint,
area numeric (15,2)
);

select * from paises;

insert into paises(nome, populacao, area) values ("Italia", 300000, 200.20);

Select id, nome, populacao, area FROM paises order by populacao desc limit 1;

Select id, nome, populacao, area FROM paises order by area asc limit 1;

SELECT * FROM paises WHERE paises.id = 1 or paises.id = 2 or paises.id = 3;

