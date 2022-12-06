import com.sun.source.tree.Tree;

import java.util.*;

/**
 * author jmh
 */
public class Test103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l11 = new TreeNode(9);
        TreeNode l12 = new TreeNode(20);
        TreeNode l21 = new TreeNode(15);
        TreeNode l22 = new TreeNode(7);
        TreeNode l23 = new TreeNode(6);
        TreeNode l24 = new TreeNode(8);
        root.left = l11;
        root.right = l12;
        l11.left = l23;
        l11.right = l24;
        l12.left = l21;
        l12.right = l22;
        List<List<Integer>> lists = zigzagLevelOrder(root);
        for(List<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //双向链表当作双向队列；注意取node和添加node时，removeFirst()和addLast()组合，removeLast()和addFirst()组合，
    // 并且要注意不同层的节点的左右孩子的便利顺序不同，先左后右，先右后左
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> doubleHead = new LinkedList<>();
        doubleHead.add(root);
        int levelCount = 0;
        while(doubleHead.size() != 0){
            List<Integer> list = new ArrayList<>();
            int layCount = doubleHead.size();
            if(levelCount % 2 == 0){
                while(layCount > 0){
                    TreeNode node = doubleHead.removeFirst();
                    list.add(node.val);
                    if(node.left != null){
                        doubleHead.addLast(node.left);
                    }
                    if(node.right != null){
                        doubleHead.addLast(node.right);
                    }
                    layCount--;
                }
            }else{
                while(layCount > 0){
                    TreeNode node = doubleHead.removeLast();
                    list.add(node.val);
                    if(node.right != null){
                        doubleHead.addFirst(node.right);
                    }
                    if(node.left != null){
                        doubleHead.addFirst(node.left);
                    }


                    layCount--;
                }

            }
            levelCount++;
            result.add(list);

        }

        return result;
    }
}
