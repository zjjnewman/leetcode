package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 程序员面试金典
 * 面试题 08.06. 汉诺塔问题 https://leetcode-cn.com/problems/hanota-lcci/
 */
public class MSJD08_06 {





    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanotaHelp(A.size(), A, B, C);
    }

    public void hanotaHelp(int cnt, List<Integer> A, List<Integer> B, List<Integer> C) {
        if(A.size() == 0){
            return;
        }
        if(cnt == 1){
            popThenPush(A, C);
        } else {
            hanotaHelp(cnt - 1, A, C, B);
            popThenPush(A, C);
            hanotaHelp(cnt - 1, B, A, C);
        }
    }

    public <T> void popThenPush(List<T> popFrom, List<T> pushFrom){
        T t = pop(popFrom);
        push(t, pushFrom);
    }

    public <T> T pop(List<T> list){
        return list.remove(list.size() - 1);
    }

    public <T> boolean push(T t, List<T> list){
        return list.add(t);
    }

    public static void main(String[] args) {
        MSJD08_06 ms = new MSJD08_06();
        List<Integer> a = new ArrayList();
        List<Integer> b = new ArrayList();
        List<Integer> c = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        ms.hanota(a, b, c);

        c.forEach(System.out::println);

    }
}
