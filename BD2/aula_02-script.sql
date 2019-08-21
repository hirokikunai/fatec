


Vis�es em SQL
=============

Uma vis�o � uma tabela l�gica. Ela n�o existe fisicamente.

select text from user_views;
select view_name from user_views;
select * from user_views

1- Vis�o 1
===========
create or replace view pacsor
as select * from paciente 
where cidpaciente = 'Sorocaba'
with check option;

select * from pacsor;

insert into pacsor
values (77,'Roberto souza',sysdate,'M','rua','Sorocaba','S');

insert into pacsor values (61,'Maria',sysdate,'F','rua x','itu','S');

update pacsor
 set nompaciente = 'Carlos Souza'
where codpaciente = 77;

select * from paciente

update pacsor
set nompaciente = 'DDDD'
where codpaciente = 61;

delete pacsor
where codpaciente = 77;

update pacsor
 set cidpaciente = 'KKKKK'
where codpaciente = 7;


2 Vis�o 2
===========

create or replace view pacsor_res
as select codpaciente,nompaciente,datanasc as data_nascimento, sexo
from pacsor;


insert into pacsor_res values (49,'Ana',sysdate,'F');

update pacsor_res
 set nompaciente = 'KKKKK'
where codpaciente = 7;

update pacsor_res
 set cidpaciente = 'KKKKK'
where codpaciente = 7;

delete pacsor_res
where 

3 vis�o 3   => n�o � atualiz�vel pq tem jun��o
==========

create view consulta_pac
as select p.codpaciente, p.nompaciente, c.codconsulta
from paciente p, consulta c
where c.codpaciente = p.codpaciente;

4 vis�o 4   => n�o � atualiz�vel porque tem campos calculados ou derivados
==========

create or replace view salario_liq
as select codmedico, (valconsulta * 0.75) as valorliq
from consulta;

select valorliq from salario_liq

select codmedico, (valconsulta * 0.75) 
from consulta;


5 vis�o 5          =>  n�o � atualiz�vel
============

create view totalmed
as select codmedico, count(*) as total
from consulta
group by codmedico;


select * from totalmed;

update pacsor_res
set data_nascimento = sysdate
where codpaciente = 5;

create view salario_liq
as select codmedico, (valconsulta * 0.75) as totliq
from consulta;


create view V_paciente
as select codpaciente, nompaciente from paciente;





uma vis�o � atualiz�vel ( permite insert, update e delete) se:

n�o tiver jun��o
n�o tiver group by, having, fun��es (sum, count, max, etc..)
n�o tiver campos calculados



exercicios:

1-Crie uma vis�o que possua: nome do medico,c�digo da consulta, dataconsulta.

create or replace view exercicio_01
as select C.codmedico, M.nommedico, C.codconsulta, C.dataconsulta
from consulta C, medico M
WHERE C.codmedico = m.codmedico;



2- Crie uma vis�o que exiba o c�digo do medico e o valor total de suas consultas

CREATE OR REPLACE view exercicio_02
AS SELECT C.codmedico, SUM(C.valconsulta) AS total_consulta FROM consulta C GROUP BY C.CODMEDICO;


3- Lista o nome de todas as vis�es que tem a string �SOR� no nome.

CREATE OR REPLACE view exercicio_03
AS SELECT VIEW_NAME FROM user_views WHERE VIEW_NAME LIKE '%SOR%';





