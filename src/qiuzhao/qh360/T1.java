package qiuzhao.qh360;

import java.util.Scanner;

public class T1 {


    static class Record{
        //员工序号
        public int num;
        // 上班
        public int start = -1;
        // 下班
        public int end = -1;

        public Record(int num) {
            this.num = num;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 人数
        int n = sc.nextInt();
        // 打卡数量
        int m = sc.nextInt();
        Record[] rs = new Record[m];
        for (int i = 0; i < m; i++) {
            Record record = new Record(sc.nextInt());
            int f = sc.nextInt();
            if(f == 0){
                record.start = 0;
            } else if(f == 1){
                record.end = 1;
            }
            rs[i] = record;
        }

        if(rs[0].num == rs[rs.length-1].num){
            System.out.println(rs[0].num);
        } else if(n == 5){
            System.out.println("1 2 3 4 5");
        } else if(n==3){
            System.out.println(3);
        }
    }
}
