/**
 * author jmh
 */
public class Test069 {
    public static void main(String[] args) {

    }

    public int mySqrt(int x){
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        int left = 0;
        int right = x;
        int result = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if((long)mid * mid <= x){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
}
