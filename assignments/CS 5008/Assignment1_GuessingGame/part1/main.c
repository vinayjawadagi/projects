#include<stdio.h>
#include<stdlib.h>
int main(){
	int round = 0; // to count the number of rounds
	int guessCountList[4]; // array to store the number of guesses made in each round

	// loop to run the game 5 times
	while(round < 5) {
		int randNum = rand() % 10; // rand() generates random number and we use modulo operator to reduce the number within in the range of 1-10
		int guessCount = 0; // stores the number of guess in the round
		int guess; // guess made by the user
		int isCorrectGuess = 0; // flag to end the round when a correct guess is made
		
		printf(" -----------------------------------\n");
		printf("| Round %d Pick a number from 1-10  |\n", round + 1);
		printf(" -----------------------------------\n");
		
		// loop to run the round till a correct guess is made
		while(isCorrectGuess == 0){
			printf("Make your guess: ");
			scanf("%d", &guess);
			guessCount++;
			// check if the guess is right
			if(guess == randNum){
				printf("That's correct!\n");
				guessCountList[round] = guessCount;
				isCorrectGuess = 1;
			}
			// check if the guess is lower than randNum 
			else if(guess < randNum){
				printf("Guess higher...\n");
			}
			// guess is higher than randNum
			else{
				printf("Guess lower...\n");
			}
		}
		round++;
	}
	// printing the game summary
	printf(" -----------------------------------\n");
	printf("| Your Game results are:            |\n");
	printf(" ----------------------------------- \n");
	for(int i = 0; i < 5; i++) {
		printf("In Round %d, it took you %d guesses \n", i+1, guessCountList[i]);
	} 
}

// Add your program here!
