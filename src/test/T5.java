package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int[] a = {sc.nextInt()};
        int b = sc.nextInt();
        int rest = -1, idx = 0;
        List<Integer> list = new ArrayList<>();
        while (true){
            rest = a[0] % b;
            if(rest == 0){
                System.out.println("0 0");
                break;
            } else{
                idx++;
                if(list.size()<= rest){
                    list.add(idx);
                    a[0] = rest*10;
                }else{
                    System.out.println(list.get(rest)-1+" "+(idx-list.get(rest)));
                }
            }
        }

        ThreadPoolExecutor e;

        Thread t = new Thread(()->{
            while(true);
        });

        t.setDaemon(true);
    }
}
