// Note: This is not an exhaustive test suite, but gives you the idea
//       of some tests you might want to create.
//       Adding more tests and slowly making them more and more complicated
//       as you develop your library is recommended.
//
// Compile this assignment with: gcc -g -Wall dll_test.c -o dll_test
//
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


// A sample collection of tests for your program
// You can add as many unit tests as you like
// We will be adding our own to test your program.


// Tests creation and deletion of list
// Ideally does not cause any segfaults, and this
// is considered passing.
// Dll should also be empty.
int unitTest1(int status){
    int passed = 0;
    dll_t* test = create_dll();
    if(dll_empty(test)){
        passed = 1;
    }
    free_dll(test);


    return passed;
}

// Tests push_front and size functions
int unitTest2(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_front(test,789);
    if(1==dll_size(test)){
       passed = 1;
    }else{
        passed = 0;
    }
    free_dll(test);

    return passed;
}


// Tests push_back and size functions
int unitTest3(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test,142);
    if(1==dll_size(test)){
       passed = 1;
    }else{
       passed = 0;
    }
    free_dll(test);

    return passed;
}

// Tests push_front and dll_pop_back functions
int unitTest4(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test,142);
    dll_pop_back(test);
    if(0==dll_size(test)){
       passed = 1;
    }else{
        passed = 0;
    }
    free_dll(test);

    return passed;
}

// Tests push_back twice, then pops once
// then should compute the correct size.
int unitTest5(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test,142);
    dll_push_front(test,142);
    dll_pop_back(test);
    if(1==dll_size(test)){
       passed = 1;
    }else{
        passed = 0;
    }
    free_dll(test);

    return passed;
}

// dll_push_front test
// push 4 elements at the front and check
// if the dll_size and test->count is equal to 4
int unitTest6(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_front(test, 4);
    dll_push_front(test, 3);
    dll_push_front(test, 2);
    dll_push_front(test, 1);
    if(test->count == 4 && dll_size(test) == 4)
        passed = 1;
    free_dll(test);

    return passed;
}

// dll_push_front test
// push 4 elements at the front and check
//if the theyre being pushed in the front
int unitTest7(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_front(test, 4);
    dll_push_front(test, 3);
    dll_push_front(test, 2);
    dll_push_front(test, 1);
    int counter = 1;
    int value = 0;
    while(counter <5){
        value = dll_pop_front(test);
        if(counter == value)
            passed = 1;
        counter++;
    }
    free_dll(test);

    return passed;
}

// dll_push_back test
// push 4 elements at the back and check
// if the dll_size and test->count is equal to 4
int unitTest8(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 4);
    dll_push_back(test, 3);
    dll_push_back(test, 2);
    dll_push_back(test, 1);
    if(test->count == 4 && dll_size(test) == 4)
        passed = 1;
    free_dll(test);

    return passed;
}

// dll_push_back test
// push 4 elements at the back and check
// if the they're being pushed in the back
int unitTest9(int status){
    int passed = 1;
    dll_t* test = create_dll();
    dll_push_back(test, 1);
    dll_push_back(test, 2);
    dll_push_back(test, 3);
    dll_push_back(test, 4);
    int counter = 1;
    int value = 0;
    while(counter < 5 && passed){
        value = dll_pop_front(test);
        if(counter == value)
            passed = 1;
        else
            passed = 0;
        counter++;
    }
    free_dll(test);

    return passed;
}

// dll_pop_front test
// add elements and pop at front and check
// if the popped element is equal to the added element
int unitTest10(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 100);
    
    if(dll_pop_front(test) == 100)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_pop_back test
// add elements and pop at back and check
// if the popped element is equal to the added element
int unitTest11(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 11);
    
    if(dll_pop_back(test) == 11)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_insert test (path 1, middle of the list)
// add element at a specific position and
// fetch the element and compare
int unitTest12(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 11);
    
    dll_insert(test, 1, 1000);
    
    if(dll_get(test, 1) == 1000)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_insert test (path 2, front of the list)
// add element at a specific position and
// fetch the element and compare
int unitTest13(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 11);
    
    dll_insert(test, 0, 1000);
    
    if(dll_get(test, 0) == 1000)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_insert test (path 3, end of the list)
// add element at a specific position and
// fetch the element and compare
int unitTest14(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 11);
    
    dll_insert(test, 2, 1000);
    
    if(dll_get(test, 2) == 1000)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_get test (path 1, start of the list)
// add elements in the DLL.
// fetch them using dll_get and compare
int unitTest15(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 1000);
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 1);
    if(dll_get(test, 0) == 1000)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_get test (path 2, middle of the list)
// add elements in the DLL.
// fetch them using dll_get and compare
int unitTest16(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 1000);
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 1);
    if(dll_get(test, 2) == 10)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_get test (path 3, end of the list)
// add elements in the DLL.
// fetch them using dll_get and compare
int unitTest17(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 10);
    dll_push_back(test, 1);
    if(dll_get(test, 3) == 1)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_remove test (path1, remove at the start of the list)
// add elements in the DLL
// remove the first element and comapre with the value
int unitTest18(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 1000);
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 1);
    if(dll_remove(test, 0) == 1000)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_remove test (path2, remove at the middle of the list)
// add elements in the DLL
// remove the 3rd element and comapre with the value
int unitTest19(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 1000);
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 1);
    if(dll_remove(test, 2) == 10)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_remove test (path3, remove at the end of the list)
// add elements in the DLL
// remove the last element and comapre with the value
int unitTest20(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 1000);
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 1);
    if(dll_remove(test, 3) == 1)
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_empty test (path1, check an empty list)
// create a list and check if it's empty
int unitTest21(int status){
    int passed = 0;
    dll_t* test = create_dll();
    if(dll_empty(test))
        passed = 1;
    free_dll(test);
    return passed;
}

// dll_empty test (path2, check an non-empty list)
// create a list, add elements and check if it's empty
int unitTest22(int status){
    int passed = 0;
    dll_t* test = create_dll();
    dll_push_back(test, 100);
    dll_push_back(test, 10);
    dll_push_back(test, 1);
    if(dll_empty(test) == 0)
        passed = 1;
    free_dll(test);
    return passed;
}

// TODO: Add more tests here at your discretion
int (*unitTests[])(int)={
    unitTest1,
    unitTest2,
    unitTest3,
    unitTest4,
    unitTest5,
    unitTest6,
    unitTest7,
    unitTest8,
    unitTest9,
    unitTest10,
    unitTest11,
    unitTest12,
    unitTest13,
    unitTest14,
    unitTest15,
    unitTest16,
    unitTest17,
    unitTest18,
    unitTest19,
    unitTest20,
    unitTest21,
    unitTest22,
    NULL
};


// ====================================================
// ================== Program Entry ===================
// ====================================================
int main(){
    unsigned int testsPassed = 0;
    // List of Unit Tests to test your data structure
    int counter =0;
    while(unitTests[counter]!=NULL){
        printf("========unitTest %d========\n",counter);
        if(1==unitTests[counter](1)){
        printf("passed test\n");
        testsPassed++;
    }else{
        printf("failed test, missing functionality, or incorrect test\n");
    }
        counter++;
    }

    printf("%d of %d tests passed\n",testsPassed,counter);

    return 0;
}
