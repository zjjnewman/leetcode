package qiuzhao.tengxun;

import java.util.*;

public class T4 {

//    public static int fn(int n,int[] arr){
//        int len = arr.length
//        int mid = len/2-1
//        for(let i=0;i<len;i++){
//            if(i<=mid){
//                输出 arr[mid+1]
//            }else{
//                输出 arr[mid]
//            }
//        }
//    }


    private static int mid(ArrayList<Integer> total, int i){
        ArrayList<Integer> list = new ArrayList<>(total);
        list.remove(i);
        Collections.sort(list);
        int idx = (total.size()-1)/2;
        return list.get(idx);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(mid(list, i));
        }
        
    }
}
