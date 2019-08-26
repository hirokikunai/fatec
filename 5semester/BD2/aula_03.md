# Anotações em Geral
SQL Server:
* Servidor: apolo
* Usuário: aluno
* Senha: A12345678a

## MS SQL

### 1 - Criar a tabela
``` SQL 
    CREATE TABLE TB1723015 (
        c1 INT NOT NULL, 
        c2 char(200) NOT NULL default '#'
    )
```

### 2 - Inserir as linhas 
``` SQL
    BEGIN
        DECLARE @cnt INT = 0;

        WHILE @cnt < 10000
        BEGIN
            INSERT TB1723015(c1)
            SELECT 1000; 
            SET @cnt = @cnt + 1;
        END;
    END;
```

### 3 - Inserir uma linha
``` SQL
    INSERT TB1723015(c1) VALUES(2000)
```

### 4 - Criar um índice
``` SQL
    CREATE nonclustered index ix_TB1723015_C1 on TB1723015(c1)
```


### 5 - Consulta 1
``` SQL
    SELECT c1, c2 FROM TB1723015 WHERE c1=1000
```

### 6 - Consulta 2
``` SQL
    SELECT c1, c2 FROM TB1723015 WHERE c1=2000
    SELECT c1 FROM TB1723015 WHERE c1=1000

```

### 7 - Consulta 3
``` SQL
    SELECT c1, c2 FROM Tb1723015 WHERE c1=1500
```
