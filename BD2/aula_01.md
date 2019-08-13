
## 3
``` SQL
INSERT INTO Assunto (CodAssunto) VALUES (1);
INSERT INTO Assunto (CodAssunto) VALUES (2);


INSERT INTO Livro (CodigoLivro,CodAssunto) VALUES(1,1);
INSERT INTO Livro (CodigoLivro,CodAssunto) VALUES(2,2);

INSERT INTO Autor (CodAutor) VALUES (1);
INSERT INTO Autor (CodAutor) VALUES (2);

INSERT INTO AutorLivro (CodigoLivro,CodAutor) VALUES (1,1);
INSERT INTO AutorLivro (CodigoLivro,CodAutor) VALUES (2,2);
```

## 4
``` SQL
ALTER TABLE Autor ADD Nacionalidade varchar2;
```

## 5
``` SQL
ALTER TABLE Livro MODIFY Titulo varchar2(40);
```

## 6
``` SQL
ALTER TABLE Assunto ADD CONSTRAINT CK_SN CHECK (descontopromocao IN ("S","N"));
```

## 7
``` SQL
UPDATE Livro SET (Titulo = "Editora LTC") WHERE CodigoLivro = 3;
```

## 8
``` SQL
DELETE FROM Livro WHERE CodAssunto = 10 AND  DataEdicao <= '01/01/1980';
```

## 9
``` SQL
SELECT (Titulo) FROM Livro WHERE Titulo LIKE "%Banco de dados%";
```

## 10
``` SQL
SELECT (NomeAutor,datanascimento) FROM Autor WHERE datanascimento < '01/01/1970' AND datanascimento > '01/01/1950' ORDER BY nome ASC, datanascimento ASC;
```

## 11
``` SQL
SELECT codigoassunto, COUNT(codigoassunto) FROM Livros;
```

## 12
``` SQL
SELECT L.titulo, A.descricao FROM Livros L, Assuntos A WHERE L.codigoassunto = A.codigoassunto;
```

### 13
``` SQL
SELECT L.codigolivro, L.titulo, Aut.codigoautor, Aut.Nomeautor FROM Livros L, Autor Aut WHERE L.codigoautor = Aut.codigoautor;
```

### 14
``` SQL
SELECT L.codigoassunto FROM Livros L WHERE COUNT(L.codigoautor) > 3 GROUP BY L.codigoautor;
```