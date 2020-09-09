package qiuzhao.novida;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {


    static String[] ps;
    static int[] nums;
    static List<String> res;


    public static void calc(int ni, int sum, String str, int[] visit){
        if(ni==3){
            if(sum==24)res.add(str);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(visit[i]==0){
                visit[i] = 1;
            }
            calc(ni+1,sum+nums[i],str+"+"+ps[i],visit);
            calc(ni+1,sum-nums[i],str+"-"+ps[i],visit);
            calc(ni+1,sum*nums[i],str+"*"+ps[i],visit);
            calc(ni+1,sum/nums[i],str+"/"+ps[i],visit);
            visit[i]=0;

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String poker = scanner.nextLine();
        if(poker.contains("joker") || poker.contains("JOKER")){
            System.out.println("ERROR");
        } else {
            res = new ArrayList<>();
            ps = poker.split(" ");
            nums = new int[ps.length];
            for (int i = 0; i < ps.length; i++) {
                if (ps[i].equals("A")) {
                    nums[i] = 1;
                } else if (ps[i].equals("J")) {
                    nums[i] = 11;
                } else if (ps[i].equals("Q")) {
                    nums[i] = 12;
                } else if (ps[i].equals("K")) {
                    nums[i] = 13;
                } else {
                    nums[i] = Integer.parseInt(ps[i]);
                }
            }
            for (int i = 0; i < 4; i++) {
                int[] visit = new int[4];
                visit[i] = 1;
                calc(0, nums[i], ps[i], visit);
                visit[i] = 0;
            }
            if (res.size() > 0) {
            } else {
                System.out.println("NONE");
            }
        }
    }
}
