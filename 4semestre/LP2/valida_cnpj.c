#include <stdio.h>
#include <string.h>
#include <ctype.h>

int multiplica12Inicial(char numero[18], int gambiInicial);
int convertToInt (int numero);
int calculoPrimeiroDV(int numero);
int RestoDivisao11 (int numero);
int calculoSegundoDV(int numero, int valorDigito01);


void main(void){
	char resultado[8];
	char cnpj[18];
	int cnpj_esperado, digitoVerificador[2];


	printf("Digite um numero de CNPJ: ");
	scanf("%s", cnpj);

	digitoVerificador[0] = calculoPrimeiroDV(multiplica12Inicial(cnpj, 5));
	digitoVerificador[1] = calculoSegundoDV(multiplica12Inicial(cnpj, 6), digitoVerificador[0]);
	printf("O 1º dígito verificador é: %d\n", digitoVerificador[0]);
	printf("O 2º dígito verificador é: %d\n", digitoVerificador[1]);
	if (digitoVerificador[0] == convertToInt(cnpj[16]) && digitoVerificador[1] == convertToInt(cnpj[17]))
		printf("Seu CPNJ é válido");


	//printf("\n%s - esperado %i, encontrado %i", resultado, esperado, encontrado);
}

int convertToInt (int numero){

	int resultado;
	resultado = numero - 48;
	return resultado;
	//printf("%d\n", resultado);

}

int multiplica12Inicial(char numero[18], int gambiInicial){
	

	int gambi = gambiInicial, resultante=0;

	for (int i = 0; i < 15; ++i)
	{
		if(i != 2 && i != 6 && i != 10){
			resultante += gambi * convertToInt(numero[i]);
			gambi--;
			if (gambi == 1)
			gambi = 9;
			//printf("%d\n", resultante);
		}

	}
	return resultante;
}


int calculoPrimeiroDV(int numero){

	int resultante = 0, dv1;
	dv1 = (numero%11);
	resultante = 11-(dv1);
	if (dv1 == 0 || dv1 == 1){
		dv1 = 0;
	}
	return dv1;
}

int calculoSegundoDV(int numero, int valorDigito01){

	int resultante = 0, dv2 = 0;
	resultante = 2*valorDigito01 + numero;
	dv2 = 11 - (resultante%11);
	if (dv2 == 0 || dv2 == 1){
	dv2 = 0;
	}
	return dv2;
}

int RestoDivisao11 (int numero){

	int resultante = 0;
	resultante =  11 - (numero%11);
	return resultante;
}