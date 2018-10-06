/* Your C Program will come here */
#include<stdio.h>

void fibo(int n){
    int i=1,j=0,temp;

    for(int r=0;r<n;r++){
        temp = j;
        j=j+i;
        i=temp;
    }

    printf("%d",j);
}

void prime(int n){
    int j,i = 1;

    while(n>0){
        i++;
        for(j = 2 ; j <= i/2 ; j++){
            if(i%j==0)break;
        }

        if(j>i/2)
            n--;
    }    
    printf("%d", i);
}


int main(){
    int n;
    scanf("%d",&n);
    if(n%2==0)
        fibo(n/2);
    else prime(n/2+1);
}