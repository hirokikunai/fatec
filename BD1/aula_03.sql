ALTER TABLE autorias DROP CONSTRAINT fk_autores_autorias;
ALTER TABLE autorias DROP CONSTRAINT fk_livros_autorias;
ALTER TABLE empretimos DROP CONSTRAINT fk_socios_emprestimos;
ALTER TABLE livros DROP CONSTRAINT fk_assuntos_livros;


DROP TABLE autorias;
DROP TABLE autores;
DROP TABLE assuntos;
DROP TABLE livros;
DROP TABLE socios;
DROP TABLE emprestimos;


CREATE TABLE emprestimos (
    idLivro VARCHAR(15) NOT NULL,
    idSocio INT,
    dataRetirada DATE NOT NULL,
    dataDevolucaoPrevista DATE NOT NULL,
    dataDevolucaoReal DATE,
    valorMulta FLOAT
);

CREATE TABLE socios (
    idSocio INT,
    nome VARCHAR2(40) NOT NULL,
    telefone VARCHAR(20)  NOT NULL,
    logradouro VARCHAR(30) NOT NULL,
    complemento VARCHAR(15),
    bairro VARCHAR(15),
    cidade VARCHAR(20),
    UF VARCHAR(2),
    CEP VARCHAR(8)
);

CREATE TABLE livros (
    idLivro VARCHAR(15) NOT NULL,
    titulo VARCHAR2(80) NOT NULL,
    editora VARCHAR2(20) NOT NULL,
    totalPago FLOAT CHECK(totalPago>0),
    diasPrazo INT CHECK(diasPrazo>=0),
    idAssunto INT NOT NULL
);

CREATE TABLE assuntos (
    idAssunto INT,
    nome VARCHAR2(40) NOT NULL
);

CREATE TABLE autores (
    idAutor INT,
    nome VARCHAR(40) NOT NULL,
    origem VARCHAR(20) NOT NULL
);

CREATE TABLE autorias (
    idLivro VARCHAR(15) NOT NULL,
    idAutor INT NOT NULL
);


ALTER TABLE socios ADD CONSTRAINT pk_socios PRIMARY KEY (idSocio);
ALTER TABLE emprestimos ADD CONSTRAINT pk_emprestimos PRIMARY KEY (idLivro, idSocio, dataRetirada);
ALTER TABLE livros ADD CONSTRAINT pk_livros PRIMARY KEY (idLivro);
ALTER TABLE emprestimos ADD CONSTRAINT fk_livros_emprestimos FOREIGN KEY (idLivro) REFERENCES livros (idLivro);
ALTER TABLE emprestimos ADD CONSTRAINT fk_socios_emprestimos FOREIGN KEY (idSocio) REFERENCES socios (idSocio);
ALTER TABLE assuntos ADD CONSTRAINT pk_assuntos PRIMARY KEY (idAssunto);
ALTER TABLE livros ADD CONSTRAINT fk_assuntos_livros FOREIGN KEY(idAssunto) REFERENCES assuntos (idAssunto);
ALTER TABLE assuntos ADD CONSTRAINT uq_assuntos UNIQUE (nome);
ALTER TABLE autorias ADD CONSTRAINT pk_autorias PRIMARY KEY (idLivro, idAutor);
ALTER TABLE autorias ADD CONSTRAINT fk_livros_autorias FOREIGN KEY (idLivro) REFERENCES livros (idLivro);
ALTER TABLE autorias ADD CONSTRAINT fk_autores_autorias FOREIGN KEY (idAutor) REFERENCES autores (idAutor);

ALTER TABLE autores ADD CONSTRAINT pk_autores PRIMARY KEY (idAutor);

INSERT INTO autores (idautor, nome, origem) VALUES (1,'Silva, José da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (2,'Silva, Vanderlei da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (3,'Silva, João da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (4,'Silva, Pedro da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (5,'Silva, Ana da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (6,'Silva, Antonio da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (7,'Silva, Joaquim da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (8,'Silva, Pedro da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (9,'Silva, Maria da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (10,'Silva, Vanderlei da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (11,'Silva, Teobaldo da', 'Origem1');
INSERT INTO autores (idautor, nome, origem) VALUES (12,'Silva, Arlete da', 'Origem1');

INSERT INTO assuntos (idAssunto, nome) VALUES (1,'MICROBIOLOGIA');
INSERT INTO assuntos (idAssunto, nome) VALUES (2,'PROGRAMAÇÃO');
INSERT INTO assuntos (idAssunto, nome) VALUES (3,'MATERIAIS');
INSERT INTO assuntos (idAssunto, nome) VALUES (4,'FISIOLOGIA');
INSERT INTO assuntos (idAssunto, nome) VALUES (5,'USINAGEM');
INSERT INTO assuntos (idAssunto, nome) VALUES (6,'BANCOS DE DADOS');
INSERT INTO assuntos (idAssunto, nome) VALUES (7,'CALCULO');

INSERT INTO livros (idLivro, titulo, editora, totalPago, diasPrazo, idAssunto) 
VALUES ('737.4.202 S2002','Os bichos são assim', 'LTC Ano: 1990', 30, 7, 1);
INSERT INTO livros (idLivro, titulo, editora, totalPago, diasPrazo, idAssunto) 
VALUES ('681.5.203 S442','Técnicas de programação estruturada', 'Campus Ano: 1992', 30, 7, 2);
INSERT INTO livros (idLivro, titulo, editora, totalPago, diasPrazo, idAssunto) 
VALUES ('588.9.949 S3003','Ensaios de dureza e de moleza', 'LTC Ano: 1993', 30, 7, 3);
INSERT INTO livros (idLivro, titulo, editora, totalPago, diasPrazo, idAssunto) 
VALUES ('737.4.234 S2323','O funcionamento do intestino', 'Globo Ano: 1990', 30, 7, 4);
INSERT INTO livros (idLivro, titulo, editora, totalPago, diasPrazo, idAssunto) 
VALUES ('588.3.342 S4343','Torno radial: Como funciona a coisa', 'LTC Ano: 1994', 30, 7, 5);
INSERT INTO livros (idLivro, titulo, editora, totalPago, diasPrazo, idAssunto) 
VALUES ('737.4.180 S2023','Bactérias, micróbios e coisas parecidas', 'Erika Ano: 1989', 30, 7, 1);
INSERT INTO livros (idLivro, titulo, editora, totalPago, diasPrazo, idAssunto) 
VALUES ('683.2.343 S334','Teoria de bancos de dados', 'Campus Ano: 1990', 30, 7, 6);
INSERT INTO livros (idLivro, titulo, editora, totalPago, diasPrazo, idAssunto) 
VALUES ('333.5.656 S1849','Calculo diferencial e integral', 'LTC Ano: 1990', 30, 7, 7);

INSERT INTO autorias ( idLivro, idAutor )
VALUES ('737.4.202 S2002',1);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('737.4.202 S2002',2);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('681.5.203 S442',3);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('588.9.949 S3003',4);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('737.4.234 S2323',5);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('588.3.342 S4343',6);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('588.3.342 S4343',7);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('588.3.342 S4343',8);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('737.4.180 S2023',9);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('737.4.180 S2023',10);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('683.2.343 S334',11);
INSERT INTO autorias ( idLivro, idAutor )
VALUES ('333.5.656 S1849',12);

INSERT INTO socios (idSocio, nome, telefone, logradouro, complemento, bairro, cidade, UF, CEP)
VALUES (1,'Bruno Nagao', '9999999999','Rua Endereço, 000', 'complemento', 'bairro', 'cidade', 'UF', '99999999' );
INSERT INTO socios (idSocio, nome, telefone, logradouro, complemento, bairro, cidade, UF, CEP)
VALUES (2,'Eduardo Son', '9999999999','Rua Endereço, 000', 'complemento', 'bairro', 'cidade', 'UF', '99999999' );
INSERT INTO socios (idSocio, nome, telefone, logradouro, complemento, bairro, cidade, UF, CEP)
VALUES (3,'Angelino Pires', '9999999999','Rua Endereço, 000', 'complemento', 'bairro', 'cidade', 'UF', '99999999' );
INSERT INTO socios (idSocio, nome, telefone, logradouro, complemento, bairro, cidade, UF, CEP)
VALUES (4,'Bruna Taura', '9999999999','Rua Endereço, 000', 'complemento', 'bairro', 'cidade', 'UF', '99999999' );
INSERT INTO socios (idSocio, nome, telefone, logradouro, complemento, bairro, cidade, UF, CEP)
VALUES (5,'Marcos Sena', '9999999999','Rua Endereço, 000', 'complemento', 'bairro', 'cidade', 'UF', '99999999' );

INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal, valorMulta) 
VALUES ('737.4.202 S2002', '1', '30/04/2019', '30/05/2019', '25/06/2019', 20);
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal, valorMulta) 
VALUES ('681.5.203 S442', '2', '30/01/2019', '28/02/2019', '09/02/2019', 20);
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('588.9.949 S3003', '3' ,'30/01/2019', '28/02/2019', NULL);
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('737.4.234 S2323', '4' ,'30/04/2019', '20/06/2019', NULL);
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('588.3.342 S4343', '5' ,'30/04/2019', '20/07/2019', NULL);
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('737.4.202 S2002', '4', '30/03/2019', '30/04/2019', '27/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('737.4.180 S2023', '2', '30/03/2019', '30/04/2019', '10/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('683.2.343 S334', '3', '30/03/2019', '30/04/2019', '15/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('333.5.656 S1849', '4', '30/03/2019', '30/04/2019', '17/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('737.4.202 S2002', '5', '30/03/2019', '30/04/2019', '10/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('681.5.203 S442', '1', '30/03/2019', '30/04/2019', '02/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('588.9.949 S3003', '2', '30/03/2019', '30/04/2019', '01/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('737.4.234 S2323', '3', '30/03/2019', '30/04/2019', '09/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('588.3.342 S4343', '4', '30/03/2019', '30/04/2019', '11/04/2019');
INSERT INTO emprestimos (idLivro, idSocio, dataRetirada, dataDevolucaoPrevista, dataDevolucaoReal) 
VALUES ('588.3.342 S4343', '3', '30/01/2019', '28/02/2019', '25/02/2019');

CREATE TABLE editoras (
    idEditora INT,
    nome VARCHAR2(40) NOT NULL,
    localUF VARCHAR2(40) NOT NULL
);

CREATE SEQUENCE editora_seq;

INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Acadêmia','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Alta Books','Rio de Janeiro, RJ');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Ática','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Atlas','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Atual','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Axcel Books','Rio de Janeiro, RJ');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Berkeley','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Bookman','Porto Alegre, RS');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Brasiliense','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Brasport','Rio de Janeiro, RJ');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Campus','Rio de Janeiro, RJ');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Ciencia Moderna','Rio de Janeiro, RJ');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Companhia das Letras','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Cortez Editora','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Cultrix','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Edgar Blucher','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Edições Paulinas','São Paulo, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Editora da FGV','Rio de Janeiro, RJ');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Editora da Unicamp','Campinas, SP');
INSERT INTO editoras ( idEditora, nome, localUF )
VALUES (editora_seq.NEXTVAL,'Editora do SEBRAE','Brasília, DF');

ALTER TABLE editoras ADD CONSTRAINT pk_editoras PRIMARY KEY (idEditora);
ALTER TABLE livros DROP COLUMN editora;
ALTER TABLE livros ADD idEditora INT;

UPDATE livros
SET idEditora = 1;

ALTER TABLE livros ADD CONSTRAINT fk_editoras_livros FOREIGN KEY (idEditora) REFERENCES editoras (idEditora);


SELECT * FROM LIVROS WHERE idAssunto IN (SELECT idAssunto FROM ASSUNTOS WHERE nome = 'BANCO DE DADOS')
UNION
SELECT * FROM LIVROS WHERE idEditora IN (SELECT IDEDITORA FROM EDITORAS WHERE NOME LIKE '%a%');
SELECT * FROM LIVROS
MINUS 
SELECT * FROM LIVROS WHERE idLivro IN (SELECT idlivro FROM EMPRESTIMOS)