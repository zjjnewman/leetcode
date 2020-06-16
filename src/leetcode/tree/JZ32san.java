package leetcode.tree;


import java.util.*;

/**
 *
 *
 */
public class JZ32san {

    //Definition for a binary leetcode.tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new LinkedList<>();
            if(root == null){
                return lists;
            }

            ArrayList<TreeNode> queue = new ArrayList<>();
            int upCnt = 0;
            int downCnt = 0;

            queue.add(root);
            upCnt++;

            TreeNode node;
            int i = 0;

//            LinkedList<Integer> linkedList = new LinkedList<>();
            ArrayList<Integer> tmpList = new ArrayList<>();

            List<Integer> levelNum = new ArrayList<>();
            levelNum.add(1);

            boolean isReverse = false;

            while (i < queue.size()){
                node = queue.get(i);
                i++;
//                if(isReverse){
//                    tmpList.addFirst(node.val);
//                } else {
//                    tmpList.addLast(node.val);
//                }
                tmpList.add(node.val);

                upCnt--;
                if(node.left != null){
                    queue.add(node.left);
                    downCnt++;
                }
                if(node.right != null){
                    queue.add(node.right);
                    downCnt++;
                }
                if(upCnt == 0){
                    if(isReverse){
                        Collections.reverse(tmpList);
                    }
                    lists.add(tmpList);
                    isReverse = !isReverse;
                    tmpList = new ArrayList<>();
                    upCnt = downCnt;
                    downCnt = 0;
                }
            }
            return lists;

//            int idx1 = 0;
//            int idx2 = 0;
//            for(int j = 0; i < levelNum.size() - 1; i++){
//                idx1 = idx1 + levelNum.get(j) - 1;
//                idx2 = idx1 + levelNum.get(j+1);
//                lists.add(queue.subList(idx1, idx2));
//            }
        }
    }
}
