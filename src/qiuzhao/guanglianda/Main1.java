package qiuzhao.guanglianda;

import java.util.Scanner;

public class Main1 {

    public int win(String str1, String str2){
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) == str2.charAt(i)){
                cnt = cnt + 20;
            } else {
                if(cnt > 0){
                    cnt = cnt - 10;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        Main1 m = new Main1();
        int win = m.win(str1, str2);
        System.out.println(win);

    }
}
