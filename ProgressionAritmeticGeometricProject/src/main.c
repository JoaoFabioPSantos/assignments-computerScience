#include <stdio.h>
#include <locale.h>
#include <stdbool.h>

int termo_pa(int a1, int r, int n) {
  	if (n == 1){
		return a1;
  	}else{
    	return termo_pa(a1, r, n - 1) + r;
  	}
}

int somaPaRecursiva(int a1, int r, int n){
    if (n == 1){
        return a1;
    }else{
        return somaPaRecursiva(a1, r, n - 1) + termo_pa(a1, r, n);
    }
}

int termo_pg(int g1, int q, int m){
    if (m == 1){
		return g1;
  	}else{
    	return termo_pg(g1, q, m - 1) * q;
  	}
}

int somaPgRecursiva(int g1, int q, int m){
    if (m == 1){
        return g1;
    }else{
        return somaPaRecursiva(g1, q, m - 1) + termo_pg(g1, q, m);
    }
}

int main()
{
    setlocale(LC_ALL,"");
  	int firstTerm, ratio, position;
  	int opt = 0;
  	int termo, soma;
  	bool run = true;
  	
  	printf("Bem vindo ao programa de Progressão Aritmética/ Progressão Geométrica\n");
  	
  	while(run){
  	    printf("\nDigite a operação que deseja realizar: \n 1- PA \n 2- PG \n 3- Sair\n");
  	    scanf("%d", &opt);
  	    
        switch(opt){
            case 1:
  	            printf("Digite o primeiro termo da PA: ");
  	            scanf("%d", &firstTerm);
  	            printf("Digite a razao da PA: ");
              	scanf("%d", &ratio);
             	printf("Digite a posicao do termo desejado: ");
             	scanf("%d", &position);
            
                printf("\033[0;32m===RESULTADOS===\033[0m\n");
              	termo = termo_pa(firstTerm, ratio, position);
              	printf("Termo na posicao %d = %d\n", position, termo);
                soma = somaPaRecursiva(firstTerm, ratio, position);
                printf("Soma dos termos = %d\n", soma);
  	            break;
  	            
  	        case 2:
  	            printf("Digite o primeiro termo da PG: ");
  	            scanf("%d", &firstTerm);
  	            printf("Digite a razao da PG: ");
              	scanf("%d", &ratio);
             	printf("Digite a posicao do termo desejado: ");
             	scanf("%d", &position);
            
              	termo = termo_pg(firstTerm, ratio, position);
              	printf("Termo na posicao %d = %d\n", position, termo);
                soma = somaPgRecursiva(firstTerm, ratio, position);
                printf("Soma dos termos = %d\n", soma);
  	            break;
  	            
  	        case 3:
  	            run = false;
  	            break;
  	        
  	        default:
  	            printf("\n\033[31m!!!ALERTA: ocorreu um erro em sua opção, reinicie o programa!!!\033[0m\n");
  	            run = false;
  	            break;
  	 }   
  	}
  	printf("\033[0;32m===Obrigado por utilizar o algoritmo===\033[0m\n");
  	
    return 0;
}

