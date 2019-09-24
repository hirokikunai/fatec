# Aula 23/09

``` SQL
Create table Tablog
(datalog date,
 campo1 varchar2(40),
 campo2 varchar2(40));
```

### 1 - Criar o campo pco_unit number(6,2) na tabela de item pedido.
 - Escreva uma stored procedure para inserir um item de pedido. 
 - Esta deve receber como parametro o num. do pedido, codproduto, qtd.
 - O preço unitário deve ser obtido atraves da tabela produto.

### 2 - Escreva uma Stored Procedure que receba como parametro o codigo do cliente. 
Se este possuir mais que 3 pedidos com prazo de entrega dentro dos próximos 3 meses
Gravar na tabela TABLOG a data do sistema e a mensagem 'Cliente especial - enviar brinde' concatenado com o nome e código do cliente. Fazer o tratamento de exceções. da seguinte forma:
 - testar se o cliente existe. Caso não exista desviar para exception e cancelar a execução do programa desfazendo as operações já efetuadas.
          


### 3-Crie uma stored procedure que calcule o percentual de comissão para um vendedor cujo código é passado como parametro.

 a. encontre a somatória de totais de todos os pedidos por vendedor
 b. se a somatoria for > 0 e < 100.00 atribua a este vendedor um  percentual    de comissão de 10%
 c. se a somatoria estiver entre >=100.00 e <=1.000,00 atribua um percentual de 15%
 d. se a somatória for > 1.000,00 atribua um percentual de 20%.
 e. se ele não tiver nenhum pedido  (=0) atribua um percentual de 0%.

 - Fazer o tratamento de erros.

### 4 - Crie um procedimento que receba como parâmetro um código de produto e verifique se existem pedidos para ele.

 - Se não existir, excluir o produto da tabela de produto. 
 - Antes da exclusão, gravar tabela tabLOG com as
 * informações: data da exclusão, código do produto, descrição do produto, id do usuário que excluiu.

Utilizar exceptions para controlar erros associados ao select. 
Em caso de exception gravar na tabela TAb_erro
o código do produto e a mensagem de erro 'Código do produto inexistente'.