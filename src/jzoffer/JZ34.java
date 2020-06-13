package jzoffer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 这个迭代没有研发成功，最终还是看答案用的递归
 * @date 2020-06-10
 * 面试题34. 二叉树中和为某一值的路径
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 */
public class JZ34 {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            recurse(root, sum);
            return lists;
        }

        public void recurse(TreeNode root, int sum){
            if(root == null){
                return;
            }
            path.add(root.val);
            sum = sum - root.val;

            if(sum == 0 && root.left == null && root.right == null){
                lists.add(new LinkedList<>(path));
            }

            recurse(root.left, sum);
            recurse(root.right, sum);
            path.removeLast();

        }





        public List<List<Integer>> pathSum1(TreeNode root, int sum) {
            List<List<Integer>> lists = new ArrayList<>();
            if(root == null){
                return lists;
            }

            LinkedList<TreeNode> stack = new LinkedList<>();

            LinkedList<Integer> tmpList = new LinkedList<>();
            int diagramSum = 0;
            int cnt = 0;

            while(root != null || !stack.isEmpty()){
                while (root != null){
                    diagramSum = diagramSum + root.val;
                    tmpList.add(root.val);
                    if(root.left == null && root.right == null){
                        if(diagramSum == sum){
                            lists.add(new LinkedList<>(tmpList));
                        }
                        while (cnt > 0){
                            cnt--;
                            int tmp = tmpList.removeLast();
                            diagramSum = diagramSum - tmp;
                        }
                    }

                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();

                if(root.right == null){

                    tmpList.remove((Integer)root.val);
                    diagramSum = diagramSum - root.val;

                } else {
                    cnt++;
                }

                root = root.right;

            }
            return lists;
        }

        /**
         *               5
         *              / \
         *             4   8
         *            /   / \
         *           11  13  4
         *          /  \    / \
         *         7    2  5   1
         *
         */
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String i = scanner.next();
            list.add(i);
            if(i.isEmpty()){
                break;
            }
        }
        scanner.close();
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String str = sc.nextLine();
//            if (str.isEmpty())
//                break;
//            System.out.println(str);
//        }
//        sc.close();

        return;
    }
}
