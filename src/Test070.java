/**
 * author jmh
 */
public class Test070 {
    public int climbStairs(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int pre2 = 1;
        int pre1 = 2;
        int flag = 3;
        int result = 0;
        while(flag <= n){
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
            flag++;
        }
        return result;
    }
}
