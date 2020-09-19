package qiuzhao.didi;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int size = str.length() / n;
        if (str.length() % n!= 0) {
            size += 1;
        }
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr=null;
            if (index * n > str.length()) {

            }
            if ((index + 1) * n > str.length()) {
                childStr= str.substring(index * n, str.length());
            } else {
                childStr= str.substring(index * n, (index + 1) * n);
            }
            list.add(childStr);
        }

        for (String s : list) {
            for (int i = s.length()-1; i>=0 ; i--) {
                System.out.print(s.charAt(i));
            }
        }
    }
}