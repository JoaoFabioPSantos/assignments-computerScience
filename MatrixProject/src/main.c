#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int operations(int numberManager, int **matInicial, int linhaInicial, int colunaInicial){
    int **resultado, **matOperador;
    int linhaOperador, colunaOperador;
    int i, j;

    printf("\n### DEFINA A MATRIZ OPERADORA ###\n");
    printf("Informe o número de linhas: \n");
    scanf("%d", &linhaOperador);
    
    printf("Informe o número de colunas: \n");
    scanf("%d", &colunaOperador);
    
    //VERIFICADORES E CALCULOS
    if(numberManager == 1 || numberManager == -1){
        if(linhaOperador != linhaInicial || colunaOperador != colunaInicial){
            return printf("!!!ERRO NA DECLARAÇÃO DE MATRIZES!!! ");
        }
        
    }else if(numberManager == 2){
        if(colunaInicial != linhaOperador){
            return printf("!!!ERRO NA DECLARAÇÃO DE MATRIZES!!!\nÉ necessário que o número de colunas da Matriz Operanda seja o mesmo de linhas da Matriz Inicial\n");
        }else{
            resultado = (int**)calloc(linhaInicial,sizeof(int*));
            if(resultado == NULL){
                printf("Memória Insuficiente");
            }
        
            for(i=0; i<linhaOperador; i++){
                resultado[i] = (int*)calloc(colunaOperador,sizeof(int));
                if(resultado[i]==NULL){
                    printf("Memória Insuficiente\n");
                }
            }
        
            matOperador = (int**)malloc(linhaOperador*sizeof(int*));
            if(matOperador == NULL){
                printf("Memória Insuficiente\n");
            }
    
            for(i=0; i<linhaOperador; i++){
                matOperador[i] = (int*)malloc(colunaOperador*sizeof(int));
                if(matOperador[i]==NULL){
                    printf("Memória Insuficiente\n");
                }
            }
            
            for(i=0; i<linhaOperador; i++){
                for(j=0; j<colunaOperador; j++){
                    matOperador[i][j] = rand()%100;
                }
            }
        
            printf("== MATRIZ OPERADOR ==");
            for(i=0; i<linhaOperador; i++){
                printf("\n");
                for(j=0; j<colunaOperador; j++){
                    printf("%d \t", matOperador[i][j]);
                }
            }
            
            for(i=0; i<linhaInicial; i++){
                for(j=0; j<colunaOperador; j++){
                    for(int k=0; k<linhaOperador; k++){
                        resultado[i][j] = resultado[i][j] + (matInicial[i][k] * matOperador[k][j]);  
                    }
                }
            }
        
            printf("\n== MATRIZ RESULTADO ==");
            for(i=0; i<linhaInicial; i++){
                printf("\n");
                for(j=0; j<colunaOperador; j++){
                    printf("%d \t", resultado[i][j]);
                }
            }
            
            return 1;    
        }
    }
    
    resultado = (int**)malloc(linhaOperador*sizeof(int*));
    if(resultado == NULL){
        printf("Memória Insuficiente\n");
    }
    
    for(i=0; i<linhaOperador; i++){
        resultado[i] = (int*)malloc(colunaOperador*sizeof(int));
        if(resultado[i]==NULL){
            printf("Memória Insuficiente\n");
        }
    }
                
    matOperador = (int**)malloc(linhaOperador*sizeof(int*));
    if(matOperador == NULL){
        printf("Memória Insuficiente\n");
    }
    for(i=0; i<linhaOperador; i++){
        matOperador[i] = (int*)malloc(colunaOperador*sizeof(int));
        if(matOperador[i]==NULL){
            printf("Memória Insuficiente\n");
        }
    }
                
    for(i=0; i<linhaOperador; i++){
        for(j=0; j<colunaOperador; j++){
            matOperador[i][j] = rand()%100;
        }
    }
                
    printf("\n=== MATRIZ OPERADOR ===");
    for(i=0; i<linhaOperador; i++){
        printf("\n");
        for(j=0; j<colunaOperador; j++){
            printf("%d \t", matOperador[i][j]);
        }
    }
                
    for(i=0; i<linhaOperador; i++){
        for(j=0; j<colunaOperador; j++){
            resultado[i][j] = (matInicial[i][j] + (numberManager*matOperador[i][j]));
        }
    }
                
    printf("\n=== MATRIZ RESULTADO ===");
    for(i=0; i<linhaInicial; i++){
        printf("\n");
        for(j=0; j<colunaInicial; j++){
            printf("%d \t", resultado[i][j]);
        }
    }
    
    for(i=0; i<linhaOperador; i++){
        free(matOperador[i]);
    }
    free(matOperador);
    return 1;
}

int main()
{
    setlocale(LC_ALL, "Portuguese");
    int option = 0;
    int linhaInicial, colunaInicial;
    int **matInicial, **resultado;
    int i,j;
    
    printf("||| PROGRAMA DE MATRIZES ||| \n");
    while(option!=6){
        
        printf("\nSelecione uma operação: \n1 - Soma \n2 - Subtração \n3 - Identidade \n4 - Transposta \n5 - Multiplicação \n6 - Sair do programa\n");
        scanf("%d", &option);
        if(option==6){
            break;
        }
        
        printf("### DEFINA A MATRIZ INICIAL ###\n");
        printf("Informe o número de linhas: \n");
        scanf("%d", &linhaInicial);
    
        printf("Informe o número de colunas: \n");
        scanf("%d", &colunaInicial);
    
        matInicial = (int**)malloc(linhaInicial*sizeof(int*));
        if(matInicial == NULL){
            printf("Memória Insuficiente\n");
        }
        for(i=0; i<linhaInicial; i++){
            matInicial[i] = (int*)malloc(colunaInicial*sizeof(int));
            if(matInicial[i]==NULL){
                printf("Memória Insuficiente\n");
            }
        }

        for(i=0; i<linhaInicial; i++){
            for(j=0; j<colunaInicial; j++){
                matInicial[i][j] = rand()%100;
            }
        }

        printf("== MATRIZ INICIAL ==");
        for(i=0; i<linhaInicial; i++){
            printf("\n");
            for(j=0; j<colunaInicial; j++){
                printf("%d \t", matInicial[i][j]);
            }
        }
        
        switch(option){
        case 1:
            operations(1, matInicial, linhaInicial, colunaInicial);
            break;
            
        case 2:
            operations(-1, matInicial, linhaInicial, colunaInicial);
            break;
            
        case 3:
            for(i=0; i<linhaInicial; i++){
                for(j=0; j<colunaInicial; j++){
                    if(i == j){
                        matInicial[i][j] = 1;
                    }else{
                        matInicial[i][j] = 0;
                    }
                }
            }
            
            printf("\n== MATRIZ IDENTIDADE: ==\n");
            for(i=0; i<colunaInicial; i++){
                printf("\n");
                for(j=0; j<linhaInicial; j++){
                    printf("%d \t", matInicial[i][j]);
                }
            }
            break;
            
        case 4:
            resultado = (int**)malloc(colunaInicial*sizeof(int*));
            if(resultado == NULL){
                printf("Memória Insuficiente\n");
            }
            for(i=0; i<linhaInicial; i++){
                resultado[i] = (int*)malloc(linhaInicial*sizeof(int));
                if(resultado[i]==NULL){
                    printf("Memória Insuficiente\n");
                }
            }
        
            for(i=0; i<linhaInicial; i++){
                for(j=0; j<colunaInicial; j++){
                    resultado[i][j] = matInicial[j][i];
                }
            }
            
            printf("\n== MATRIZ TRANSPOSTA: ==\n");
            for(i=0; i<colunaInicial; i++){
                printf("\n");
                for(j=0; j<linhaInicial; j++){
                    printf("%d \t", resultado[i][j]);
                }
            }
            break;
    
        case 5:
            operations(2, matInicial, linhaInicial, colunaInicial);    
            break;
            
        case 6:
            printf("\n||| Saindo do programa |||\n");
            break;
        
        default:
            printf("\nValor inválido\n");
            break;
        }
    }
    for(i=0; i<linhaInicial; i++){
                free(matInicial[i]);
                free(resultado[i]);
            }
    free(matInicial);
    free(resultado);
    
    printf("\n||| Obrigado por utilizar o programa |||");
}
