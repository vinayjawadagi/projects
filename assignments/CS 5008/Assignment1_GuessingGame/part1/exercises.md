# Exercises

In order to start thinking a bit algorithmically, modify this file and answer the following questions. Be sure to add/commit/push any changes made to this file to our repository.

1. In the worst case in our guessing game--how many guesses could it take to get the right number if we had no hint at all? Explain.
2. In the worst case in our guessing game--how many guesses does it take to get the right number if we get a hint of 'higher or lower' when guessing numbers 1-10? *Hint* In your answer show this mathematically with the [log function](https://www.mathsisfun.com/algebra/logarithms.html).

## Answers

1. If theres no hints provided in the guessing game, the user will need 10 tries in the worst case scenario to make a right guess.   
For example,   
Let’s assume the number to be guessed is ’n’ which equals to 10.   
n = 10   
By the process of elimination the user will make an initial guess for ’n’ as 1, then increment each guess by 1 till he gets to ’n’ equals to 10 on his 10th guess.   
Therefore, in the worst case scenario the user will end up taking 10 tries to guess the right answer.   

2. In the case where the game provides hints as to the guess is either lower or higher than the number to be guessed, the number of worst case scenario guesses are:   

  a. The user uses a simple way of incrementing or decrementing the guessed number.   
  
Lets assume two cases where the number to be guessed, ’n’   
n = 10   and   n = 1   
When n = 10 the user starts with initial guess of ’n’ as 1. The game responds with a hint saying the number is higher. Then the user increments his guess by 1, so his next guess will be 2. The user continues this until he incrementally reaches to ’n’ as 10 as his final guess. This will take the user 10 guesses to get to the right answer.   
Similarly when n = 1, the user starts with initial guess of ’n’ as 10. The game responds with a hint saying the number is lower. So like the the case where n = 10, the user will decrement by 1 until he reaches the answer ’n’ as 1 on his 10th guess.   

  b. The user takes the algorithmic approach to guess (binary search)

The range of numbers where our number to be guessed ’n’ lies in is [1,10]. The user guesses the mid point of the range I.e. 5 on the first guess. The game  responds with a prompt telling the user to either higher or lower. Based on this input the user shortens the range to [1, 5) or (5, 10].   
Let’s take an example where the number to be guessed is 4.   
Initial range = [1,10]    
After the first guess which is ‘5’ the system responds with a prompt, “Guess lower”.    
So the user divides the range into [1, 5) and (5, 10] and chooses the next range as [1, 4] (since 5 is already guessed it is excluded).    
-> New range = [1, 4]      
The second guess would be,    
-> (1+4) / 2 = 2   
The system responds with a prompt “guess higher”.    
So the user divides the range into [1, 2) and (2, 4] and chooses the next range as [3, 4].    
-> New range = [3,4]   
The third guess would be,    
-> (3+4) / 2 = 3     
The system responds with a prompt, “guess higher”     
So the user divides the range into (3,3) and (3, 4] and chooses the next range as [4,4].     
-> New range = [4,4]      
The fourth and final guess would be,     
-> (4+4) / 2 = 4     
This would be the right answer and it took the user 4 guesses, which is one of the worst case scenarios.     
In the worst case scenario the user would end up with a range that would have just 1 number left which is the right number.     
 
We can generalize it in this way, let’s assume the range has ’n’ numbers.     
After the first guess the range would have n / 2 numbers.    
After the second guess the range would have (n / 2)/ 2 => n / (2 ^2) numbers.    
After the third guess the range would have (n / (2 ^2)) / 2 => n / (2 ^3) numbers.    
After continuing this the user would arrive at ‘m’th guess where the range would have just 1 number, which can also be represented as n / ( 2 ^m).     
So,     
-> (n / (2 ^m)) = 1     
-> n = 2^m     
Applying log to the base 2 on both sides we get,     
-> log2 n = log2 2^m      
Simplifying this gets us,      
-> log2 n = m (log2 2)      
-> log2 n = m (1)     
-> log2 n = m      
-> m = log2 n      

If we apply the above equation to our case where, the number of numbers in the range [1, 10], ’n’ = 10     
-> m = log2 10     
-> m = 3.321      
-> m ≈  4      

So we can conclude that in the worst case scenario the user would need 4 guess to guess the right number if he uses the algorithmic approach (binary search).   

