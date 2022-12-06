/**
 * author jmh
 */
public class Test033 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        Test033 test = new Test033();
        int result = test.search(nums, 0);
        System.out.println(result);
    }

    public int search(int[] nums, int target){
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else{
                return -1;
            }
        }
        if(nums[0] > nums[nums.length - 1]){
            int reverseIndex;
            for(reverseIndex = 0; reverseIndex < nums.length; reverseIndex++){
                if(nums[reverseIndex] > nums[reverseIndex + 1]){
                    break;
                }
            }
            if(target >= nums[0]){
                return midSearch(nums, 0, reverseIndex, target);
            }else{
                return midSearch(nums, reverseIndex + 1, nums.length - 1, target);
            }
        }else{
            return midSearch(nums, 0, nums.length -1, target);
        }
    }


   public int midSearch(int[] nums, int start, int end, int target){
        if(nums[start] > target || nums[end] < target){
            return -1;
        }
        if(start == end){
            if(nums[start] == target){
                return start;
            }else{
                return -1;
            }
        }
        int mid = (start + end) / 2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            return midSearch(nums, start, mid-1, target);
        }else{
            return midSearch(nums, mid+1, end, target);
        }
   }


}
