// =================== Support Code =================
// Graph.
//
//
//
// - Implement each of the functions to create a working graph.
// - Do not change any of the function declarations
//   - (i.e. graph_t* create_graph() should not have additional arguments)
// - You should not have any 'printf' statements in your graph functions.
//   - (You may consider using these printf statements to debug, but they should be removed from your final version)
// ==================================================
#ifndef MYGRAPH_H
#define MYGRAPH_H

#include "my_dll.h"
#include <stdlib.h>
#include <assert.h>
// Create a graph data structure
typedef struct graph{
    int numNodes;
    int numEdges;
    dll_t* nodes;     //an array of nodes storing all of our nodes.
}graph_t;

typedef struct graph_node{
    int data;
    int visited;
    dll_t* inNeighbors;
    dll_t* outNeighbors;
}graph_node_t;

// Creates a graph
// Returns a pointer to a newly created graph.
// The graph should be initialized with data on the heap.
// The graph fields should also be initialized to default values.
// Returns NULL if we cannot allocate memory.
graph_t* create_graph(){
    // Modify the body of this function as needed.
    graph_t* myGraph= (graph_t*) malloc(sizeof(graph_t));
    if(myGraph == NULL) return NULL;

    myGraph->nodes = create_dll();

    if(myGraph->nodes == NULL) return NULL;

    myGraph->numEdges = 0;
    myGraph->numNodes = 0;
    return myGraph;
}

// Returns the node pointer if the node exists.
// Returns NULL if the node doesn't exist or the graph is NULL
graph_node_t* find_node(graph_t* g, int value){
    if(g == NULL) return NULL;

    if(g->numNodes == 0) return NULL;

    node_t* temp = g->nodes->head;
    graph_node_t* g_node = temp->data;
    while(temp != NULL){
        g_node = temp->data;
        if(g_node->data == value)
            return g_node;
        temp = temp->next;
    }

    return NULL;
}

// Creates a graph node
// Note: This relies on your dll implementation.
graph_node_t* create_graph_node(int value){
    graph_node_t* graph_node = malloc(sizeof(graph_node_t));

    if ( graph_node == NULL ) return NULL;

    graph_node->data = value;
    graph_node->inNeighbors = create_dll();
    if(graph_node->inNeighbors == NULL) return NULL;
    graph_node->outNeighbors = create_dll();
    if(graph_node->outNeighbors == NULL) return NULL;
    graph_node->visited = 0;

    return graph_node;
}

// Returns 1 on success
// Returns 0 on failure ( or if the node already exists )
// Returns -1 if the graph is NULL.
int graph_add_node(graph_t* g, int value){
    if ( g == NULL ) return -1;

    if (find_node(g, value) != NULL) return -1;

    graph_node_t * newNode = create_graph_node(value);
    if ( newNode == NULL ) return -1;

    assert(g->nodes);
    dll_push_back(g->nodes, newNode);
    g->numNodes++;

    return 1;
}

// Returns 1 on success
// Returns 0 on failure ( or if the source or destination nodes don't exist )
// Returns -1 if the graph is NULL.
int contains_edge(graph_t * g, int source, int destintaion){
    if(g == NULL) return -1;

    graph_node_t* src = find_node(g, source);
    if(src == NULL) return 0;
    graph_node_t* dst = find_node(g, destintaion);
    if(dst == NULL) return 0;

    if(dll_index_of(src->outNeighbors, dst) != -1)
        return 1;
    else
        return 0;
}

// Returns dll_t* of all the in neighbors of this node.
// Returns NULL if thte node doesn't exist or if the graph is NULL.
dll_t* getInNeighbors( graph_t * g, int value ){
    graph_node_t* graph_node = find_node(g, value);
    if(graph_node == NULL) return NULL;

    return graph_node->inNeighbors;
}

// Returns dll_t* of all the out neighbors of this node.
// Returns NULL if thte node doesn't exist or if the graph is NULL.
dll_t* getOutNeighbors( graph_t * g, int value ){
    graph_node_t* node = find_node(g, value);
    if(node == NULL) return NULL;

    return node->outNeighbors;
}

// Returns 1 on success
// Returns 0 on failure ( or if the node doesn't exist )
// Returns -1 if the graph is NULL.
int graph_remove_node(graph_t* g, int value){
    // The function removes the node from the graph along with any edges associated with it.
    if(g == NULL) return -1;
    graph_node_t* src = find_node(g, value);
    if(src == NULL) return 0;

    node_t* node = g->nodes->head;
    graph_node_t* graph_node = node->data;
    while(node != NULL){
        graph_node = node->data;
        int indexIn = dll_index_of(getInNeighbors(g,graph_node->data), src);
        int indexOut = dll_index_of(getOutNeighbors(g,graph_node->data), src);
        if(indexIn != -1){
            dll_remove(getInNeighbors(g,graph_node->data), indexIn);
            g->numEdges--;
        }
        if(indexOut != -1){
            dll_remove(getInNeighbors(g,graph_node->data), indexOut);
            g->numEdges--;
        }

        node = node->next;
    }

    int nodeIndex = dll_index_of(g->nodes, src);
    free_dll(src->inNeighbors);
    free_dll(src->outNeighbors);
    free(src);
    dll_remove(g->nodes, nodeIndex);
    g->numNodes--;
    // That is, this node would have to be removed from all the in and out neighbor's lists that countain it.
    return -1;
}

// Returns 1 on success
// Returns 0 on failure ( or if the source or destination nodes don't exist, or the edge already exists )
// Returns -1 if the graph is NULL.
int graph_add_edge(graph_t * g, int source, int destination){
    // The function adds an edge from source to destination but not the other way.
    // Make sure you are not adding the same edge multiple times.
    // Make sure you modify the in and out neighbors appropriatelly. destination will be an out neighbor of source.
    // Source will be an in neighbor of destination.
    if(g == NULL) return -1;

    graph_node_t* src = find_node(g, source);
    if(src == NULL) return 0;
    graph_node_t* dst = find_node(g, destination);
    if(dst == NULL) return 0;

    if(contains_edge(g, source, destination) != 0) return 0;

    dll_push_back(src->outNeighbors, dst);
    dll_push_back(dst->inNeighbors, src);
    g->numEdges++;

    return 1;
}

// Returns 1 on success
// Returns 0 on failure ( or if the source or destination nodes don't exist, or the edge doesn't exists )
// Returns -1 if the graph is NULL.
int graph_remove_edge(graph_t * g, int source, int destination){
    //The function removes an edge from source to destination but not the other way.
    //Make sure you remove destination from the out neighbors of source.
    //Make sure you remove source from the in neighbors of destination.
    if(g == NULL) return -1;
    if(contains_edge(g, source, destination) == 0) return 0;

    graph_node_t* src = find_node(g, source);
    graph_node_t* dst = find_node(g, destination);

    dll_remove(src->outNeighbors, dll_index_of(src->outNeighbors,dst));
    dll_remove(dst->inNeighbors, dll_index_of(dst->inNeighbors,src));
    g->numEdges--;
    return 1;
}

// Returns the number of in neighbors of this node.
// Returns -1 if the graph is NULL or the node doesn't exist.
int getNumInNeighbors( graph_t * g, int value){
    if(g == NULL) return -1;
    graph_node_t* graph_node = find_node(g, value);
    if(graph_node == NULL) return -1;

    return graph_node->inNeighbors->count;
}


// Returns the number of out neighbors of this node.
// Returns -1 if the graph is NULL or the node doesn't exist.
int getNumOutNeighbors( graph_t * g, int value){
    if(g == NULL) return -1;
    graph_node_t* graph_node = find_node(g, value);
    if(graph_node == NULL) return -1;

    return graph_node->outNeighbors->count;
}

// Returns the number of nodes in the graph
// Returns -1 if the graph is NULL.
int graph_num_nodes(graph_t* g){
    if(g == NULL) return -1;
    return g->numNodes;
}

// Returns the number of edges in the graph,
// Returns -1 on if the graph is NULL
int graph_num_edges(graph_t* g){
    if(g == NULL) return -1;
    return g->numEdges;
}


// helper fucntion to print a list
void dll_print_list(dll_t* t){
    if(t == NULL || t->count == 0){
        printf("[ EMPTY ] \n");
        return;
    }
    printf("[ ");
    node_t* node = t->head;
    graph_node_t* graph_node = node->data;
    while(node != NULL){
        graph_node = node->data;
        printf("%d ", graph_node->data);
        node = node->next;
    }
    printf("]\n");
}

// Free graph
// Removes a graph and ALL of its elements from memory.
// This should be called before the program terminates.
// Make sure you free all the dll's too.
void free_graph(graph_t* g){
    node_t* temp = g->nodes->head;
    graph_node_t* temp_graph = temp->data;

    while(temp != NULL && g->nodes->count != 0) {
        temp_graph = temp->data;

        free_dll(temp_graph->inNeighbors);

        free_dll(temp_graph->outNeighbors);

        free(temp_graph);
        temp = temp->next;
    }
    free_dll(g->nodes);
    free(g);
}

// helper function to reset vistited param of all the graph nodes.
void reset_visited(graph_t* g){
    node_t* node = g->nodes->head;
    while(node != NULL){
        graph_node_t* g_node = node->data;
        g_node->visited =0;
        node= node->next;
    }
}

// returns 1 if we can reach the destination from source
// returns 0 if it is not reachable
// returns -1 if the graph is NULL (using BFS)
int is_reachable(graph_t * g, int source, int dest){
    if(g == NULL) return -1;

    reset_visited(g);

    dll_t* list = create_dll();
    graph_node_t* dst = find_node(g, dest);
    graph_node_t* src = find_node(g, source);
    dll_push_back(list, src); // adding the node to a list
    int distance = 0; // the number of nodes traversed

    while(!dll_empty(list)){
        graph_node_t* curr_graph_node = dll_pop_front(list); // pop the first node
        if(curr_graph_node == dst && distance != 0){ // if the nodes are equal and the number of nodes traversed is not 0
            return 1;
        }
        node_t* itr = curr_graph_node->outNeighbors->head;
        while(itr!= NULL){  // add all the out neighbor nodes which are not visited to the list
            graph_node_t* curr_node = itr->data;
            if(curr_node->visited != 1) {
                dll_push_back(list, curr_node);
                curr_node->visited = 1;
            }
            itr = itr->next;
        }
        distance++;
    }
    return 0; // when the list becomes empty and we didnt reach the destination return 0
}

// returns 1 if there is a cycle in the graph
// returns 0 if no cycles exist in the graph
// returns -1 if the graph is NULL
// You may use either BFS or DFS to complete this task.
int has_cycle(graph_t * g){
    // check if each node can reach itself, if true then there is a cycle else no cycle
    if(g == NULL) return -1;
    node_t* node = g->nodes->head;
    graph_node_t* g_node;
    int res;
    while(node != NULL){
        g_node = node->data;
        res = is_reachable(g, g_node->data, g_node->data);
        if(res){
            return 1;
        }
        node = node->next;
    }

    return 0;
}


int dfs(graph_node_t* src, graph_node_t* dst, dll_t* path, graph_t* g);
// prints any path from source to destination if there
// exists a path from the source to the destination.
// Note: Consider using one of the other functions to help you
//       determine if a path exists first
// (Choose either BFS or DFS, typically DFS is much simpler)
//
// Returns 1 if there is a path from source to destination
// Returns 0 if there is not a path from a source to destination
// Returns -1 if the graph is NULL
int print_path(graph_t * g, int source, int dest){
    if(g == NULL) return -1;
    if(is_reachable(g, source, dest) == 0) return 0;

    reset_visited(g);
    dll_t* list = create_dll();
    graph_node_t* dst = find_node(g, dest);
    graph_node_t* src = find_node(g, source);
    dfs(src, dst, list, g);

    dll_print_list(list);

    return 1;
}

// Recursive function to print the path from source to destination
int dfs(graph_node_t* source, graph_node_t* destination, dll_t* path, graph_t* g) {
    dll_push_back(path, source); // push the node into the list

    if(source->data == destination->data){ // base case to check if the node is equal to destination
        return 1;
    }
    if(source->outNeighbors->count == 0) return 0; // if the node desnt have any out neighbours return
    node_t* node = source->outNeighbors->head;
    graph_node_t* g_node;
    int res = 0;
    while(node != NULL){ // recursively check if each node has a path to destination
        g_node = node->data;
        if(!g_node->visited){
            res = dfs(g_node, destination, path, g);
            g_node->visited = 1;
        }
        if(res == 1){
            return 1;
        }
        else{
            dll_remove(path, dll_index_of(path, g_node)); // if there's no path then remove the node from the path list
        }
        node = node->next; // check the next node in neighbour list
    }
    return 0;
}


#endif


