package qiuzhao.wangyihuyu;

import javax.swing.plaf.metal.MetalTheme;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class T11 {



    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.nextLine().trim();
        String[] cmd = s.split(" ");
        HashMap<Integer, String[]> map = new HashMap<>();
        int fdCnt = 0;
        int fdMin = fdCnt;

        String c0 = cmd[0];
        if(c0.equals("open")){
            int min = Math.min(fdMin, fdCnt);
            if(min == fdCnt){
                fdCnt++;
            }
            map.put(min, new String[]{cmd[1]});
        }else if(c0.equals("dup")){
            String[] file = map.get(Integer.parseInt(cmd[1]));
            int min = Math.min(fdMin, fdCnt);
            if(min == fdCnt){
                fdCnt++;
            }
            map.put(min, file);
        }else if(c0.equals("dup2")){
            String[] fd = new String[]{cmd[1]};
            String[] newfd = new String[]{cmd[2]};

        }else if(c0.equals("close")){

        }else if(c0.equals("query")){

        }

    }
}
