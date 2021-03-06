# Lista de Exercícios I - 02/09/2019

## 1 - Criar tabelas
``` SQL
    CREATE TABLE TB_Depto (
        codDepto NUMBER(3) PRIMARY KEY,
        nomeDepto VARCHAR2(50) NOT NULL
    )

    CREATE TABLE TB_Funcionario (
        codFunc NUMBER(3) PRIMARY KEY,
        nomeFunc VARCHAR2(50) NOT NULL,
        sexo VARCHAR2(1) NOT NULL,
        dataAdmissao DATE DEFAULT (sysdate),
        salario NUMBER(7, 2),
        codDepto NUMBER(3) NOT NULL
        CONSTRAINT fk_depto REFERENCES TB_Depto(codDepto)
    )

    CREATE TABLE TB_Projeto (
        codProjeto NUMBER(3) PRIMARY KEY,
        descricao VARCHAR2(100) NOT NULL
    )

    CREATE TABLE TB_FuncProj (
        codFunc NUMBER(3),
        codProjeto NUMBER(3),
        tempoAlocacao DATE DEFAULT (sysdate),
        bonus_sal NUMBER(7, 2) NOT NULL,
        CONSTRAINT pk_funcProjet PRIMARY KEY (codFunc, codProjeto)
    )

    ALTER TABLE TB_FuncProj 
    ADD CONSTRAINT fk_projeto 
    FOREIGN KEY (codProjeto)
    REFERENCES Tb_Projeto(codProjeto)

    ALTER TABLE TB_FuncProj 
    ADD CONSTRAINT fk_func 
    FOREIGN KEY (codFunc)
    REFERENCES Tb_Funcionario(codFunc)
```

### 1.1 - Inserir 3 Linhas em cada

``` SQL
    INSERT INTO TB_Depto VALUES (1, 'Setor de Desenvolvimento');
    INSERT INTO TB_Depto VALUES (2, 'Setor de Logística');
    INSERT INTO TB_Depto VALUES (3, 'Setor de Administração');

    INSERT INTO TB_Funcionario VALUES (1, 'Angelino', 'M', '27/04/1997', 2000, 1);
    INSERT INTO TB_Funcionario VALUES (2, 'Felipe', 'M', '06/05/1990', 5000, 1);
    INSERT INTO TB_Funcionario VALUES (3, 'Marcus', 'M', '07/05/2000', 500, 2);

    INSERT INTO TB_Projeto VALUES (1, 'Projeto em Java - fuuuuuu');
    INSERT INTO TB_Projeto VALUES (2, 'Projeto em Delphi');
    INSERT INTO TB_Projeto VALUES (3, 'Projeto em JavaScript');

    INSERT INTO TB_FuncProj VALUES (1, 3, '10/05/2015', 100); 
    INSERT INTO TB_FuncProj VALUES (2, 2, '10/05/2016', 10);
    INSERT INTO TB_FuncProj VALUES (3, 1, '10/05/2010', 1000);
```


### 2.A - Junção
```SQL
    SELECT f.nomeFunc, f.dataAdmissao, f.codDepto, d.nomeDepto
    FROM TB_Funcionario f
    INNER JOIN TB_Depto d
    ON f.codDepto = d.codDepto
    AND to_char(f.dataAdmissao, 'YYYY') > '1975';
```

### 2.B - Junção
#### Exibir o nome dos funcionários e a descrição de cada projeto os quais ele participa ordenado pela  descrição do projeto e pelo nome do funcionário
```SQL
    SELECT f.nomeFunc, p.descricao
    FROM TB_Funcionario f
    INNER JOIN TB_FuncProj fp
    ON fp.codFunc = f.codFunc
    INNER JOIN TB_Projeto p
    ON fp.codProjeto = p.codProjeto
    ORDER BY p.descricao, f.nomeFunc;Func;
```

### 3.A - Visões
#### Criar uma visão para listar o codigo do funcionário, codigo do projeto em que ele trabalha e o bonus-salário aumentado em 15%.

```SQL
    CREATE VIEW view_funcSalarioBonus 
    AS SELECT fp.codFunc, fp.codProjeto, fp.bonus_sal * 1.15 AS bonus_sal
    FROM TB_FuncProj fp
```

### 3.B - Visões
#### - Criar uma visão para listar o código do funcionário, nome do funcionário e a qtde de projetos que ele está alocado , mas só para os funcionários alocados em mais de 2 projetos

```SQL
    CREATE VIEW view_funcAlocacao 
    AS 
    SELECT f.codFunc, f.nomeFunc, COUNT(fp.codProjeto) AS numero_projetos
    FROM TB_Funcionario f
    INNER JOIN TB_FuncProj fp 
    ON f.codFunc = fp.codFunc
    GROUP BY f.codFunc, f.nomeFunc
    HAVING COUNT(fp.codProjeto) > 2
```

### 4.A - Subconsultas
#### - Listar o nome do funcionário que tem o salário menor que a média.

```SQL
    SELECT f.nomeFunc
    FROM TB_Funcionario f
    WHERE f.salario < (
        SELECT AVG(f2.salario) AS media_salario
        FROM TB_Funcionario f2
    )
```

### 4.B - Subconsultas
#### - Listar o nome dos funcionários que trabalham no mesmo projeto do funcionário de nome ‘José da Silva’ (inclua dados para fazer este teste).

```SQL
    SELECT f.nomeFunc
    FROM TB_Funcionario f
    INNER JOIN TB_FuncProj fp 
    ON f.codFunc = fp.codFunc
    WHERE fp.codProjeto IN (
        SELECT fp2.codProjeto
        FROM TB_Funcionario f2
        INNER JOIN TB_FuncProj fp2
        ON f2.codFunc = fp2.codFunc
        WHERE UPPER(f2.nomeFunc) <> 'Angelino'
    )
```

### 4.C - Subconsultas
#### - Listar o nome dos funcionários que não tem projetos alocados. Usando NOT IN

```SQL
    SELECT f.nome
    FROM TB_Funcionario f
    WHERE f.codFunc 
    NOT IN (
        SELECT fp.codFunc 
        FROM TB_FuncProj fp
    );

    SELECT * 
    FROM TB_Funcionario f
    WHERE NOT EXISTS ( 
        SELECT codFunc
        FROM TB_FuncProj fp
        WHERE fp.codFunc = f.codFunc
    );
```

### 4.D - Subconsultas
#### - Listar o codigo do projeto que tem o maior tempo de alocação dos funcionarios

```SQL
    SELECT 
        fp1.codProjeto, SUM(fp1.tempoAlocacao) AS tempo_alocacao_func
    FROM
        TB_FuncProj fp1
    GROUP BY 
        fp1.codProjeto
    ORDER BY 
        SUM(fp1.tempoAlocacao)
    LIMIT 1;
```

### 4.E - Subconsultas
#### - Alterar o salario dos funcionários somando 200,00 reais para os funcionarios que trabalham em mais de 2 projetos

```SQL
    UPDATE
        TB_Funcionario f
    SET 
        f.salario = f.salario + 200
    WHERE f.codFunc = (
        SELECT 
            fp.codFunc, 
        FROM
            TB_FuncProj fp
        HAVING
            COUNT(fp.codProjeto) > 2
        GROUP BY
            fp.codFunc
    );
```

### 5 - Considere a seguinte consulta em SQL
```SQL
    SELECT nomefunc FROM TB_Funcionario WHERE salario > 3000.00
    INTERSECT
    SELECT nomeFunc FROM Tb_Funcionario INNER JOIN TB_FunProj
    ON TB_Funcionario.codfunc = TB_prodjeto.codFunc
```

##### Resposta (B) - Nome dos funcionários que ganham mais de 3000,00 reais e trabalham em algum projeto

### 6 - Deseja-se dar um aumento de salario em 5% a todos os funcionários que trabalham em projetos com o tempo de alocação maior que 6 meses. O comando que deve ser executado para realizar o esperado é:

##### Resposta (A):
```SQL
    UPDATE tb_funcionario
    SET salario = salario *1.05
    WHERE codFunc IN (SELECT codfunc FROM Tb_funcproj WHERE tempoalocacao > 6)
```



### Anotações em Geral

* Para modificar alguma propriedade de coluna:
``` SQL
    ALTER TABLE nome_tabela
    MODIFY nome_coluna novo_tipo_coluna;   
```