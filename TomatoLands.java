import java.util.*;

public class TomatoLands{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        double validNum[] = new double[cases];

        for(int i = 0 ; i < cases ; i++){
            validNum[i]=sc.nextDouble();
        }

        double count;

        for (double num : validNum) {
            count = 0;
            for(double  i = 1 ; i <= num; i++){
                for(double j = 1 ; j <= num ; j++){
                    if(i*j<=num){
                        count++;
                    }
                }
                count = count % 1000000007;
            }
            System.out.println(count);
        }
    }
}