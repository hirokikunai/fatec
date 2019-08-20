## Exercicios

### 1 - Crie uma visão que possua: nome do medico,código da consulta, dataconsulta.
``` SQL
create or replace view exercicio_01
as select C.codmedico, M.nommedico, C.codconsulta, C.dataconsulta
from consulta C, medico M
WHERE C.codmedico = m.codmedico;
```

### 2 - Crie uma visão que exiba o código do medico e o valor total de suas consultas
``` SQL
CREATE OR REPLACE view exercicio_02
AS SELECT C.codmedico, SUM(C.valconsulta) AS total_consulta FROM consulta C GROUP BY C.CODMEDICO;
```

### 3 - Lista o nome de todas as visóes que tem a string SOR no nome.
``` SQL 
CREATE OR REPLACE view exercicio_02
AS SELECT VIEW_NAME FROM user_views WHERE VIEW_NAME LIKE '%SOR%'
```




