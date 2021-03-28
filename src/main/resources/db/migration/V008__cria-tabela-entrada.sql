create table entrada(
id bigint(20) NOT NULL AUTO_INCREMENT,
descricao varchar(50) not null,
fonte_pagadora varchar(50) not null,
data_entrada date not null,
recebido boolean not null,
valor double not null,
PRIMARY KEY (id)
);