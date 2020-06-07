package datastructure.tree;


import datastructure.IStack;

import java.util.LinkedList;

/**
 * 二叉树的遍历
 * @date 2020-06-03
 */
class TreeTraverse{

    //先序遍历递归实现
    public void preOrderRecurse(TreeNode root){
        if(root != null){
            System.out.print(root.val+"   ");
            preOrderRecurse(root.left);
            preOrderRecurse(root.right);
        }
    }
    //先序遍历迭代实现
    public void preOrderIterate(TreeNode root){
        IStack<TreeNode> stack = new IStack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                System.out.print(root.val+"   ");
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }


    //中序遍历递归
    public void inOrderRecurse(TreeNode root){
        if (root != null) {
            inOrderRecurse(root.left);
            System.out.print(root.val+"   ");
            inOrderRecurse(root.right);
        }
    }
    //中序遍历迭代
    public void inOrderIterate(TreeNode root){
        IStack<TreeNode> stack = new IStack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val+"   ");
            root = root.right;
        }
    }


    //后序遍历递归
    public void postOrderRecurse(TreeNode root){
        if(root != null){
            postOrderRecurse(root.left);
            postOrderRecurse(root.right);
            System.out.print(root.val+"   ");
        }
    }
    /**
     * 后序遍历迭代
     * 有点难看的答案
     *
     * 恍然大悟：后序遍历的顺序是：左右根。先序遍历的顺序是：根左右，如果入栈后弹出变为 右左根。若先序变为 根右左 再入栈弹出 就是 左右根
     * @param root
     */
    public void postOrderIterate(TreeNode root){
        IStack<TreeNode> stack = new IStack();
        IStack<TreeNode> output = new IStack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                output.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        while (!output.isEmpty()){
            System.out.print(output.pop().val+ "   ");
        }
    }


    //层次遍历
    //尝试加入记录层数
    int level = 0;
    //每层的节点数
    int levelCntUp = 0;
    int levelCntDown = 0;
    public void levelTraverse(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        levelCntUp++;
        level++;
        TreeNode node;

        while (queue.peek() != null){
            node = queue.remove();
            levelCntUp--;

//            if(node.left != null || node.right != null){
//                level++;
//            }
//            System.out.print(node.val + "   ");

            if(node.left != null){
                queue.add(node.left);
                levelCntDown++;
            }
            if(node.right != null){
                queue.add(node.right);
                levelCntDown++;
            }
            if(node.right == null && node.left == null){
                System.out.println("层数： " + level);
                break;
            }

            if(levelCntUp == 0){
                level++;
                levelCntUp = levelCntDown;
                levelCntDown = 0;
//                System.out.println("层数： " + level);
//                System.out.println("个数： "+levelCntUp);
            }
        }
    }
}