CREATE TABLE cartao_credito (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nome_cartao varchar(30) NOT NULL,
  numero_cartao varchar(19) NOT NULL,
  validade datetime NOT NULL,
  dia_vencimento int(2) NOT NULL,
  PRIMARY KEY (id)
);