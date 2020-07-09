package leetcode.tree;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import datastructure.tree.TreeNode;
import datastructure.tree.TreeUtils;

import java.util.LinkedList;

/**
 * 230. 二叉搜索树中第K小的元素 https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class LC0230 {


    class Solution {

        int kTh = Integer.MIN_VALUE;
        int cnt = 0;

        public int kthSmallest(TreeNode root, int k) {

            inOrderTraverse(root, k);
            return kTh;
        }

        /**
         * 最直观的做法是，中序遍历
         */
        public void inOrderTraverse(TreeNode root, int k){
            if(root != null){
                inOrderTraverse(root.left, k);
                cnt++;
                if(cnt == k){
                    kTh = root.val;
                }
                inOrderTraverse(root.right, k);
            }
        }

        public int inOrderTraverseIterable(TreeNode root, int k){
            if(root == null){
                return Integer.MIN_VALUE;
            }

            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            TreeNode treeNode = root;
            int cnt = 0;

            while (!stack.isEmpty() || treeNode != null){
                while (treeNode != null){
                    stack.push(treeNode);
                    treeNode = treeNode.left;
                }
                treeNode = stack.pop();
                cnt++;
                if(cnt == k){
                    return treeNode.val;
                }
//                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
            return Integer.MIN_VALUE;
        }

    }

    public static void main(String[] args) {
        LC0230.Solution lc = new LC0230().new Solution();

        datastructure.tree.TreeNode root = TreeUtils.deserialize("[3,1,4,null,2]");

        System.out.println(lc.kthSmallest(root, 1));
    }
}
