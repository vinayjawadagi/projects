// Modify this file
// compile with: gcc linkedlist.c -o linkedlist

#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    struct node* next;
    int year;
    int wins;
}node_t;

node_t* create_list(){
    node_t* node2018 = (node_t*) malloc(sizeof(node_t));
    node2018->year = 2018;
    node2018->wins = 108;
    node_t* node2017 = (node_t*) malloc(sizeof(node_t));
    node2017->year = 2017;
    node2017->wins = 93;
    node_t* node2016 = (node_t*) malloc(sizeof(node_t));
    node2016->year = 2016;
    node2016->wins = 93;
    node_t* node2015 = (node_t*) malloc(sizeof(node_t));
    node2015->year = 2015;
    node2015->wins = 78;
    node_t* node2014 = (node_t*) malloc(sizeof(node_t));
    node2014->year = 2014;
    node2014->wins = 71;

    node2018->next = node2017;
    node2017->next = node2016;
    node2016->next = node2015;
    node2015->next = node2014;
    node2014->next = NULL;
    
    return node2018;
}

void print_list(node_t* head){
    while(head != NULL){
        printf("%d, %d wins\n",head->year, head-> wins);
        head = head->next;
    }
}

void free_list(node_t* head){
    node_t* temp;
    while(head != NULL){
        temp = head;
	head = head->next;
        free(temp);
    }
}

int main() {
	node_t* new_node = create_list();
	print_list(new_node);
	free_list(new_node);
	return 0;
}

