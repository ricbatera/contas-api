create table recurso_entrada_saida(
id bigint(20) not null auto_increment,
descricao varchar(50) not null,
id_tipo_entrada_saida bigint,
nome_cartao varchar(30),
numero_cartao varchar(19),
validade datetime,
dia_vencimento int(2),
agencia varchar(20),
banco varchar(30),
conta varchar(20),
PRIMARY KEY (id)
);

alter table recurso_entrada_saida add constraint fk_tipo_entrada_saida_id
foreign key (id_tipo_entrada_saida) references tipo_entrada_saida(id);