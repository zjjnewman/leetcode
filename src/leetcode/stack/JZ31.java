package leetcode.stack;


import java.util.LinkedList;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列 https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class JZ31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null && popped == null){
            return true;
        }
        if(pushed.length == 0 && popped.length == 0){
            return true;
        }

        if(pushed == null || popped == null){
            return false;
        }
        if(pushed.length == 0 || popped.length == 0){
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        int pushIdx = 0;
        stack.push(pushed[pushIdx]);
        for(int i = 0; i < popped.length;i++){
            while(true){
                if(!stack.isEmpty() && stack.peek() == popped[i]){
                    stack.pop();
                    break;
                } else if(pushIdx >= pushed.length){
                    return false;
                } else {
                    stack.push(pushed[pushIdx]);
                    pushIdx++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
