/**
 * author jmh
 */
public class Jian10 {
    public static void main(String[] args) {
        System.out.println(numWays2(92));
    }
    public int numWays(int n){

        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return numWays(n - 1) + numWays(n - 2);
    }

    public static int numWays2(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        long pre2 = 1;
        long pre1 = 2;
        long flag = 3;
        long result = 0;
        while(flag <= n){
            result = (pre2 + pre1)%1000000007;
            pre2 = pre1;
            pre1 = result;
            flag++;
        }

        return (int)result;
    }
}
