# Exercises

Discuss and answer the following questions (Make sure to elaborate and justify your responses):

1. What does it mean if a binary search tree is a 'balanced tree'?
2. What is the Big-O search time for a balanced binary search tree? (You may assume the binary tree is perfectly balanced and full).
3. Now think about a binary search tree in general, and that it is basically a linked list with up to two paths from each node. Could a binary search tree ever exhibit an O(n) worse-case search time? Explain why or why not. It may be helpful to think of an example of operations that could exhibit worse-case behavior if you believe so.
4. What is the recurrence relation for a binary search?
	- Note: Your answer should be in the form of: T(N) = aT(N/b) + f(n) (i.e. determine what 'a' 'b' and 'f(n)' are).

## Answers

1. *A balanced binary tree is a type of binary tree in which the height of the left and right subtrees of any node differs by at most one.*
2. *In a perfectly balanced and full binary search tree the search time has a big O time complexity of O(log n), where n is the number of nodes in the tree, because in each iteration the data is reduced to half which works just like binary search.*
3. *Yes binary search tree can exhibit O(n) worst case scenario when the BST is not balanced, for example if the bst is completely skewed i.e. it basically becomes a linked list and the worst case scenaio for search is O(n).*
4. *T(N) Represents the time required to  search an element using binary search. 'a' represent the number of time we have to split the array in half when we comapre the middle element of the sub-array. the value of 'b' in out case would be 2 since we are splitting the array in half, the time required to search the subarray would be half the time. and f(n) would be O(1) which is the time required to compare the middle element with the search element. so the reccurence realtion would be:
T(N) = aT(N/2) + O(1)  *



## Interview Prep (Optional +1% Bonus on assignment)

> **Rules** 
> 
> This is for bonus--and you may not ask TA's, Professors, or anyone about the question until after the homework is due.
> 
> Stratigically, you should not attempt this problem until you complete the rest of the homework (1% is less than 100% :) )

A bit ago a student asked me about this course, CS 5800, and other courses and how they may prepare you for interviews. I was recently talking to a Google, now Microsoft Engineer who told me that the reality is having a lot of LeetCode practice will help. LeetCode is a website to practice solving algorithmic challenges.

Let's finish off this exercise with a small C programming sample.

###

Solve the following: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

**Copy and paste your code into** a file in this directory called [challenge.c](./challenge.c) that solves the following problem.

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

* The left subtree of a node contains only nodes with keys less than the node's key.
* The right subtree of a node contains only nodes with keys greater than the node's key.
* Both the left and right subtrees must also be binary search trees.
* Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/

### Constraints:

* The number of nodes in the tree is in the range [1, 100].
* 0 <= Node.val <= 100
* All the values in the tree are unique.
* root is guaranteed to be a valid binary search tree.

### Example 1

> Input: root = [1,0,2]
>
> Output: [3,3,2]

### Example 2

> Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
> 
> Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

### Example 3

> Input: root = [0,null,1]
> 
> Output: [1,null,1]
