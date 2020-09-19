package qiuzhao.shenzhou;

import java.util.Arrays;
import java.util.LinkedList;

public class T2 {
    public static int[] pushIntArray (int[] arr, int pushOffset) {

        int[] chars = new int[arr.length];

        StringBuilder sb = new StringBuilder();

        LinkedList<String> list = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            list.addLast(String.valueOf(arr[i]));
        }

        while (pushOffset != 0){
            String a = list.removeLast();
            list.addFirst(a);
            pushOffset--;
        }
        System.out.println(list);
        int i = 0;
        for (String s : list) {
            int a =Integer.parseInt(s);
            arr[i] = a;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        pushIntArray(new int[]{1,2,3,4,5}, 2);
    }
}
