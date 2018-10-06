import java.lang.*;
import java.util.*;

class Bride{
    int x;
    int y;
    int qualities;

    Bride(){
        x=-1;
        y=-1;
        qualities=0;
    }
}

class SuitableBride{
    static Bride getBrideKundali(int grid[][], int i, int j, int rows, int columns){
        int count = 0;
        Bride bride = new Bride();

        if(i+1<rows){
            if(j+1<columns&&grid[i+1][j+1]==1)count++;
            if(j-1>=0&&grid[i+1][j-1]==1)count++;
            if(grid[i+1][j]==1)count++;
        }
        if(i-1>=0){
            if(j+1<columns&&grid[i-1][j+1]==1)count++;
            if(j-1>=0&&grid[i-1][j-1]==1)count++;
            if(grid[i-1][j]==1)count++;
        }
        if(j+1<columns&&grid[i][j+1]==1)count++;
        if(j-1>=0&&grid[i][j-1]==1)count++;

        bride.x = i;
        bride.y = j;
        bride.qualities = count;

        return bride;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();

        int grid[][] = new int[rows][columns];

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        // for(int i = 0 ; i < rows ; i++){
        //     for(int j = 0 ; j < columns ; j++){
        //         System.out.print(grid[i][j]+"");
        //     }
        //     System.out.println();
        // }

        // Bride maxBride = getBrideKundali(grid,5,0,rows,columns);
        
        // System.out.println(maxBride.x+":"+maxBride.y+":"+maxBride.qualities);

        Bride maxBride = new Bride();
        Bride currBride = new Bride();
        boolean flag = false;

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                if(grid[i][j]==1){
                    currBride = getBrideKundali(grid,i,j,rows,columns);
                    System.out.println((currBride.x+1)+":"+(currBride.y+1)+":"+(currBride.qualities));
                    if(maxBride.qualities==currBride.qualities){
                        if(i+j==maxBride.x+maxBride.y)flag = true;
                        else if(i+j<maxBride.x+maxBride.y){
                            maxBride = currBride;
                            flag = false;
                        }
                    }else{
                        if(maxBride.qualities<currBride.qualities){
                            maxBride = currBride;
                            flag = false;
                        }
                    }
                }
            }
        }

        if(maxBride.qualities!=0){
            if(flag==false){
                System.out.println((maxBride.x+1)+":"+(maxBride.y+1)+":"+(maxBride.qualities));
            }else System.out.println("Polygamy not allowed");
        }else System.out.println("No suitable girl found");
    }
}