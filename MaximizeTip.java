/*Rahul and Ankit are the only two waiters in Royal Restaurant. Today, the restaurant received N orders. The amount of tips may differ when handled by different waiters, if Rahul takes the ith order, he would be tipped Ai rupees and if Ankit takes this order, the tip would be Bi rupees.
In order to maximize the total tip value they decided to distribute the order among themselves. One order will be handled by one person only. Also, due to time constraints Rahul cannot take more than X orders and Ankit cannot take more than Y orders. It is guaranteed that X + Y is greater than or equal to N, which means that all the orders can be handled by either Rahul or Ankit. Find out the maximum possible amount of total tip money after processing all the orders.


Input:

•    The first line contains one integer, number of test cases.
•    The second line contains three integers N, X, Y.
•    The third line contains N integers. The ith integer represents Ai.
•    The fourth line contains N integers. The ith integer represents Bi.

 

Output:
Print a single integer representing the maximum tip money they would receive.
 

Constraints:
1 ≤ N ≤ 105
1 ≤ X, Y ≤ N; X + Y ≥ N
1 ≤ Ai, Bi ≤ 104

 

Example:

Input:

2
5 3 3
1 2 3 4 5
5 4 3 2 1
8 4 4
1 4 3 2 7 5 9 6 
1 2 3 6 5 4 9 8

 

Output:

21
438*/



/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class TIP{
    int a;
    int b;
}

class MaximizeTip {
    static int findMaxPos(TIP tips[],int n){
        int maxPos = -1;
        int maxDiff = -1;

        for (int i = 0 ; i < n ; i++) {
            if((tips[i].a!=-1)&&Math.abs(tips[i].a-tips[i].b)>maxDiff){
                maxDiff = Math.abs(tips[i].a-tips[i].b);
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
        
        for(int j = 0 ; j < noOfTestCases ; j++){
            TIP tips[] = new TIP[105];
            int aCapacity, bCapacity, totalOrders;

            totalOrders = sc.nextInt();
            aCapacity = sc.nextInt();
            bCapacity = sc.nextInt();

            for(int i = 0 ; i < totalOrders; i++){
                tips[i] = new TIP();
                tips[i].a = sc.nextInt();
            }

            for(int i = 0 ; i < totalOrders; i++){
                tips[i].b = sc.nextInt();
            }

            int maxPos,totalProfit;

            totalProfit = 0;

            for(int i = 0 ; i < totalOrders; i++){
                maxPos = findMaxPos(tips,totalOrders);
                if(aCapacity==0){
                    bCapacity--;
                    totalProfit+=tips[maxPos].b;
                    tips[maxPos].a=-1;
                    tips[maxPos].b=-1;
                }else if(bCapacity==0){
                    aCapacity--;
                    totalProfit+=tips[maxPos].a;
                    tips[maxPos].a=-1;
                    tips[maxPos].b=-1;
                }else if(tips[maxPos].b>tips[maxPos].a){
                    bCapacity--;
                    totalProfit+=tips[maxPos].b;
                    tips[maxPos].a=-1;
                    tips[maxPos].b=-1;
                }else{
                    aCapacity--;
                    totalProfit+=tips[maxPos].a;
                    tips[maxPos].a=-1;
                    tips[maxPos].b=-1;
                }
            }

            profit[j] = totalProfit;
        }

        displayArr(profit);
	}
}