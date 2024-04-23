// =================== Support Code =================
// Doubly Linked List ( DLL ).
//
//
//
// - Implement each of the functions to create a working DLL.
// - Do not change any of the function declarations
//   - (i.e. dll_t* create_dll() should not have additional arguments)
// - You should not have any 'printf' statements in your DLL functions.
//   - (You may consider using these printf statements to debug, but they should be removed from your final version)
//   - (You may write helper functions to help you debug your code such as print_list etc)
// ==================================================
#ifndef MYDLL_H
#define MYDLL_H
#include <stdlib.h>

// Create a node data structure to store data within
// our DLL. In our case, we will stores 'integers'
typedef struct node{
        void* data;
        struct node* next;
        struct node* previous;
}node_t;

// Create a DLL data structure
// Our DLL holds a pointer to the first node in our DLL called head,
// and a pointer to the last node in our DLL called tail.
typedef struct DLL{
        int count;        // count keeps track of how many items are in the DLL.
        node_t* head;        // head points to the first node in our DLL.
        node_t * tail;          //tail points to the last node in our DLL.
}dll_t;

// Creates a DLL
// Returns a pointer to a newly created DLL.
// The DLL should be initialized with data on the heap.
// (Think about what the means in terms of memory allocation)
// The DLLs fields should also be initialized to default values.
// Returns NULL if we could not allocate memory.
dll_t* create_dll(){
        dll_t* myDLL= (dll_t*) malloc(sizeof(dll_t));
        if(myDLL == NULL)
                return NULL;
        myDLL->count = 0;
        myDLL->head = NULL;
        myDLL->tail = NULL;
        
        return myDLL;
}

// DLL Empty
// Check if the DLL is empty
// Returns 1 if true (The DLL is completely empty)
// Returns 0 if false (the DLL has at least one element enqueued)
// Returns -1 if the dll is NULL.
int dll_empty(dll_t* l){
        if(l == NULL)
                return -1;
        
        if(l->count == 0)
                return 1;
        else
                return 0;
}

// push a new item to the front of the DLL ( before the first node in the list).
// Returns 1 on success
// Returns 0 on failure ( i.e. we couldn't allocate memory for the new node)
// Returns -1 if DLL is NULL.
// (i.e. the memory allocation for a new node failed).
int dll_push_front(dll_t* l, void* item){
        if(l == NULL)
                return -1;
        if(dll_empty(l)){
                node_t* newNode = (node_t*) malloc(sizeof(node_t));
                if(newNode == NULL)
                        return 0;
                
                newNode->data = item;
                newNode->previous = NULL;
                newNode->next = NULL;
                
                l->head = newNode;
                l->tail = newNode;
                l->count = 1;
                
                return 1;
        }
        else {
                node_t* newNode = (node_t*) malloc(sizeof(node_t));
                if(newNode == NULL)
                        return 0;
                
                newNode->data = item;
                newNode->previous = NULL;
                newNode->next = l->head;
                
                l->head->previous = newNode;
                l->head = newNode;
                l->count++;
                
                return 1;
        }
}

// push a new item to the end of the DLL (after the last node in the list).
// Returns 1 on success
// Returns 0 on failure ( i.e. we couldn't allocate memory for the new node)
// Returns -1 if DLL is NULL.
// (i.e. the memory allocation for a new node failed).
int dll_push_back(dll_t* l, void* item){
        if(l == NULL)
                return -1;
        if(dll_empty(l)){
                return dll_push_front(l, item);
        }
        else {
                node_t* newNode = (node_t*) malloc(sizeof(node_t));
                if(newNode == NULL)
                        return 0;
                
                newNode->data = item;
                newNode->previous = l->tail;
                l->tail->next = newNode;
                newNode->next = NULL;
                l->tail = newNode;
                l->count++;
                
                return 1;
        }
}

// Returns the first item in the DLL and also removes it from the list.
// Returns 0 on failure, i.e. there is noting to pop from the list.
// Returns a -1 if the DLL is NULL.
// Assume no negative numbers in the list or the number zero.
void* dll_pop_front(dll_t* t){
        if(t == NULL)
                return -1;
        if(dll_empty(t)){
                return 0;
        }
        else {
                node_t* temp = t->head;
                void* popData = t->head->data;
                if(t->head->next != NULL){  // if there's only one element in the DLL
                        t->head->next->previous = NULL;
                        t->head = t->head->next;
                }
                t->count--;
                free(temp);
                
                return popData;
        }
}

// Returns the last item in the DLL, and also removes it from the list.
// Returns 0 on failure, i.e. there is noting to pop from the list.
// Returns a -1 if the DLL is NULL.
// Assume no negative numbers in the list or the number zero.
void* dll_pop_back(dll_t* t){
        if(t == NULL)
                return -1;
        if(dll_empty(t)){
                return 0;
        }
        else {
                node_t* temp = t->tail;
                void* popData = t->tail->data;
                if(t->head->next != NULL) { // if there's only one element in the list
                        t->tail->previous->next = NULL;
                        t->tail = t->tail->previous;
                }
                t->count--;
                free(temp);
                
                return popData;
        }
}

// Inserts a new node before the node at the specified position.
// Returns 1 on success
// Retruns 0 on failure:
//  * we couldn't allocate memory for the new node
//  * we tried to insert at a negative location.
//  * we tried to insert past the size of the list
//   (inserting at the size should be equivalent as calling push_back).
// Returns -1 if the list is NULL
int dll_insert(dll_t* l, int pos, void* item){
        if(l == NULL)
                return -1;
        
        if(pos < 0 || pos > l->count)
                return 0;

        if(pos == 0 || l->count == 0){
                return dll_push_front(l, item);
        }
        else{
                int count = 0;
                node_t* temp = l->head;
                node_t* newNode = (node_t*) malloc(sizeof(node_t));
                if(newNode == NULL)
                        return 0;
                
                while(count != pos){
                        temp = temp->next;
                        count++;
                }
                
                newNode->data = item;
                temp->previous->next = newNode;
                newNode->previous = temp->previous;
                temp->previous = newNode;
                newNode->next = temp;
                l->count++;
                
                return 1;
        }
}

// Returns the item at position pos starting at 0 ( 0 being the first item )
//  (does not remove the item)
// Retruns 0 on failure:
//  * we tried to get at a negative location.
//  * we tried to get past the size of the list
// Returns -1 if the list is NULL
// Assume no negative numbers in the list or the number zero.
void* dll_get(dll_t* l, int pos){
        if(l == NULL)
                return -1;
        if(pos < 0 || pos >= l->count)
                return 0;
        
        int count = 0;
        node_t* temp = l->head;
        while(count != pos){
                temp = temp->next;
                count++;
        }
        return temp->data;
}

// Removes the item at position pos starting at 0 ( 0 being the first item )
// Retruns 0 on failure:
//  * we tried to remove at a negative location.
//  * we tried to remove get past the size of the list
// Returns -1 if the list is NULL
// Assume no negative numbers in the list or the number zero.
void* dll_remove(dll_t* l, int pos){
        if(l == NULL)
                return -1;
        if(pos < 0 || pos >= l->count)
                return 0;
        
        if(pos == 0){
                return dll_pop_front(l);
                
        }
        else if(pos == l->count - 1){
                return dll_pop_back(l);
        }
        else {
                int count = 0;
                void* poppedData = 0;
                node_t* temp = l->head;
                while(count != pos){
                        temp = temp->next;
                        count++;
                }
                poppedData = temp->data;
                temp->previous->next = temp->next;
                temp->next->previous = temp->previous;
                l->count--;
                free(temp);
                return poppedData;
        }
}

//returns the index if it is present or returns -1 when its not present
int dll_index_of(dll_t* l, void* data){
    if(l == NULL || l->count == 0) return -1;
    int index = 0;
    node_t* itr = l->head;
    while(itr != NULL){
        if(itr->data == data){
            return index;
        }
        itr = itr->next;
        index++;
    }
    return -1;
}

// DLL Size
// Queries the current size of a DLL
// Returns -1 if the DLL is NULL.
int dll_size(dll_t* t){
        if(t == NULL)
                return -1;
        return t->count;
}

// Free DLL
// Removes a DLL and all of its elements from memory.
// This should be called before the proram terminates.
void free_dll(dll_t* t){
        if(t->count != 0) {
                node_t* temp = t->head;
                while(temp != NULL && t->count != 0){
                        temp = t->head;
                        t->head = t->head->next;
                        t->count--;
                        free(temp);
                }
        }

        free(t);
}



#endif
