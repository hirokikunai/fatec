


Visões em SQL
=============

Uma visão é uma tabela lógica. Ela não existe fisicamente.

select text from user_views;
select view_name from user_views;
select * from user_views

1- Visão 1
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


2 Visão 2
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

3 visão 3   => não é atualizável pq tem junção
==========

create view consulta_pac
as select p.codpaciente, p.nompaciente, c.codconsulta
from paciente p, consulta c
where c.codpaciente = p.codpaciente;

4 visão 4   => não é atualizável porque tem campos calculados ou derivados
==========

create or replace view salario_liq
as select codmedico, (valconsulta * 0.75) as valorliq
from consulta;

select valorliq from salario_liq

select codmedico, (valconsulta * 0.75) 
from consulta;


5 visão 5          =>  não é atualizável
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





uma visão é atualizável ( permite insert, update e delete) se:

não tiver junção
não tiver group by, having, funções (sum, count, max, etc..)
não tiver campos calculados



exercicios:

1-Crie uma visão que possua: nome do medico,código da consulta, dataconsulta.

create or replace view exercicio_01
as select C.codmedico, M.nommedico, C.codconsulta, C.dataconsulta
from consulta C, medico M
WHERE C.codmedico = m.codmedico;



2- Crie uma visão que exiba o código do medico e o valor total de suas consultas

CREATE OR REPLACE view exercicio_02
AS SELECT C.codmedico, SUM(C.valconsulta) AS total_consulta FROM consulta C GROUP BY C.CODMEDICO;


3- Lista o nome de todas as visões que tem a string “SOR’ no nome.

CREATE OR REPLACE view exercicio_03
AS SELECT VIEW_NAME FROM user_views WHERE VIEW_NAME LIKE '%SOR%';





