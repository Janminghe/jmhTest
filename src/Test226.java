
/**
 * author jmh
 */
public class Test226 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.right == null && root.left == null){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;

    }
}
