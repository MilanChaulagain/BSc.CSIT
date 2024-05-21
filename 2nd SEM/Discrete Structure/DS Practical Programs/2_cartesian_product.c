#include <stdio.h>
#include <conio.h>

int main(){
    int a[10], b[10], c[10], i,j,k;
    printf("Enter the 5 elements in set a: ");
    for(i = 0; i < 5; i++){
        scanf("%d", &a[i]);
    }
    printf("\nEnter the 5 elements in Set B: ");
    for(j = 0; j< 5; j++){
        scanf("%d", &b[j]);
    }
    printf("\nCartesian product = ");
    printf("{");
    for(i=0;i<5;i++){
        for(j=0;j<5;j++){
            printf(("%d, %d"), a[i],b[j]);
            printf(",");
        }
    }
            printf("}");
    getch();
    return 0;
}