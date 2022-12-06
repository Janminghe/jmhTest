/**
 * author jmh
 */
public class Test104 {
    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        Test104 test = new Test104();
        String str = test.addStrings(num1, num2);
        System.out.println(str);
    }
    public String addStrings(String num1, String num2) {
        if(num1.length() == 0){
            return num2;
        }
        if(num2.length() == 0){
            return num1;
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int i = chars1.length - 1;
        int j = chars2.length - 1;
        int temp = 0;
        StringBuffer str = new StringBuffer();
        while(i >=0 && j >=0){
            int i1 = chars1[i] - '0';
            int j1 = chars2[j] - '0';
            int c = (i1 + j1 + temp) % 10 ;
            temp = (i1 + j1 + temp) / 10;
            str.append(c);
            i--;
            j--;
        }
        if(i < 0){
            while(j >= 0){
                int i1 = 0;
                int j1 = chars2[j] - '0';
                int c = (i1 + j1 + temp) % 10 ;
                temp = (i1 + j1 + temp) / 10;
                str.append(c);
                j--;
            }
        }
        if(j < 0){
            while(i >= 0){
                int i1 = chars1[i] - '0';
                int j1 = 0;
                int c = (i1 + j1 + temp) % 10 ;
                temp = (i1 + j1 + temp) / 10;
                str.append(c);
                i--;
            }
        }
        if(temp != 0){
            str.append(temp);
        }
        return str.reverse().toString();
    }
}
