package qiuzhao.tengxun;

import java.util.ArrayList;
import java.util.Scanner;

public class T2 {

    /**
     * 50 5
     * 2 1 2
     * 5 10 11 12 13 14
     * 2 0 1
     * 2 49 2
     * 4 6 7 8 2
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // n 个人 m个小团队

        // m行 x 个人

        if(m==1||n==1){
            System.out.println(m);
            return;
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        boolean[] isKnow = new boolean[n];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < x; j++) {
                list.add(scanner.nextInt());
            }
            arrayLists.add(list);
        }

        for (int i = 0; i < m; i++) {
            if(arrayLists.get(i).contains(0)){
                ArrayList<Integer> list = arrayLists.get(i);
                for (Integer integer : list) {
                    isKnow[integer] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = arrayLists.get(i);
            boolean isK = false;
            for (Integer integer : list) {
                if(isKnow[integer]){
                    isK = true;
                    break;
                }
            }
            if(isK){
                for (Integer integer : list) {
                    isKnow[integer] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = arrayLists.get(i);
            boolean isK = false;
            for (Integer integer : list) {
                if(isKnow[integer]){
                    isK = true;
                    break;
                }
            }
            if(isK){
                for (Integer integer : list) {
                    isKnow[integer] = true;
                }
            }
        }

        int cnt = 0;
        for (boolean b : isKnow) {
            if(b){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
