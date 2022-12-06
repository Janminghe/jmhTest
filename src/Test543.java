/**
 * author jmh
 */
public class Test543 {
    public static void main(String[] args) {


    }
    public int diameterOfBinaryTree(TreeNode root){
        int result = 0;
        if(root != null){
            result = Math.max(tempMax(root), result);
        }
        if(root.left != null){
            result = Math.max(tempMax(root.left), result);
        }
        if(root.right != null){
            result = Math.max(tempMax(root.right), result);
        }
        return result;
    }



    public int tempMax(TreeNode root){
        return height(root.left) + height(root.right);
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
