/**
 * author jmh
 */
public class Test026 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums){
        if(nums.length == 1){
            return 1;
        }
        int curr = 0;
        int next = 1;
        while(next < nums.length){
            if(nums[next] > nums[curr]){
                nums[curr + 1] = nums[next];
                curr++;
                next++;
            }else{
                next++;
            }
        }
        return curr + 1;
    }
}
