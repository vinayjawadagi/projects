//
//  my_bst.c
//  ass8
//
//  Created by Vinay Jawadagi on 10/31/23.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct bstnode{
    int data;               // data each node holds
    struct bstnode* leftChild; // pointer to left child (if any)
    struct bstnode* rightChild;// pointer to right child (if any)
}bstnode_t;

// Our BST data structure
// Our BST holds a pointer to the root node in our BST.
typedef struct bst{
    unsigned int size;  // Size keeps track of how many items are in the BST.
    // Size should be incremented when we add.
    bstnode_t* root;    // root points to the root node in our BST.
}bst_t;

// Creates a BST
// Returns a pointer to a newly created BST.
// The BST should be initialized with data on the heap.
// The BST fields should also be initialized to default values(i.e. size=0).
bst_t* bst_create(){
    // Modify the body of this function as needed.
    bst_t* myBST= (bst_t*) malloc(sizeof(bst_t));
    myBST->size = 0;
    myBST->root = NULL;
    
    return myBST;
}

// BST Empty
// Check if the BST is empty
// Returns 1 if true (The BST is completely empty)
// Returns 0 if false (the BST has at least one element)
int bst_empty(bst_t* t){
    if(t == NULL)
        exit(1);
    
    if(t->size == 0)
        return 1;
    
    return 0;
}


// helper function to add a node into the BST
int add_node(bstnode_t* node, int new_value){
    if(node->data >= new_value){
        
        if(node->leftChild == NULL){ // if the current node doesnt have a left child, create a new node and add the value
            
            node->leftChild = (bstnode_t*) malloc(sizeof(bstnode_t));
            if(node->leftChild == NULL) //if malloc fails return -1
                return -1;
            node->leftChild->data = new_value;
            node->leftChild->leftChild = NULL;
            node->leftChild->rightChild = NULL;
            return 1;
            
        }
        
        else{
            return add_node(node->leftChild, new_value);
        }
        
    }
    else{
        
        if(node->rightChild == NULL){  // if the current node doesnt have a right child, create a new node and add the value
            
            node->rightChild = (bstnode_t*) malloc(sizeof(bstnode_t));
            if(node->rightChild == NULL) //if malloc fails return -1
                return -1;
            node->rightChild->data = new_value;
            node->rightChild->leftChild = NULL;
            node->rightChild->rightChild = NULL;
            return 1;
            
        }
        else{
            return add_node(node->rightChild, new_value);
        }
        
    }
}

// Adds a new node containng item to the BST
// The item is added in the correct position in the BST.
//  - If the data is less than or equal to the current node we traverse left
//  - otherwise we traverse right.
// The bst_function returns '1' upon success
//  - bst_add should increment the 'size' of our BST.
// Returns a -1 if the operation fails.
//      (i.e. the memory allocation for a new node failed).
// Your implementation should should run in O(log(n)) time.
//  - A recursive imlementation is suggested.
int bst_add(bst_t* t, int item){
    if(t == NULL)
        return -1;
    
    if(t->root == NULL){// if the root node is empty
        t->root = (bstnode_t*) malloc(sizeof(bstnode_t));
        if(t->root == NULL)
            return -1;
        
        t->root->data = item;
        t->root->leftChild = NULL;
        t->root->rightChild = NULL;
        t->size++;
        return 1;
    }
    
    if(add_node(t->root, item) == 1){
        t->size++;
        return 1;
    }
    return -1;
}


// Helper function to print the tree in ascending order;
void bfs_asc(bstnode_t* node){
    if(node == NULL)
        return;
    bfs_asc(node->leftChild);
    printf("%d ",node->data);
    bfs_asc(node->rightChild);
}


// Helper function to print the tree in descending order;
void bfs_des(bstnode_t* node){
    if(node == NULL)
        return;
    bfs_des(node->rightChild);
    printf("%d ",node->data);
    bfs_des(node->leftChild);
}


// Prints the tree in ascending order if order = 0, otherwise prints in descending order.
// For NULL tree -- print "(NULL)".
// It should run in O(n) time.
void bst_print(bst_t *t, int order){
    if(NULL == t){
        printf("(NULL)");
        return;
    }
    if(order){ // descending order
        bfs_des(t->root);
        printf("\n");
    }
    else{ // ascending order
        bfs_asc(t->root);
        printf("\n");
    }
}


int node_sum(bstnode_t* node){
    if(node == NULL)
        return 0;
    
    return node->data + node_sum(node->leftChild) + node_sum(node->rightChild);
}


// Returns the sum of all the nodes in the bst.
// exits the program for a NULL tree.
// It should run in O(n) time.
int bst_sum(bst_t *t){
    if(t == NULL)
        exit(1);
    
    return node_sum(t->root);
}

// Helper method to find the node
int find_node(bstnode_t* node, int val){
    if(node == NULL)
        return 0;
    if(node->data == val){
        return 1;
    }
    
    return find_node(node->leftChild, val) + find_node(node->rightChild, val);
}


// Returns 1 if value is found in the tree, 0 otherwise.
// For NULL tree it exists the program.
// It should run in O(log(n)) time.
int bst_find(bst_t * t, int value){
    if(t == NULL)
        exit(1);
    
    return find_node(t->root, value);
}

// Returns the size of the BST
// A BST that is NULL exits the program.
// (i.e. A NULL BST cannot return the size)
unsigned int bst_size(bst_t* t){
    if(t == NULL)
        exit(1);
    
    return t->size;
}


// Helper method to free the BST Memory
void free_node(bstnode_t* node){
    if(node ==  NULL){
        return;
    }
    free_node(node->leftChild);
    free_node(node->rightChild);
    free(node);
}


// Free BST
// Removes a BST and ALL of its elements from memory.
// This should be called before the proram terminates.
void bst_free(bst_t* t){
    free_node(t->root);
    free(t);
}
