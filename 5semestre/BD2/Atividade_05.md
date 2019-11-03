# Atividade 16/09


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

## 2.6 - Subconsultas
### 2.6.1 - Listar todos os clientes que moram na mesma cidade que 'João da Silva'.
```SQL
SELECT
  nomecliente 
FROM
  tb_cliente
WHERE 
  cidade = 
  (
    SELECT 
      cidade
    FROM
      tb_cliente
    WHERE 
      nomecliente = "João da Silva" 
    LIMIT 1
  )

```

### 2.6.2 -	Quais produtos tem valor unitário maior que a média.
```SQL
  SELECT descricao FROM tb_produto WHERE valor_unit > (SELECT AVG(valor_unit) AS media_valor FROM tb_produto)
```

### 2.6.3 -	Quais os clientes que só compraram com o vendedor com codigo 10 e com mais nenhum outro vendedor (fidelidade).
```SQL
  SELECT codcliente FROM tb_pedido WHERE NOT IN (
    SELECT codcliente FROM tb_pedido WHERE codvendedor != 10
  )
```

### 2.6.4 -	Quais vendedores não fizeram mais de 5 pedidos.
```SQL
  SELECT codvendedor FROM tb_vendedor 
  WHERE codvendedor = (
    SELECT codvendedor, COUNT(*) AS npedidos FROM tb_pedidos GROUP BY codvendedor 
  ) OR codvendedor NOT IN (
    SELECT codvendedor, COUNT(*) AS npedidos FROM tb_pedidos GROUP BY codvendedor 
  )
```

### 2.6.5 -	Quais os vendedores não fizeram nenhum pedido no mês de maio/2017
```SQL
  SELECT codvendedor FROM tb_vendedor 
  WHERE codvendedor NOT IN (
    SELECT codvendedor, COUNT(*) AS npedidos FROM tb_pedidos HAVING TO_DATE(PRAZO_ENTREGA,'MON/YYYY') = TO_DATE('MAR/2017','MON/YYYY'); GROUP BY codvendedor 
  )
```


