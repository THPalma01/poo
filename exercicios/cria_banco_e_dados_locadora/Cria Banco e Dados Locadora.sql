create database locadora;
use locadora;
create table genero (
	codGenero int primary key,
	descricao varchar(60)
);
insert into genero values
(1, 'Terror'),
(2, 'Comedia'),
(3, 'Drama');
create table filme (
	codFilme int primary key,
	titulo varchar(70),
	duracao int,
	preco decimal(10,2),
	codGenero int
);

alter table filme
	add constraint fkGenero 
	     foreign key (codGenero) 
		 references genero(codGenero);
insert into filme values
(1, 'Aladin', 76, 5.87, 2),
(2, 'Sexta-Feira 13 parte 99', 120, 1.76, 1);
