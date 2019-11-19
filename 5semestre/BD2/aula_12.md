Aula 18/11

## 1.	Sobre o modelo do item-pedido, escreva um trigger que ao inserir um item do pedido verifique se o cliente já possui mais de 10 pedidos com entrega no mês atual. Se sim, aplicar um desconto de 15% ao preço do item que está sendo cadastrado.

create or replace TRIGGER INSERE_ITEM
BEFORE INSERT ON TB_ITEM_PEDIDO
FOR EACH ROW
    DECLARE
        VCODCLIENTE TB_PEDIDO.CODCLIENTE%TYPE;
        COUNTER INT;
    BEGIN
        SELECT CODCLIENTE INTO VCODCLIENTE FROM TB_PEDIDO
        WHERE TB_PEDIDO.NUMPEDIDO = :NEW.NUMPEDIDO;
        
        SELECT COUNT(*) INTO COUNTER FROM TB_PEDIDO WHERE TB_PEDIDO.CODCLIENTE = VCODCLIENTE GROUP BY CODCLIENTE;
            IF(COUNTER > 10) THEN
                UPDATE TB_ITEM_PEDIDO SET pco_unit = (:OLD.pco_unit * 0.85);
            END IF;
    END;
    
INSERT INTO TB_ITEM_PEDIDO VALUES(7,13,1,10);


## 2.	Crie um trigger que ao ser alterado o campo endereço da tabela de cliente, faça a inserção de uma linha na tabela de log com a mensagem: "Observar mudança de endereço" <codigo do cliente> <endereço velho><endereço novo>  Tablog (datalog,campo1,campo2)

``` SQL
CREATE OR REPLACE TRIGGER TR_UPDATE_ENDERECO
BEFORE UPDATE OF ENDERECO ON TB_CLIENTE
FOR EACH ROW
BEGIN
    INSERT INT TABLOG VALUES (SYSDATE, 'OBSERVAR MUDANCA DE ENDERECO',
    'END. VELHO = '||:OLD.ENDERECO ||' END. NOVO = '||:NEW.ENDERECO);
END;

```