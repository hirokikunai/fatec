DROP TABLE departamento;
CREATE TABLE departamento
(
    idDepartamento   VARCHAR2(3),
    nomeDepartamento VARCHAR2(50) NOT NULL,
    ramal            NUMBER(4,0)
);
ALTER TABLE departamento
ADD CONSTRAINT pk_departamento PRIMARY KEY (idDepartamento);

DROP TABLE cargo;
CREATE TABLE cargo
(
    idCargo         VARCHAR2(3) PRIMARY KEY,
    nomeCargo       VARCHAR2(50) NOT NULL,
    valorSalario    NUMBER(8,2) NOT NULL
);

DROP TABLE funcionario;
CREATE TABLE funcionario
(
    idFuncionario   VARCHAR2(4) PRIMARY KEY,
    nomeFuncionario VARCHAR2(50) NOT NULL,
    idDepartamento  VARCHAR2(3) NOT NULL,
    sexo            VARCHAR2(1),
    idCargo         VARCHAR2(2),
    dataAdmissao    DATE
);

ALTER TABLE funcionario
ADD CONSTRAINT fk_funcionario_departamento FOREIGN KEY (idDepartamento) REFERENCES departamento (idDepartamento);


INSERT INTO cargo (idCargo, nomeCargo, valorSalario) VALUES ('C7','VEGETA',400);
INSERT INTO cargo (idCargo, nomeCargo, valorSalario) VALUES ('C2','MADIMBU',750);
INSERT INTO cargo (idCargo, nomeCargo, valorSalario) VALUES ('C5','BULMA',2300);
INSERT INTO cargo (idCargo, nomeCargo, valorSalario) VALUES ('C4','CELL',600);

INSERT INTO departamento (idDepartamento, nomeDepartamento, ramal) VALUES ('D1','ADMINISTRAÇÃO',221);
INSERT INTO departamento (idDepartamento, nomeDepartamento, ramal) VALUES ('D2','OFICINA',235);
INSERT INTO departamento (idDepartamento, nomeDepartamento, ramal) VALUES ('D3','SERVIÇOS GERAIS',243);
INSERT INTO departamento (idDepartamento, nomeDepartamento, ramal) VALUES ('D4','VENDAS',258);

INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1001,'joão sampaio','10/08/1993','M','C2','D2');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1004,'lucio torres','02/03/1994','M','C2','D2');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1034,'roberto pereira','23/05/1992','M','C3','D1');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1021,'josé nogueira','10/11/1994','M','C3','D1');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1029,'ruth de souza','05/01/1992','F','C1','D3');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1095,'maria da silva','03/09/1992','F','C4','D1');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1023,'luiz de almeida','12/01/1992','M','C2','D2');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1042,'pedro pinheiro','29/07/1994','M','C4','D1');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1048,'ana silveira','01/06/1993','F','C5','D1');
INSERT INTO funcionario (idFuncionario,  nomeFuncionario, dataAdmissao, sexo, idCargo, idDepartamento) VALUES (1015,'paulo rodrigues','17/08/1992','M','C2','D2');
