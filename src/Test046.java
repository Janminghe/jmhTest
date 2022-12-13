import java.util.ArrayList;
import java.util.List;

/**
 * author jmh
 */
public class Test046 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        List<List<Integer>> result = new Test046().permute(nums);
        for(List<Integer> listTemp : result){
            System.out.println(listTemp);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        return permuteTemp(nums, 0);
    }

    public List<List<Integer>> permuteTemp(int[] nums, int begin){
        List<List<Integer>> result = new ArrayList<>();
        if(begin == nums.length - 1){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[begin]);
            result.add(temp);
            return result;
        }
        List<List<Integer>> resultTemp = permuteTemp(nums, begin + 1);
        int tag = nums[begin];
        for(List<Integer> listTemp : resultTemp){
            int len = listTemp.size();
            for(int i = 0; i <= len; i++){
                List<Integer> list = new ArrayList<>(List.copyOf(listTemp));
                list.add(i, tag);
                result.add(list);
            }
        }
        return result;
    }
}
