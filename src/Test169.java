import java.util.HashMap;
import java.util.Map;

/**
 * author jmh
 */
public class Test169 {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int target = nums.length / 2;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
                if(map.get(nums[i]) > target){
                    result = nums[i];
                    break;
                }
            }
        }
        return result;
    }
}
