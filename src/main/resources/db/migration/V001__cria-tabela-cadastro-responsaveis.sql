create table responsavel(
	id bigint not null auto_increment,
	nome varchar(20) not null,
	sobrenome varchar(50) not null,
	data_cadastro datetime,
	status varchar(20) not null,
	primary key(id)
);