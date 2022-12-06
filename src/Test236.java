import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * author jmh
 */
public class Test236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l11 = new TreeNode(5);
        TreeNode l12 = new TreeNode(1);
        TreeNode l21 = new TreeNode(6);
        TreeNode l22 = new TreeNode(2);
        TreeNode l23 = new TreeNode(0);
        TreeNode l24 = new TreeNode(8);
        TreeNode l31 = new TreeNode(7);
        TreeNode l32 = new TreeNode(4);
        root.left = l11;
        root.right = l12;
        l11.left = l21;
        l11.right = l22;
        l12.left = l23;
        l12.right = l24;
        l22.left = l31;
        l22.right = l32;

        TreeNode treeNode = lowestCommonAncestor(root, l11, l12);
        System.out.println(treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        if(dfs(root.left, p)&&dfs(root.right, q)){
            return root;
        }
        if(dfs(root.left, q)&&dfs(root.right, p)){
            return root;
        }

        if(root.right != null && lowestCommonAncestor(root.right, p, q) != null){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return lowestCommonAncestor(root.left, p, q);
        }
    }

    public static boolean dfs(TreeNode root, TreeNode node){
        if(root == null){
            return false;
        }
        if(root.val == node.val){
            return true;
        }
        return dfs(root.left, node) || dfs(root.right, node);
    }

}
