import java.util.ArrayList;
import java.util.List;

/**
 * author jmh
 */
public class Test144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            result.add(root.val);
            if(root.left != null){
                result.addAll(preorderTraversal(root.left));
            }
            if(root.right != null){
                result.addAll(preorderTraversal(root.right));
            }
        }
        return result;
    }
}
