import java.util.*;

/**
 * author jmh
 */
public class Test102 {
    public static void main(String[] args) {
//        List<TreeNode> nodes = new ArrayList<>();
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);
        List<List<Integer>> result = levelOrder(root);
        for(List<Integer> list : result){
            System.out.print("[");
            for(int i : list){
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelCount = queue.size();
            while(levelCount > 0){
                TreeNode temp = queue.remove();
                level.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                levelCount--;
            }
            result.add(level);
        }

        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public static TreeNode getTree(List<TreeNode> nodes){
        if(nodes.size() == 0){
            return null;
        }
        TreeNode root = nodes.get(0);
        root.left = nodes.get(1);
        root.right = nodes.get(2);
        for(int i = 1; i < nodes.size() / 2; i++){
            nodes.get(i).left = nodes.get(2 * i + 1);
            nodes.get(i).right = nodes.get(2 * i + 2);
        }
        return root;
    }
}
