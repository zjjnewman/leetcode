package qiuzhao.wangyihuyu;

import java.util.*;

public class T3 {

    static class Task{
        public int id = -1;
        public int start=-1;
        public int end=-1;

        @Override
        public String toString() {
            return "Task{" +
                    "id=" + id +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<Integer, Task> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split(" ");
            int id = Integer.parseInt(s[1]);
            if(map.containsKey(id)){
                if(s[2].equals("0")){
                    map.get(id).start = Integer.parseInt(s[0]);
                } else if(s[2].equals("1")){
                    map.get(id).end = Integer.parseInt(s[0]);
                }
            }else {
                Task task = new Task();
                task.id = id;
                if(s[2].equals("0")){
                    task.start = Integer.parseInt(s[0]);
                } else if(s[2].equals("1")){
                    task.end = Integer.parseInt(s[0]);
                }
                map.put(id, task);
            }
        }
        for (Map.Entry<Integer, Task> e : map.entrySet()) {
            if(e.getValue().start==-1 || e.getValue().end==-1 ){
                System.out.println("error");
                return;
            }
            if(e.getValue().start > e.getValue().end){
                System.out.println("error");
                return;
            }
            if(e.getKey()==-1){
                System.out.println("error");
                return;
            }
        }



        for (Map.Entry<Integer, Task> e : map.entrySet()) {
        }

        // 获取最大任务id
        int maxId = 0;
        for (Map.Entry<Integer, Task> e : map.entrySet()) {
            maxId = Math.max(e.getValue().id, maxId);
        }

        if(maxId == 1){
            System.out.println(1);
            return;
        }
        if(maxId == 2){
            int t2Time = map.get(2).end -map.get(2).start;
            int t1Time = map.get(1).end -map.get(1).start - t2Time;
            if(t2Time > t1Time){
                System.out.println(2);
            }else {
                System.out.println(1);
            }
            return;
        }

        if(maxId==3){
            int t3Time = map.get(3).end -map.get(3).start;
            int t2Time = map.get(2).end -map.get(2).start - t3Time;
            int t1Time = map.get(1).end -map.get(1).start - t2Time - t3Time;
            if(t2Time > t1Time){
                if(t3Time > t2Time){
                    System.out.println(3);
                } else {
                    System.out.println(2);
                }
            }else {
                if(t3Time > t1Time){
                    System.out.println(3);
                } else {
                    System.out.println(1);
                }
            }
            return;
        }

        if(maxId==4){
            int t4Time = map.get(4).end -map.get(4).start;
            int t3Time = map.get(3).end -map.get(3).start;
            int t2Time = map.get(2).end -map.get(2).start - t3Time - t4Time;
            int t1Time = map.get(1).end -map.get(1).start - t2Time - t3Time - t4Time;
            class Ret{
                public int tTime;
                public int id;

                public Ret(int tTime, int id) {
                    this.tTime = tTime;
                    this.id = id;
                }
            }
            List<Ret> list = new ArrayList<>();
            list.add(new Ret(t1Time,1));
            list.add(new Ret(t2Time,2));
            list.add(new Ret(t3Time,3));
            list.add(new Ret(t4Time,4));
            list.sort(new Comparator<Ret>() {
                @Override
                public int compare(Ret o1, Ret o2) {
                    return o2.tTime - o1.tTime;
                }
            });
            System.out.println(list.get(0).id);
        }

    }
}
/*
3
1 1 0
2 2 0
7 1 1

4
1 1 0
2 2 0
6 2 1
7 1 1

8

 */