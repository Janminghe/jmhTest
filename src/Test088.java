/**
 * author jmh
 */
public class Test088 {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int flag1 = m - 1;
        int flag2 = n - 1;
        int flag3 = m + n -1;
        while(flag1 >=0 && flag2 >= 0){
            if(nums1[flag1] >= nums2[flag2]){
                nums1[flag3] = nums1[flag1];
                flag1--;
            }else{
                nums1[flag3] = nums2[flag2];
                flag2--;
            }
            flag3--;
        }
        if(flag1 < 0){
            while(flag3 >= 0){
                nums1[flag3] = nums2[flag3];
                flag3--;
            }
        }
    }
}
