package zijie2019;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * [编程题]万万没想到之聪明的编辑 https://www.nowcoder.com/test/question/analytic?tid=35258752
 */
public class ZJ201901 {
    /**
     * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
     * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
     * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
     *
     * 第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
     *
     * 后面跟随N行，每行为一个待校验的字符串。
     *
     *
     *
     */
    public String process(String str){
        if(str.length() == 0){
            return str;
        }
        /**
         * 考虑用单调栈，一旦尾部字符前的字符符合规则，从队首弹出
         *
         * 单调栈的状态有3种：且 每种状态设计的转换情况有 状态下面的描述
         *      size = 1
         *          A：  当前栈内 A，  若下一个字符是：？，则栈转换状态 由 size = 1 转换为 size = ？
         *              A   2
         *              B   1
         *      size = 2
         *          AA： 当前栈内 AA， 若下一个字符是：？，则栈转换状态 由 size = 1 转换为 size = ？
         *              A   2
         *              B   3
         *      size = 3
         *          AAB：当前栈内 AAB，若下一个字符是：？，则栈转换状态 由 size = 1 转换为 size = ？
         *              B   3
         *              C   1
         */


        LinkedList<Integer> linkedList = new LinkedList<>();
        char[] chars = str.toCharArray();
        boolean[] isRemove = new boolean[str.length()];

        linkedList.addLast(0);
        for (int i = 1; i < chars.length; i++) {
            if (!linkedList.isEmpty()){

                if(linkedList.size() == 1){
                    if(chars[linkedList.peekLast()] == chars[i]){
                        linkedList.addLast(i);
                    } else {
                        linkedList.addLast(i);
                        linkedList.removeFirst();
                    }

                }else if(linkedList.size() == 2){
                    if(chars[linkedList.peekLast()] == chars[i]){
                        isRemove[i] = true;
                    } else {
                        linkedList.addLast(i);
                    }

                }else if(linkedList.size() == 3){
                    if(chars[linkedList.peekLast()] == chars[i]){
                        isRemove[i] = true;
                    } else {
                        linkedList.addLast(i);
                        linkedList.removeFirst();
                        linkedList.removeFirst();
                        linkedList.removeFirst();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(!isRemove[i]){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }





    public static void main(String[] args) throws IOException {

        ZJ201901 t = new ZJ201901();

        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            String strProcessed = t.process(str);
            bufferedWriter.write(strProcessed + "\n");
        }

        bufferedWriter.flush();

    }
}
