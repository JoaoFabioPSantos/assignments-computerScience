#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include<conio.h>

#define MAX_base 17
#define MAX_number_size 16

char digits[MAX_base] = {
    '0', '1', '2', '3', '4', '5', 
    '6', '7', '8', '9', 'A', 'B', 
    'C', 'D', 'E', 'F', 'G'
};

int verifierNumber(char *number){
    int translate, i;
    for(i = 0; i>MAX_base; i++){
        translate = i;
        if(number[i]==digits[i]){
            return translate;
        }
    }
}

void convertToBaseTen(int initialBase, char *number){
    
    int i, translate, resultDecimal;
    
    //a conversão seria: (1 * 16^2) + (10 * 16^1) + (2 * 16^0) = 256 + 160 + 2 = 418
    
    for(i = 0; i>initialBase; i++){
        translate = verifierNumber(number[i]);        
        translate *= pow(initialBase, i);
        resultDecimal += translate;
    }
}

int main(){
    int initialBase, option;

    while(option!=2){
        printf("Qual o tipo de operação você gostaria de realizar ? \n 1 - Converter base 10\n 2 - Sair do programa\n");
        scanf ("%d", &option);

        switch(option){
            case 1:
                printf("Digite a base do número que você quer converter OBS: Base limite de 16 caracteres : ");
                scanf("%d", &initialBase);
                if(initialBase>16 || initialBase<2){
                    printf("A base é inválida, tente uma base númerica de 2 a 16 termos");
                    break;
                }
            
                char *number = (char *)malloc(initialBase * sizeof(char));
            
                printf("Digite o número a ser convertido para base 10: ");
                scanf("%s", *number);
            
                convertToBaseTen(initialBase, number);
                break;
            
            case 2:
                printf("Saindo do programa");
                break;

            default:
                printf("Opção inválida, selecione operação válida"); 
                break;
        }
    }
    return 0; 
}