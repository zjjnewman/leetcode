package qiuzhao.shunfeng;

import java.util.*;

public class Main2 {

    public static int maxIncome(PriorityQueue<Task> tasks){

        ArrayList<Task> tasksDone = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.poll();
            if(tasksDone.isEmpty()){
                tasksDone.add(task);
            } else{
                // 是否可以接受新任务
                boolean isCanDo = true;
                for (Task taskD : tasksDone) {
                    // 如果新的任务与已经接受的任务的时间冲突，那么就不考虑添加新任务
                    if(!(task.end <= taskD.start || task.start >= taskD.end)){
                        isCanDo = false;
                        break;
                    }
                }
                if(isCanDo){
                    tasksDone.add(task);
                }
            }
        }

        int incomeAll = 0;
        for (Task task : tasksDone) {
            incomeAll = incomeAll + task.income;
        }
        return incomeAll;
    }

    static class Task{
        int start;
        int end;
        int income;
        boolean isDone;
        public Task(int start, int end, int income){
            this.start = start;
            this.end = end;
            this.income = income;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 任务的个数
        int n = scanner.nextInt();

//        ArrayList<Task> tasks = new ArrayList<>();
        PriorityQueue<Task> tasks = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.income / (o2.end - o2.start)  - o1.income / (o1.end - o1.start);
            }
        });
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println(maxIncome(tasks));
    }
}
