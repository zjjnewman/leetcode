package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2020-06-09
 * 面试题07. 重建二叉树 https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 */
public class JZ07 {

    //Definition for a binary leetcode.tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        int preIdx = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length != inorder.length || preorder.length == 0){
                return null;
            }
            /**
             * 需求：用 前序数组 的值， 查找 这个值 在中序数组中索引，可以用遍历，也可以用的数据结构是map
             *
             * 以中序数组为主体，用前序数组定位元素在书中是左子树还是，右子树
             *
             *
             *
             * 以前序数组为主体，用中序数组定位是左子树还是右子树
             * 前序的第一个idxVal0 为根节点，考虑下一个idxVal1，
             * 在中序数组中查找得到idxVal0的idx0，idxVal1的idx1，查看idx0，idx1数值比较
             * 若idx1 < idx0 ，则idx1是左子树，若idx1 > idx0 ，则idx1是右子树
             * 不可行
             */

            Map<Integer, Integer> map = valMapToIndex(inorder);

            TreeNode root = buildTreeHelper(map, preorder,0, preorder.length - 1);
            return root;
        }


        public TreeNode buildTreeHelper(Map<Integer, Integer> map, int[] preorder, int low, int high) {
            if(preIdx >= preorder.length){
                return null;
            }
            int rootInIdx = map.get(preorder[preIdx]);
            if(rootInIdx < low || rootInIdx > high){
                return null;
            }
            TreeNode currRoot = new TreeNode(preorder[preIdx]);
            preIdx++;
            currRoot.left = buildTreeHelper(map, preorder, low, rootInIdx - 1);
            currRoot.right= buildTreeHelper(map, preorder, rootInIdx + 1, high);
            return currRoot;
        }

        // *********************************************************************************************************
        public TreeNode buildTree1(int[] preorder, int[] inorder) {

            if(preorder.length == 0){
                return null;
            }

            Map<Integer, Integer> map = valMapToIndex(inorder);
            map.get(preorder[0]);
            TreeNode root = helper(preorder, map,0, 0, preorder.length - 1);
            return root;
        }

        public TreeNode helper(int[] preorder, Map map, int idxPreHead, int idxInHead, int idxInTail){

            if(idxPreHead > preorder.length - 1){
                return null;
            }

            if(idxInHead > idxInTail){
                return null;
            }

            TreeNode node = new TreeNode(preorder[idxPreHead]);

            int tmp = idxInTail;

            int rootIdx = (int)map.get(preorder[idxPreHead]);
            idxInTail = rootIdx - 1;
            idxPreHead = idxPreHead + 1;

            node.left = helper(preorder, map, idxPreHead, idxInHead, idxInTail);

            idxPreHead = idxPreHead + (rootIdx - idxInHead);

            node.right = helper(preorder, map, idxPreHead, rootIdx + 1, tmp);

            return node;
        }

        public Map<Integer, Integer> valMapToIndex(int[] arr){
            Map<Integer, Integer> map = new HashMap<>();
            int length = arr.length;
            for(int i = 0; i < length; i++){
                map.put(arr[i], i);
            }
            return map;
        }
    }


    public static void main(String[] args) {

        //[3,1,2,4]
        //[1,2,3,4]
        int[] pre = new int[]{3,1,2,4};
        int[] in = new int[]{1,2,3,4};

        new JZ07().new Solution().buildTree(pre, in);

    }
}
