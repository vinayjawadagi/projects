**Instructions** 

- Discuss and answer the following questions (Make sure to elaborate and justify your responses):
- If you would like to hand write or draw your answers, then scan or take a picture of a file called exercises.pdf or exercises.png and put it in this directory.


# Exercises

1. Explain: What do you think the Big-O (worst-case) complexity of the merge sort algorithm is and why? 

*The worst-case scenario for merge sort occurs when the array is in reverse order or nearly in reverse order which is O(NlogN) where N is the number of elements in the array. In that case, each element needs to be compared and moved multiple times during the merging process, each subarray has to be reversed and merged till we reach the sorted array.*

2. Explain: What do you think the best-case complexity of the merge sort algorithm is and why?

*The best-case scenario for merge sort is when the array is already sorted, but the time complexity is the same as worst case that is O(nlogn). This is because, even though the array is sorted we are still splitting the array logn times and the merge function even though it doesnt move the values, it still compares the sub arrays. So the splitting process takes O(logn) time and the merging also takes O(n) time. which is why merge sort's time complexity in it's best case scenario is also O(nlogn) *

3. Does merge sort require any additional storage beyond the original array? If so how much and why?

*Merge sort is not an in-place sorting algorithm it requires additional space during the 'merging' process. When we are merging the subarrays we copy the left and right sub array into a temporary arrays. As we comapre the left and right subarrays we copy the values to the original array.
Merge sort requires O(N) extra space where N is the number of elements in the array. This is because we create two arrays of the size of the sub array that we are merging. So in total we use the space equivalent to an array of length N. This value scales linearly with the number of elements in the array so the space complexity of merge sort is O(N).*

4. How much time in Big-O does it take to merge all of the subarrays together? Explain or draw why?

*The merge function takes two sorted subarrays and combines them into a single sorted array. The merging process involves comparing elements from the two subarrays and placing them in sorted order in a temporary array. Consider an array of length 4:
array = [38, 27, 43, 3]
This array is split into the following each line is an iteration:
  [38,27,43,3]     
[38, 27] [43, 3] 
[38] [27] [43] [3]
when we merge ([38, 27] [43, 3]) each element is compared once so the number of comarisions are 4.
so similarly if we had an array of n elements, we would make a total of n compraisions.
so it takes O(N) time to merge all the sub arrays.
*
