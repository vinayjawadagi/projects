# Exercises

1. What do you think the Big-O (worst-case) complexity of this algorithm is? 
2. What do you think the best-case complexity of this algorithm is? 
	- Note-- assume you do not have any information about if the array is already sorted or not.
3. Does selection sort require any additional storage beyond the original array? 
	- i.e. Did you have to allocate any extra memory to perform the sort?
5. Would the Big-O complexity change if we used a linked list instead of an array?

## Answers:

1. *the big o of selection sort is O(N^2), since we loop thru all the elements in the outer loop and in the inner loop we find the minimum element.*
2. *the best case would also be O(N^2) since we will still be finidng the minimum element in each iteration.*
3. *Selection sort has space complexity of O(1) since we dont need an additional array to store the sorted array, while we do use some variables to store intermediate values it remains constant regardless of the size of the array.*
4. *The time complexity would still remain O(N^2) in the worst case, since we would just be replacing the swap funciton to swap the data of the nodes and finding the munimum value would also take O(N).*
