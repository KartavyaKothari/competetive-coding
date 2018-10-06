import java.util.*;
import java.lang.*;

class PrimeGenerator{
    static void generatePrimes(long a, long b){
        for(long i = a ; i <= b ; i++){
            long j;
            long l = (int)Math.sqrt(i)+1;
            for(j = 2 ; j <= l ; j++){
                if(i%j==0){
                    break;
                }
            }
            if(j>l&&i!=1||i==2)System.out.println(i);
        }
    }

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        long a[] = new long[cases];
        long b[] = new long[cases];

        for(int  i = 0 ; i < cases ; i ++){
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
        }

        for(int i = 0 ; i < cases ; i++){
            generatePrimes(a[i],b[i]);
            System.out.println();
        }
    }
}