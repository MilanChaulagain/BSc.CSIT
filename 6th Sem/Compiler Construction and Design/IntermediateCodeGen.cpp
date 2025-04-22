#include <stdio.h>
#include <string.h>

int tempCount = 1;

char* newTemp() {
    static char temp[5];
    sprintf(temp, "t%d", tempCount++);
    return temp;
}

void generate3AC(char* expr) {
    char op1, op2, op3;
    sscanf(expr, "%c = %c %c %c", &op1, &op2, &op3, &op3);
    
    // Step 1: Multiply c * d => t1 = c * d
    printf("t1 = %c %c %c\n", op2, op3, op3);

    // Step 2: Add b + t1 => t2 = b + t1
    printf("t2 = %c %c t1\n", op2, op3);

    // Step 3: Final assignment => a = t2
    printf("%c = t2\n", op1);
}

int main() {
    char expr[100];

    printf("Enter expression (like a = b + c * d): ");
    fgets(expr, 100, stdin);

    printf("\nIntermediate Code (3AC):\n");
    generate3AC(expr);

    return 0;
}

