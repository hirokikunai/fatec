SELECT f.codcliente, f.nrfatura, f.datafatura, p.descricao, i.qtde, i.valor 
FROM fatura f, itens_fatura i, produto p 
WHERE f.nrfatura = i.nrfatura and i.codproduto = p.codproduto
ORDER BY f.codcliente, f.nrfatura;


// 5
SELECT c.codcliente, c.saldo, sum(i.qtde * i.valor) TOTAL
FROM cliente c, fatura f, itens_fatura i
WHERE c.codcliente = f.codcliente AND f.nrfatura = i.nrfatura
GROUP BY c.codcliente, c.saldo;

// 6
SELECT c.codcliente, c.saldo, sum(i.qtde * i.valor) totalValor, sum(i.qtde) Quantidade
FROM cliente c, fatura f, itens_fatura i
WHERE c.codcliente = f.codcliente AND f.nrfatura = i.nrfatura
GROUP BY c.codcliente, c.saldo

//7
SELECT c.codcliente, c.saldo, sum(i.qtde * i.valor) totalValor, sum(i.qtde) Quantidade, ROUND(sum(i.qtde * i.valor) / sum(i.qtde),2) media
FROM cliente c, fatura f, itens_fatura i
WHERE c.codcliente = f.codcliente AND f.nrfatura = i.nrfatura
GROUP BY c.codcliente, c.saldo

// 8

SELECT f.nrfatura, sum(i.valor*i.qtde) TOTAL
FROM fatura f, itens_fatura i
WHERE f.nrfatura = i.nrfatura
GROUP BY f.nrfatura;

SELECT c.codcliente, f.nrfatura, c.saldo
FROM cliente c, itens_fatura i, fatura f
WHERE c.codcliente = f.codcliente AND f.nrfatura = i.nrfatura;

