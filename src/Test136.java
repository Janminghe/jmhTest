import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * author jmh
 */
public class Test136 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        Object[] array = set.toArray();
        return Integer.parseInt(((Integer)array[0]).toString());
    }
}
