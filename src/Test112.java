/**
 * author jmh
 */
public class Test112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        Test112 test= new Test112();
        boolean result = test.hasPathSum(root, -5);
        System.out.println(result);
    }

    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.val == targetSum){
            if(root.left == null && root.right == null){
                return true;
            }
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
