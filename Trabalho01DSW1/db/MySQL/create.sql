create database Hoteis;

use Hoteis;

CREATE TABLE Hotel(
	e_mail varchar(256) not null,
	senha varchar(256) not null, 
	CNPJ varchar(256) not null, 
	nomeHotel varchar(256), 
	cidade varchar(256), 
	primary key (e_mail));

INSERT INTO Hotel(e_mail, senha, CNPJ, nomeHotel, cidade) values ('rennes@estudante.ufscar.br', 'Us3rl0c4lh0st10@', '55.789.390/0008-99', 'meuHotelA', 'São Carlos');

INSERT INTO Hotel(e_mail, senha, CNPJ, nomeHotel, cidade) values ('rennes2@estudante.ufscar.br', 'Us3rl0c4lh0st10@', '55.789.390/0008-99', 'meuHotelZ', 'Ibaté');

