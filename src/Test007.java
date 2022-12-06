/**
 * author jmh
 */
public class Test007 {
    public static void main(String[] args) {
        int result = reverse(-2147483648);
        System.out.println(result);
    }
    public static int reverse(int x){
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        int flag = 0;
        if(sb.charAt(0) == '-'){
            sb.replace(0, 1, "");
            flag = -1;
        }
        StringBuilder reverse = sb.reverse();
        if(flag == -1){
            reverse.insert(0, '-');

        }
        String s = reverse.toString();
        long result = Long.parseLong(s);
        if(result < Math.pow(-2, 31) || result > Math.pow(2, 31) - 1){
            return 0;
        }else{
            return (int)result;
        }
    }
}
