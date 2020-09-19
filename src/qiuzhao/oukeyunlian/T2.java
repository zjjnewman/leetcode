package qiuzhao.oukeyunlian;

import java.util.*;

public class T2 {
    public static boolean isPowerOfTwo (int n) {
        if(n == 0){
            return false;
        }
        if(n==1){
            return true;
        }
        int a = 1;
        for (int i = 0; i < 32; i++) {
            a = (a<<1);
            if(a == n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
        System.out.println(isPowerOfTwo(16));
        ArrayList<String> list = new ArrayList<>(q);
    }
}
