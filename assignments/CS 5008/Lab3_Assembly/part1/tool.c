#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char** argv){
    int movCounter = 0;
    int mulCounter = 0;
    int addCounter = 0;
    int subCounter = 0;
    int divCounter = 0;
    int leaCounter = 0;
    int pushCounter = 0;
    int popCounter = 0;
    int retCounter = 0;
    int cycleCount = 0;
    FILE* filePtr = fopen(argv[1], "r");
    
    if(filePtr == NULL)
        printf("file is empty");
    
    char command[50];
              
    while(fscanf(filePtr, "%s", command) != EOF){
        if(!strncmp(command, "mov", 3)){
            movCounter++;
            cycleCount += 1;
            }
        else if(!strncmp(command, "mul", 3)){
                        mulCounter++;
                        cycleCount += 2;
                        }
        else if(!strncmp(command, "add", 3)){
                        addCounter++;
                        cycleCount += 1;
                        }
        else if(!strncmp(command, "sub", 3)){
                        subCounter++;
                        cycleCount += 1;
                        }
        else if(!strncmp(command, "div", 3)){
                        divCounter++;
                        cycleCount += 4;
                        }
        else if(!strncmp(command, "lea", 3)){
                        leaCounter++;
                        cycleCount += 1;
                        }
        else if(!strncmp(command, "push", 4)){
                        pushCounter++;
                        cycleCount += 1;
                        }
        else if(!strncmp(command, "pop", 3)){
                        popCounter++;
                        cycleCount += 1;
                        }
        else if(!strncmp(command, "ret", 3)){
                        retCounter++;
                        cycleCount += 1;
                        }
        else if(!strncmp(command, "imul", 4)){
                        divCounter++;
                        cycleCount += 2;
                        }
        else if(!strncmp(command, "idiv", 4)){
                        divCounter++;
                        cycleCount += 4;
                        }
    }

    printf("MOV %d \n", movCounter);
    printf("MUL %d \n", mulCounter);
    printf("DIV %d \n", divCounter);
    printf("LEA %d \n", leaCounter);
    printf("ADD %d \n", addCounter);
    printf("SUB %d \n", subCounter);
    printf("PUSH %d \n", pushCounter);
    printf("POP %d \n", popCounter);
    printf("RET %d \n", retCounter);
    printf("Total Instructions = %d \n", (movCounter + mulCounter + divCounter + leaCounter +
                                          addCounter + subCounter + pushCounter + popCounter + retCounter));
    printf("Total Cycles = %d \n",cycleCount);
}
