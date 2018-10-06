    #include<stdio.h>
#include<stdlib.h>

int main() {
  
    int adj[5][5] = { 0, 20, 30, 40, 0,
    	              0,  0, 40,  0, 30,
	              0,  0,  0, 40, 20,
                            0,  0,  5,  0, 20,
    	              0,  0,  0,  0,  0  };

    int heu[5] = {50,30,20,20,0};
  
    int i, j, k, dis=0, min, posi=0, posj=0, start=1, end=5;
    int path[5] = {start,0,0,0,0}, pcount=0;  
 
    printf("Initial state: node %d\n", start);
    printf("Final state: node %d\n", end);
 
    for(i=0; i<5; ++i)
        printf("\nh(%d) = %d", i+1, heu[i]);
    printf("\n");
 
    i=start-1;  j=0;
  
    while(1){
      
        printf("\nNode %d selected", path[pcount] );
        printf("\n");

        if(path[pcount] == end)
            break;
        min = 99999;
        for(k=0; k<4; k++)   
            for(j=1; j<5; ++j){
                if(adj[k][j] == 0)
                    continue;
                if(k > i)
                    break;
    
                if(k != i){
                    printf("\nNode %d: f(%d) = %d+%d = %d", j+1, j+1, adj[k][j], heu[j], adj[k][j]+heu[j] );
                    continue;
                }
               
                printf("\nNode %d: f(%d) = %d+%d = %d", j+1, j+1, dis+adj[i][j], heu[j], dis+adj[i][j]+heu[j] );           
    
                if (min > (dis + adj[i][j] + heu[j]) ){
                    min = dis + adj[i][j] + heu[j];
                    posi = i;
                    posj = j;
                }
            }
      
        dis += adj[posi][posj];
        path[++pcount] = posj + 1;
        i = posj;
        adj[posi][posj] = 0;
    }

    printf("\nPath : ");
    for(i=0; i<=pcount; ++i)
        printf("%d ", path[i]);
 
    printf("\nCost = %d", dis);
    return 0;
}