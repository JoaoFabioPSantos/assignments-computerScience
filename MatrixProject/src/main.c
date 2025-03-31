#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "Portuguese");
    int option = 0;
    int linhaInicial, colunaInicial, linhaSomatoria, colunaSomatoria;
    int i, j;
    int **matInicial, **resultado, **matSomatoria, **matOperanda;
    
    printf("||| PROGRAMA DE MATRIZES ||| \n");
    while(option!=6){
        
        printf("\nSelecione uma operação: \n1 - Soma \n2 - Subtração \n3 - Identidade \n4 - Transposta \n5 - Multiplicação \n6 - Sair do programa\n");
        scanf("%d", &option);
        if(option==6){
            break;
        }
        
        printf("== DEFINA A MATRIZ INICIAL ==\n");
    
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
            //SOMATORIO
            printf("\n== DEFINA A MATRIZ SOMATORIA ==\n");
    
            printf("Informe o número de linhas: \n");
            scanf("%d", &linhaSomatoria);
    
            printf("Informe o número de colunas: \n");
            scanf("%d", &colunaSomatoria);
        
            if(linhaSomatoria != linhaInicial || colunaSomatoria != colunaInicial){
                printf("\n!!! Matriz Somatória Inválida !!!");
                break;
    
            }else{
                
                resultado = (int**)malloc(linhaInicial*sizeof(int*));
                    if(resultado == NULL){
                        printf("Memória Insuficiente\n");
                    }
    
                for(i=0; i<linhaInicial; i++){
                    resultado[i] = (int*)malloc(colunaInicial*sizeof(int));
                    if(resultado[i]==NULL){
                        printf("Memória Insuficiente\n");
                    }
                }
                
                matSomatoria = (int**)malloc(linhaSomatoria*sizeof(int*));
                if(matSomatoria == NULL){
                    printf("Memória Insuficiente\n");
                }
    
                for(i=0; i<linhaSomatoria; i++){
                    matSomatoria[i] = (int*)malloc(colunaSomatoria*sizeof(int));
                    if(matSomatoria[i]==NULL){
                        printf("Memória Insuficiente\n");
                    }
                }
                
                for(i=0; i<linhaSomatoria; i++){
                    for(j=0; j<colunaSomatoria; j++){
                        matSomatoria[i][j] = rand()%100;
                    }
                }
                
                printf("\n=== MATRIZ SOMATÓRIO ===");
                for(i=0; i<linhaSomatoria; i++){
                    printf("\n");
                    for(j=0; j<colunaSomatoria; j++){
                        printf("%d \t", matSomatoria[i][j]);
                    }
                }
                
                for(i=0; i<linhaInicial; i++){
                    for(j=0; j<colunaInicial; j++){
                        resultado[i][j] = (matInicial[i][j] + matSomatoria[i][j]);
                    }
                }
                
                printf("\n=== MATRIZ RESULTADO ===");
                for(i=0; i<linhaInicial; i++){
                    printf("\n");
                    for(j=0; j<colunaInicial; j++){
                        printf("%d \t", resultado[i][j]);
                    }
                }
            }
        
            for(i=0; i<linhaSomatoria; i++){
                free(matSomatoria[i]);
            }
            free(matSomatoria);
        
            break;
            
        case 2:
            //SUBTRAÇÃO
                printf("\n== DEFINA A MATRIZ SOMATORIO ==\n");
    
                printf("Informe o número de linhas: \n");
                scanf("%d", &linhaSomatoria);
    
                printf("Informe o número de colunas: \n");
                scanf("%d", &colunaSomatoria);
        
                if(linhaSomatoria != linhaInicial || colunaSomatoria != colunaInicial){
                    printf("\n!!! Matriz Operanda Inválida !!!");
                    break;
    
                }else{
                
                    resultado = (int**)malloc(linhaInicial*sizeof(int*));
                    if(resultado == NULL){
                        printf("Memória Insuficiente\n");
                    }
    
                    for(i=0; i<linhaInicial; i++){
                        resultado[i] = (int*)malloc(colunaInicial*sizeof(int));
                        if(resultado[i]==NULL){
                            printf("Memória Insuficiente\n");
                        }
                    }
                
                
                    matSomatoria = (int**)malloc(linhaSomatoria*sizeof(int*));
                    if(matSomatoria == NULL){
                        printf("Memória Insuficiente\n");
                    }
    
                    for(i=0; i<linhaSomatoria; i++){
                        matSomatoria[i] = (int*)malloc(colunaSomatoria*sizeof(int));
                        if(matSomatoria[i]==NULL){
                            printf("Memória Insuficiente\n");
                        }
                    }
                
                    for(i=0; i<linhaSomatoria; i++){
                        for(j=0; j<colunaSomatoria; j++){
                            matSomatoria[i][j] = rand()%100;
                        }
                    }
                
                    printf("\n=== MATRIZ SOMATÓRIO ===");
                    for(i=0; i<linhaSomatoria; i++){
                        printf("\n");
                        for(j=0; j<colunaSomatoria; j++){
                            printf("%d \t", matSomatoria[i][j]);
                        }
                    }
                
                    for(i=0; i<linhaInicial; i++){
                        for(j=0; j<colunaInicial; j++){
                            resultado[i][j] = matInicial[i][j] - matSomatoria[i][j];
                        }
                    }
                
                    printf("\n=== MATRIZ RESULTADO ===");
                    for(i=0; i<linhaInicial; i++){
                        printf("\n");
                        for(j=0; j<colunaInicial; j++){
                            printf("%d \t", resultado[i][j]);
                        }
                    }
                }
        
            for(i=0; i<linhaInicial; i++){
                free(matSomatoria[i]);
            }
            free(matSomatoria);
        
            break;
            
        case 3:
            //IDENTIDADE
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
            //TRANSPOSTA
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
            //MULTIPLICAÇÃO
            int linhaOperanda, colunaOperanda;
        
            printf("\n== DEFINA A MATRIZ OPERANDO ==\n");
    
            printf("Informe o número de linhas: \n");
            scanf("%d", &linhaOperanda);
    
            printf("Informe o número de colunas: \n");
            scanf("%d", &colunaOperanda);
        
            if(colunaInicial != linhaOperanda){
                printf("\n!!! Matriz Operanda Inválida\nÉ necessário que o número de colunas da Matriz Operanda seja o mesmo de linhas da Matriz Inicial !!!");
                break;
    
            }else{
                
                resultado = (int**)calloc(linhaInicial,sizeof(int*));
                if(resultado == NULL){
                    printf("Memória Insuficiente\n");
                }
    
                for(i=0; i<linhaInicial; i++){
                    resultado[i] = (int*)calloc(colunaOperanda,sizeof(int));
                    if(resultado[i]==NULL){
                        printf("Memória Insuficiente\n");
                    }
                }
                
                matOperanda = (int**)malloc(linhaOperanda*sizeof(int*));
                if(matOperanda == NULL){
                    printf("Memória Insuficiente\n");
                }
    
                for(i=0; i<linhaOperanda; i++){
                    matOperanda[i] = (int*)malloc(colunaOperanda*sizeof(int));
                    if(matOperanda[i]==NULL){
                        printf("Memória Insuficiente\n");
                    }
                }
                
                for(i=0; i<linhaOperanda; i++){
                    for(j=0; j<colunaOperanda; j++){
                        matOperanda[i][j] = rand()%100;
                    }
                }
                
                printf("== MATRIZ OPERANDO ==");
                for(i=0; i<linhaOperanda; i++){
                    printf("\n");
                    for(j=0; j<colunaOperanda; j++){
                        printf("%d \t", matOperanda[i][j]);
                    }
                }
                
                for(i=0; i<linhaInicial; i++){
                    for(j=0; j<colunaOperanda; j++){
                        for(int k=0; k<linhaOperanda; k++){
                            resultado[i][j] = resultado[i][j] + (matInicial[i][k] * matOperanda[k][j]);  
                        }
                    }
                }
        
                printf("\n== MATRIZ RESULTADO ==");
                for(i=0; i<linhaInicial; i++){
                    printf("\n");
                    for(j=0; j<colunaOperanda; j++){
                        printf("%d \t", resultado[i][j]);
                    }
                }
                
            }
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