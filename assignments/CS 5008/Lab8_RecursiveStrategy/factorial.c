#include <stdio.h>
// TODO: Implement iterative solution here
unsigned long long factorial(int n){
    unsigned long long res = 1;
    while(n > 1){
        res = res * n;
        n--;
    }
    return res;
};

// TODO: Implement recursive solution here
unsigned long long factorial_rec(int n){
    if(n == 2){
        return 2;
    }
    
    return n * factorial_rec(n -1);
}

int main(){
//    int n = 0;
//    while(1){
//        printf("enter number\n");
//        scanf("%d",&n);
//        if(n == -1)
//            break;
//        Both of these should print the same result!
//        printf("factorial(%d) = %Lf\n",n,factorial(n));
//        printf("factorial_rec(%d) = %Lf\n",n,factorial_rec(n));
//    }
    printf("factorial(15) = %llu\n",factorial(15));
    printf("factorial_rec(15) = %llu\n",factorial_rec(15));
    
    
    return 0;
}
