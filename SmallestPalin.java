import java.util.*;
import java.lang.*;

class SmallestPalin{
    static void nearestPalin(long num){
        long numr = 0;
        long temp;

        while(true){
            num++;
            numr = 0;
            temp = num;

            while(temp!=0){
                numr = numr*10+temp%10;
                temp = temp/10;
            }
    
            if(numr==num){
                System.out.println(num);
                break;
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        long num;

        for(int i = 0 ; i < cases ; i++){
            num = sc.nextLong();
            nearestPalin(num);
        }
    }
}