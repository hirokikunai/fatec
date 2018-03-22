#include <stdio.h>

int Potencia(int base, int numeroPot);

int main () {
	int numeroInteiro, i = 0, j=0;
	printf ("\nInsira um numero inteiro: \n");
	scanf ("%i", &numeroInteiro);

		int TabInt[numeroInteiro][numeroInteiro];

			for (i=0;i<numeroInteiro;i++){
				for(j=0;j<numeroInteiro;j++){
				
					
					TabInt[i][j] = 0;
					
				}
			}

	
		if (numeroInteiro >= 0) {
			for (i=0;i<numeroInteiro;i++){
				for(j=0;j<numeroInteiro;j++){
				
					
					TabInt[i][j] = Potencia(2,(i+j));
					
				}
			}	
		} 
		else { printf ("\nValor invalido, tente novamente.\n"); }

		for (i=0;i<numeroInteiro;i++) {
			for(j=0;j<numeroInteiro;j++) {
			
				printf ("%3d ", TabInt[i][j]);
				
			}printf("\n");

		}
	return 0;
}

int Potencia(int base, int numeroPot){
	
	int resultado=1, i =0;
	
	if (numeroPot == 0){
		resultado = 1;
	}
	else{
		for (i=0;i<=numeroPot;i++){
				resultado = resultado * base;
		}
	}
	return resultado;
}
