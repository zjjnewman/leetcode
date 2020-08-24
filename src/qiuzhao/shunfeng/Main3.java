package qiuzhao.shunfeng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {


    static class Task {
        public int start;//开始时间
        public int end;//结束时间
        public int income;//赏金

        public Task(int start, int end, int income) {
            this.start = start;
            this.end = end;
            this.income = income;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // a是任务数组
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.end - o2.end;//按照结束时间升序排序
            }
        });

        // 动态数组dp[]便是前i个任务的最大赏金，对于第 i 个任务，可以选或者不选
        int[] dp = new int[n];
        // 初始化dp[]数组第一个任务可以赚的钱
        dp[0]=tasks[0].income;

        // 在第一个任务选定的基础上，第二个任务可以选或者不选，
        for(int i=1;i < n;i++){

            // 将要接受的任务
            Task temp=tasks[i];
            int itemp = -1;
            for (int j = i - 1; j >= 0 ; j--) {
                //找出选择了第i个任务后，前边还能够接受的任务（只要接受的 任务的结束时间 <= 第i个任务的开始时间 就可以，因为前边已经将区间按照结束时间来升序排序了）
                if(temp.start >= tasks[j].end){
                    itemp = j;
                    break;
                }
            }
            //dp[i-1]表示不选第i个任务，后边表示选第i个任务
            if(itemp == -1){
                dp[i] = Math.max(dp[i-1], temp.income);
            } else {
                dp[i]=Math.max(dp[i-1], temp.income + dp[itemp]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        System.out.println(dp[n-1]);
/*
4
1 2 3
2 3 5
2 8 10
3 9 11


*/
    }
}


