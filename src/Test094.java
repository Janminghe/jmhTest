import java.util.ArrayList;
import java.util.List;

/**
 * author jmh
 */
public class Test094 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root != null){
            if(root.left != null){
                result.addAll(inorderTraversal(root.left));
            }
            result.add(root.val);
            if(root.right != null){
                result.addAll(inorderTraversal(root.right));
            }
        }
        return result;
    }
}
