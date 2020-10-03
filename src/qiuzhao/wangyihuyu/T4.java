package qiuzhao.wangyihuyu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class  T4{

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

        int id = -1;
        int max = 0;
        for (Map.Entry<Integer, Task> e : map.entrySet()) {
            if(e.getValue().end - e.getValue().start > max){
                id = e.getKey();
            }
        }
        System.out.println(id);
    }
}