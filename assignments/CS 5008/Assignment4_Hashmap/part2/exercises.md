# Exercises

Discuss and answer the following questions (Make sure to elaborate and justify your responses):

1. How good is the provided hash function--are we really getting constant time operations with our hashmap?
2. What is one other way you could implement the hash function? Anything creative is acceptable in this answer.
3. If I have to resize the hashmap to add more buckets, what is th Big-O complexity?
4. What is 'open addressing' in regards to hash maps and hash tables?

## Answers:

1. The hash function that we are using may not be the best choice. Since it mainly depends on the the string length and bucket size, if we consider bucket size as constant and vary the string length, we can expect a lot of collisons in case the string legnths are equal. we also wont be utilizing the entire array or we might end uo with an array thats crowded at a certain range of the array. consider the case, we are storing name as key and score as value. if we have a bucket size of 50 and considering that names are on average 4-10 characters, due to frequent collisions we would end up with an array that has values concentrated in indexes 3 to 9 and we'll be getting a lot of collisions. this way wont likely get constant time operations. but depending on the situations this hash function might be a good hash fucntion, like if we know that keys wont have the same string length this would be an ideal hash function. 

2. an alternative to the hash function that we used: 

int hashfunction(char* key) {

    int hash_value = 0;
    int i = 0;
    while (key[i] != '\0') {
        hash_value = (hash_value * Math.pow(i,i)) + key[i];
        i++;
    }
    return hash_value % bucket_size;

}

Here the main idea is to use the sum of ascci value of the key characters to generate the a number and then we can use mod it by the bucket size. to make it more random before we add the ascii value we can multiply it with a number in my case i just used the index to the power of itself.

3. Lets assume we have a hashmap of bucketsize 5 which contains 10 key-value pairs(each postion has 2 nodes) and we are going to resize it to a bucket_size of 10.
to do this we have to create a new hashmap and allocate array size of 10, then we have to iterate thru each key-value pair of the old hashmap and sequentially use the new hashmap's hashfunction and insert it into the new hashmap. the pseudo code is:


hashmap* resize(hashmap* old_hashmap) {

    create_hashmap( size = 10);
    while(old_hashmap->array->position < old_size){
        get_oldvalue();
        hash_old_vlaue_using_new_hashmap_hash_function();
        insert_into_new_hashmap();
    }
    return new_hashmap;

}

by looking at the pseudo code we can say that the time complexity will be O(n).

4. Open addressing refers to a techinique used to avoid collisions. When we're inserting a key into the hashmap, we find it's position using the hashfunction. if that position is already occupied by another key then it resolves collision by finidng the next available position from it's derived position. and while retriving the key we follow the same steps to determine the position where we inserted it. 


