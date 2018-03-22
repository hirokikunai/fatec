#include <stdio.h>
#include <string.h>

void PulaLinha (int linhas);
void DashLinha (int linhas);

int main(){
	
	char senha[5] = {"0000"};
	printf("Bem vindo ao meu programa");
	PulaLinha(2);
	printf("Estou declarando as variáveis...");
	PulaLinha(3);
	DashLinha(2);
	printf("Insira a senha para acessar o programa: ");
	
	scanf ("%s", senha );
	
	if(strcmp(senha, "0000")==0){
		printf("Senha correta");
	}
	else{
		printf("Senha incorreta");
	}
	
	
	
	
}


void PulaLinha (int linhas){
	int i=0;
	
	for (i=0;i<linhas;i++){
		printf("\n");
	}
	return;
	
}

void DashLinha (int linhas){
	int i=0;
	
	for (i=0;i<linhas;i++){
		printf("-------------------------------------------------------\n");

	}
	return;
	
}


