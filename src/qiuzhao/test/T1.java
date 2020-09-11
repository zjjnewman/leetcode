package qiuzhao.test;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[]  names = sc.nextLine().split(" ");
        if(names.length == 0){
            System.out.println("unknown name");
            return;
        }

        if(names.length < 3){
            StringBuilder s = new StringBuilder();
            for (String name : names) {
                s.append(name.toLowerCase());
            }
            System.out.println(s.toString());
        }else{
            StringBuilder s = new StringBuilder();
            for (String name : names) {
                s.append(name.toLowerCase().charAt(0));
            }
            System.out.println(s.toString());
        }
    }
}
