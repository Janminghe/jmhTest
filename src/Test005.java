/**
 * author jmh
 */
public class Test005 {
    public static void main(String[] args) {
        String s = "aaaaa";
        Test005 test = new Test005();
        String re = test.longestPalindrome1(s);
        System.out.println(re);
    }
    public String longestPalindrome(String s){
        if(s.length() == 1){
            return s;
        }
        int maxLen = 0;
        int begin = 0;
        int end = 1;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length() + 1; j++){
                if(isPalindrome(s.substring(i, j))){
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        begin = i;
                        end = j;
                    }

                }
            }
        }
        return s.substring(begin, end);
    }

    public String longestPalindrome1(String s){
        if( s == null || s.length() == 0 || s.length() == 1){
            return s;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            if(i < n - 1 && chars[i] == chars[i+1]){
                dp[i][i+1] = true;
            }
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(dp[i+1][j-1] && chars[i] == chars[j]){
                    dp[i][j] = true;
                }
            }
        }
        int maxLen = 0;
        int begin = 0;
        int end = 1;
        for(int i = 0; i < n; i++){
            for(int j = i ; j < n; j++){
                if(dp[i][j]){
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end+1);
    }

    public boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while(l < r){
            if(chars[l] == chars[r]){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
