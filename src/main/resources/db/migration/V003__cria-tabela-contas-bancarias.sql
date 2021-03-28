CREATE TABLE conta_bancaria (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  agencia varchar(20) NOT NULL,
  banco varchar(30) NOT NULL,
  conta varchar(20) NOT NULL,
  PRIMARY KEY (id)
);