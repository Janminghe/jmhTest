import java.util.Queue;
import java.util.Stack;

/**
 * author jmh
 */
public class Test020 {
    public boolean isValid(String s){
        if(s.length() % 2 != 0){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '[' || chars[i] == '{' || chars[i] == '('){
                stack.push(chars[i]);
            }else{
                if(stack.empty()){
                    return false;
                }
                char left = stack.pop();
                if((chars[i] == ']' && left == '[') || (chars[i] == '}' && left == '{') || (chars[i] == ')' && left == '(')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
