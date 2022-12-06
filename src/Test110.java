/**
 * author jmh
 */
public class Test110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(4);
        TreeNode right1 = new TreeNode(2);
        TreeNode right2 = new TreeNode(3);
        TreeNode right3 = new TreeNode(4);

        root.left = left1;
        left1.left = left2;
        left2.left = left3;

        root.right = right1;
        right1.right = right2;
        right2.right = right3;

        Test110 test = new Test110();
        boolean b = test.isBalanced(root);
        System.out.println(b);

    }

    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int result = Math.abs(treeHeight(root.left) - treeHeight(root.right));
        boolean resultLeft = isBalanced(root.left);
        boolean resultRight = isBalanced(root.right);
        return result <= 1 && resultLeft && resultRight;

    }

    public boolean isBalanced2(TreeNode root){
        if(root == null){
            return true;
        }
        if(isBalanced2(root.left)){
            if(isBalanced2(root.right)){
                int result = Math.abs(treeHeight(root.left) - treeHeight(root.right));
                return result <= 1;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }



    public int treeHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}
