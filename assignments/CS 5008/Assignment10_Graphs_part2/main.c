// Compile this assignment with: gcc main.c -o main
//
// Include parts of the C Standard Library
// These have been written by some other really
// smart engineers.
#include <stdio.h>  // For IO operations
#include <stdlib.h> // for malloc/free

// Our library that we have written.
// Also, by a really smart engineer!
#include "my_graph.h"
// Note that we are locating this file
// within the same directory, so we use quotations
// and provide the path to this file which is within
// our current directory.

int main(int argc, const char * argv[]) {
    graph_t * g = create_graph();
    graph_add_node(g, 1);
    graph_add_node(g, 2);
    graph_add_node(g, 3);
    graph_add_node(g, 4);
    graph_add_node(g, 5);
    graph_add_node(g, 6);
    //graph_add_edge(g, 1, 2);
    //graph_remove_edge(g, 1, 2);
//    graph_remove_node(g, 2);
//    printf("%p \n", find_node(g, 1));
//    printf("%p \n", find_node(g, 2));
//    printf("%p \n", find_node(g, 3));
//    printf("%d \n",getNumInNeighbors(g, 2));
//    printf("%d \n",getNumInNeighbors(g, 3));
    graph_add_edge(g, 1, 5);
    graph_add_edge(g, 2, 1);
    graph_add_edge(g, 2, 5);
    graph_add_edge(g, 3, 1);
    graph_add_edge(g, 3, 4);
    graph_add_edge(g, 5, 4);
    graph_add_edge(g, 5, 6);
    graph_add_edge(g, 6, 4);
    graph_add_edge(g, 6, 3);
    
//    printf("%d \n" ,contains_edge(g, 5, 1));
//    printf("%d \n" ,contains_edge(g, 2, 1));
//    printf("%d \n" ,contains_edge(g, 2, 5));
//    printf("%d \n" ,contains_edge(g, 3, 1));
//    printf("%d \n" ,contains_edge(g, 3, 4));
//    printf("%d \n" ,contains_edge(g, 5, 4));
//    printf("%d \n" ,contains_edge(g, 5, 6));
//    printf("%d \n" ,contains_edge(g, 6, 4));
//    printf("%d \n" ,contains_edge(g, 6, 3));
//    dll_print_list(getInNeighbors(g, 2));
//    dll_print_list(getOutNeighbors(g, 2));
    
//    printf(" in 1: %d\n", getNumInNeighbors(g, 1));
//    printf(" in 2: %d\n", getNumInNeighbors(g, 2));
//    printf(" in 3: %d\n", getNumInNeighbors(g, 3));
//    printf(" in 4: %d\n", getNumInNeighbors(g, 4));
//    printf(" in 5: %d\n", getNumInNeighbors(g, 5));
//    printf(" in 6: %d\n", getNumInNeighbors(g, 6));
//
//    printf(" out 1: %d\n", getNumOutNeighbors(g, 1));
//    printf(" out 2: %d\n", getNumOutNeighbors(g, 2));
//    printf(" out 3: %d\n", getNumOutNeighbors(g, 3));
//    printf(" out 4: %d\n", getNumOutNeighbors(g, 4));
//    printf(" out 5: %d\n", getNumOutNeighbors(g, 5));
//    printf(" out 6: %d\n", getNumOutNeighbors(g, 6));
    
//    graph_remove_edge(g, 1, 5);
//    graph_remove_edge(g, 2, 1);
//    graph_remove_edge(g, 2, 5);
//    graph_remove_edge(g, 3, 1);
//    graph_remove_edge(g, 3, 4);
//    graph_remove_edge(g, 5, 4);
//    graph_remove_edge(g, 5, 6);
//    graph_remove_edge(g, 6, 4);
//    graph_remove_edge(g, 6, 3);
    
    
//    printf("%d \n" ,contains_edge(g, 1, 5));
//    printf("%d \n" ,contains_edge(g, 2, 1));
//    printf("%d \n" ,contains_edge(g, 2, 5));
//    printf("%d \n" ,contains_edge(g, 3, 1));
//    printf("%d \n" ,contains_edge(g, 3, 4));
//    printf("%d \n" ,contains_edge(g, 5, 4));
//    printf("%d \n" ,contains_edge(g, 5, 6));
//    printf("%d \n" ,contains_edge(g, 6, 4));
//    printf("%d \n" ,contains_edge(g, 6, 3));
//    dll_print_list(getInNeighbors(g, 1));
//    dll_print_list(getOutNeighbors(g, 1));
    
//    printf(" in 1 : %d\n", getNumInNeighbors(g, 1));
//    printf(" in 2: %d\n", getNumInNeighbors(g, 2));
//    printf(" in 3: %d\n", getNumInNeighbors(g, 3));
//    printf(" in 4: %d\n", getNumInNeighbors(g, 4));
//    printf(" in 5: %d\n", getNumInNeighbors(g, 5));
//    printf(" in 6: %d\n", getNumInNeighbors(g, 6));
//
//    printf(" out 1: %d\n", getNumOutNeighbors(g, 1));
//    printf(" out 2: %d\n", getNumOutNeighbors(g, 2));
//    printf(" out 3: %d\n", getNumOutNeighbors(g, 3));
//    printf(" out 4: %d\n", getNumOutNeighbors(g, 4));
//    printf(" out 5: %d\n", getNumOutNeighbors(g, 5));
//    printf(" out 6: %d\n", getNumOutNeighbors(g, 6));
    
//    graph_remove_node(g, 1);
//    graph_remove_node(g, 2);
//    graph_remove_node(g, 3);
//    graph_remove_node(g, 4);
//    graph_remove_node(g, 5);
//    graph_remove_node(g, 6);
//
//    printf("%d \n",getNumInNeighbors(g, 2));
//    printf("%d \n",getNumInNeighbors(g, 3));
    
    printf("%d \n",is_reachable(g, 3, 6));
    printf("%d \n",is_reachable(g, 1, 3));
    printf("%d \n",is_reachable(g, 1, 2));
    printf("%d \n",is_reachable(g, 1, 1));
    printf("%d \n",is_reachable(g, 1, 2));
    printf("%d \n",is_reachable(g, 1, 3));
    printf("%d \n",is_reachable(g, 1, 4));
    printf("%d \n",is_reachable(g, 1, 5));
    printf("%d \n",is_reachable(g, 1, 6));
    printf("\n");
    printf("%d \n",is_reachable(g, 4, 1));
    printf("%d \n",is_reachable(g, 4, 2));
    printf("%d \n",is_reachable(g, 4, 3));
    printf("%d \n",is_reachable(g, 4, 4));
    printf("%d \n",is_reachable(g, 4, 5));
    printf("%d \n",is_reachable(g, 4, 6));
    printf("1: %d \n",is_reachable(g, 1, 1));
    printf("2: %d \n",is_reachable(g, 2, 2));
    printf("3: %d \n",is_reachable(g, 3, 3));
    printf("4: %d \n",is_reachable(g, 4, 4));
    printf("5: %d \n",is_reachable(g, 5, 5));
    printf("6: %d \n",is_reachable(g, 6, 6));
    
    printf("%d \n",has_cycle(g));
    
    print_path(g, 3, 6);
    printf("%d \n",print_path(g, 2, 3));
    printf("total nodes:%d\n", graph_num_nodes(g));
    printf("total edges:%d\n", graph_num_edges(g));
    
    free_graph(g);
    return 0;
}
