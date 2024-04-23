# Exercises

Discuss and answer the following questions (Make sure to elaborate and justify your responses):

1. What is the Big-O space complexity of an adjacency list?
1. What is the Big-O space complexity of an adjacency matrix?
3. What is the Big-O to search an entire graph using Depth-First Search (DFS)?
4. What is the Big-O to search an entire graph using Breadh-First Search (BFS)?

## Answers

1. *The space complexity of an adjacency list representation for a graph depends on the number of Nodes (N) and edges (E) in the graph. In the worst case, where the graph is dense and every Node is connected to every other Node, the space complexity can be O(N^2).*
2. *The space complexity of an adjacency matrix representation for a graph is O(N^2), where N is the number of nodes.*
3. *The time complexity to search a graph using DFS depends on the number of Nodes (N) and edges (E) in the graph.Considering we mark each node that we visit in the worst case, the time complexity is O(N + E), where N is the number of Nodes and E is the number of edges.*
4. *The time complexity to search a graph using BFS depends on the number of Nodes (N) and edges (E) in the graph just like DFS. Considering we mark each node that we visit in the worst case, the time complexity is O(N + E), where N is the number of Nodes and E is the number of edges. The only difference bw BFS and DFS is that we visit the nodes by level in BFS and we visit the nodes by depth in DFS.*


## Interview Prep (Optional +1% Bonus on assignment)

> **Rules** 
> 
> This is for bonus--and you may not ask TA's, Professors, or anyone about the question until after the homework is due.
> 
> Stratigically, you should not attempt this problem until you complete the rest of the homework (1% is less than 100% :) )

A bit ago a student asked me about this course, CS 5800, and other courses and how they may prepare you for interviews. I was recently talking to a Google, now Microsoft Engineer who told me that the reality is having a lot of LeetCode practice will help. LeetCode is a website to practice solving algorithmic challenges.

Let's finish off this exercise with a small C programming sample.

### Clone Graph

Solve the following: https://leetcode.com/problems/clone-graph/

**Copy and paste your code into** a file in this directory called [challenge.c](./challenge.c) that solves the following problem.

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
