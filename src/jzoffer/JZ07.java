package jzoffer;

import datastructure.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2020-06-09
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 面试题07. 重建二叉树
 *
 */
public class JZ07 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {

        public TreeNode buildTree1(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = numIndexMap(inorder);
            int length = preorder.length;
            for(int i = 0; i < length - 1; i++){
                TreeNode node = new TreeNode(preorder[i]);
                int nodeIdx = map.get(preorder[i]);
                int childIdx1 = map.get(preorder[i+1]);
                int childIdx2 = map.get(preorder[i+2]);

            }
            return null;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {

            if(preorder.length == 0){
                return null;
            }

            Map<Integer, Integer> map = numIndexMap(inorder);
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

        public Map<Integer, Integer> numIndexMap(int[] arr){
            Map<Integer, Integer> map = new HashMap<>();
            int length = arr.length;
            for(int i = 0; i < length; i++){
                map.put(arr[i], i);
            }
            return map;
        }
    }
}
