create table tipo_entrada_saida(
	id bigint not null auto_increment,
	nome varchar(20) not null,
	primary key(id)
);

INSERT INTO `tipo_entrada_saida` (`id`, `nome`) VALUES
(null,'Cartão de Crédito'),
(null,'Conta Bancária'),
(null, 'Dinheiro');