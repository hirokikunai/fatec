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
        salario NUMBER(5, 2),
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
    INSERT ALL 
    INTO TB_Depto (codDepto, nomeDepto) VALUES (1, 'Setor de Desenvolvimento')
    INTO TB_Depto (codDepto, nomeDepto) VALUES (2, 'Setor de Logística')
    INTO TB_Depto (codDepto, nomeDepto) VALUES (3, 'Setor de Administração')
    SELECT * FROM TB_Depto

    INSERT ALL
    INTO TB_Funcionario (codFunc, nomeFunc, sexo, dataAdmissao, salario, codDepto)
    VALUES (1, 'Angelino', 'M', '27/04/1997', 2000, 1)
    INTO TB_Funcionario (codFunc, nomeFunc, sexo, dataAdmissao, salario, codDepto)
    VALUES (2, 'Felipe', 'M', '06/05/1990', 5000, 1)
    INTO TB_Funcionario (codFunc, nomeFunc, sexo, dataAdmissao, salario, codDepto)
    VALUES (3, 'Marcus', 'M', '07/05/2000', 500, 2)
    SELECT * FROM TB_Funcionario

    INSERT ALL
    INTO TB_Projeto (codProjeto, descricao)
    VALUES (1, 'Projeto em Java - fuuuuuu')
    INTO TB_Projeto (codProjeto, descricao)
    VALUES (2, 'Projeto em Delphi')
    INTO TB_Projeto (codProjeto, descricao)
    VALUES (3, 'Projeto em JavaScript')
    SELECT * FROM TB_Projeto

    INSERT ALL
    INTO TB_FuncProj (codFunc, codProjeto, tempoAlocacao, bonus_sal)
    VALUES (1, 3, '10/05/2015', 100) 
    INTO TB_FuncProj (codFunc, codProjeto, tempoAlocacao, bonus_sal)
    VALUES (2, 2, '10/05/2016', 10)
    INTO TB_FuncProj (codFunc, codProjeto, tempoAlocacao, bonus_sal)
    VALUES (3, 1, '10/05/2010', 1000) 
    SELECT * FROM TB_FuncProj
```


### 2.A - Junção
```SQL
    SELECT f.nomeFunc, f.dataAdmissao, f.codDepto, d.nomeDepto
    FROM TB_Funcionarios f
    INNER JOIN TB_Depto d
    ON f.codDepto = d.codDepto
    AND f.dataAdmissao > TO_CHAR(f.dataAdmissao, 'YYYY')
    // Parei aqui
```

### Anotações em Geral

* Para modificar alguma propriedade de coluna:
``` SQL
    ALTER TABLE nome_tabela
    MODIFY nome_coluna novo_tipo_coluna;   
```