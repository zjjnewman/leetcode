package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0102 {

    // Definition for a binary leetcode.tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levelLists = new ArrayList<>();
            if(root == null){
                return levelLists;
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode node = null;

            //记录每层个数的辅助变量
            int levelUpCnt = 0;
            int levelDownCnt = 0;

            //记录每层节点的辅助变量

            List<Integer> levelList = new ArrayList<>();

            levelUpCnt++;

            while(queue.peek() != null){
                node = queue.remove();
                levelUpCnt--;
                levelList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                    levelDownCnt++;
                }

                if(node.right != null){
                    queue.add(node.right);
                    levelDownCnt++;
                }

                if(levelUpCnt == 0){
                    levelLists.add(levelList);
                    levelList = new ArrayList<>();
                    levelUpCnt = levelDownCnt;
                    levelDownCnt = 0;
                }
            }

            return levelLists;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
//        List<List<Integer>> l = new LeetCode0102().new Solution().levelOrder(t1);

//        for(List l1 : l){
//            System.out.println(l1);
//        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        lists.add(list);
    }



    class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            return dfs(root, list, 0);
        }

        private List<List<Integer>> dfs(TreeNode root, List<List<Integer>> list, int level) {
            if (root == null) {
                return list;
            }


            if (list.size() <= level) {
                List<Integer> list2 = new ArrayList<>();
                list.add(list2);
            }
            list.get(level).add(root.val);


//            if (list.size()> level) {
//                list.get(level).add(root.val);
//            } else {
//                List<Integer> list2 = new ArrayList<>();
//                list.add(list2);
//                list.get(level).add(root.val);
//            }


            dfs(root.left, list, level + 1);
            dfs(root.right, list,level + 1);
            return list;
        }
    }
}
