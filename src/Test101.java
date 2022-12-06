/**
 * author jmh
 */
public class Test101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l11 = new TreeNode(2);
        TreeNode l12 = new TreeNode(2);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(4);
        TreeNode l23 = new TreeNode(4);
        TreeNode l24 = new TreeNode(3);
        root.left = l11;
        root.right = l12;
        l11.left = l21;
        l11.right = l22;
        l12.left = l23;
        l12.right = l24;

        Test101 test = new Test101();
        boolean result = test.isSymmetric(root);
        System.out.println(result);

    }

    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return mySymmertic(root.left, root.right);
    }

    public boolean mySymmertic(TreeNode left, TreeNode right){
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if(left == null && right == null){
            return true;
        }
        if(left.val != right.val){
            return false;
        }
        return mySymmertic(left.left, right.right) && mySymmertic(left.right, right.left);
    }
}

