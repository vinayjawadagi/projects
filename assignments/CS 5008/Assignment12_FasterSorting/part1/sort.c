// Task: Implement the 'sortIntegers' function below

// =================== Libraries ==================
#include <stdio.h> // Include file for standart input/output

// =============== Helper Functions ===============

// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
void merge(int array[], int l, int m, int r) {
    int l_len = m - l + 1;
    int r_len = r - m;

    // left and right subarrays
    int left[l_len];
    int right[r_len];

    int i;
    int j;
    
    // copy original array to left and right subarrays
    for (i = 0; i < l_len; i++)
        left[i] = array[l + i];
    for (j = 0; j < r_len; j++)
        right[j] = array[m + 1 + j];

    i = 0;
    j = 0;
    int k = l;
    // merge the sorted arrays back into original array
    while (i < l_len && j < r_len) {
        if (left[i] <= right[j]) {
            array[k] = left[i];
            i++;
        } else {
            array[k] = right[j];
            j++;
        }
        k++;
    }

    // copy the remaining elements of left subarray if there are any
    while (i < l_len) {
        array[k] = left[i];
        i++;
        k++;
    }

    // copy the remaining elements of right subarray if there are any
    while (j < r_len) {
        array[k] = right[j];
        j++;
        k++;
    }
}

// Implement your mergeSort function here
// TODO:
void mergeSort(int array[], int l, int r) {
    if (l == r)
        return;
    
    int m = (l + r) / 2;

    mergeSort(array, l, m);
    mergeSort(array, m + 1, r);

    // merge the sorted sub arrays
    merge(array, l, m, r);
}

// Provided below is a sort function. We have also
// provided a template for how to document functions
// to help organize your code.
// Name: sortIntegers
// Input(s):
//          (1) 'array' is a pointer to an integer address.
//              This is the start of some 'contiguous block of memory' that we will sort.
//          (2) 'size' tells us how big the array of data is we are sorting.
// Output: No value is returned, but 'array' should be modified to store a sorted array of numbers.
void sortIntegers(int* array, unsigned int size){
    // TODO: make a call to your mergeSort function here
    mergeSort(array, 0, size - 1);
}


// Input: A pointer to an array (i.e. the array itself points to the first index)
//        The size of the array (Because we do not know how big the array is automatically)
void printIntArray(int* array, unsigned int size){
  unsigned int i; // Note: 'unsigned int' is a datatype for storing positive integers.
  for(i = 0; i < size; i=i+1){
    printf("%d ",array[i]);
  }
  printf("\n");
}

int main(){
  
  // Some test data sets.
  int dataset1[] = {0,1,2,3,4,5,6,7,8,9,10};
  int dataset2[] = {10,9,8,7,6,5,4,3,2,1,0};
  int dataset3[] = {0,3,2,1,4,7,6,5,8,9,10};
  int dataset4[] = {2,1,1,1,1,1,1,1,1,1,1};
  int dataset5[] = {100,201,52,3223,24,55,623,75,8523,-9,150};
  int dataset6[] = {-1,1,2,-3,4,5,-6,7,8,-9,10};
  
  // Sort our integer array
  sortIntegers(dataset1, 11);
  sortIntegers(dataset2, 11);
  sortIntegers(dataset3, 11);
  sortIntegers(dataset4, 11);
  sortIntegers(dataset5, 11);
  sortIntegers(dataset6, 11);
  
  // Print out an array
  printIntArray(dataset1, 11);
  printIntArray(dataset2, 11);
  printIntArray(dataset3, 11);
  printIntArray(dataset4, 11);
  printIntArray(dataset5, 11);
  printIntArray(dataset6, 11);
  
  return 0;
}
