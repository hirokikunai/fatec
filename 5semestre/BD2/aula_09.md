# Aula 11/11/2019

Aula  - Triggers

/* Triggers - Gatilho

TRIGGER
-------

Um gatilho de banco de dados(trigger) é um procedimento pl/sql que você associa a uma tabela.
Quando uma instrução sql é executada sobre uma tabela e atende a uma condição de gatilho, o SGBD aciona automaticamente 
o corpo do gatilho (que é um programa pl/sql).

Os gatilhos são usados para impor regras de integridade aos dados e impor complexas condições de segurança.

Como deve ser utilizado:

a) Qdo uma operacao for executada, ações relacionadas também devem ser executadas.
b) Nao há necessidade de utiliza-lo para operações específicas do ORACLE, como para garantir integridade referencial - 
so tomaria tempo do ORACLE sem agregar vantagem.
c) Triggers com mais de 60 linhas devem ser transformados em procedimentos que depois serão chamados por ele.
d) Nao crie triggers recursivos.
e) Seja cuidadoso: Um trigger será executado toda vez que 1 evento ocorrer, portanto, dependendo do caso, pode tornar lento e trabalhoso em situações de muito movimento.

--------------------------------------------------------------------------------------------

Tipos de Trigger
----------------

DML - Eventos de Insert, Update ou Delete em tabelas.
DDL - Eventos Create Table, Alter e Drop Table.

--------------------------------------------------------------------------------------------



Triggers DML
------------

 - Nao usar COMMIT ou ROLLBACK nem alterar chaves primarias únicas ou estrangeiras.

EVENTO (condições) : INSERT, UPDATE, DELETE
TEMPO : BEFORE (antes)
        AFTER  (depois)
nivel  : FOR EACH ROW (a cada linha)
        linha=disparado uma vez para cada linha processada.
        instrução = disparado uma vez só, antes ou depois da instrução.


Restrições: não pode ter commit ou rollback ou savepoints.

Define-se um Gatilho atravé do comando => create trigger

Qdo mais de 1 evento pode-se usar INSERTING, UPDATING, DELETING

--------------------------------------------------------------------------------------------

Exemplo 1: Este gatilho grava um registro na tabela logteste, 
toda vez que um registro foi excluido da tabela produto*/

```SQL
CREATE TABLE logteste
(nrlog NUMBER PRIMARY KEY, 
 Dttrans DATE NOT NULL, 
 Usuario VARCHAR2(15) NOT NULL, 
 Tabela VARCHAR2(30),
 Opera CHAR(1) CHECK (opera IN('I','A','E')),
 Linhas NUMBER(5) NOT NULL CHECK(linhas >=0));

/* Criação de auto incremento para o Oracle, não é necessário no SQL ou MYSQL */
CREATE SEQUENCE seqlog;

SELECT seqlog.currval FROM dual;

INSERT INTO TB_produto VALUES (6,'Caneta','UN', 5.00);

/* Trigger para gravar na tabela de log toda vez que um produto for excluido */
CREATE OR REPLACE TRIGGER EliminaProduto
BEFORE DELETE ON tb_produto
FOR EACH ROW
BEGIN
  INSERT INTO logteste VALUES(seqlog.nextval,sysdate,user,'tb_produto '||:old.codproduto,'E',1);
END Eliminaproduto;


/* Para testar o trigger */
DELETE Tb_produto WHERE codproduto = 6;
SELECT * FROM LOGTESTE;


/*
Exemplo 2: Este gatilho não permite que os usuários atualizem ou eliminem registros
 de pacientes antes das 
7:00 da manhã e depois das 14:00
*/


CREATE OR REPLACE TRIGGER ChecaHora
BEFORE UPDATE OR  DELETE ON paciente
BEGIN
  IF to_number(to_char(SYSDATE,'HH24')) NOT BETWEEN 7 AND 14 THEN
    raise_application_error(-20400,'Alterações não permitidas');
  END IF;
END ChecaHora;
/

UPDATE paciente
SET nompaciente = 'Fernando Sampaio'
WHERE codpaciente = 3;


/* Exemplo 3 - igual ao exemplo 2 porém identificando se o usuário tentou fazer update ou delete. */

CREATE OR REPLACE Trigger ChecaHora2
BEFORE UPDATE OR  DELETE ON paciente
BEGIN
  IF to_char(SYSDATE,'HH24') NOT BETWEEN 11 AND 20 THEN
    IF updating THEN	
      raise_application_error(-20400,'Update não permitido');
    ELSIF deleting THEN
      raise_application_error(-20410,'Delete não permitido');
    END IF;
  END IF;
END ChecaHora2;
/

/* Desabilita ou habilita o trigger */
ALTER TRIGGER nome_da_trigger DISABLE; 
ALTER TRIGGER nome_da_trigger ENABLE;
```

==================================================================
USANDO :new e :old 


Exemplo 1
---------

```SQL
CREATE or replace TRIGGER Troca_data
BEFORE INSERT ON pedido
FOR EACH ROW
BEGIN
      :NEW.prazo_entrega := SYSDATE + 15;
END;
```

testar:
 
```SQL
 INSERT INTO tb_pedido VALUES (999,'30/10/2017',1,2);
```

------------------------------------------------------------------

Exemplo 2
---------			   Memoria
			      ------------------	
:NEW.______       	     |------------------|
			:New  9999 30/10/2010 |
			     |------------------|
			     |			|
			     |                  |	
			      ------------------	




===============================================================

Tabela de valores das variáveis de memória

:NEW				:OLD

INSERT    valores que estao sendo incluidos      Nao definido-null

UPDATE	  valores que modificados              valores originais 	                            		                 da tabela
	   
DELETE	  Nao Definido-null 	                Dados antes da 
						deleção	

--------------------------------------------------------------------------------------------

Exercicio
---------

1- alterar o trigger   elimina_produto para gravar o codigo do produto excluido.

---- inserindo um novo produto para teste

 insert into produto values (6,'Caneta','UN', 5.00,30);


Create or Replace trigger EliminaProduto
before delete on tb_produto
for each row
begin
  insert into logteste values
   (seqlog.nextval,sysdate,user,'produto '||:old.codprod,'E',1);
end Eliminaproduto;
/


delete tb_produto
where codprod =6;



Create or Replace trigger updatePedido
before update of prazo_entrega  on tb_pedido
for each row
begin
  insert into logteste values
   (seqlog.nextval,sysdate,user,'pedido '|| :old.prazo_entrega ||
    ' novo: '|| :new.prazo_entrega,'E',1);
end updatepedido;






create or replace trigger Tx
before  insert or delete or update of endereco on cliente
for each row
begin
   insert into logteste values (seglog.nextval,sysdate,null,null,null,null);
end;



Para já
=========

 insert into produto values (18,'Caneta','UN', 5.00,30);


1. Escreva um trigger que ao incluir um produto altere
 seu valor unitario multiplicando por 0.8







=====================================================

2. Escreva um trigger que ao alterar o prazo de entrega de um pedido, 
grave na tablog o prazo antigo, prazo novo e o nome do cliente.



create sequence seqtablog;


create table tablog
( numLog number primary key,
  datalog  date,
  usuario  varchar2(15),
  tabela   varchar2(15),
  oldcampo varchar2(30),
  newcampo varchar2(30),
  campo1   varchar2(30));


===================================================================================
outro exemplo: trigger para registrar quem entrou no sistema:

create table sys_vigia
(campo varchar2(200));


CREATE OR REPLACE TRIGGER marca_logon 
   AFTER LOGON ON DATABASE 
BEGIN 
  INSERT INTO sys_vigia 
    VALUES (USER || ' entrou no sistema em ' || 
            TO_CHAR(sysdate, 'DD-MM-YYYY HH24:MI:SS')); 
  COMMIT; 
END; 
/ 

SQL> CREATE OR REPLACE TRIGGER marca_logon 
  2     AFTER LOGON ON DATABASE 
  3  BEGIN 

  4    INSERT INTO sys_vigia 
  5      VALUES (USER || ' entrou no sistema em ' || 
  6              TO_CHAR(sysdate, 'DD-MM-YYYY HH24:MI:SS')); 
  7    COMMIT; 
  8  END; 
  9  / 

Gatilho criado.

SQL> select * from sys_vigia;

CAMPO
--------------------------------------------------------------------
ANGELICA entrou no sistema em 07-05-2009 12:11:17

esta trigger registra o nome do usuário e a que horas ele entrou. Esse exemplo foi retirado diretamente da documentação Oracle. No nosso exemplo fazemos referencia a um evento do sistema ao invés de referenciarmos uma tabela. Outros eventos do sistema são: 

- AFTER SERVERERROR 
- AFTER LOGON 
- BEFORE LOGOFF 
- AFTER STARTUP 
- BEFORE SHUTDOWN 


Triggers instead of
=======================



INSTEAD OF indica que a trigger irá ser executada no lugar da instrução que disparou a trigger. Literalmente, a instrução é substituída pela trigger. Essa técnica permite que façamos, por exemplo, alterações em uma tabela através de uma view. É usado nos casos em que a view não pode alterar uma tabela por não referenciar uma coluna com a constraint not null. Nesse caso a trigger pode atualizar a coluna que a view não tem acesso. 

Dois detalhes muito importantes sobre INSTEAD OF: 

- Só funcionam com views e 
- É sempre de linha. Será considerado assim, mesmo que "FOR EACH ROW" for omitido. 

Exemplo: 
Código: 

CREATE OR REPLACE TRIGGER novo_func 
   INSTEAD OF INSERT ON vemp 
FOR EACH ROW 
WHEN ... 
. 
. 
. 
END; 
/ 
 

O evento define qual é a instrução DML que aciona a trigger. Informa qual instrução SQL irá disparar a trigger. Pode ser: 

- INSERT 
- UPDATE 
- DELETE 



=======
# Aula 14/10/2019

### Dicas

1. O %type é utilizado para dizer que a variável declarada é do mesmo tipo que o campo atribuído. Exemplo:

```SQL
    v_preco produto.valor_unitario%type;
```
Neste caso, a variável v_preco recebe o mesmo tipo do campo valor_unitario.
