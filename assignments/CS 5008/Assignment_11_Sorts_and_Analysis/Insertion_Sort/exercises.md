# Exercises

Discuss and answer the following questions (Please make sure to elaborate and justify your responses):

1. Explain what do you think the Big-Oh (worst-case) complexity of this algorithm is? Why?
2. What do you think the best-case complexity of this algorithm is?
   - Provide an example of an array of elements that fit the best-case.
3. Does insertion sort require any additional storage beyond the original array? Explain why or why not.
4. What is a 'stable sorting' algorithm? Is insertion sort a 'stable' algorithm, why or why not?

## Answers:

1. *the worst-case time complexity of Insertion Sort is when the input array is in reverse order, O(n^2), where 'n' is the number of elements in the array. Each element must be compared and moved to the start of the sorted part of the array.*
2. *The best-case time complexity of Insertion Sort is O(n) when the input array is already sorted. In this case, we only need to perform comparisons since each element is already in its correct position. example: [1,2,3,4,5,6]*
3. *Since Insertion sort is an inplace sorting algorithm, meaning the original array itself is modifled to sort, no additional data structures are needed apart from a few variables to keep track of indices and values during the sorting process.*
4. *A stable sorting algorithm the one where the order of equal elements are preserved. For exapmple if we take this array where x1 is the same as x2 equals to 0,
[1,2,x1,-1,-3,x2]
A stable algorithm would osrt it such that x1 is always before x2, maintaining thier previos order. i.e after sorting
[-3,-1,x1,x2,1,2].
Insertion sort is a stable algorithm since, when two elements are equal we do not swap them if they are already in the correct order.*
