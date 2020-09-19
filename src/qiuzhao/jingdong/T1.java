package qiuzhao.jingdong;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1000; i <= 3999; i++) {
            hashMap.put(String.valueOf(i), 0);
        }
        String str = sc.nextLine();
        str = str.replaceAll(" ", "");
        for (int i = 0; i < str.length() - 4; i++) {
            String year = str.substring(i, i+4);
            if (hashMap.containsKey(year)){
                list.add(year);
            }
        }
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
