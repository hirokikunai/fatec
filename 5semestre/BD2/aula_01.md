# AULA 01 - REVISÃO

## CREATE BASE TABLE
``` SQL
CREATE TABLE livro 
  ( 
    codigolivro      NUMBER(5) PRIMARY KEY, 
    titulo           VARCHAR2(30), 
    editora          VARCHAR2(20), 
    cidade           VARCHAR2(30), 
    dataedicao       DATE, 
    versao           NUMBER(3), 
    codigoassunto    NUMBER(5), 
    preco            NUMBER(5, 2), 
     datacadastro    DATE, 
     lancamento      CHAR(1) 
  ); 

CREATE TABLE assunto 
  ( 
     codigoassunto       NUMBER(5) PRIMARY KEY, 
     descricao           VARCHAR2(40), 
     descontopromocao    CHAR(1) 
  ); 

CREATE TABLE autorlivro 
  ( 
     codigolivro    NUMBER(5) NOT NULL, 
     codigoautor    NUMBER(5) NOT NULL 
  );

CREATE TABLE autor 
  (
    codigoautor     NUMBER(5) PRIMARY KEY, 
    nomeautor       VARCHAR2(20),
    datanascimento  DATE,
    cidadenasc      VARCHAR2(20), 
    sexo            CHAR(1)
  ); 

```




### 2
Analise o modelo e escreva um comando para adicionar a chave primária e as estrangeiras na tabela AutorLivro, e a estrangeira na tabela de livro considerando que a tabela já está com sua estrutura criada.

``` SQL
  ALTER TABLE livro ADD PRIMARY KEY (codigolivro);
  ALTER TABLE autorlivro ADD CONSTRAINT FK_AUTOR FOREIGN KEY codigoautor REFERENCES autor(codigoautor);
  ALTER TABLE autorlivro ADD CONSTRAINT FK_LIVRO FOREIGN KEY codigolivro REFERENCES livro(codigolivro);
  ALTER TABLE livro ADD CONSTRAINT FK_ASSUNTO FOREIGN KEY codigoassunto REFERENCES assunto(codigoassunto);
```

### 3
Escreva os comandos necessários para incluir 2 linhas em cada tabela listada acima. A inclusão  dos registros de dados devem obedecer a uma ordem? Porque?

``` SQL
INSERT INTO Assunto (codigoassunto) VALUES (1);
INSERT INTO Assunto (codigoassunto) VALUES (2);


INSERT INTO Livro (CodigoLivro,codigoassunto) VALUES(1,1);
INSERT INTO Livro (CodigoLivro,codigoassunto) VALUES(2,2);

INSERT INTO Autor (codigoautor) VALUES (1);
INSERT INTO Autor (codigoautor) VALUES (2);

INSERT INTO AutorLivro (CodigoLivro,codigoautor) VALUES (1,1);
INSERT INTO AutorLivro (CodigoLivro,codigoautor) VALUES (2,2);
```

### 4
Adicionar uma nova coluna de nome Nacionalidade na tabela Autor.  

``` SQL
ALTER TABLE Autor ADD Nacionalidade varchar2;
```

### 5
Alterar a coluna Titulo da tabela Livros de 30 para 40 posições.

``` SQL
ALTER TABLE Livro MODIFY Titulo varchar2(40);
```

### 6
Incluir uma restrição de domínio para a coluna descontopromocao da tabela assunto de forma a aceitar apenas ‘S’ ou  ‘N’

``` SQL
UPDATE assunto SET descontopromocao CHAR(1);
UPDATE assunto SET descontopromocao = NULL;
ALTER TABLE Assunto ADD CONSTRAINT CK_SN CHECK (descontopromocao IN ("S","N"));
```

### 7
Alterar  o campo editora da tabela livros mudando para ‘Editora LTC’  para o livro de código 3.

``` SQL
UPDATE Livro SET (Titulo = "Editora LTC") WHERE CodigoLivro = 3;
```

### 8
Excluir os livros com codigoassunto igual a 10 e anoedição menor que 1980;

``` SQL
DELETE FROM Livro WHERE codigoassunto = 10 AND  TO_CHAR(DataEdicao,'YYYY') <= '1980';
```

### 9
Listar o título dos livros que possuam a palavra “Banco de Dados’ em qualquer posição do Título. 

``` SQL
SELECT (Titulo) FROM Livro WHERE UPPER(Titulo) LIKE "%Banco de dados%";
```

### 10
Listar o nome dos autores que nasceram entre 1950 e 1970 ordenado pelo nome e depois pela data de nascimento.

``` SQL
SELECT (NomeAutor,datanascimento) FROM Autor WHERE TO_CHAR(datanascimento,'YYYY') <= '1970' AND TO_CHAR(datanascimento,'YYYY') > '1950' ORDER BY nome ASC, datanascimento ASC;
```

### 11
Listar a quantidade de livros existentes por assunto. Exibir o código do assunto e a qtde de livros.

``` SQL
SELECT codigoassunto, COUNT(*) FROM Livros GROUP BY codigoassunto;
```

### 12
Listar  o título do livro e a descrição do assunto a qual ele pertence.

``` SQL
SELECT L.titulo, A.descricao FROM Livros L, Assuntos A WHERE L.codigoassunto = A.codigoassunto;

SELECT L.titulo, A.descricao FROM Livros L INNER JOIN Assunto A ON L.codigoassunto = A.codigoassunto;
```

### 13
Listar o código do livro, titulo, código e nome dos autores de cada livro

``` SQL
SELECT L.codigolivro, L.titulo, Aut.codigoautor, Aut.Nomeautor FROM Livros L, Autor Aut WHERE L.codigoautor = Aut.codigoautor;
```

### 14
Listar o código dos autores que tem mais de 3 livros publicados.

``` SQL
SELECT L.codigoassunto FROM Livros L HAVING COUNT(L.codigoautor) > 3 GROUP BY L.codigoautor;
```