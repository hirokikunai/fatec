# Aula 16/09


## 1 - Criar as Tabelas
```SQL
    CREATE TABLE tb_cliente
    ( codcliente number(5) not null,
    nomecliente varchar2(30) not null,
    endereco varchar2(30),
    cidade varchar2(20),
    cep varchar2(10),
    uf char(2));


    CREATE TABLE tb_vendedor
    ( codvendedor number(5) not null,
    nomevendedor varchar2(30) not null,
    faixa_com    number(4,2),
    salario_fixo number(7,2));


    CREATE TABLE tb_produto
    ( codproduto   number(5) not null,
    descricao varchar(20),
    unid       char(2),
    valor_unit number(6,2));

    CREATE TABLE TB_PEDIDO

    ( NUMPEDIDO     number(5) NOT NULL,
    PRAZO_ENTREGA DATE,
    CODCLIENTE     number(5),
    CODVENDEDOR   number(5));

    CREATE TABLE TB_ITEM_PEDIDO
    (NUMPEDIDO   number(5) NOT NULL,
    CODPRODUTO  number(5) NOT NULL,
    QTDE        number(5));
 ```

## 2 - Inserir chaves
```SQL
    ALTER TABLE TB_PRODUTO 
    ADD CONSTRAINT PK_PRODUTO_CODPRODUTO PRIMARY KEY(CODPRODUTO);
    
    ALTER TABLE TB_VENDEDOR 
    ADD CONSTRAINT PK_VENDEDOR_CODVENDEDOR PRIMARY KEY(CODVENDEDOR);

    ALTER TABLE TB_PEDIDO 
    ADD CONSTRAINT PK_PEDIDO_NUMPEDIDO PRIMARY KEY(NUMPEDIDO);

    ALTER TABLE TB_ITEM_PEDIDO ADD CONSTRAint  PK_ITEMPEDIDO_PEDPROD 
    PRIMARY KEY(NUMPEDIDO,CODPRODUTO);
    
    ALTER TABLE TB_PEDIDO 
    ADD CONSTRAINT FK_PEDIDO_CODCLI FOREIGN KEY(CODCLIENTE) REFERENCES TB_CLIENTE;

    ALTER TABLE TB_PEDIDO 
    ADD CONSTRAINT FK_PEDIDO_CODVENDEDOR FOREIGN KEY(CODVENDEDOR) REFERENCES TB_VENDEDOR;

    ALTER TABLE TB_ITEM_PEDIDO 
    ADD CONSTRAINT FK_ITEMPEDIDO_NUMPEDIDO FOREIGN KEY(NUMPEDIDO) REFERENCES TB_PEDIDO;

    ALTER TABLE TB_ITEM_PEDIDO 
    ADD CONSTRAINT FK_ITEMPEDIDO_CODPRODUTO FOREIGN KEY(CODPRODUTO) REFERENCES TB_PRODUTO;
```

## 3 - Inserir dados
```SQL
    insert into TB_vendedor values (5,'Antonio Pedro',5.0,400);
    insert into TB_vendedor values (15,'Carlos Sola',0.0,400);
    insert into tb_vendedor values (25,'Ana Carolina',1.0,200);
    insert into TB_vendedor values (35,'Solange Almeida',1.0,300);

    SELECT * FROM TB_VENDEDOR

    INSERT INTO TB_CLIENTE 
    VALUES ( 30, 'João da Silva', 'AV. MATT HOFFMANN, 1100', 'SÃO PAULO', '97056-001', 'SP');

    INSERT INTO TB_CLIENTE 
    VALUES ( 31, 'LUCAS ANTUNES', 'RUA TRODANI, 120', 'SOROCABA', '19658-023', 'SP');

    INSERT INTO TB_CLIENTE 
    VALUES ( 32, 'LAURA STRAUSS', 'RUA TULIPAS, 650', 'PRIMAVERA', '18556-025', 'SP');

    INSERT INTO TB_PRODUTO 
    VALUES ( 11, 'APPLE DISPLAY', 'UN', 975.99);

    INSERT INTO TB_PRODUTO VALUES ( 12, 'IBM THINK PAD R61', 'UN', 999.70);

    INSERT INTO TB_PRODUTO VALUES ( 13, 'PÓ PARA TONER', 'KG', 85.60);
    INSERT INTO TB_PEDIDO VALUES ( 7, '26/02/2019', 31, 15);
    INSERT INTO TB_PEDIDO VALUES ( 8, '23/05/2019', 32, 25);
    INSERT INTO TB_PEDIDO VALUES ( 9, '21/02/2019', 32, 5);
    INSERT INTO TB_PEDIDO VALUES ( 10, '20/02/2019', 30, 5);

    SELECT * FROM TB_PEDIDO;

    INSERT INTO TB_ITEM_PEDIDO VALUES (7, 11, 3);
    INSERT INTO TB_ITEM_PEDIDO VALUES (7, 12, 3);
    INSERT INTO TB_ITEM_PEDIDO VALUES (8, 13, 3);
    INSERT INTO TB_ITEM_PEDIDO VALUES (9, 11, 3);
    INSERT INTO TB_ITEM_PEDIDO VALUES (10, 11, 3);
    INSERT INTO TB_ITEM_PEDIDO VALUES (10, 12, 3);
    INSERT INTO TB_ITEM_PEDIDO VALUES (10, 13, 3);
```

## 4 - Querys da aula
```SQL
    INSERT INTO TB_PRODUTO VALUES (20,'NOTEBOOK VAIO', 1, 1000);

    UPDATE TB_PRODUTO
    SET valor_unit = valor_unit * 0.8
    WHERE codproduto NOT IN ( SELECT codproduto FROM tb_item_pedido );

    UPDATE TB_PRODUTO
    SET valor_unit = valor_unit * 0.8
    WHERE NOT EXISTS ( SELECT 1 FROM tb_item_pedido 
                    WHERE tb_item_pedido.codproduto = tb_produto.codproduto)
```