CREATE TABLE parcela (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  data_venvimento date not NULL,
  parcela_numero int(11) not NULL,
  situacao varchar(20) not NULL,
  valor_unit double not NULL,
  saida_id bigint(20) not NULL,
  PRIMARY KEY (id)
);

alter table parcela add constraint fk_saida_id
foreign key (saida_id) references saida(id);