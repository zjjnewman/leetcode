package qiuzhao.sougou;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class T2 {
    public static long getPasswordCount (String password) {
        // write code here
        long[] nums = new long[password.length() + 1];

        long[] pws = new long[password.length() + 1];
        for (int i = 0; i < password.length(); i++) {
            nums[i+1] = Long.parseLong(password.substring(i, i + 1));
        }
        HashSet<String> set = new HashSet<>();
        set.add(password);

        for (int i = 0; i <= 9 ; i++) {
            pws[1] = i;
            for (int j = 1; j < password.length(); j++) {
                float f = ((float) nums[j+1] + (float) pws[j]) / 2;
                long d = (nums[j+1] + pws[j]) / 2;
                pws[j + 1] = d;
            }
            set.add(Arrays.toString(pws).substring(1, pws.length));
        }
        return set.size();
    }



    public static void main(String[] args) {

        System.out.println(getPasswordCount("12345"));
    }
}
