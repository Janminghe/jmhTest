/**
 * author jmh
 */
public class Jian10a1 {
    public static void main(String[] args) {

    }
    public int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        int result = 0;
        int flag = 2;
        while(flag <= n){
            result = (f0 + f1)%1000000007;
            f0 = f1;
            f1 = result;
            flag++;
        }
        return result;
    }
}
