// =================== Support Code =================
// Hashmap
//
// - Implement each of the functions to create a working hashmap.
// - Do not change any of the function declarations
//   - (i.e. hashmap_t* hashmap_create() should not have additional arguments)
// - You should not have any 'printf' statements in your functions other
//   than functions that explicitly ask for printf  output.
//   - (You may consider using these printf statements to debug, but they should be removed from your final version)
// - You may add any helper functions that you think you need (if any, or otherwise for debugging)
// ==================================================
#ifndef MY_HASHMAP_T
#define MY_HASHMAP_T

#include <stdlib.h>
#include <string.h>


// A key value pair
// This is specifically for a (char*, char*) key value pair
typedef struct pair{
    char* key;
    char* value;
}pair_t;

// Each node holds a key and a value
typedef struct node{
    struct node* next;
    pair_t* kv;          // 'kv' stands for key/value pair
}node_t;


// Simple hash function that will put a key into a bucket
// You should not modify this
int stringHash(char* myKey, int numberOfBuckets){
    return strlen(myKey) % numberOfBuckets;
}

// Create a function prototype to a function that takes
// in a char* and an int.
typedef int(*hashFunctionPointer)(char*,int) ;

// Chained implementation of a hashmap
typedef struct hashmap{
    unsigned int buckets;   // i.e. size of the hashmap
    node_t** arrayOfLists;  // An array of linked lists for our buckets
                            // Read another way
                            //      - an array of node_t*

    // A function pointer to a hash function
    // The hash_function must take in a 'char*' as a key, and have a
    // second parameter specifying the number of buckets.
    hashFunctionPointer hashFunction;
}hashmap_t;

// Creates a new hashmap
// Allocates memory for a new hashmap.
// Initializes the capacity(i.e. number of buckets)
hashmap_t* hashmap_create(unsigned int _buckets){
    // Allocate memory for our hashmap
    hashmap_t* my_map = (hashmap_t*) malloc(sizeof(hashmap_t));
    if(my_map == NULL)
        return NULL;
    
    // Set the number of buckets
    my_map->buckets = _buckets;
    // Initialize our array of lists for each bucket
    my_map->arrayOfLists = (node_t**) malloc(sizeof(node_t) * _buckets);
    if(my_map->arrayOfLists == NULL){
        return NULL;
    }
    
    // Setup our hashFunction to point to our
    // stringHash function.
    my_map->hashFunction = stringHash;
    // Return the new map that we have created
    return my_map;
}

// Frees a hashmap
// Responsibility to free a hashmap that has been previously allocated.
// Must also free all of the chains in the hashmap
// This function should run in O(n) time
void hashmap_delete(hashmap_t* _hashmap){
    if(_hashmap != NULL){
        int bucketCount = 0;
        while( bucketCount < _hashmap->buckets) {
            if(_hashmap->arrayOfLists[bucketCount] == NULL){ // if there's no node in the 'array' position then go to the next position
                bucketCount++;
            }
            else{
                if(_hashmap->arrayOfLists[bucketCount]->next == NULL){ // if there's only one node in the 'array' position
                                                                       // delete it and go to the next array poition
                    free(_hashmap->arrayOfLists[bucketCount]->kv->key);
                    free(_hashmap->arrayOfLists[bucketCount]->kv->value);
                    free(_hashmap->arrayOfLists[bucketCount]->kv);
                    free(_hashmap->arrayOfLists[bucketCount]);
                    
                    bucketCount++;
                }
                else {
                    node_t* temp = _hashmap->arrayOfLists[bucketCount]; // else, free the node and assign the next node to the array position
                    _hashmap->arrayOfLists[bucketCount] = temp->next;
                    free(temp->kv->key);
                    free(temp->kv->value);
                    free(temp->kv);
                    free(temp);
                }
            }
        }
        free(_hashmap->arrayOfLists); // free the array and the hashmap
        free(_hashmap);
    }
}

// Returns a boolean value if a key has been put into
// the hashmap
//  - Returns a '1' if a key exists already
//  - Returns a '0' if the key does not exist
//  - Returns a '-9999' if the hashmap is NULL
// The algorithm is:
//  - Call the _hashmap's hash function on the key
//  - Search that bucket to see if the key exists.
// This function should run in average-case constant time
int hashmap_hasKey(hashmap_t* _hashmap, char* key){
    if(_hashmap != NULL){
        int bucketCount = 0;
        node_t* iterator = _hashmap->arrayOfLists[bucketCount]; //
        while( bucketCount < _hashmap->buckets) {
            if(iterator == NULL){ // if there's no node at the array position then increment array position
                bucketCount++;
                iterator = _hashmap->arrayOfLists[bucketCount];
            }
            else{
                if(iterator->next == NULL){ // if there's only one node in the array positon
                                           // then check and increment the array positon and reinitialize the iterator if the key is not equal
                    if(!strcmp(iterator->kv->key, key)){
                        return 1;
                    }
                    bucketCount++;
                    iterator = _hashmap->arrayOfLists[bucketCount];
                }
                else{
                    if(!strcmp(iterator->kv->key, key)){ // else iterate thru the list
                        return 1;
                    }
                    iterator = iterator->next;
                }
            }
        }
        return 0;
    }
    else{
        return -9999;
    }
}

// Insert a new key/value pair into a hashmap
// The algorithm is:
//  - If a key already exists, do not add it--return
//  - Call the _hashmap's hash function on the key
//  - Store the key/value pair at the end of the buckets chain
//      - You should malloc the key/value in this function
// This function should run in average-case constant time
void hashmap_insert(hashmap_t* _hashmap,char* key,char* value){
    if(_hashmap == NULL)
        return;
    if(!hashmap_hasKey(_hashmap, key)){
        int pos = _hashmap->hashFunction(key, _hashmap->buckets); // get the postion
        
        node_t* newNode = (node_t*) malloc(sizeof(node_t)); // malloc space for the new node
        if(newNode == NULL)
            return;
        
        pair_t* newKV = (pair_t*) malloc(sizeof(pair_t)); // malloc space for the new KV pair
        if(newKV == NULL)
            return;
        
        newKV->key = (char*) malloc(strlen(key) + 1); // malloc space for the key char array
        if(newKV->key == NULL)
            return;
        
        newKV->value = (char*) malloc(strlen(value) + 1); // malloc space for value char array
        if(newKV->value == NULL)
            return;
        
        strcpy(newKV->key, key);
        strcpy(newKV->value, value);
        newNode->kv = newKV;
        newNode->next = NULL; // since we're inserting the newNode at the end of the list, next should be null
        
        if(_hashmap->arrayOfLists[pos] == NULL){ // if there's no node at the array position, insert there
            _hashmap->arrayOfLists[pos] = newNode;
        }
        else{
            node_t* temp = _hashmap->arrayOfLists[pos]; // else insert at the end of the node list
            while(temp->next != NULL){
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }
}

// Return a value from a key
// Returns NULL if the key is not found
// The algorithm is:
//  - If the key does not exist, then--return NULL if not found.
//  - Call the _hashmap's hash function on the key
//  - Search the _hashmap's bucket for the key and return the value
// This function should run in average-case constant time
char* hashmap_getValue(hashmap_t* _hashmap, char* key){
    if(_hashmap == NULL)
        return NULL;
    
    if(hashmap_hasKey(_hashmap, key)){
        int pos = _hashmap->hashFunction(key, _hashmap->buckets); // get the position
        node_t* temp = _hashmap->arrayOfLists[pos];
        while(strcmp(temp->kv->key, key)){ // loop thru till the key is not equal to the kv pair key
            temp = temp->next;
        }
        return temp->kv->value;
    }
    else
        return NULL;
}

// TODO NOTE THAT I DID NOT FINISH REMOVE KEY BECAUSE...
// Remove a key from a hashmap
// The algorithm is:
//  - Determine if the key exists--return if it does not.
//  - Call the _hashmap's hash function on the key
//  - Search the _hashmap's bucket for the key and then remove it
// This function should run in average-case constant time
void hashmap_removeKey(hashmap_t* _hashmap, char* key){
    if(_hashmap == NULL)
        return;
    
    if(hashmap_hasKey(_hashmap, key)){
        int pos = _hashmap->hashFunction(key, _hashmap->buckets);
        node_t* iterator = _hashmap->arrayOfLists[pos];
        
        // if there's only one node in the list then free the node and reassign the next node to the array position to NULL
        // or if the key is on the first node of the list, free the node and reassign the next node to the array position
        if(iterator->next == NULL || !strcmp(iterator->kv->key, key)){
            if(iterator->next != NULL)
                _hashmap->arrayOfLists[pos] = iterator->next;
            else
                _hashmap->arrayOfLists[pos] = NULL;
            
            free(iterator->kv->value);
            free(iterator->kv->key);
            free(iterator->kv);
            free(iterator);
        }
        else{
            while(iterator->next != NULL){ // loop thru till we find the node previous to the node that has the key
                if(!strcmp(iterator->next->kv->key, key)){
                    break;
                }
                iterator = iterator->next;
            }
            node_t* temp = iterator->next; // store the pointer in a temp variable so that we can reconnect tthe list
            if(iterator->next != NULL)
            iterator->next = iterator->next->next;
            free(temp->kv->value);
            free(temp->kv->key);
            free(temp->kv);
            free(temp);
        }
    }
    else
        return;
}

// Update a key with a new Value
// The algorithm is:
//  - Returns immediately if the key does not exist
//  - Call the _hashmap's hash function on the key
//  - Updates the value of the key to the new value
// This function should run in average-case constant time
void hashmap_update(hashmap_t* _hashmap, char* key, char* newValue){
    if(_hashmap == NULL)
        return;
    
    if(hashmap_hasKey(_hashmap, key)){
        int pos = _hashmap->hashFunction(key, _hashmap->buckets);
        node_t* temp = _hashmap->arrayOfLists[pos];
        while(strcmp(temp->kv->key, key)){
            temp = temp->next;
        }
        strcpy(temp->kv->value, newValue);
    }
    else
        return;
}

// Prints all of the keys in a hashmap
// The algorithm is:
//  - Iterate through every bucket and print out the keys
// This function should run in O(n) time
void hashmap_printKeys(hashmap_t* _hashmap){
    if(_hashmap != NULL){
        int bucketCount = 0;
        node_t* temp = _hashmap->arrayOfLists[bucketCount];
        
        while( bucketCount < _hashmap->buckets) {
            if(temp == NULL){
                bucketCount++;
                temp = _hashmap->arrayOfLists[bucketCount];
                continue;
            }
            else{
                if(_hashmap->arrayOfLists[bucketCount]->next == NULL){
                    printf("Key: %s , Value: %s \n",temp->kv->key, temp->kv->value);
                    bucketCount++;
                    temp = _hashmap->arrayOfLists[bucketCount];
                }
                else {
                    printf("Key: %s , Value: %s \n",temp->kv->key, temp->kv->value);
                    temp = temp->next;
                }
            }
        }
    }
}

#endif
