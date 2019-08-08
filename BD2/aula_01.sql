INSERT INTO Assunto (CodAssunto) VALUES (1);
INSERT INTO Assunto (CodAssunto) VALUES (2);

INSERT INTO Livro (CodigoLivro,CodAssunto) VALUES(1,1);
INSERT INTO Livro (CodigoLivro,CodAssunto) VALUES(2,2);

INSERT INTO Autor (CodAutor) VALUES (1);
INSERT INTO Autor (CodAutor) VALUES (2);

INSERT INTO AutorLivro (CodigoLivro,CodAutor) VALUES (1,1);
INSERT INTO AutorLivro (CodigoLivro,CodAutor) VALUES (2,2);

ALTER TABLE Autor ADD Nacionalidade varchar2;
ALTER TABLE Livro MODIFY Titulo varchar2(40);

ALTER TABLE Assunto ADD CONSTRAINT CK_SN CHECK (descontopromocao IN ("S","N"));

UPDATE Livro SET (Titulo = "Editora LTC") WHERE CodigoLivro = 3;

DELETE FROM Livro WHERE CodAssunto = 10 AND  DataEdicao <= '01/01/1980';

SELECT (Titulo) FROM Livro WHERE Titulo LIKE "%Banco de dados%";

SELECT (NomeAutor,datanascimento) FROM Autor WHERE datanascimento < '01/01/1970' AND datanascimento > '01/01/1950' ORDER BY nome ASC, datanascimento ASC;

SELECT codigoassunto, COUNT(codigoassunto) FROM Livros


