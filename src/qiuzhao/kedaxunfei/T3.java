package qiuzhao.kedaxunfei;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        int cnt=0;
        while (l!=0){
            cnt++;
            l = l&(l-1);
        }
        System.out.println(cnt);
    }
}
