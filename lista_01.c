#include <stdio.h>
#include <string.h>


int main (){

	char inputUsuario[51], caracteres[51], verificaExistencia;
	int comprimento = 0, i = 0, j = 0;
	scanf("%[/n]",inputUsuario);
	comprimento = strlen(inputUsuario);

	printf("%s\n", inputUsuario);

	//scanf("%s", caracteres);


	printf("Caractere %d\n", j);



	for (i = 0; i < comprimento; ++i)
	{
		caracteres[i]=0;
		for ( j = 0; j < comprimento; ++j)
		{
			if((inputUsuario[i] == inputUsuario[j])){
				 caracteres[i]++;
			}



		}	printf("%d - %s\n", caracteres[i], &inputUsuario[i]);

	}
	printf("%s\n", &inputUsuario[2]);

    return 0;


}

