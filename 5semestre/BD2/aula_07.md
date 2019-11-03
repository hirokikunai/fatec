# Aula 07/10/2019

### 1. 

#### a) Criar o campo pco_unit number(6,2) na tabela de item pedido.

```SQL
ALTER TABLE tb_item_pedido ADD  pco_unit NUMBER(6,2)
```

#### b) Escreva uma stored procedure para inserir um item de pedido. Esta deve receber como parametro o num. do pedido, codproduto, e a quantidade. O preço unitario deve ser obtido atraves da tabela produto.

```SQL
    CREATE OR REPLACE PROCEDURE INSERE_ITEM (Pnumpedido number, Pcodproduto number, Pqtde number)
    AS
    p_unit NUMBER(5, 2);

    BEGIN
        SELECT valor_unit into p_unit
        FROM TB_produto p
        WHERE p.codproduto = Pcodproduto;
        
        IF p_unit IS NOT NULL THEN
            INSERT INTO TB_item_pedido VALUES (Pnumpedido, Pcodproduto, Pqtde, p_unit);
        END IF;
        COMMIT;
        
        Exception
            when no_data_found then
            INSERT INTO tab_erro VALUES (sysdate, 'produto não encontrado: ' || Pcodproduto); 
    END;

    EXEC INSERE_ITEM (10, 20, 5);
    SELECT * FROM tb_item_pedido;
```
