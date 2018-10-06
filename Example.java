import java.util.*;
import java.lang.*;
import java.io.*;

class TIP{
    public int a;
    public int b;
}

class Example {
    static int findMaxPos(TIP tips[]){
        int maxAi = -1;
        int maxBi = -1;
        int maxPos = 0;

        for (int i = 0 ; i < tips.length ; i++) {
            if(tips[i].a>maxAi){
                maxAi = tips[i].a;
                maxPos = i;
            }
            if(tips[i].b>maxBi){
                maxBi = tips[i].b;
                maxPos = i;
            }
        }

        return maxPos;
    }

    static void displayArr(int arr[]){
        for (int var : arr) {
            System.out.println(var);
        }
    }

	public static void main (String[] args) {
		int noOfTestCases;
		Scanner sc = new Scanner(System.in);
		
        noOfTestCases = sc.nextInt();
        
        int profit[] = new int[noOfTestCases];
        
        TIP tips[] = new TIP[105];
        int aCapacity, bCapacity, totalOrders;

        totalOrders = sc.nextInt();
        aCapacity = sc.nextInt();
        bCapacity = sc.nextInt();

        sc.nextLine();

        System.out.println(totalOrders+" "+aCapacity+" "+bCapacity+" ");

        for(int i = 0 ; i < totalOrders; i++){
            tips[i] = new TIP();
            tips[i].a = sc.nextInt();
            System.out.print("***"+tips[i].a);
        }

        for(int i = 0 ; i < totalOrders; i++){
            tips[i].b = sc.nextInt();
        }
	}
}