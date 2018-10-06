#include <stdio.h>

int doors[1000];

void initializeDoors(){
    for(int i = 0 ; i < 1000 ; i++){
	    doors[i]=0;
	}
}

void flipDoor(int i){
    if(doors[i]==0)doors[i]=1;
    else doors[i]=0;
}

void displayDoors(int n){
    initializeDoors();
    for(int i = 1 ; i <= n ; i++){
        for(int j = i ; j <=n ; j+=i){
            flipDoor(j-1);
        }
    }
    for(int i = 0 ; i < n ; i++){
        printf("%d ",doors[i]);
    }
    printf("\n");
}

int main() {
	//code
	initializeDoors();
	
	int noOfCases;
	scanf("%d",&noOfCases);
	
	int currCase;
	
	for(int r = 0 ; r < noOfCases; r++){
	    scanf("%d",&currCase);
	    displayDoors(currCase);
	}
	return 0;
}