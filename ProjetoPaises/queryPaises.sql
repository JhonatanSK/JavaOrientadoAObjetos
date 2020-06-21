create database SistemaPaises;
use SistemaPaises;

create table paises(
id int auto_increment primary key,
nome varchar (100), 
populacao bigint,
area numeric (15,2)
);

SELECT id, nome, populacao, area FROM paises WHERE id = 4;

select * from paises;

delete from paises where id > 6;

insert into paises(nome, populacao, area) values ("Italia", 300000, 200.20);
insert into paises(nome, populacao, area) values ("Japão", 300000, 200.20);

Select id, nome, populacao, area FROM paises order by populacao desc limit 1;

Select id, nome, populacao, area FROM paises order by area asc limit 1;

SELECT * FROM paises WHERE paises.id = 1 or paises.id = 2 or paises.id = 3;

