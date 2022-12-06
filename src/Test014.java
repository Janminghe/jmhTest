/**
 * author jmh
 */
public class Test014 {
    public static void main(String[] args) {

    }


    public String longestCommonPrefix(String[] strs){
        if(strs.length == 1){
            return strs[0];
        }
        String result = prefixOfTwo(strs[0], strs[1]);
        for(int i = 2; i < strs.length; i++){
            result = prefixOfTwo(result, strs[i]);
            if(result.equals("")){
                return result;
            }
        }
        return result;
    }

    public String prefixOfTwo(String str1, String str2){
        if(str1.length() == 0 || str2.length() == 0){
            return "";
        }
        int flag1 = 0;
        int flag2 = 0;
        while(flag1 < str1.length() && flag2 < str2.length()){
            if(str1.charAt(flag1) == str2.charAt(flag2)){
                flag1++;
                flag2++;
            }else{
                break;
            }
        }
        return str1.substring(0, flag1);
    }
}
