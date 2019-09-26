
var Retangulo = function(x,y) {
    var base = x;
    var altura = y;

    this.Area = function() {
        return base*altura;
    }
}

var ret = new Retangulo(10,20);
document.write(`Area do retangulo: ${ret.Area()} <br>`);

var Conta = function() {
    var nome_correntista, banco, numero_conta, saldo;

    this.getNomeCorrentista = function() {
        return nome_correntista;
    } 
    this.getBanco = function() {
        return banco;
    } 
    this.getNumeroConta = function() {
        return numero_conta;
    } 
    this.getSaldo = function() {
        return saldo;
    } 
    this.setNomeCorrentista = function(nome_correntista_) {
        nome_correntista = nome_correntista_;
    } 
    this.setBanco = function(banco_) {
        banco = banco_;
    } 
    this.setNumeroConta = function(numero_conta_) {
        numero_conta = numero_conta_;
    } 
    this.setSaldo = function(saldo_) {
        saldo = saldo_;
    } 
}

function ContaPoupanca() {
    var juros;
    this.getJuros = function() {
        return juros;
    }
    this.setJuros = function(juros_) {
        juros = juros_;
    }
}

function ContaCorrente() {
    var saldo_especial;
    this.getSaldoEspecial = function() {
        return saldo_especial;
    }
    this.setSaldoEspecial = function(saldo_especial_) {
        saldo_especial = saldo_especial_;
    }
}

ContaCorrente.prototype = new Conta();
ContaPoupanca.prototype = new Conta();

var cc = new ContaCorrente();
var cp = new ContaPoupanca();

cc.setNomeCorrentista("Joaquim");
cc.setBanco("8123-1");
cc.setNumeroConta("1111-1");
cc.setSaldo(1000.0);
cc.setSaldoEspecial(100.0);

cp.setNomeCorrentista("Fernanda");
cp.setBanco("6535-1");
cp.setNumeroConta("10002-5");
cp.setSaldo(3000.0);
cp.setJuros(0.0);

document.write(`<br>Conta Corrente<br><br>`);
document.write(`Nome Correntista: ${cc.getNomeCorrentista()} <br>`);
document.write(`Banco: ${cc.getBanco()} <br>`);
document.write(`Nº conta: ${cc.getNumeroConta()} <br>`);
document.write(`Saldo: ${cc.getSaldo()} <br>`);
document.write(`Saldo especial: ${cc.getSaldoEspecial()} <br>`);

document.write(`<br>Conta Poupança<br><br>`);
document.write(`Nome Correntista: ${cp.getNomeCorrentista()} <br>`);
document.write(`Banco: ${cp.getBanco()} <br>`);
document.write(`Nº conta: ${cp.getNumeroConta()} <br>`);
document.write(`Saldo: ${cp.getSaldo()} <br>`);
document.write(`Saldo especial: ${cp.getSaldoEspecial()} <br>`);

