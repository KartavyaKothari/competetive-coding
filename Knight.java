/*
    Knights on Board
Max. Marks: 100
Suraj designed an enhanced version of chess game of size  with top left position as . In this version of game if a piece crosses the border from one side, it enters from the exact opposite side. 

For example :  

if it goes up from  position, it will enter the board from . 
if it goes left from  position , it will enter the board from .

He started with a knight from an initial position. In the first step knight can move to  different positions which get distributed to  knights in these  positions. Now in the second step each of these  knights can move to different positions, get distributed and so on.

Given an intial position of knight  on the board such that  and , suraj wants to find how many minimum steps required to visit each position on the board. If knight is unable to cover all the positions, print .

Input
: Total number of test cases
In each test case you are given two space integers  and . 
In the next line two space separated integers  and .

Output

Print minimum number of steps such that knights can cover each and every cell on the board.
For each test case, output should be in a different line.

Constraints





 

SAMPLE INPUT 
2
3 3
0 0
3 3
0 0
SAMPLE OUTPUT 
2
2
Explanation
In the sample the board size is 3 X 3 and initially there is one knight at point (0 , 0). 

After one move , there will be knights at the points -    (1,1) , (1,2) , (2,1) and (2,2).

After the second move whole board will be covered.

Important note : Please pay attention to the fact that if knights cross border from one side , they enter the board from just opposite side.
*/

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.*;
import java.lang.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Pos{
    int x;
    int y;
    
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class TestClass {
    static void initBoard(boolean board[][],int n, int m){
        for(int i = 0 ; i < n ; i++)
                for(int j = 0 ; j < m ; j++)
                    board[i][j] = false;
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int n,m,x,y,len,count,blocks;
        
        for(int c = 0 ; c < cases ; c++){
            n = sc.nextInt();
            m = sc.nextInt();
            
            count = 0;
            blocks = 0;
            
            boolean board[][] = new boolean[n][m];
            initBoard(board,n,m);
                    
            ArrayList<Pos> coord = new ArrayList<Pos>();
            
            x = sc.nextInt();
            y = sc.nextInt();
            
            len = 1;
            
            coord.add(new Pos(x,y));
            board[x][y]=true;
            blocks++;
            boolean flag = false;
            
            while(true){
                count++;
                len = coord.size();
                for(int i = 0 ; i < len ; i++){
                    Pos p = coord.get(0);
                    
                    Pos a = new Pos((p.x+1)%n,p.y);
                    if(board[a.x][a.y]==false){
                        flag=true;
                        coord.add(a);
                    }   
                    board[a.x][a.y]=true;
                    if(++blocks==n*m)break;
                    
                    Pos b = new Pos(p.x,(p.y+1)%m);
                    if(board[b.x][b.y]==false){
                        flag=true;
                    
                        coord.add(b);
                    }   
                    board[b.x][b.y]=true;
                    if(++blocks==n*m)break;
                    
                    
                    Pos z = new Pos((p.x+1)%n,(p.y+1)%m);
                    if(board[z.x][z.y]==false){
                        flag=true;
                        coord.add(z);
                    }    
                    board[z.x][z.y]=true;
                    if(++blocks==n*m)break;
                    
                    
                    Pos d = new Pos((p.x-1+n)%n,p.y);
                    if(board[d.x][d.y]==false){
                        flag=true;
                        coord.add(d);
                    }    
                    board[d.x][d.y]=true;
                    if(++blocks==n*m)break;
                    
                    
                    Pos e = new Pos(p.x,(p.y-1+n)%n);
                    if(board[e.x][e.y]==false){
                        flag=true;
                        coord.add(e);
                    }   
                    board[e.x][e.y]=true;
                    if(++blocks==n*m)break;
                    
                    
                    Pos f = new Pos((p.x+1)%n,(p.y-1+n)%n);
                    if(board[f.x][f.y]==false){
                        flag=true;
                        coord.add(f);
                    }    
                    board[f.x][f.y]=true;
                    if(++blocks==n*m)break;
                    
                    
                    Pos g = new Pos((p.x-1+n)%n,(p.y-1+n)%n);
                    if(board[g.x][g.y]==false){
                        flag=true;
                        coord.add(g);
                    }   
                    board[g.x][g.y]=true;
                    if(++blocks==n*m)break;
                    
                    
                    Pos h = new Pos((p.x-1+n)%n,(p.y+1)%n);
                    if(board[h.x][h.y]==false){
                        flag=true;
                    
                        coord.add(h);
                    }
                    board[h.x][h.y]=true;
                    if(++blocks==n*m)break;
                    
                    
                    coord.remove(0);
                }
                if(blocks==n+m){
                    System.out.println(count);
                    break;
                }
                if(flag==false){
                    System.out.println("-1");
                    break;
                }
            }
            
        }
    }
}
