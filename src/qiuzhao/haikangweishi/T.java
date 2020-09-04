package qiuzhao.haikangweishi;

import java.util.ArrayList;
import java.util.Arrays;

public class T {
    // 是否为质数
    public static boolean isPrime(int num){
        if(num == 1){
            return false;
        }

        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    // 求某范围内的所有质数
    public static void allPrimes(int start, int end){
        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(isPrime(i)){
                cnt++;
                arr.add(i);
            }
        }
        System.out.println(cnt);
        System.out.println(arr.size());
    }

    public static void main(String[] args) {
        allPrimes(1, 100000);
    }
}
