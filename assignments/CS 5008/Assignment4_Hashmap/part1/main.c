#include <stdio.h>  // For IO operations
#include <stdlib.h> // for malloc/free

// Our library that we have written.
// Also, by a really smart engineer!
#include "my_hashmap.h"


int main() {

        hashmap_t* test = hashmap_create(5);
        //hashmap_insert(test, "keyss", "hhs");
//        hashmap_insert(test, "keyss", "abc");
//        hashmap_insert(test, "xxxxx", "xyz");
//        hashmap_hasKey(test, "xxxxx");
//        hashmap_printKeys(test);
//        hashmap_update(test, "xxxxx", "XYZ");
//        hashmap_printKeys(test);
//        printf("--------------\n");
//        hashmap_insert(test, "vinayrj", "my name");
//        hashmap_insert(test, "cprogramming", "is hard");
//        hashmap_printKeys(test);
//        printf("--------------\n");
//        printf("%s \n",hashmap_getValue(test, "keys"));
//        printf("%s \n",hashmap_getValue(test, "keyss"));
//        printf("%s \n",hashmap_getValue(test, "xxxxx"));
//        printf("%s \n",hashmap_getValue(test, "vinayrj"));
//        printf("%s \n",hashmap_getValue(test, "cprogramming"));
        //hashmap_removeKey(test, "keyss");
        //printf("%d \n",hashmap_hasKey(test, "keyss"));
        hashmap_insert(test, "keyss", "0 0");
        hashmap_insert(test, "keyzz", "0 1");
        hashmap_insert(test, "keyxx", "0 2");
        hashmap_insert(test, "k", "1 0");
        hashmap_insert(test, "z", "1 1");
        hashmap_insert(test, "x", "1 2");
        hashmap_insert(test, "ke", "2 0");
        hashmap_insert(test, "kz", "2 1");
        hashmap_insert(test, "kx", "2 1");
        hashmap_insert(test, "key", "3 0");
        hashmap_insert(test, "kez", "3 1");
        hashmap_insert(test, "kex", "3 1");
        hashmap_insert(test, "keys", "4 0");
        hashmap_insert(test, "keyz", "4 1");
        hashmap_insert(test, "keyx", "4 1");
        //hashmap_printKeys(test);
//        hashmap_removeKey(test, "keyxx");
//        hashmap_removeKey(test, "x");
//        hashmap_removeKey(test, "kx");
//        hashmap_removeKey(test, "kex");
//        hashmap_removeKey(test, "keyx");
        printf("%d \n",hashmap_hasKey(test, "k"));
        printf("%d \n",hashmap_hasKey(test, "z"));
        printf("%d \n",hashmap_hasKey(test, "x"));
        hashmap_update(test, "keyss", "0 0 x");
        hashmap_update(test, "keyzz", "0 1 x");
        hashmap_update(test, "keyxx", "0 2 x");
        hashmap_update(test, "k", "1 0 x");
        hashmap_update(test, "z", "1 1 x");
        hashmap_update(test, "x", "1 2 x");
        hashmap_update(test, "ke", "2 0 x");
        hashmap_update(test, "kz", "2 1 x");
        hashmap_update(test, "kx", "2 1 x");
        hashmap_update(test, "key", "3 0 x");
        hashmap_update(test, "kez", "3 1 x");
        hashmap_update(test, "kex", "3 1 x");
        hashmap_update(test, "keys", "4 0 x");
        hashmap_update(test, "keyz", "4 1 x");
        hashmap_update(test, "keyx", "4 1 x");
        hashmap_printKeys(test);


        hashmap_delete(test);
        return 0;
}
