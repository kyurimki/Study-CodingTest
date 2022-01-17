#include <stdio.h>

int main(void){
    int input;
    scanf("%d", &input);
    int i = 1;
    while (i <= input){
        for(int j = 0; j < input-i; j++){
            printf(" ");
        }
        for(int k = 0; k < i; k++){
            printf("*");
        }
        i++;
        printf("\n");
    }
    return 0;
}