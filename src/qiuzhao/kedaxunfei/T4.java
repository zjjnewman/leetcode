package qiuzhao.kedaxunfei;

import java.util.LinkedList;
import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.nextLine();
            int n = in.nextInt();

            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < str.length(); i++) {
                list.addLast(str.charAt(i));
            }
            while (n!=0){
                Character character = list.removeFirst();
                list.addLast(character);
                n--;
            }
            StringBuilder sb = new StringBuilder();
            for (Character character : list) {
                sb.append(character);
            }
            System.out.println(sb.toString());
        }
    }
}
