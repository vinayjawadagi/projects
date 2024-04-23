// Compile this assignment with: gcc -g -Wall main.c -o main
//
// Include parts of the C Standard Library
// These have been written by some other really
// smart engineers.
#include <stdio.h>  // For IO operations
#include <stdlib.h> // for malloc/free

// Our library that we have written.
// Also, by a really smart engineer!
#include "my_dll.h"
// Note that we are locating this file
// within the same directory, so we use quotations
// and provide the path to this file which is within
// our current directory.



// ====================================================
// ================== Program Entry ===================
// ====================================================
int main(){
    dll_t* dll = create_dll();
    
    printf("current dll size: %d \n", dll_size(dll));
    printf("is empty? %d \n", dll_empty(dll));
    printf("pushed? %d \n", dll_push_front(dll, 1));
    printf("pushed? %d \n", dll_push_front(dll, 2));
    printf("pushed? %d \n", dll_push_front(dll, 3));
    printf("pushed? %d \n", dll_push_front(dll, 4));
    printf("--------------- \n");
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("whats at 1? %d \n", dll_get(dll, 1));
    printf("whats at 2? %d \n", dll_get(dll, 2));
    printf("whats at 3? %d \n", dll_get(dll, 3));
    printf("is empty? %d \n", dll_empty(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("did it pop? %d \n", dll_pop_front(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("did it pop? %d \n", dll_pop_front(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("did it pop? %d \n", dll_pop_front(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("did it pop? %d \n", dll_pop_front(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("is empty? %d \n", dll_empty(dll));


    printf("pushed? %d \n", dll_push_back(dll, 1));
    printf("pushed? %d \n", dll_push_back(dll, 2));
    printf("pushed? %d \n", dll_push_back(dll, 3));
    printf("pushed? %d \n", dll_push_back(dll, 4));
    printf("--------------- \n");
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("whats at 1? %d \n", dll_get(dll, 1));
    printf("whats at 2? %d \n", dll_get(dll, 2));
    printf("whats at 3? %d \n", dll_get(dll, 3));
    printf("is empty? %d \n", dll_empty(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("--------------- \n");
    printf("whats the size? %d \n", dll_size(dll));
    printf("did it pop? %d \n", dll_pop_back(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("whats at 0? %d \n", dll_get(dll, 2));
    printf("did it pop? %d \n", dll_pop_back(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("whats at 0? %d \n", dll_get(dll, 1));
    printf("did it pop? %d \n", dll_pop_back(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("did it pop? %d \n", dll_pop_back(dll));
    printf("whats the size? %d \n", dll_size(dll));
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("is empty? %d \n", dll_empty(dll));



    printf("pushed? %d \n", dll_push_back(dll, 1));
    printf("pushed? %d \n", dll_push_back(dll, 2));
    printf("pushed? %d \n", dll_push_back(dll, 3));
    printf("pushed? %d \n", dll_push_back(dll, 4));

    printf("push at 2 %d \n", dll_insert(dll, 2, 7));
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("whats at 1? %d \n", dll_get(dll, 1));
    printf("whats at 2? %d \n", dll_get(dll, 2));
    printf("whats at 3? %d \n", dll_get(dll, 3));
    printf("whats at 4? %d \n", dll_get(dll, 4));


    printf("pushed? %d \n", dll_push_back(dll, 1));
    printf("pushed? %d \n", dll_push_back(dll, 2));
    printf("pushed? %d \n", dll_push_back(dll, 3));
    printf("pushed? %d \n", dll_push_back(dll, 4));

    printf("removing element at 0 %d \n", dll_remove(dll, 4));
    printf("whats at 0? %d \n", dll_get(dll, 0));
    printf("whats at 1? %d \n", dll_get(dll, 1));
    printf("whats at 2? %d \n", dll_get(dll, 2));
    printf("whats at 3? %d \n", dll_get(dll, 3));
    printf("whats at 4? %d \n", dll_get(dll, 4));
    
    printf("is empty? %d \n", dll_empty(NULL));
    free_dll(dll);
}
