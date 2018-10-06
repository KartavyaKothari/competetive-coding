import java.lang.*;
import java.util.*;

class Node{
    boolean isN;
    boolean isS;
    boolean isE;
    boolean isW;
    boolean isDrop;
    boolean isReachable;

    Node(boolean isN,boolean isS,boolean isE,boolean isW,boolean isDrop,boolean isReachable){
        this.isN = isN;
        this.isS = isS;
        this.isE = isE;
        this.isW = isW;
        this.isDrop = isDrop;
        this.isReachable = isReachable;
    }
}

class CanIReach{
    static Node nodeGrid[][];

    static boolean isSolutionReachable(int i, int j, int n){
        if(nodeGrid[i][j].isDrop==true)return false;
        if(nodeGrid[i][j].isReachable==true)return true;

        if(nodeGrid[i][j].isS&&i+1<n){
            nodeGrid[i][j].isReachable = isSolutionReachable(i+1, j, n);
            if(nodeGrid[i][j].isReachable==true)
                return nodeGrid[i][j].isReachable;
        }

        if(nodeGrid[i][j].isE&&j+1<n){
            nodeGrid[i][j].isReachable = isSolutionReachable(i, j+1, n);
            if(nodeGrid[i][j].isReachable==true)
                return nodeGrid[i][j].isReachable;
        }

        if(nodeGrid[i][j].isW&&j-1>=0){
            nodeGrid[i][j].isReachable = isSolutionReachable(i, j-1, n);
            if(nodeGrid[i][j].isReachable==true)
                return nodeGrid[i][j].isReachable;
        }

        if(nodeGrid[i][j].isN&&i-1>=0){
            nodeGrid[i][j].isReachable = isSolutionReachable(i-1, j, n);
            if(nodeGrid[i][j].isReachable==true)
                return nodeGrid[i][j].isReachable;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodeGrid = new Node[n][n];

        sc.nextLine();

        for(int i = 0 ; i < n ; i++){
            String newInput = sc.nextLine();
            String inputSplit[] = newInput.split(",");
            for(int j = 0 ; j < n ; j++){
                String dir = inputSplit[j];
                nodeGrid[i][j] = new Node(dir.contains("N"),
                                            dir.contains("S"),
                                            dir.contains("E"),
                                            dir.contains("W"),
                                            dir.contains("D"),
                                            dir.contains("F"));
            }
        }

        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(isSolutionReachable(0,i,n)==true){System.out.println("0,"+i);count++;}
        }

        for(int i = 1 ; i < n ; i++){
            if(isSolutionReachable(i,0,n)==true){System.out.println(i+",0");count++;}
        }

        System.out.println(count);
    }
}