CREATE TABLE saida (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  data_compra date NOT NULL,
  descricao varchar(100) NOT NULL,
  parcelada bit(1) NOT NULL,
  valor_total double NOT NULL,
  responsavel_id bigint(20) not null,
  recurso_entrada_saida_id bigint(20) not null,
  PRIMARY KEY (id)
);

alter table saida add constraint fk_responsavel_id
foreign key (responsavel_id) references responsavel(id);

alter table saida add constraint fk_recurso_entrada_saida_id
foreign key (recurso_entrada_saida_id) references recurso_entrada_saida(id);