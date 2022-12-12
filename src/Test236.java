import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * author jmh
 */
public class Test236 {
    TreeNode ans = new TreeNode();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        if((lson&&rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))){
            this.ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
