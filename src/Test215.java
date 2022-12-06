import java.util.Random;

/**
 * author jmh
 */
public class Test215 {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k){
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }


    public int quickSelect(int[] nums, int l, int r, int index){
        int f = randomPartition(nums, l, r);
        if(f == index){
            return nums[f];
        }else if(f < index){
            return quickSelect(nums, f + 1, r, index);
        }else{
            return quickSelect(nums, l, f - 1, index);
        }
    }

    public int randomPartition(int[] nums, int l, int r){
        int flagindex = random.nextInt(r - l + 1) + l;
        swap(nums, flagindex, r);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r){
        int x = nums[r];
        int i = l - 1;
        for(int j = l; j < r; j++){
            if(nums[j] <= x){
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }


    public void swap(int[] nums,  int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
