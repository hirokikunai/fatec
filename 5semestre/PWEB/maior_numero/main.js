window.addEventListener('load', function () {
  this.setTimeout(1000);
  window.alert(
    maiorNumero(
      this.prompt("Insira o 1º numero"),
      this.prompt("Insira o 2º numero"),
      this.prompt("Insira o 3º numero")
    )
  )
}, false);

function maiorNumero(a, b, c) {
  var std = "";
  var maior = Math.max(a, b, c);

  if (a == b == c) {
    std = `Todos os numeros são iguais`;
  } else if (a == b) {
    std = `o numero ${a} e ${b} sao iguais`;
  } else if (b == c) {
    std = `o numero ${b} e ${c} sao iguais`;
  } else if (a == c) {
    std = `o numero ${a} e ${c} sao iguais`;
  };
  return ((std != "" ? std + " e " : "") + `o maior numero é ${maior}`);
}