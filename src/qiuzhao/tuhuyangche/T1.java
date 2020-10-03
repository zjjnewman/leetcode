package qiuzhao.tuhuyangche;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class T1 {

    public static int getWork(String dS, String dE){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
            c1.setTime(df.parse(dS));
            c2.setTime(df.parse(dE));
        } catch (Exception ignored){

        }
        int cnt =0;
        if(c1.compareTo(c2)>=0){
            return 0;
        }
        while (c1.compareTo(c2)<0){
            if(c1.get(Calendar.DAY_OF_WEEK)!=7 && c1.get(Calendar.DAY_OF_WEEK)!=1){
                cnt++;
            }
            c1.add(Calendar.DAY_OF_MONTH,1);

        }
        return cnt;
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param y1 int整型 当前日期的年
     * @param m1 int整型 当前日期的月
     * @param d1 int整型 当前日期的日
     * @param y2 int整型 项目截止日期的年
     * @param m2 int整型 项目截止日期的月
     * @param d2 int整型 项目截止日期的日
     * @return int整型
     */
    static public int workdays_between (int y1, int m1, int d1, int y2, int m2, int d2) {
        String[] ss = new String[6];
        ss[0]=String.valueOf(y1);
        ss[1]=String.valueOf(m1);
        ss[2]=String.valueOf(d1);
        ss[3]=String.valueOf(y2);
        ss[4]=String.valueOf(m2);
        ss[5]=String.valueOf(d2);
        // write code here
        if(ss[1].length()==1){
            ss[1] = "0"+ss[1];
        }
        if(ss[4].length()==1){
            ss[4] = "0"+ss[4];
        }

        if(ss[2].length()==1){
            ss[2] = "0"+ss[2];
        }
        if(ss[5].length()==1){
            ss[5] = "0"+ss[5];
        }

        String dS = ss[0]+"-"+ss[1]+"-"+ss[2];
        String dE = ss[3]+"-"+ss[4]+"-"+ss[5];
        System.out.println(dS+" "+dE);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
            c1.setTime(df.parse(dS));
            c2.setTime(df.parse(dE));
        } catch (Exception ignored){

        }
        int cnt =0;
        if(c1.compareTo(c2)>=0){
            return 0;
        }
        while (c1.compareTo(c2)<0){
            if(c1.get(Calendar.DAY_OF_WEEK)!=7 && c1.get(Calendar.DAY_OF_WEEK)!=1){
                cnt++;
            }
            c1.add(Calendar.DAY_OF_MONTH,1);

        }
        return cnt;
    }




    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        String[] ss = sc.nextLine().trim().split(",");
        if(ss[1].length()==1){
            ss[1] = "0"+ss[1];
        }
        if(ss[4].length()==1){
            ss[4] = "0"+ss[4];
        }

        if(ss[2].length()==1){
            ss[2] = "0"+ss[2];
        }
        if(ss[5].length()==1){
            ss[5] = "0"+ss[5];
        }

        String dataS = ss[0]+"-"+ss[1]+"-"+ss[2];
        String dataE = ss[3]+"-"+ss[4]+"-"+ss[5];
        System.out.println(workdays_between(2020,9,25,2021,9,30));
    }
}
/*
2020,9,25,2020,9,28

2020,9,25,2020,9,28
2020,9,25,2020,9,30
2020,9,25,2020,9,29

 */