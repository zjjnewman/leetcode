package leetcode.stack;

import datastructure.tree.TreeNode;
import datastructure.tree.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class JZ32 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        int up = 0;
        int down = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        queue.addFirst(root);
        up++;
        while(!queue.isEmpty()){
            TreeNode node = queue.pollLast();
            up--;
            arr.add(node.val);
            if(node.left != null){
                queue.addFirst(node.left);
                down++;
            }
            if(node.right != null){
                queue.addFirst(node.right);
                down++;
            }
            if(up == 0){
                up = down;
                down = 0;
                list.add(arr);
                arr = new ArrayList<Integer>();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t = TreeUtils.deserialize("[1]");

        List<List<Integer>> lists = levelOrder(t);

        //[[3],[9,20],[15,7]]
        System.out.println(lists);

    }
}
