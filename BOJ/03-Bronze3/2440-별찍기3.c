#include <stdio.h>

int main(void){
    int input;
    scanf("%d", &input);
    int i = 1;
    while (i <= input){
        for(int j = input - i + 1; j > 0; j--){
            printf("*");
        }
        i++;
        printf("\n");
    }
    return 0;
}